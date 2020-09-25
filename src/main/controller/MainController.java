package main.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
//models
import main.model.Order;

public class MainController {
    //for receiving order from NewOrderController
    Order newOrder;
    ObservableList<Order> ordersForMenu;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button placeorder_btn;

    @FXML
    private Button storage_btn;

    @FXML
    private Button lastorders_btn;

    @FXML
    private Button showmenu_btn;

    @FXML
    void initialize() {

    }

    public void placeorder_btn(ActionEvent actionEvent) {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/resources/views/new_order.fxml"));
            Parent root = loader.load();
            NewOrderController secController = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            /*
            stage.setOnCloseRequest( (WindowEvent event1) -> {
                newOrder = secController.getOrder();
                stage.close();
            });*/

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void show_stockItems(ActionEvent actionEvent) {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/resources/views/all_stock_items.fxml"));
            Parent root = loader.load();
            StockController secController = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();


        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void show_lastOrders(ActionEvent actionEvent) {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/resources/views/last_orders.fxml"));
            Parent root = loader.load();
            LastOrdersController secController = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();


        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void show_menu(ActionEvent actionEvent) {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/resources/views/menu.fxml"));
            Parent root = loader.load();
            MenuController secController = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();


        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

