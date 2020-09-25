package main.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.model.Dish;
import main.model.Meal;
import main.sample.DatabaseHandler;

import java.sql.SQLException;
import java.time.LocalDate;


public class MenuController {
    ObservableList<Dish> ListFromDataBase;

    @FXML
    private TableView<Dish> tableview_menu;

    @FXML
    private TableColumn<Dish, Integer> tablecolumn_id;

    @FXML
    private TableColumn<Dish, String> tablecolumn_name;

    @FXML
    private TableColumn<Dish, String> tablecolumn_prod1;

    @FXML
    private TableColumn<Dish, String> tablecolumn_prod2;

    @FXML
    void initialize(){
        //here we are returning a list with data from DataBase
        DatabaseHandler dbHandler = new DatabaseHandler();
        ListFromDataBase = dbHandler.getMenuProducts();

        //setting TableView here
        tablecolumn_id.setCellValueFactory(new PropertyValueFactory<>("item_id"));
        tablecolumn_name.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        tablecolumn_prod1.setCellValueFactory(new PropertyValueFactory<>("item_prod1"));
        tablecolumn_prod2.setCellValueFactory(new PropertyValueFactory<>("item_prod2"));

        tableview_menu.setItems(ListFromDataBase);

        tableview_menu.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && (tableview_menu.getSelectionModel().getSelectedItem() != null) ) {
                Dish dish = tableview_menu.getSelectionModel().getSelectedItem();
                String s1, s2, name, prod1, prod2;
                double price = 0.0;

                //setting variables
                name = dish.getItem_name();
                prod1= dish.getItem_prod1();
                prod2= dish.getItem_prod2();
                Meal meal = new Meal(name, prod1, prod2);
                try {
                    price = meal.getPrice();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                //setting alert message
                s1 = "This delicious "+ name +" consist of:\n" + prod1 + " and " + prod2;
                s2 = "It will cost you " + price +"$";
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("quick info");
                alert.setHeaderText(s1);
                alert.setContentText(s2);
                alert.showAndWait();

                System.out.println();
            }
        });
    }

}

