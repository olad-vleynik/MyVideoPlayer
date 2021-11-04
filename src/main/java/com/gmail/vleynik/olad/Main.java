package com.gmail.vleynik.olad;

import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Paths;

public class Main {
    public static VideoPlayerApp videoPlayerApp;

    public static void main(String[] args) {
        videoPlayerApp = new VideoPlayerApp();
        VideoPlayerApp.launchApp();
    }

    public static void restartApp() {
        try {
            videoPlayerApp.stop();
            videoPlayerApp = new VideoPlayerApp();
            videoPlayerApp.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
