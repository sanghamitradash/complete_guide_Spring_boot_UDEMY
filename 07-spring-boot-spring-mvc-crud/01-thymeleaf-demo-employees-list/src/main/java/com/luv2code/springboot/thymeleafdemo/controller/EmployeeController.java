package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    //create a field employeeService
    private EmployeeService employeeService;

    /* create a constructor injection: BECAUSE here we have only one constructor in our class
    so AUTOWIRED annotation is optional
    SO Spring will still inject this given dependency */
    public EmployeeController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    //add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model theModel){

        //get the employees from db
        List<Employee> theEmployees = employeeService.findAll();

        //add to the Spring model
        theModel.addAttribute("employees", theEmployees);

        return "list-employees";
    }

}
