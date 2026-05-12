package com.example.dormitory;

import com.example.dormitory.Tenant;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PaymentController {

    @FXML
    private TableView<Tenant> paymentTable;

    @FXML
    private TableColumn<Tenant, String> nameColumn;

    @FXML
    private TableColumn<Tenant, String> roomColumn;

    @FXML
    private TableColumn<Tenant, Boolean> paidColumn;

    @FXML
    private TableColumn<Tenant, Double> rentColumn;

    @FXML
    private TableColumn<Tenant, Double> debtColumn;

    @FXML
    private TableColumn<Tenant, Integer> missedColumn;


    @FXML
    private TableColumn<Tenant, Boolean> evictedColumn;

    private final ObservableList<Tenant> tenantList =
            FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        nameColumn.setCellValueFactory(
                new PropertyValueFactory<>("tenantName"));

        roomColumn.setCellValueFactory(
                new PropertyValueFactory<>("roomNumber"));

        paidColumn.setCellValueFactory(
                new PropertyValueFactory<>("isPaid"));

        rentColumn.setCellValueFactory(
                new PropertyValueFactory<>("monthlyRent"));

        debtColumn.setCellValueFactory(
                new PropertyValueFactory<>("totalDebt"));

        missedColumn.setCellValueFactory(
                new PropertyValueFactory<>("missedMonths"));


        evictedColumn.setCellValueFactory(
                new PropertyValueFactory<>("isEvicted"));

        loadSampleData();
    }

    private void loadSampleData() {

        tenantList.add(new Tenant(
                "John Doe",
                "Room 101",
                true,
                120,
                0,
                0,
                false,
                5
        ));

        tenantList.add(new Tenant(
                "Jane Smith",
                "Room 202",
                false,
                150,
                150,
                1,
                false,
                0
        ));

        tenantList.add(new Tenant(
                "Michael Cruz",
                "Room 303",
                false,
                200,
                600,
                3,
                true,
                0
        ));

        paymentTable.setItems(tenantList);
    }

    @FXML
    private void handleMarkPaid() {

        Tenant selected =
                paymentTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            return;
        }

        selected.setPaid(true);

        // RESET DEBT
        selected.setTotalDebt(0);

        // RESET MISSED MONTHS
        selected.setMissedMonths(0);

        // ADD STREAK
        selected.setPaidStreak(
                selected.getPaidStreak() + 1
        );

        selected.setEvicted(false);

        paymentTable.refresh();
    }

    @FXML
    private void handleMissPayment() {

        Tenant selected =
                paymentTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            return;
        }

        selected.setPaid(false);

        // ADD MISSED MONTH
        int newMissed =
                selected.getMissedMonths() + 1;

        selected.setMissedMonths(newMissed);

        // ADD CURRENT RENT TO DEBT
        double updatedDebt =
                selected.getTotalDebt()
                        + selected.getMonthlyRent();

        selected.setTotalDebt(updatedDebt);

        // RESET STREAK
        selected.setPaidStreak(0);

        // EVICT AFTER 3 MISSED MONTHS
        if (newMissed >= 3) {
            selected.setEvicted(true);
        }

        paymentTable.refresh();
    }
}
