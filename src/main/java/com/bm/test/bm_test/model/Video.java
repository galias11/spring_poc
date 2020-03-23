package com.bm.test.bm_test.model;

// vendors
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Video {
    @Id
    String name;
    String url;

    public Video() {
        this.name = "";
        this.url = "";
    }

    public Video(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }
}
