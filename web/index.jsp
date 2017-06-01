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
        <title>Home Page</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    
    <body>
        <h1>Book List</h1>
    <table border="1px">
        <tr>
            <th>Cover</th>
            <th>Title</th>
            <th>Price</th>
        </tr>
        <tr>
            <td>
                <figure>
                    <img src="https://images-na.ssl-images-amazon.com/images/I/41MLd2DZYwL._SY344_BO1,204,203,200_.jpg" alt="Twilight">
                </figure>
            </td>
            <td class="bookTitle">Twilight</td>
            <td class="bookPrice">$499</td>
            <td>
                <form action="cart" method="post">
                    <input type="hidden" name="action" value="add">
                    <input type="hidden" name="code" value="TWI">
                    <input type="submit" value="Add to Cart">
                </form>
            </td>
        </tr>
        
        
        <tr>
            <td>
                <figure>
                    <img src="https://upload.wikimedia.org/wikipedia/en/thumb/8/89/Newmooncover.jpg/220px-Newmooncover.jpg" alt="New Moon">
                </figure>
            </td>
            <td class="bookTitle">Twilight New Moon</td>
            <td class="bookPrice">$349</td>
            <td>
                <form action="cart" method="post">
                    <input type="hidden" name="action" value="add">
                    <input type="hidden" name="code" value="TNM">
                    <input type="submit" value="Add to Cart">
                </form>
            </td>
        </tr>
        
        <tr>
            <td>
                <figure>
                    <img src="https://upload.wikimedia.org/wikipedia/en/2/20/Eclipsecover.jpg" alt="Eclipse">
                </figure>
            </td>
            <td class="bookTitle">Twilight Eclipse</td>
            <td class="bookPrice">$249</td>
            <td>
                <form action="cart" method="post">
                    <input type="hidden" name="action" value="add">
                    <input type="hidden" name="code" value="TWE">
                    <input type="submit" value="Add to Cart">
                </form>
            </td>
        </tr>
        
        <tr>
            <td>
                <figure>
                    <img src="https://upload.wikimedia.org/wikipedia/en/3/31/Breaking_Dawn_cover.jpg" alt="Breaking Dawn">
                </figure>
            </td>
            <td class="bookTitle">Twilight Breaking Dawn</td>
            <td class="bookPrice">$199</td>
            <td>
                <form action="cart" method="post">
                    <input type="hidden" name="action" value="add">
                    <input type="hidden" name="code" value="TBD">
                    <input type="submit" value="Add to Cart">
                </form>
            </td>
        </tr>
        
    </table>
    </body>
</html>
