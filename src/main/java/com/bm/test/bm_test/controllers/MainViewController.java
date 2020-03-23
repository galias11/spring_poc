package com.bm.test.bm_test.controllers;

// vendors
import com.bm.test.bm_test.db.UserRepository;
import com.bm.test.bm_test.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

// local
import com.bm.test.bm_test.model.dto.VideoForm;
import com.bm.test.bm_test.db.VideoRepository;
import com.bm.test.bm_test.model.entity.Video;

@Controller
public class MainViewController {
    @Autowired
    VideoRepository videoRepository;

    @Autowired
    UserRepository userRepository;

    private List<Video> getVideoList() {
        ArrayList<Video> videoList = new ArrayList<>();
        videoRepository.findAll().forEach(videoList::add);
        return videoList;
    }

    private ModelAndView getModel() {
        String viewName = "main-view";
        return new ModelAndView(viewName);
    }

    @GetMapping(path="/main")
    public ModelAndView getMainView(@RequestAttribute("user-name") String userName) {
        User user = userRepository.findUserById(userName);
        ModelAndView model = this.getModel();
        model.addObject("videoForm", new VideoForm());
        model.addObject("videos", this.getVideoList());
        model.addObject("userVideos", user.getFavVideos());
        return model;
    }
}
