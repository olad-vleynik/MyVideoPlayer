package com.gmail.vleynik.olad;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.nio.file.Paths;

public class VideoPlayerApp extends Application {
    public static File videoFile;

    @Override
    public void start(Stage primaryStage) throws Exception {
        videoFile = new File(LastVideo.load());
        MediaViewSetup mediaViewSetup = new MediaViewSetup(videoFile, 640,480);


        Scene scene = new Scene(new Pane(mediaViewSetup.getMediaView()));
        primaryStage.setScene(scene);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setX(0);
        primaryStage.setY(0);
        primaryStage.show();

        String controlPanelFXML = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "ControlPanel.fxml").toString();
        ControlPanelStageSetup cpStageSetup = new ControlPanelStageSetup (controlPanelFXML, primaryStage, mediaViewSetup, videoFile);
        cpStageSetup.getControlPanel().show();
    }

    public static void launchApp() {
        launch();
    }
}
