<a href="${pageContext.request.contextPath}/employeeTask">
    Employee Task
</a>
||
<a href="${pageContext.request.contextPath}/managerTask">
    Manager Task
</a>
||
<a href="${pageContext.request.contextPath}/userInfo">
    User Info
</a>
||
<a href="${pageContext.request.contextPath}/login">
    Login
</a>
||
<a href="${pageContext.request.contextPath}/logout">
    Logout
</a>
&nbsp;
<span style="color:red">[ ${loginedUser.userName} ]</span>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<h1>Product Search</h1>
<p>Page for providing information about products in stock</p>


<div>
    <form action="/product" method="get">
        <label for="name">Enter a product name to search for:</label><br>
        <input type="text" id="name" name="name"><br>
        <label for="category">Product category selection:</label><br>
        <input type="text" id="category" name="category">

        <br>
        <input type="submit" value="Submit">
    </form>
</div>

<div>
    <p><a href="./productAdd.html">Add product form</a>  </p>
</div>

<div>
    <p><a href="./viewBasket">View Cart</a>  </p>
</div>
</body>

<head>
    <meta charset="UTF-8">
</head>
<body>

<h1>Add Product</h1>


<div>
    <form action="/product" method="post">
        <label for="name">Product name:</label><br>
        <input type="text" id="name" name="name"><br>
        <label for="category">Category:</label><br>
        <input type="text" id="category" name="category"><br>
        <label for="price">Price:</label><br>
        <input type="text" id="price" name="price">
        <br><br>
        <input type="submit" value="Submit">
    </form>
</div>


</body>
</html>
