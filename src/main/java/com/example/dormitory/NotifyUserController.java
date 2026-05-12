package com.example.dormitory;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class NotifyUserController {

    @FXML
    private Label tenantNameLabel;

    @FXML
    private Label dueDateLabel;

    @FXML
    private Label monthlyRentLabel;

    @FXML
    private Label statusLabel;

    @FXML
    private Label messageLabel;

    private final String tenantName = "John Doe";
    private final double monthlyRent = 120;
    private final LocalDate dueDate = LocalDate.of(2026, 5, 12);

    @FXML
    public void initialize() {
        tenantNameLabel.setText("Tenant: " + tenantName);
        dueDateLabel.setText("Due Date: " + dueDate);
        monthlyRentLabel.setText(String.format("Monthly Rent: %.2f", monthlyRent));

        updateNotification();
    }

    @FXML
    private void handleNotifyRentDue() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Rent Due Notification");
        alert.setHeaderText(statusLabel.getText());
        alert.setContentText(messageLabel.getText());
        alert.showAndWait();
    }

    private void updateNotification() {
        LocalDate today = LocalDate.now();
        long daysUntilDue = ChronoUnit.DAYS.between(today, dueDate);

        if (daysUntilDue < 0) {
            long overdueDays = Math.abs(daysUntilDue);
            statusLabel.setText("Rent Overdue");
            statusLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #C0392B;");
            messageLabel.setText("Your rent is overdue by " + overdueDays + " day(s). Please settle your balance as soon as possible.");
        } else if (daysUntilDue == 0) {
            statusLabel.setText("Rent Due Today");
            statusLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #D35400;");
            messageLabel.setText("Your rent is due today. Please pay your monthly rent to avoid penalties.");
        } else if (daysUntilDue <= 7) {
            statusLabel.setText("Rent Due Soon");
            statusLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #F39C12;");
            messageLabel.setText("Your rent is due in " + daysUntilDue + " day(s). Please prepare your payment.");
        } else {
            statusLabel.setText("No Rent Due Yet");
            statusLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #27AE60;");
            messageLabel.setText("Your rent is not due yet. Next payment is scheduled for " + dueDate + ".");
        }
    }
}
