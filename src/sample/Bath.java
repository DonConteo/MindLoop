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

public class Bath {

    @FXML
    private Button fromBathToRoomButton;

    @FXML
    void initialize(){
        fromBathToRoomButton.setOnMouseEntered(event -> {
            fromBathToRoomButton.graphicProperty().setValue(new ImageView("res/images/ArrowLeftPressed.png"));
        });
        fromBathToRoomButton.setOnMouseExited(event -> {
            fromBathToRoomButton.graphicProperty().setValue(new ImageView("res/images/arrowLeftUnpressed.png"));
        });
        fromBathToRoomButton.setOnAction(event -> {
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
