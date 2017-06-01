/*
    Jeffery Calhoun
    cs4010 hw4
    11/22/2016
*/
package calhoun.data;

import calhoun.business.BookItem;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class BookIO {
    
    //Parses text file to create a book with a given code
    public static BookItem getBookItem(String code, String path){
        try{
            File f = new File(path);
            BufferedReader in = new BufferedReader(new FileReader(f));
            String line = in.readLine();
            
            while(line != null){
                StringTokenizer t = new StringTokenizer(line, "|");
                String producctCode = t.nextToken();
                if(code.equalsIgnoreCase(producctCode)){
                    String title = t.nextToken();
                    String imageURL = t.nextToken();
                    double price = Double.parseDouble(t.nextToken());
                    BookItem bookItem = new BookItem();
                    bookItem.setTitle(title);
                    bookItem.setCode(code);
                    bookItem.setImageURL(imageURL);
                    bookItem.setPrice(price);
                    in.close();
                    return bookItem;
                }
                line = in.readLine();
            }
            in.close();
            return null;
        }
        catch(IOException e){
            System.err.println(e);
            return null;
            
        }
    }
}
