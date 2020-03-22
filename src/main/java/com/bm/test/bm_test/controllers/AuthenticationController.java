package com.bm.test.bm_test.controllers;

// vendors
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// local
import com.bm.test.bm_test.constants.Constants;
import com.bm.test.bm_test.model.*;
import com.bm.test.bm_test.services.AuthenticationService;
import com.bm.test.bm_test.db.UserRepository;

import java.util.HashMap;

@Controller
@RequestMapping(path="/api")
public class AuthenticationController {
    @Autowired
    private UserRepository userRepository;
    private AuthenticationService authenticationService = new AuthenticationService();

    private ResponseEntity mapErrorResponse(ServiceException exception) {
        ResponseData responseData = new ErrorResponseData(exception.getErrorCode(), exception.getErrorDescription());
        HttpStatus responseCode;

        switch (exception.getErrorCode()) {
            case Constants.ERROR_NOT_AUTH:
                responseCode = HttpStatus.UNAUTHORIZED;
                break;
            case Constants.ERROR_NOT_FOUND:
                responseCode = HttpStatus.NOT_FOUND;
                break;
            default:
                responseCode = HttpStatus.BAD_REQUEST;
                break;
        }

        return (new Response(responseCode, responseData)).getResponse();
    }

    @PostMapping(path="/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity addNewUser(@RequestBody LoginForm loginForm) {
        HashMap<String, String> tokenData;
        try {
            tokenData = authenticationService.authenticate(loginForm);
        } catch (ServiceException e) {
            return this.mapErrorResponse(e);
        }

        SuccessResponseData responseData = new SuccessResponseData();
        responseData.addElement("data", tokenData);
        return (new Response(HttpStatus.OK, responseData)).getResponse();
    }
}
