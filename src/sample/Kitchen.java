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

public class Kitchen {

    @FXML
    private Button fromKitchenToRoomButton;

    @FXML
    void initialize(){
        fromKitchenToRoomButton.setOnMouseEntered(event -> {
            fromKitchenToRoomButton.graphicProperty().setValue(new ImageView("res/images/arrowRightPressed.png"));
        });
        fromKitchenToRoomButton.setOnMouseExited(event -> {
            fromKitchenToRoomButton.graphicProperty().setValue(new ImageView("res/images/arrowRightUnpressed.png"));
        });
        fromKitchenToRoomButton.setOnAction(event -> {
        });
        fromKitchenToRoomButton.setOnAction(event -> {
            Parent roomParent = null;
            try {
                roomParent = FXMLLoader.load(getClass().getResource("room.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene room = new Scene(roomParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(room);
            window.show();
        });
    }
}
