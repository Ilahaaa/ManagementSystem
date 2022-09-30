<%--
  Created by IntelliJ IDEA.
  User: Ilaha.Abdullayeva
  Date: 9/12/2022
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<style>
    form{
        padding:16px;
        font-size: 18px;
    }
    input {
        width: 100%;
        padding: 15px;
        margin: 5px 0 22px 0;
        display: inline-block;
        border: none;
        background: #f1f1f1;
    }

    input:focus {
        background-color: #ddd;
        outline: none;
    }
    button{
        background-color: #04AA6D;
        color: white;
        padding: 16px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
        opacity: 0.9;
        font-size: 20px;
    }
   button:hover {
        opacity: 1;
    }

   h2{
       text-align: center;
       color: red;
   }
</style>



<h2>Add student</h2>
<form action="register"  method="post">
    <label for="name"><b>Name</b></label>
    <input type="text" name="name"  id="name"></br>
    <label for="surname"><b>Surname</b></label>
    <input type="text" name="surname" id="surname"></br>
    <label for="faculty"><b>Faculty</b></label>
    <input type="text" name="faculty" id="faculty"></br>
    <button type="submit" value="submit">Submit</button>
</form>



</body>
</html>
