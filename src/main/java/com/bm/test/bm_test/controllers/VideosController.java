package com.bm.test.bm_test.controllers;

// vendors
import com.bm.test.bm_test.config.Messages;
import com.bm.test.bm_test.model.*;
import com.bm.test.bm_test.model.dto.VideoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// local
import com.bm.test.bm_test.db.VideoRepository;
import com.bm.test.bm_test.services.VideoService;

@Controller
@RequestMapping("/api/private")
public class VideosController {
    @Autowired
    VideoRepository videoRepository;
    VideoService videoService = new VideoService();

    @PostMapping("/add-video")
    public String addVideo(VideoForm videoForm) {
        try {
            videoService.saveVideo(videoForm);
        } catch (ServiceException e) {
            return "redirect:/main";
        }

        return "redirect:/main";
    }

    @GetMapping("/videos-list")
    public @ResponseBody Iterable<Video> getAllVideos() {
        return videoRepository.findAll();
    }
}
