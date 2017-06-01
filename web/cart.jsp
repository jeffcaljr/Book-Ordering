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
        <title>JSP Page</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <h1>Cart Page</h1>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
               <td>$${book.bookItem.priceCurrency}</td>
               <td>${book.totalCurrency}</td>
               <td>
                   <form action="cart" method="post">
                       <input type="hidden" name="code" value="${book.bookItem.code}"/>
                       <input type="hidden" name="action" value="add" />
                       <input type="number"name="quantity" min="0" value="${book.quantity}"/>
                       <input type="submit" value="Update"/>
                   </form>
               </td>
               <td>
                   <form action="cart" method="post">
                       <input type="hidden" name="action" value="add">
                       <input type="hidden" name="code" value="${book.bookItem.code}">
                       <input type="hidden" name="quantity" value="0">
                       <input type="submit" value="RemoveItem">
                   </form>
               </td>
           </tr>
       </c:forEach>
       </table>
       
       <form action="cart" method="get">
           <input type="hidden" name="action" value="continue">
           <input type="submit" value="Continue Shopping">
       </form>
       
       <form action="cart" method="get">
           <input type="hidden" name="action" value="checkout">
           <input type="submit" value="Checkout">
       </form>
    </body>
</html>
