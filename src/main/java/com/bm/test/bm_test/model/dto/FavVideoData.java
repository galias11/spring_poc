package com.bm.test.bm_test.model.dto;

public class FavVideoData {
    private String videoName;

    public FavVideoData() {
        this.videoName = "";
    }

    public FavVideoData(String userName, String videoName) {
        this.videoName = videoName;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }
}
