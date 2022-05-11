package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ItemFormController {
    public AnchorPane mainContext;

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
