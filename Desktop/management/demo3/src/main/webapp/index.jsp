<%@ page import="java.sql.Connection" %>
<%@ page import="com.example.management.dao.DbConnection" %>
<%@ page import="com.example.management.dao.StudentDao" %>
<%@ page import="com.example.management.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>


<style>
    table {
        border-collapse: collapse;
        border-spacing: 0;
        width: 100%;
        border: 1px solid #ddd;
    }

    th, td {
        text-align: left;
        padding: 16px;
    }
    thead th{
        background-color: brown;
        color: #dddddd;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }


a{
    background-color: mediumblue;
    color: white;
    padding: 14px 25px;
    text-align: center;
    text-decoration: none;
    display: inline-block;}

</style>







<a href="add_student.jsp" >Add student</a>
</br>
</br>

<table >
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Faculty</th>
        <th>Actions</th>
        <th></th>

    </tr>
    </thead>
    <tbody>

    <% int i=1;
        StudentDao dao=new StudentDao(DbConnection.connectDb());
        List<Student> list=dao.getAllStudents();
        for (Student s: list
             ) {

            %>

    <tr>
       <th>
                   <%
                     out.print(i);
                   %>
       </th>

        <th><%=s.getName()%></th>
        <th><%=s.getSurname()%></th>
        <th><%=s.getFaculty()%></th>
        <th><a href="edit_student.jsp?id=<%=s.getId()%>">Edit</a></th>
        <th><a href="delete?id=<%=s.getId()%>">Delete</a></th>


    </tr>

      <%
        i++;
        }
    %>
    </tbody>

</table>


</body>



</html>