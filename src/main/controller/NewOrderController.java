package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
//models
import javafx.scene.input.InputMethodEvent;
import main.sample.DatabaseHandler;
import main.model.Meal;
import main.model.Order;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class NewOrderController {
    Order createdOrder;
    Meal cold_meal;
    Meal hot_meal;
    Meal drink_meal;

    @FXML
    private ChoiceBox<String> coldmeal_box;

    @FXML
    private ChoiceBox<String> hotmeal_box;

    @FXML
    private ChoiceBox<String> drink_box;

    @FXML
    private Button makeorder_btn;

    @FXML
    private TextField calculated_bucks;

    public NewOrderController(){ // doesnt have access to FXML
    }

    @FXML
    void initialize(){
        coldmeal_box.getItems().add("борщ");
        coldmeal_box.getItems().add("щи");
        coldmeal_box.getItems().add("солянка");
        coldmeal_box.getItems().add("холодник");
        coldmeal_box.getItems().add("гаспачо");
        coldmeal_box.getItems().add("уха");

        hotmeal_box.getItems().add("блины");
        hotmeal_box.getItems().add("драники");
        hotmeal_box.getItems().add("куриное филе");
        hotmeal_box.getItems().add("спагетти с курицей");
        hotmeal_box.getItems().add("минтай в сливках");
        hotmeal_box.getItems().add("пикантная буженина из свинины");

        drink_box.getItems().add("кофе");
        drink_box.getItems().add("чай");
        drink_box.getItems().add("кофе со льдом");
        drink_box.getItems().add("смузи с медовой дыней");
        drink_box.getItems().add("ромовый коктейль с ананасом");
        drink_box.getItems().add("вишневый кулер");

        createdOrder = new Order();
    }

    public void add_newOrder(ActionEvent actionEvent) throws SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();

        if(coldmeal_box.getValue() == null  || hotmeal_box.getValue() == null  || drink_box.getValue() == null ){
            //setting alert message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Incorrect input");
            alert.setHeaderText("Please check your field for void");
            alert.setContentText("Correct input and try again");
            alert.showAndWait();
        }
        else{
            switch (coldmeal_box.getValue())
            {
                case "борщ":
                {
                    cold_meal = new Meal("борщ", "свеклa",	"свинина",0.3,0.2);
                }break;
                case "щи":
                {
                    cold_meal = new Meal("щи", "курица",	"картофель",0.4,0.5);
                }break;
                case "солянка":
                {
                    cold_meal = new Meal("cолянка","говядина", "лук",0.3,0.2);
                }
                break;
                case "холодник":
                {
                    cold_meal = new Meal("холодник", "кефир",	"свекла",1,0.4);
                }break;
                case "гаспачо":
                {
                    cold_meal = new Meal("гаспачо", "соус табаско",	"помидоры",0.2,1);
                }break;
                case "уха":
                {
                    cold_meal = new Meal("уха","судак", "лук",1,0.4);
                }break;

            }
            switch (hotmeal_box.getValue())
            {
                case "блины":
                {
                    hot_meal = new Meal("блины", "молоко",	"яйца",0.7,2);
                }break;
                case "драники":
                {
                    hot_meal = new Meal("драники", "свинина",	"картофель",0.3,0.4);
                }break;
                case "куриное филе":
                {
                    hot_meal = new Meal("куриное филе", "курица",	"шампиньоны",0.4,0.25);
                }break;
                case "спагетти с курицей":
                {
                    hot_meal = new Meal("спагетти с курицей", "курица","спагетти",0.8,0.4);
                }break;
                case "минтай в сливках":
                {
                    hot_meal = new Meal("минтай в сливках", "минтай",	"сливки",1,0.1);
                }break;
                case "пикантная буженина из свинины":
                {
                    hot_meal = new Meal("пикантная буженина из свинины", "свинина","перец",1,0.7);
                }break;

            }
            switch (drink_box.getValue())
            {
                case "кофе":
                {
                    drink_meal = new Meal("кофе", "кофе",	"сахар",0.05,0.02);
                }break;
                case "чай":
                {
                    drink_meal = new Meal("чай", "чай",	"сахар",0.4,0.02);
                }break;
                case "кофе со льдом":
                {
                    drink_meal = new Meal("кофе со льдом", "кофе",	"сгущеное молоко",0.03,0.02);
                }break;
                case "смузи с медовой дыней":
                {
                    drink_meal = new Meal("смузи с медовой дыней", "медовая дыня",	"лайм",0.03,0.15);
                }break;
                case "ромовый коктейль с ананасом":
                {
                    drink_meal = new Meal("ромовый коктейль с ананасом", "ананас",	"ром",0.1,0.05);
                }break;
                case "вишневый кулер":
                {
                    drink_meal = new Meal("вишневый кулер", "чай",	"вишня",0.08,0.23);
                }break;

            }

            createdOrder.setColdMeal(cold_meal);
            createdOrder.setHotMeal(hot_meal);
            createdOrder.setDrink(drink_meal);
            LocalDate current_time = LocalDateTime.now ().toLocalDate();
            createdOrder.setDate(current_time.toString());

            dbHandler.addNewOrder(createdOrder);
            calculated_bucks.setText(String.valueOf(createdOrder.getPrice()));
        }
    }

}


