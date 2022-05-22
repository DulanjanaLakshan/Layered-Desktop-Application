package controller;

import bo.BoFactory;
import bo.custom.ItemBO;
import com.jfoenix.controls.JFXButton;
import dto.ItemDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import views.tdm.ItemTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemFormController {
    private final ItemBO itemBO = (ItemBO) BoFactory.getBOFactory().getBO(BoFactory.BoTypes.ITEM);
    public AnchorPane mainContext;
    public TextField txtCode;
    public TextField txtName;
    public TextField txtDescription;
    public TextField txtQty;
    public TextField txtPrice;
    public TableView<ItemTM> tblItem;
    public TableColumn colCode;
    public TableColumn colName;
    public TableColumn colDescription;
    public TableColumn colQty;
    public TableColumn colPrice;
    public JFXButton btnSaveCustomer;

    public void initialize() throws SQLException, ClassNotFoundException {
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        tblItem.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtCode.setText(newValue.getCode());
                txtName.setText(newValue.getName());
                txtDescription.setText(newValue.getDescription());
                txtQty.setText(String.valueOf(newValue.getQty()));
                txtPrice.setText(String.valueOf(newValue.getPrice()));
            }
        });
        loadAllItem();
    }

    private void loadAllItem() throws SQLException, ClassNotFoundException {
        tblItem.getItems().clear();
        ArrayList<ItemDTO> allItem = itemBO.getAllItem();
        for (ItemDTO item : allItem) {
            tblItem.getItems().add(new ItemTM(item.getCode(), item.getName(), item.getDescription(), item.getQty(), item.getPrice()));
        }
    }

    public void btnSaveCustomer(ActionEvent actionEvent) {
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
