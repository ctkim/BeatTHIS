package com.example.awesomemusicselectorapp;

// information about each song on playlist
public class Song {
    private String name;
    private String path;

    public Song(String name, String path) {
        this.name = name;
        this.path = path;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getPath() {
        return path;
    }
}
