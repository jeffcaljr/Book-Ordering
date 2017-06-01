/*
    Jeffery Calhoun
    cs4010 hw4
    11/22/2016
*/
package calhoun.business;

import java.io.Serializable;
import java.text.NumberFormat;

//Representation of a BookItem that is placed in a cart
public class Book implements Serializable{
    private BookItem bookItem;
    private int quantity;

    public Book() {
    }

    public BookItem getBookItem() {
        return bookItem;
    }

    public void setBookItem(BookItem bookItem) {
        this.bookItem = bookItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getTotal(){
        return this.quantity * bookItem.getPrice();
    }
    
    public String getTotalCurrency(){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(getTotal());
    }
    
    
}
