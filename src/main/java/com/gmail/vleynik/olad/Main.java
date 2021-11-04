package com.gmail.vleynik.olad;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;

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
