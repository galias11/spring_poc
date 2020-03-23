package com.bm.test.bm_test.services;

// vendors
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashMap;

// local
import com.bm.test.bm_test.config.JwtTokenProvider;
import com.bm.test.bm_test.config.SpringUtils;
import com.bm.test.bm_test.constants.Constants;
import com.bm.test.bm_test.db.UserRepository;
import com.bm.test.bm_test.config.Messages;
import com.bm.test.bm_test.model.*;

import javax.annotation.PostConstruct;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    private JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();
    private final BCryptPasswordEncoder pwdEncoder;

    public AuthenticationService() {
        this.userRepository = SpringUtils.CONTEXT.getBean(UserRepository.class);
        this.pwdEncoder = new BCryptPasswordEncoder(Constants.PASSWORD_STRING);
    }

    private User getUser(LoginForm loginForm) {
        return userRepository.findUserById(loginForm.getUserName());
    }

    private boolean validatePassword(LoginForm loginForm, User user) {
        return pwdEncoder.matches(loginForm.getPassword(), user.getEncryptedPassword());
    }

    public HashMap<String, String> authenticate(LoginForm loginForm)
            throws ServiceException
    {
        System.out.println(jwtTokenProvider);
        User user = this.getUser(loginForm);

        if(user == null) {
            throw new ServiceException(Messages.USERS_NOT_FOUND.getCode(), Messages.USERS_NOT_FOUND.getDescription());
        }

        if(!this.validatePassword(loginForm, user)) {
            throw new ServiceException(Messages.USERS_INVALID_CREDENTIALS.getCode(), Messages.USERS_INVALID_CREDENTIALS.getDescription());
        }

        HashMap<String, String> response = new HashMap<String, String>();
        response.put("accessToken", jwtTokenProvider.generateJWTToken(user));
        return response;
    }
}