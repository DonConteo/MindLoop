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

public class Enter {
    @FXML
    private Button fromEnterToRoomButton;

    @FXML
    void initialize(){
        fromEnterToRoomButton.setOnMouseEntered(event -> {
            fromEnterToRoomButton.graphicProperty().setValue(new ImageView("res/images/ArrowLeftPressed.png"));
        });
        fromEnterToRoomButton.setOnMouseExited(event -> {
            fromEnterToRoomButton.graphicProperty().setValue(new ImageView("res/images/arrowLeftUnpressed.png"));
        });
        fromEnterToRoomButton.setOnAction(event -> {
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
