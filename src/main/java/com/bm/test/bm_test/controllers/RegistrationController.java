package com.bm.test.bm_test.controllers;

// vendors
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// local
import org.springframework.web.servlet.ModelAndView;

@Controller // This means that this class is a Controller
public class RegistrationController {

    @GetMapping(path="/register")
    public ModelAndView getRegistrationForm() {
        String viewName = "registration-form";
        return new ModelAndView(viewName);
    }
}
