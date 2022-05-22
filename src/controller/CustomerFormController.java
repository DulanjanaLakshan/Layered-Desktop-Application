package controller;

import bo.BoFactory;
import bo.custom.CustomerBO;
import com.jfoenix.controls.JFXButton;
import dto.CustomerDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import views.tdm.CustomerTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerFormController {
    private final CustomerBO customerBO = (CustomerBO) BoFactory.getBOFactory().getBO(BoFactory.BoTypes.CUSTOMER);
    public AnchorPane mainContext;
    public TextField txtCustomerId;
    public TextField txtCustomerName;
    public TextField txtCustomerAddress;
    public TextField txtCustomerNo;
    public TextField txtCustomerEmail;
    public TableView<CustomerTM> tblCustomer;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colNumber;
    public TableColumn colEmail;
    public JFXButton btnSaveCustomer;

/*  String id=txtCustomerId.getText();
    String name=txtCustomerName.getText();
    String address=txtCustomerAddress.getText();
    String no=txtCustomerNo.getText();
    String email=txtCustomerEmail.getText();*/

    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
           if (newValue != null) {
                txtCustomerId.setText(newValue.getId());
                txtCustomerName.setText(newValue.getName());
                txtCustomerAddress.setText(newValue.getAddress());
                txtCustomerNo.setText(newValue.getNumber());
                txtCustomerEmail.setText(newValue.getEmail());
            }
        });
        txtCustomerAddress.setOnAction(event -> btnSaveCustomer.fire());
        loadAllCustomers();
    }

    public void btnSaveCustomer(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        CustomerDTO customerDTO = new CustomerDTO(txtCustomerId.getText(), txtCustomerName.getText(), txtCustomerAddress.getText(),txtCustomerNo.getText(),txtCustomerEmail.getText());
        customerBO.addCustomer(customerDTO);
        tblCustomer.getItems().add(new CustomerTM(txtCustomerId.getText(), txtCustomerName.getText(), txtCustomerAddress.getText(),txtCustomerNo.getText(),txtCustomerEmail.getText()));
        clear();
    }

    public void btnUpdateCustomer(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        CustomerDTO customerDTO = new CustomerDTO(txtCustomerId.getText(), txtCustomerName.getText(), txtCustomerAddress.getText(),txtCustomerNo.getText(),txtCustomerEmail.getText());
        customerBO.updateCustomer(customerDTO);
        loadAllCustomers();
        clear();
    }

    public void btnDeleteCustomer(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        customerBO.deleteCustomer(txtCustomerId.getText());
        loadAllCustomers();
        clear();
    }

    public void btnBack(MouseEvent mouseEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../views/HomeForm.fxml"));
        Scene scene = new Scene(load);
        Stage stage = (Stage) mainContext.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void loadAllCustomers() {
        tblCustomer.getItems().clear();
        try {
            ArrayList<CustomerDTO> allCustomers = customerBO.getAllCustomer();
            for (CustomerDTO customer : allCustomers) {
                tblCustomer.getItems().add(new CustomerTM(customer.getId(), customer.getName(), customer.getAddress(),customer.getNumber(),customer.getEmail()));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void clear() {
        txtCustomerId.clear();
        txtCustomerName.clear();
        txtCustomerAddress.clear();
        txtCustomerNo.clear();
        txtCustomerEmail.clear();
    }

}
