package controller;

import Dto.CustomerDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerFormController {
    public AnchorPane mainContext;
    public TextField txtCustomerId;
    public TextField txtCustomerName;
    public TextField txtCustomerAddress;
    public TextField txtCustomerNo;
    public TextField txtCustomerEmail;

    String id=txtCustomerId.getText();
    String name=txtCustomerName.getText();
    String address=txtCustomerAddress.getText();
    String no=txtCustomerNo.getText();
    String email=txtCustomerEmail.getText();


    public void btnSaveCustomer(ActionEvent actionEvent) {
        CustomerDTO customerDTO = new CustomerDTO(id, name, address, no, email);
    }

    public void btnUpdateCustomer(ActionEvent actionEvent) {
    }

    public void btnDeleteCustomer(ActionEvent actionEvent) {
    }

    public void btnBack(MouseEvent mouseEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../views/HomeForm.fxml"));
        Scene scene = new Scene(load);
        Stage stage = (Stage) mainContext.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
