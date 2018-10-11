package com.springapp.mvc;

import com.springapp.mvc.domain.Student;
import com.springapp.mvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {


	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello Student!");
		return "hello"; //returns a string that’s a hint (in this case, a very explicit one, WEB-INF/views/home.jsp) to help chose the View to render the response
	}

}