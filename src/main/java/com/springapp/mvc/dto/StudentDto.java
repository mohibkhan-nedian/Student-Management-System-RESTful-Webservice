package com.springapp.mvc.dto;

import com.springapp.mvc.domain.Student;

/**
 * Created by mohib on 10/28/2015.
 */
public class StudentDto {
    private String name;
    private Integer age;

    public StudentDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
