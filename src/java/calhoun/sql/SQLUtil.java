/*
    Jeffery Calhoun
    cs4010 hw4
    11/22/2016
*/
package calhoun.sql;

import calhoun.user.User;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeff
 */
public class SQLUtil {
    
    Connection connection;

    public SQLUtil() {
        
        try{
            //load the JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/hw4";
            String username = "student";
            String password = "sesame";
            connection = (Connection) DriverManager.getConnection(dbURL, username, password);
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            for(Throwable t: e){
                t.printStackTrace();
            }
        }
    }
    
    /**
     * Checks if email exists in User Database
     * @param email: user email to be checked
     * @return: true if a row with email was found, false otherwise
     */
    public boolean userEmailExists(String email){
        String preparedSQL = "SELECT Email FROM User WHERE Email = ?";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(preparedSQL);
            ps.setString(1, email);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
               System.out.println("email exists");
                return true;
            }
            else{
                System.out.println("email doesn't exist");
                return false;
            }
            
        } catch (SQLException e) {
            for(Throwable t: e){
                t.printStackTrace();
            }
            System.out.println("email doesn't exist");
            return false;
        }
        
    }
    
    /**
     * Checks database for user
     * @param email : user's email address
     * @param password: user's password
     * @return User object with fetched firstName, lastName, and email; null if user not found
     */
    public User userVerify(String email, String password){
        User user = null;
        String preparedSQL = "SELECT * FROM User WHERE Email = ? AND BINARY Password = ?";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(preparedSQL);
            ps.setString(1, email);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                user = new User(rs.getString("Email"),
                       rs.getString("FirstName"),
                       rs.getString("LastName"));
            }
            
        } catch (SQLException e) {
            for(Throwable t: e){
                t.printStackTrace();
            }
        }
        finally{
            System.out.println(((user == null) ? "user doesn't exist" : user.getEmail() + " exists!"));
            return user;
            
            
        }
    }
    
    public boolean addUser(User user, String password){
        String preparedSQL = "INSERT INTO User (Email, FirstName, LastName, Password) VALUES (?, ?, ?, ?)";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(preparedSQL);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            ps.setString(4, password);
            
            ps.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            for(Throwable t: e){
                t.printStackTrace();
            }
            return false;
        }
    }
}
