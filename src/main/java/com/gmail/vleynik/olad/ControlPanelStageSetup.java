package com.gmail.vleynik.olad;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.io.File;
import java.net.URL;

public class ControlPanelStageSetup {
    private final Stage controlPanel = new Stage();

    public ControlPanelStageSetup (String fxmlFile, Stage primaryStage, MediaViewSetup mediaViewSetup, File videoFile) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ControlPanel.fxml"));
        Parent root = loader.load();

        ControlPanelController controlPanelController = loader.getController();
        controlPanelController.setPrimaryStage(primaryStage);
        controlPanelController.setMediaView(mediaViewSetup.getMediaView());
        controlPanelController.setMediaPlayer(mediaViewSetup.getMediaPlayer());
        controlPanelController.setVideoName(videoFile.getName());

        mediaViewSetup.setCpController(controlPanelController);

        controlPanel.setScene(new Scene(root));
        controlPanel.setAlwaysOnTop(true);
        controlPanel.setX(0);
        controlPanel.setY(485);
        controlPanel.setResizable(false);
        controlPanel.initStyle(StageStyle.UTILITY);
        controlPanel.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                primaryStage.close();
            }
        });
    }

    public Stage getControlPanel() {
        return controlPanel;
    }
}
