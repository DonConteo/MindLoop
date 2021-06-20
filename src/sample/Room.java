package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class Room {

    @FXML
    private Button fromRoomToKitchenButton;
    @FXML
    private Button fromRoomToBathButton;

    @FXML
    void initialize(){
        fromRoomToKitchenButton.setOnMouseEntered(event -> {
            fromRoomToKitchenButton.graphicProperty().setValue(new ImageView("res/images/ArrowLeftPressed.png"));
        });
        fromRoomToKitchenButton.setOnMouseExited(event -> {
            fromRoomToKitchenButton.graphicProperty().setValue(new ImageView("res/images/arrowLeftUnpressed.png"));
        });
        fromRoomToBathButton.setOnMouseEntered(event -> {
            fromRoomToBathButton.graphicProperty().setValue(new ImageView("res/images/arrowRightPressed.png"));
        });
        fromRoomToBathButton.setOnMouseExited(event -> {
            fromRoomToBathButton.graphicProperty().setValue(new ImageView("res/images/arrowRightUnpressed.png"));
        });
        fromRoomToKitchenButton.setOnAction(event -> {
            Parent kitchenParent = null;
            try {
                kitchenParent = FXMLLoader.load(getClass().getResource("kitchen.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene kitchen = new Scene(kitchenParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(kitchen);
            window.show();
        });
        fromRoomToBathButton.setOnAction(event -> {
            Parent bathParent = null;
            try {
                bathParent = FXMLLoader.load(getClass().getResource("bath.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene bath = new Scene(bathParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(bath);
            window.show();
        });
    }
}

