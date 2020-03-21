package com.bm.test.bm_test.model;

// vendors
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    private String userName;
    private String firsName;
    private String lastName;
    private String password;

    @ElementCollection
    @CollectionTable(name ="user_videos" , joinColumns=@JoinColumn(name="userName"))
    @Column(name="url")
    private List<Video> favVideos = new ArrayList<Video>();

    public User() {
        this.userName = "";
        this.firsName = "";
        this.lastName = "";
        this.password = "";
    }

    public User(String userName, String firsName, String lastName, String password) {
        this.userName = userName;
        this.firsName = firsName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirsName() {
        return firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Video> getFavVideos() {
        return favVideos;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFavVideos(ArrayList<Video> favVideos) {
        this.favVideos = favVideos;
    }

    public void addFavourite(Video video) {
        this.favVideos.add(video);
    }
}
