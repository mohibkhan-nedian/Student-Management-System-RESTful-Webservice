package com.springapp.mvc;

import com.springapp.mvc.domain.Student;
import com.springapp.mvc.dto.StudentDto;
import com.springapp.mvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Random;

/**
 * Created by mohib on 10/28/2015.
 */

@RestController
@RequestMapping("/")
public class HelloRestController {

    @Autowired
    private StudentService studentService; // actually object of studentserviceimpl is created by Spring, since its impl is declared as service

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    //    public @ResponseBody String insert(StudentDto studentDto){
    public String insert(StudentDto studentDto){
        studentService.insert(new Student(studentDto.getName(), studentDto.getAge()));
        return "Object Created";
    }

    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public String deleteStudent(@RequestParam(value="id")int id){
        studentService.delete(id);
        return "Deleted";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    // No @ResponseBody required as @RestController used for class, it will be required if replace @RestController with @Controller
    public @ResponseBody StudentDto getStudent(int id) {

        Student student = studentService.getStudentById(id);
        StudentDto studentDto = new StudentDto();
        studentDto.setAge(student.getAge()) ;
        studentDto.setName(student.getName());
        return  studentDto;
    }

    @RequestMapping(value = "/patch", method = RequestMethod.PATCH)
    public StudentDto updateName( int id, String name) {
        Student student = studentService.update( id, name);
        StudentDto studentDto = new StudentDto();
        studentDto.setName(student.getName());
        studentDto.setAge(student.getAge());
        return  studentDto;
    }

    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public StudentDto updateAge( int id,int age, String name) {
        Student student = studentService.update(id, age, name);
        StudentDto studentDto = new StudentDto();
        studentDto.setName(student.getName());
        studentDto.setAge(student.getAge());
        return  studentDto;
    }

}