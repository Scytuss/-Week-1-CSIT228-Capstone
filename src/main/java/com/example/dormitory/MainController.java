package com.example.dormitory;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.scene.Node;

public class MainController {

    @FXML
    private void handleDashboard(){}
    @FXML
    private StackPane contentPane;

    @FXML
    private void handleAddTenant() {
        try {
            Node view = FXMLLoader.load(
                    getClass().getResource("add-tenant-view.fxml")
            );

            contentPane.getChildren().setAll(view);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}