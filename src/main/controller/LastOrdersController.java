package main.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.model.OrderforTW;
import main.sample.DatabaseHandler;

import java.io.IOException;

public class LastOrdersController {
    ObservableList<OrderforTW> ListFromDataBase;

    @FXML
    private TableView<OrderforTW> tableview_stock;

    @FXML
    private TableColumn<OrderforTW, Integer> tablecolumn_id;

    @FXML
    private TableColumn<OrderforTW, String> tablecolumn_cold;

    @FXML
    private TableColumn<OrderforTW, String> tablecolumn_hot;

    @FXML
    private TableColumn<OrderforTW, String> tablecolumn_drink;

    @FXML
    private TableColumn<OrderforTW, String> tablecolumn_time;

    @FXML
    private TableColumn<OrderforTW, String> tablecolumn_price;

    @FXML
    private Button add_order_btn;

    @FXML
    void initialize() {
        //here we are returning a list with data from DataBase
        DatabaseHandler dbHandler = new DatabaseHandler();
        ListFromDataBase = dbHandler.getLastOrders();

        //setting TableView here
        tablecolumn_id.setCellValueFactory(new PropertyValueFactory<>("Order_id"));
        tablecolumn_cold.setCellValueFactory(new PropertyValueFactory<>("Order_cold"));
        tablecolumn_hot.setCellValueFactory(new PropertyValueFactory<>("Order_hot"));
        tablecolumn_drink.setCellValueFactory(new PropertyValueFactory<>("Order_drink"));
        tablecolumn_time.setCellValueFactory(new PropertyValueFactory<>("Order_time"));
        tablecolumn_price.setCellValueFactory(new PropertyValueFactory<>("Order_price"));

        tableview_stock.setItems(ListFromDataBase);
    }

    @FXML
    void create_new_order(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/resources/views/new_order.fxml"));
            Parent root = loader.load();
            NewOrderController secController = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}

