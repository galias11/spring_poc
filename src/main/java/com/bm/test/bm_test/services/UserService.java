package com.bm.test.bm_test.services;

// vendors
import com.bm.test.bm_test.db.VideoRepository;
import com.bm.test.bm_test.model.dto.UserForm;
import com.bm.test.bm_test.model.entity.Video;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

// local
import com.bm.test.bm_test.config.SpringUtils;
import com.bm.test.bm_test.constants.Constants;
import com.bm.test.bm_test.model.entity.User;
import com.bm.test.bm_test.db.UserRepository;
import com.bm.test.bm_test.model.dto.ServiceException;
import com.bm.test.bm_test.config.Messages;

@Service
public class UserService {
    private UserRepository userRepository;
    private VideoRepository videoRepository;
    private final BCryptPasswordEncoder pwdEncoder;

    public UserService() {
        this.userRepository = SpringUtils.CONTEXT.getBean(UserRepository.class);
        this.videoRepository = SpringUtils.CONTEXT.getBean(VideoRepository.class);
        this.pwdEncoder = new BCryptPasswordEncoder(Constants.PASSWORD_STRING);
    }

    private boolean checkExistingUser(User user) {
        User existingUser = this.userRepository.findUserById(user.getUserName());
        return existingUser != null;
    }

    private User createUser(UserForm userForm) {
        String encryptedPassword = this.pwdEncoder.encode((userForm.getPassword()));
        return new User(userForm.getUserName(), userForm.getFirstName(), userForm.getLastName(), encryptedPassword);
    }

    public void saveUser(UserForm userForm)
        throws ServiceException
    {
        User newUser = this.createUser(userForm);

        if(this.checkExistingUser(newUser)) {
            throw new ServiceException(Messages.USERS_ALREADY_EXISTS.getCode(), Messages.USERS_ALREADY_EXISTS.getDescription());
        }

        this.userRepository.save(newUser);
    }

    public void saveFavVideo(String videoName, String userName)
        throws ServiceException {
        User user = this.userRepository.findUserById(userName);
        Video video = this.videoRepository.findVideoByName(videoName);

        user.addFavourite(video);

        this.userRepository.save(user);
    }
}