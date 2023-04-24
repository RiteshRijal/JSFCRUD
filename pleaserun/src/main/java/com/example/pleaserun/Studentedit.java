package com.example.pleaserun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Studentedit {
    
    // JDBC driver and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/mydatabase";
    
    // Database credentials
    static final String USER = "root";
    static final String PASS = "password";

    // Retrieve all students from the database
    public List<Student> getAllStudents() {
        Connection conn = null;
        PreparedStatement stmt = null;
        List<Student> students = new ArrayList<>();
        try {
            // Register JDBC driver and open connection
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // Execute a SQL query to retrieve all students
            String sql = "SELECT * FROM students";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            // Extract data from result set and create a list of students
            while (rs.next()) {
                Student student = new Student();
                student.setName(rs.getString("name"));
                student.setAddress(rs.getString("address"));
                student.setSelectedClass(rs.getString("class"));
                student.setSelectedSubject(rs.getString("subjects"));
                students.add(student);
            }
            
            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // Finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
                // Nothing we can do
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return students;
    }
    
    // Update a student's information in the database
    public void updateStudent(Student student) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // Register JDBC driver and open connection
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // Execute a SQL query to update the student's information
            String sql = "UPDATE students SET address=?, class=?, subjects=? WHERE name=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, student.getAddress());
            stmt.setString(2, student.getSelectedClass());
            stmt.setString(3, student.getSelectedSubject());
            stmt.setString(4, student.getName());
            stmt.executeUpdate();
            
            // Clean-up environment
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // Finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
                // Nothing we can do
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
