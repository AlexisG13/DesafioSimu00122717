package sample.Controllers;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;


public class Controller {

    @FXML
    private StackPane parentContainer;

    @FXML
    private AnchorPane anchorRoot;
    @FXML
    private Button button;

    @FXML
    public void loadScene(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/sample/Views/model.fxml"));
            Scene currentScene = button.getScene();
            root.translateXProperty().set(currentScene.getWidth());
            parentContainer.getChildren().add(root);
            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(root.translateXProperty(),0, Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.seconds(1),kv);
            timeline.getKeyFrames().add(kf);
            timeline.setOnFinished(e ->{
                parentContainer.getChildren().remove(anchorRoot);
            });
            timeline.play();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }finally {
            event.consume();
        }
    }
}
