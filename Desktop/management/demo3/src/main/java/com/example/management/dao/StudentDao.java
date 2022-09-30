package com.example.management.dao;


import com.example.management.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    static Connection connection;
    static PreparedStatement ps;
    private Connection conn;

    public StudentDao(Connection conn) {
super();
  this.conn=conn;
    }

// select all students
    public List<Student> getAllStudents(){
    ArrayList<Student> list=new ArrayList<Student>();

    try {
        connection = DbConnection.connectDb();
        ps=connection.prepareStatement("select * from student");
        ResultSet rs=ps.executeQuery();

        while (rs.next()){
          Student s=new Student();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setSurname(rs.getString("surname"));
            s.setFaculty(rs.getString("faculty"));
            list.add(s);

        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
        return list;
    }



// select student by id

    public Student getStudent(int id){
        Student student=null;
        try {
            connection = DbConnection.connectDb();
            ps=connection.prepareStatement("select * from student where id=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                id = rs.getInt("id");
                String name=rs.getString("name");
                String surname=rs.getString("surname");
                String faculty=rs.getString("faculty");
                student=new Student(id,name,surname,faculty);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }




// add student

    public void insertStudent(Student student) {
        String sql = "INSERT INTO student(name,surname,faculty) VALUES(?,?,?)";

        try {
            connection = DbConnection.connectDb();
            ps = connection.prepareStatement(sql); {
                ps.setString(1, student.getName());
                ps.setString(2, student.getSurname());
                ps.setString(3,student.getFaculty());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }



//update student
    public void updateStudent(Student student) {
        String sql = "UPDATE  student SET name=?,surname=?,faculty=? where id=?";

        try {
            connection = DbConnection.connectDb();
            ps = connection.prepareStatement(sql); {
                ps.setString(1, student.getName());
                ps.setString(2, student.getSurname());
                ps.setString(3,student.getFaculty());
                ps.setInt(4,student.getId());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }



// delete student
    public void deleteStudent(int id) {
        String sql = "Delete from student where id=?";

        try {
            connection = DbConnection.connectDb();
            ps = connection.prepareStatement(sql); {
                ps.setInt(1,id);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }



}
