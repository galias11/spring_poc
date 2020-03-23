package com.bm.test.bm_test.model.dto;

// vendors
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class VideoForm {
    @NotNull
    @Size(min=4, max=100)
    private String name;

    @NotNull
    @Size(min=4, max=200)
    private String url;

    public VideoForm() {
        this.name = "";
        this.url = "";
    }

    public VideoForm(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
