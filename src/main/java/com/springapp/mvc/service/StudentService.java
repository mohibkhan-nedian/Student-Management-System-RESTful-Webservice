package com.springapp.mvc.service;

import com.springapp.mvc.dao.Studentdao;
import com.springapp.mvc.domain.Student;

/**
 * Created by mohib on 10/27/2015.
 */
// although dao and service interfaces are usually same...following is wrong, studentservice shouldnt extend dao
public interface StudentService extends Studentdao{
 // made another interface for studentservice to add some special behavior if required other than defined in dao

}
