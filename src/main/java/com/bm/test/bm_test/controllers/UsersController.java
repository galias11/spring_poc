package com.bm.test.bm_test.controllers;

// vendors
import com.bm.test.bm_test.config.Messages;
import com.bm.test.bm_test.model.dto.*;
import com.bm.test.bm_test.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// local
import com.bm.test.bm_test.services.UserService;
import com.bm.test.bm_test.db.UserRepository;

@Controller
@RequestMapping(path="/api")
public class UsersController {
    @Autowired
    private UserRepository userRepository;
    private UserService userService = new UserService();

    @PostMapping(path="/public/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity addNewUser(@RequestBody UserForm userForm) {
        try {
            userService.saveUser(userForm);
        } catch (ServiceException e) {
            ResponseData responseData = new ErrorResponseData(e.getErrorCode(), e.getErrorDescription());
            return (new Response(HttpStatus.BAD_REQUEST, responseData)).getResponse();
        }

        SuccessResponseData responseData = new SuccessResponseData();
        responseData.addElement("data", Messages.USERS_REGISTER_SUCCESS.getDescription());
        return (new Response(HttpStatus.OK, responseData)).getResponse();
    }

    @GetMapping(path="/private/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}