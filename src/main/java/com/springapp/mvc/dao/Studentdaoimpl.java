package com.springapp.mvc.dao;

import com.springapp.mvc.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by mohib on 10/27/2015.
 */
@Repository
public class Studentdaoimpl implements Studentdao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(Student student) {
        sessionFactory.getCurrentSession().saveOrUpdate(student);
    }

    @Override
    public void delete(int id) {
        Student student =(Student)sessionFactory.getCurrentSession().get(Student.class,id);
        sessionFactory.getCurrentSession().delete(student);
    }

    @Override
    public Student getStudentById(int id){
        Student student =(Student)sessionFactory.getCurrentSession().get(Student.class,id);
        return  student;
    }

    @Override
    public
    Student update(int id,String name){
        Student student =(Student)sessionFactory.getCurrentSession().get(Student.class,id);
        student.setName(name);
        sessionFactory.getCurrentSession().saveOrUpdate(student);
        return  student;
    }

    @Override
    public Student update(int id, int age, String name){
        Student student =(Student)sessionFactory.getCurrentSession().get(Student.class,id);
        student.setName(name);
        student.setAge(age);
        sessionFactory.getCurrentSession().saveOrUpdate(student);
        return  student;
    }

}
