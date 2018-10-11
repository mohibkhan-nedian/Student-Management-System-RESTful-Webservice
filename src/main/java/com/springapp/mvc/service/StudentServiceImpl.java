package com.springapp.mvc.service;

import com.springapp.mvc.dao.Studentdao;
import com.springapp.mvc.dao.Studentdaoimpl;
import com.springapp.mvc.domain.Student;
import com.springapp.mvc.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mohib on 10/27/2015.
 */

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private Studentdao studentdao; // actually object of studentdaoimpl is created, see mvc-dispatcher-servlet.xml

    @Override
    @Transactional
    public void insert(Student student) {
        studentdao.insert(student);
    }

    @Override
    @Transactional
    public void delete(int id ){

        studentdao.delete(id);
    }

    @Override
    @Transactional
    public Student update( int id, String name ){
        Student student = studentdao.update( id, name);
        return student;
    }
    @Override
    @Transactional
    public Student update(int id, int age, String name ){

        Student student = studentdao.update( id, age, name);
        return student;
    }
    @Override
    @Transactional
    public Student getStudentById(int id) {

        Student student = (Student)studentdao.getStudentById(id);
        return student;

    }


}
