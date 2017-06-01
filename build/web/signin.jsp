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
        <title>Sign In</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <h1>Sign In</h1>
        <p>${error}</p>
        <form action="cart" method="post">
            
            <input type="hidden" name="action" value="signin"/>
            
            <label>Email:</label>
            <input type="email" name="email" value="${email}" required/>
            <br/>
            
            <label>Password:</label>
            <input type="password" name="password" required/>
            <br/>
            
            <input type="submit" value="Submit" /> 
        </form>
    </body>
</html>
