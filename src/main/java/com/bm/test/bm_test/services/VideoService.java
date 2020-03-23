package com.bm.test.bm_test.services;

// vendors
import com.bm.test.bm_test.model.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// local
import com.bm.test.bm_test.config.Messages;
import com.bm.test.bm_test.model.dto.ServiceException;
import com.bm.test.bm_test.config.SpringUtils;
import com.bm.test.bm_test.db.VideoRepository;
import com.bm.test.bm_test.model.dto.VideoForm;

@Service
public class VideoService {
    @Autowired
    private VideoRepository videoRepository;

    public VideoService() {
        this.videoRepository = SpringUtils.CONTEXT.getBean(VideoRepository.class);
    }

    private boolean checkExistingName(VideoForm videoForm) {
        Video video = this.videoRepository.findVideoByName(videoForm.getName());
        return video != null;
    }

    public void saveVideo(VideoForm videoForm) throws ServiceException {
        if(this.checkExistingName(videoForm)) {
            throw new ServiceException(Messages.VIDEO_ALREADY_EXISTS.getCode(), Messages.VIDEO_ALREADY_EXISTS.getDescription());
        }

        Video video = new Video(videoForm.getName(), videoForm.getUrl());

        videoRepository.save(video);
    }
}
