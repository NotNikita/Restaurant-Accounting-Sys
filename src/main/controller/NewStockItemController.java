package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.sample.DatabaseHandler;
import main.model.Product;

public class NewStockItemController {
    Product createdProduct;

    @FXML
    private TextField name_field;

    @FXML
    private TextField price_field;

    @FXML
    private TextField weight_field;

    @FXML
    private Button add_item_btn;

    public void addNewProduct(ActionEvent actionEvent) {
        DatabaseHandler dbHandler = new DatabaseHandler();

        if(name_field.getText().trim().isEmpty()   || price_field.getText().trim().isEmpty()  || weight_field.getText().trim().isEmpty() ){
            //setting alert message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Incorrect input");
            alert.setHeaderText("Please check your field for void");
            alert.setContentText("Correct input and try again");
            alert.showAndWait();
        }
        else{

            createdProduct = new Product(name_field.getText(), new Double(price_field.getText()), new Double(weight_field.getText()));
            dbHandler.addNewProduct(createdProduct);
        }
    }
}
