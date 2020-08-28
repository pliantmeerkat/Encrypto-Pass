package com.jackbranch.pmanger;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.logging.Logger;

public class SecureApplication extends javafx.application.Application {

    private static final Logger LOGGER = Logger.getLogger(SecureApplication.class.getName());

    @Override
    public void start(Stage primaryStage) throws Exception {
        LOGGER.info("Starting application....");
        Parent root = FXMLLoader.load(getClass().getResource("/views/startup.fxml"));
        primaryStage.setTitle("Password Manager");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
