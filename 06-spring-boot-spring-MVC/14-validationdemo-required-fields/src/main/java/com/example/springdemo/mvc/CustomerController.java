package com.example.springdemo.mvc;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @GetMapping("/")
    public String showForm(Model theModel){ //Model allow us to share
        // information between controllers and view pages(Thymeleaf)

        theModel.addAttribute("customer", new Customer());
        //customer is the NAME and new Customer() is VALUE

        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer,
                              BindingResult theBindingResult){
        /* @Valid tell SPRINGBOOT MVC to perform VALIDATION

        @ModelAttribute says read the form data from that model attribute customer so that the customer that
        submitted by the HTML form

        BindingResults is the results of validation
         */

        if (theBindingResult.hasErrors()){
            return "customer-form";
        }
        else{
            return "customer-confirmation";
        }

    }
}
