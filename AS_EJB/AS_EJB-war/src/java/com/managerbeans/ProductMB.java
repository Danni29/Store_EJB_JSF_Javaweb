package com.managerbeans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.entities.Product;
import com.sessionbeans.ProductFacadeLocal;
import com.sessionbeans.ProductTypeFacadeLocal;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

/**
 *
 * @author Ngocd
 */
@Named(value = "productMB")
@RequestScoped
public class ProductMB {

    @EJB
    private ProductFacadeLocal productFacade;

    @EJB
    private ProductTypeFacadeLocal productTypeFacade;

     private Product product = new Product();

    private String name;
    private int type;
    private int price;
    private String info;
    private Part pic;
    private int amount;
    private String message;
    private int idtype;
    String UPLOAD_DIRECTORY = "images";

    /**
     * Creates a new instance of ProductMB
     */
    InputStream inputStream = null;
    OutputStream outputStream = null;
    String path = "/Users/danni/Desktop/AS_EJB/AS_EJB-war/web/";
    //Real Path
    FacesContext context = FacesContext.getCurrentInstance();
    ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
    //Constructs path of the directory to save uploaded file
    String uploadFilePath = path + File.separator + UPLOAD_DIRECTORY;
    
    public String saveProduct() throws IOException {
        
            System.out.println("Dir: " + path);
            //Creates the save directory if it does not exists
            File fileSaveDir = new File(uploadFilePath);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdirs();
            }
            boolean file1Success = false;
            if (pic.getSize() > 0) {
                String fileName = getFileNameFromPart(pic);
                File outputFile = new File(uploadFilePath + File.separator + fileName);
                inputStream = pic.getInputStream();
                outputStream = new FileOutputStream(outputFile);
                byte[] buffer = new byte[1024];
                int bytesRead = 0;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                file1Success = true;
            }
            boolean file2Success = false;

            if (file1Success || file2Success) {
                setMessage("Image successfully uploaded");
            } else {
                setMessage("Error, select atleast one file!");
            }
            product.setProductName(name);
            product.setAmount(amount);
            product.setTypeid(productTypeFacade.find(this.type));
            product.setProductInfo(info);
            product.setPrice(price);
            product.setPic(getFileNameFromPart(pic));
            productFacade.create(product);
            setMessage("Image successfully uploaded");
            return "index";
        
           

    }

    public String deleteProduct(int id) {
        Product p = productFacade.find(id);
        productFacade.remove(p);
        setMessage("Product ID: " + id + " is deleted.");
        return "index";
    }

    public String viewProductDetails(int id) {
        product = productFacade.find(id);
        idtype = product.getTypeid().getTypeID();
        return "index";
    }

   
    public List<Product> showAllProduct(){ 
            return productFacade.findAll();  
    }
    public String getFileNameFromPart(Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {
                String fileName = content.substring(content.indexOf('=')
                        + 1).trim().replace("\"", "");
                return fileName;
            }
        }
        return null;
    }
    


 

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Part getPic() {
        return pic;
    }

    public void setPic(Part pic) {
        this.pic = pic;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIdtype() {
        return idtype;
    }

    public void setIdtype(int idtype) {
        this.idtype = idtype;
    }
    
}