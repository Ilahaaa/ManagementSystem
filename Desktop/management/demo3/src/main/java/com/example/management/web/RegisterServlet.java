package com.example.management.web;

import java.io.*;
import java.sql.SQLException;


import com.example.management.dao.DbConnection;
import com.example.management.dao.StudentDao;
import com.example.management.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String faculty = req.getParameter("faculty");
        Student student = new Student(name, surname, faculty);


        try {
            StudentDao dao = new StudentDao(DbConnection.connectDb());
            dao.insertStudent(student);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        resp.sendRedirect(req.getContextPath() + "/index.jsp");

    }
}