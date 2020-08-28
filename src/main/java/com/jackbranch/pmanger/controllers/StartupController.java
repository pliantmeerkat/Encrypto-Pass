package com.jackbranch.pmanger.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.ResourceBundle;

@Getter
@Setter
public class StartupController implements Initializable {

    @FXML
    public ProgressBar startupProgress;
    @FXML
    public Label startupLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        startupProgress.setProgress(0);
        startupLabel.setText("TEXT");
    }
}
