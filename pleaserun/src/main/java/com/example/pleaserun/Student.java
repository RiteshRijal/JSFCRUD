package com.example.pleaserun;

import jakarta.enterprise.context.RequestScoped;


import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Named
@RequestScoped
public class Student implements Serializable {   
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String address;
    private String selectedClass;
    private String selectedSubject;
    private List<String> availableClasses;
    private List<String> availableSubjects;
    
    public void submit() {
        // save student data into database
        StudentDAO dao = new StudentDAO();
        dao.save(this);
    }
   public List<Student> getAllStudents() {
    Showall  dao = new Showall();
    return dao.getAllStudents();
}
   public void delete() {
        // save student data into database
        StudentDAO dao = new StudentDAO();
        dao.delete(this);
    }
    
    
    public Student() {
        availableClasses = Arrays.asList("Class A", "Class B", "Class C");
        availableSubjects = Arrays.asList("BscCSIT", "BBA", "BBM");
    }
    public String getId(){
        return id;
    }
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getSelectedClass() {
        return selectedClass;
    }

    public void setSelectedClass(String selectedClass) {
        this.selectedClass = selectedClass;
    }

    public String getSelectedSubject() {
        return selectedSubject;
    }

    public void setSelectedSubject(String selectedSubject) {
        this.selectedSubject = selectedSubject;
    }

    public List<String> getAvailableClasses() {
        return availableClasses;
    }

    public List<String> getAvailableSubjects() {
        return availableSubjects;
    }
    public String toString() {
        return "Name: " + name + ", Address: " + address + ", Class: " + selectedClass + ", Subjects: " + selectedSubject;
    }
     

    void setId(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
