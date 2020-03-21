package com.bm.test.bm_test.controllers;

// vendors
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// local
import com.bm.test.bm_test.model.UserForm;
import com.bm.test.bm_test.model.ServiceException;
import com.bm.test.bm_test.services.UserService;
import com.bm.test.bm_test.model.User;
import com.bm.test.bm_test.db.UserRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class UsersController {
    @Autowired
    private UserRepository userRepository;
    private UserService userService = new UserService();

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser(@RequestBody UserForm userForm) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        try {
            userService.saveUser(userRepository, userForm);
        } catch (ServiceException e) {
            return "chanfle";
        }

        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}