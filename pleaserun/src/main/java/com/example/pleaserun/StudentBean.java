/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pleaserun;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author Ritesh Rijal
 */
@Named
@RequestScoped
public class StudentBean {
    private List<StudentBean> dataList;

   
    private List<Student> students;
    private Studentedit studentEdit = new Studentedit();

    public List<Student> getStudents() {
        students = studentEdit.getAllStudents();
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
}
