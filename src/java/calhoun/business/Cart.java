/*
    Jeffery Calhoun
    cs4010 hw4
    11/22/2016
*/
package calhoun.business;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 *
 * @author Jeff
 */
public class Cart implements Serializable{
    private ArrayList<Book> books;
    
    public Cart(){
        books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
    
    public int getCount(){
        return books.size();
    }
    
    //Get total price of cart
    public double getTotal(){
        double total = 0.0;
        for(Book book: books){
            total += book.getTotal();
        }
        return total;
    }
    
   
    public void addItem(Book book){
        int quantity = book.getQuantity();
        for(Book b: books){
            if(b.getBookItem().getCode().equals(book.getBookItem().getCode())){
                b.setQuantity(b.getQuantity() + 1);
                return;
            }
        }
        books.add(book);
    }
    
    public void updateItem(Book book){
        int quantity = book.getQuantity();
        for(Book b: books){
            if(b.getBookItem().getCode().equals(book.getBookItem().getCode())){
                b.setQuantity(quantity);
                return;
            }
        }
        books.add(book);
    }
    
    //Search books in cart for all books matching the code you want to remove, and remove them
    public void removeItem(Book book){
        for(int i = 0; i < books.size(); i++){
            Book b = books.get(i);
            if(book.getBookItem().getCode().equals(b.getBookItem().getCode())){
                books.remove(b);
                return;
            }
        }
    }
    
    //Get the total price of the cart in a currency format
    public String getTotalCurrency(){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(getTotal());
    }
    
    
}
