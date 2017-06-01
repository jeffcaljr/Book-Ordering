/*
    Jeffery Calhoun
    cs4010 hw4
    11/22/2016
*/
package calhoun.business;

import java.io.Serializable;
import java.text.NumberFormat;

//Data representation of a book
public class BookItem implements Serializable{
    private String code;
    private String title;
    private String imageURL;
    private double price;

    public BookItem() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getPriceCurrency(){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(getPrice());
    }
    
}
