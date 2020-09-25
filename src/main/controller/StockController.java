package main.controller;

import javafx.collections.FXCollections;
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
import main.sample.DatabaseHandler;
import main.model.Product;
import main.model.ProductForTW;

import java.io.IOException;

public class StockController {
    ObservableList<Product> ListFromDataBase;
    ObservableList<ProductForTW> ListForTableView;

    @FXML
    private TableView<ProductForTW> tableview_stock;

    @FXML
    private TableColumn<ProductForTW, Integer> tablecolumn_id;

    @FXML
    private TableColumn<ProductForTW, String> tablecolumn_name;

    @FXML
    private TableColumn<ProductForTW, Double> tablecolumn_price;

    @FXML
    private TableColumn<ProductForTW, Double> tablecolumn_weight;

    @FXML
    private Button add_item_btn;

    @FXML
    void initialize(){
        //here we are returning a list with data from DataBase
        DatabaseHandler dbHandler = new DatabaseHandler();
        ListFromDataBase = dbHandler.getStockProducts();
        ListForTableView = ConvertProductList(ListFromDataBase);

        //setting TableView here
        tablecolumn_id.setCellValueFactory(new PropertyValueFactory<>("Product_id"));
        tablecolumn_name.setCellValueFactory(new PropertyValueFactory<>("Product_name"));
        tablecolumn_price.setCellValueFactory(new PropertyValueFactory<>("Product_price"));
        tablecolumn_weight.setCellValueFactory(new PropertyValueFactory<>("Product_weight"));

        tableview_stock.setItems(ListForTableView);
    }

    private ObservableList<ProductForTW> ConvertProductList(ObservableList<Product> list) {

        ListForTableView = FXCollections.observableArrayList();

        for (Product product : list)
        {
            ProductForTW product_tw = new ProductForTW(product.getId(), product.getName(),
                    product.getPrice(), product.getWeight());

            ListForTableView.add(product_tw);
        }

        return ListForTableView;
    }

    @FXML
    void create_stockItem(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/resources/views/new_stockItem.fxml"));
            Parent root = loader.load();
            NewStockItemController secController = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();


        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
