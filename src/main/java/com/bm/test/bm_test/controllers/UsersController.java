package com.bm.test.bm_test.controllers;

// vendors
import com.bm.test.bm_test.config.Messages;
import com.bm.test.bm_test.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// local
import com.bm.test.bm_test.interfaces.ResponseData;
import com.bm.test.bm_test.services.UserService;
import com.bm.test.bm_test.db.UserRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path="/services")
public class UsersController {
    @Autowired
    private UserRepository userRepository;
    private UserService userService = new UserService();

    @PostMapping(path="/add")
    public @ResponseBody ResponseEntity addNewUser(@RequestBody UserForm userForm) {
        try {
            userService.saveUser(userRepository, userForm);
        } catch (ServiceException e) {
            ResponseData responseData = new ErrorResponseData(e.getErrorCode(), e.getErrorDescription());
            return (new Response(HttpStatus.BAD_REQUEST, responseData)).getResponse();
        }

        ResponseData responseData = new SuccessResponseData(Messages.USERS_REGISTER_SUCCESS);
        return (new Response(HttpStatus.OK, responseData)).getResponse();
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}