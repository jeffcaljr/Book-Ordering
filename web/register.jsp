<%-- 
    Jeffery Calhoun
    cs4010 hw4
    11/22/2016
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <h1>New User Registration</h1>
        
        <form action="cart" method="post">
            
            <input type="hidden" name="action" value="register"/>
            
            <label>Email:</label>
            <input type="email" name="email" value="${email}" required/>
            <br/>
            
            <label>Password:</label>
            <input type="password" name="password" value="${password}" required/>
            <br/>
            
            <label>First Name:</label>
            <input type="text" name="firstName" required/>
            <br/>
            
            <label>Password:</label>
            <input type="text" name="lastName" required/>
            <br/>
            
            <input type="submit" value="Join Now" /> 
        </form>
    </body>
</html>
