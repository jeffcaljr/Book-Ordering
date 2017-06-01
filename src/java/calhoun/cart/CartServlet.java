/*
    Jeffery Calhoun
    cs4010 hw4
    11/22/2016
*/
package calhoun.cart;

import calhoun.business.Book;
import calhoun.business.BookItem;
import calhoun.business.Cart;
import calhoun.data.BookIO;
import calhoun.sql.SQLUtil;
import calhoun.user.User;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CartServlet extends HttpServlet {


  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.jsp";
        String action = request.getParameter("action");
        
        //Load driver and conenct to hw4 Database
        SQLUtil sqlUtil = new SQLUtil();
        
        if(action == null){
            action = "continue";
        }
        
        if(action.equals("continue")){
            url = "/index.jsp";
        }
        else if(action.equals("add")){
            url = "/cart.jsp";
            
            String code = request.getParameter("code");
            String quantityString = request.getParameter("quantity");
                        
            //Retrieve HTTP session and a Cart
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            if(cart == null){
                cart = new Cart();
            }
            
            
            
            //Create a BookItem for the book that will be added to cart
            String path = getServletContext().getRealPath("/WEB-INF/books.txt");
            BookItem bookItem = BookIO.getBookItem(code, path);
            
            Book book = new Book();
            
            book.setBookItem(bookItem);
            
            int quantity;
            
            if(quantityString == null){
                //user added a book through the "add" button, not the update form
                //therefore, quantity is not set at all
                quantity = 1;
                book.setQuantity(quantity);
                cart.addItem(book);
                
            }
            else{
                try{
                    quantity = Integer.parseInt(quantityString);
                    if(quantity < 0){
                        quantity = 1;
                    }
                    
                    book.setQuantity(quantity);
                    
                    if(quantity == 0){
                        cart.removeItem(book);
                    }
                    else{
                        cart.updateItem(book);
                    }
                }
                catch(NumberFormatException ex){
                    quantity = 1;
                }
                
            }
            
            session.setAttribute("cart", cart);
            
        }
        else if(action.equals("signin")){
            request.removeAttribute("error");
            
            HttpSession session = request.getSession();
            
            Cart cart = (Cart) session.getAttribute("cart");
            request.setAttribute("cart", cart);
            
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            User user = null;
            
             if(sqlUtil.userEmailExists(email.trim())){
                 //user exists.
                user = sqlUtil.userVerify(email.trim(), password);
                
                if(user == null){
                    //user exists, but the password doesnt match
                    request.setAttribute("error", "The password does not match. Please try again.");
                    session.setAttribute("email", email);
                    url = "/signin.jsp";
                }
                else{
                    //user exists and password matches
                    session.setAttribute("user", user);
                    url = "/checkout.jsp";
                }
            }
            else{
                //user email doesn't exist, move to registration page
                session.setAttribute("email", email);
                session.setAttribute("password", password);
                url = "/register.jsp";
                
            }
            
            
        }
        else if(action.equals("register")){
            HttpSession session = request.getSession();
            
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            
            User user = new User(email.trim(), firstName.trim(), lastName.trim());
            
            if(sqlUtil.addUser(user, password)){
                session.setAttribute("user", user);
            }
            
            url = "/checkout.jsp";
            
        }
        else if(action.equals("checkout")){
      
            url = "/signin.jsp";
            
            HttpSession session = request.getSession();
            
            Cart cart = (Cart) session.getAttribute("cart");
            
            request.setAttribute("cart", cart);
            
            
            User user = (User) session.getAttribute("user");
            
            if(user != null){
                url = "/checkout.jsp";
            }
            else{
                url = "/signin.jsp";
            }
            
        }
        else if(action.equals("reset")){
            HttpSession session = request.getSession();
            session.removeAttribute("cart");
            session.removeAttribute("user");
            session.removeAttribute("email");
            session.removeAttribute("password");
            url = "/index.jsp";
        }
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    

}
