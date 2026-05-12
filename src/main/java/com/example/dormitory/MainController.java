package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

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
    @FXML
    private void handlePayment() {

        try {

            Node view = FXMLLoader.load(
                    getClass().getResource("payment-view.fxml")
            );

            contentPane.getChildren().setAll(view);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
