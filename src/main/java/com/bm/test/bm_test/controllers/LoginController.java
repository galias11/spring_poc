package com.bm.test.bm_test.controllers;

// vendors
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping(path="/login")
    public ModelAndView getLogin() {
        String viewName = "login";
        return new ModelAndView(viewName);
    }
}
