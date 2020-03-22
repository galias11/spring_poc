package com.bm.test.bm_test.services;

// vendors
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bm.test.bm_test.constants.Security;
import com.bm.test.bm_test.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

// local
import com.bm.test.bm_test.config.SpringUtils;
import com.bm.test.bm_test.constants.Constants;
import com.bm.test.bm_test.db.UserRepository;
import com.bm.test.bm_test.config.Messages;

import java.util.Date;
import java.util.HashMap;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
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

    private String generateJWTToken(User user) {
        String accessToken = JWT.create()
                .withSubject(user.toString())
                .withExpiresAt(new Date(System.currentTimeMillis() + Security.EXPIRATION_TIME))
                .sign(Algorithm.HMAC256(Security.SECRET));
        return accessToken;
    }

    public HashMap<String, String> authenticate(LoginForm loginForm)
            throws ServiceException
    {
        User user = this.getUser(loginForm);

        if(user == null) {
            throw new ServiceException(Messages.USERS_NOT_FOUND.getCode(), Messages.USERS_NOT_FOUND.getDescription());
        }

        if(!this.validatePassword(loginForm, user)) {
            throw new ServiceException(Messages.USERS_INVALID_CREDENTIALS.getCode(), Messages.USERS_INVALID_CREDENTIALS.getDescription());
        }

        HashMap<String, String> response = new HashMap<String, String>();
        response.put("accessToken", generateJWTToken(user));
        return response;
    }
}