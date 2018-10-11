package com.springapp.mvc.dao;

import com.springapp.mvc.domain.Student;

/**
 * Created by mohib on 10/27/2015.
 */
public interface Studentdao {
    void insert(Student student);

    Student update(int id, String name);

    Student update(int id ,int age, String name);

    void delete(int id);

    Student getStudentById(int id);

}
