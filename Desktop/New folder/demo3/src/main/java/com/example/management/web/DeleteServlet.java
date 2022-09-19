package com.example.management.web;

import com.example.management.dao.DbConnection;
import com.example.management.dao.StudentDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     int id=Integer.parseInt(request.getParameter("id"));
        try {
            StudentDao dao=new StudentDao(DbConnection.connectDb());
            dao.deleteStudent(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect(request.getContextPath() + "/index.jsp");

    }


}
