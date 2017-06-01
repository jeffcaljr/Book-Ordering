<%-- 
    Jeffery Calhoun
    cs4010 hw4
    11/22/2016
    
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
        <h1 class="pageTitle">Thanks for your order.</h1>
        <p>Here is the information that you entered:</p>
        
        <p><span class="label">Email:</span>${user.email}</p>
        <p><span class="label">First Name:</span>${user.firstName}</p>
        <p><span class="label">Last Name:</span>${user.lastName}</p>
        
        <c:if test="cart.books.count == 0">
            <p>Your cart is empty.</p>
        </c:if>

            
        <table border="1px">
            <tr>
                <th>Cover</th>
                <th>Title</th>
                <th>Price</th>
                <th>Amount</th>
                <th>Quantity</th>
            </tr>
            <c:forEach var="book" items="${cart.books}">
                <tr>
                    <td>
                        <figure>
                            <img src="${book.bookItem.imageURL}">
                        </figure>
                    </td>
                    <td>${book.bookItem.title}</td>
                    <td>${book.bookItem.priceCurrency}</td>
                    <td>${book.totalCurrency}</td>
                    <td>${book.quantity}</td>
                </tr>
            </c:forEach>
            
                <tr>
                    <th>Total</th>
                    <td></td>
                    <td></td>
                    <td>${cart.totalCurrency}</td>
                    <td></td>
                </tr>
        </table>
                    <br
                    <p>To order another book, click on the button below</p>
                <form action="cart" method="get">
                    <input type="hidden" name="action" value="reset">
                    <input type="submit" value="Return">
                </form>
    </body>
</html>
