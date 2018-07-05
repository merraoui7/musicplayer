package com.example.admin.musicplayer.Model;

/**
 * Created by admin on 7/4/2018.
 */

public class Music {
    private String path;
    private String name;
    private String duration;

    public Music(String path, String name, String duration) {
        this.path = path;
        this.name = name;
        this.duration = duration;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    public String getDuration() {
        return duration;
    }
}
