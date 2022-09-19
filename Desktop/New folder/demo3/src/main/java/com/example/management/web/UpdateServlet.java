package com.example.management.web;

import com.example.management.dao.DbConnection;
import com.example.management.dao.StudentDao;
import com.example.management.model.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String faculty = request.getParameter("faculty");
        int id=Integer.parseInt(request.getParameter("id"));


        try {
            Student student1=new Student(id,name,surname,faculty);
            StudentDao dao = new StudentDao(DbConnection.connectDb());
            dao.updateStudent(student1);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect(request.getContextPath() + "/index.jsp");

    }
    }

