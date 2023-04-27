/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pleaserun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ritesh Rijal
 */
public class Showall 
        
{
    public Showall() {
   // constructor code here
}
     private final String url = "jdbc:mysql://localhost:3306/mydatabase?autoReconnect=true&useSSL=false";
    private final String user = "root";
    private final String password = "root";
     public List<Student> getAllStudents() {
    List<Student> students = new ArrayList<>();
    String sql = "SELECT * FROM students";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        return students;
    }

    try (Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            Student student = new Student();
            student.setName(rs.getString("name"));
            student.setAddress(rs.getString("address"));
            student.setSelectedClass(rs.getString("class"));
            student.setSelectedSubject(rs.getString("subjects"));
            students.add(student);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return students; 
}
}
