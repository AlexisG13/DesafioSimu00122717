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
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import sample.ModelViewer;

import java.io.IOException;

public class MainController {



    @FXML
    private Button btnModel;

    @FXML
    public void loadScene(ActionEvent event, String n , Button button){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/sample/Views/"+n+".fxml"));
            Scene currentScene = button.getScene();
            root.translateXProperty().set(currentScene.getWidth());
            StackPane parentContainer = (StackPane) currentScene.getRoot();
            parentContainer.getChildren().add(root);
            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(root.translateXProperty(),0, Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.seconds(1),kv);
            timeline.getKeyFrames().add(kf);
            timeline.play();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }finally {
            event.consume();
        }
    }

    public void show3Domain(){
        ModelViewer.display();
    }

    public void loadDomain(ActionEvent event){
        loadScene(event,"3",btnModel);
    }

    public void loadCond(ActionEvent event){
        loadScene(event,"4",btnModel);
    }

    public void loadTable(ActionEvent event){
        loadScene(event,"6",btnModel);
    }

    public void paso1(ActionEvent event){
        loadScene(event,"7",btnModel);
    }

    public void paso2(ActionEvent event){
        loadScene(event,"8",btnModel);
    }

    public void paso3(ActionEvent event){
        loadScene(event,"9",btnModel);
    }

    public void paso4(ActionEvent event){
        loadScene(event,"10",btnModel);
    }

    public void paso5_1(ActionEvent event){
        loadScene(event,"11",btnModel);
    }

    public void paso5_2(ActionEvent event){
        loadScene(event,"12",btnModel);
    }

    public void load13(ActionEvent event){
        loadScene(event,"13",btnModel);
    }

    public void load14(ActionEvent event){
        loadScene(event,"14",btnModel);
    }

    public void load15(ActionEvent event){
        loadScene(event,"15",btnModel);
    }

    public void load16(ActionEvent event){
        loadScene(event,"16",btnModel);
    }

    public void load17(ActionEvent event){
        loadScene(event,"17",btnModel);
    }

    public void load18(ActionEvent event){
        loadScene(event,"18",btnModel);
    }

    public void load19(ActionEvent event){
        loadScene(event,"19",btnModel);
    }

    public void load20(ActionEvent event){
        loadScene(event,"20",btnModel);
    }

    public void load21(ActionEvent event){
        loadScene(event,"21",btnModel);
    }

    public void load22(ActionEvent event){
        loadScene(event,"22",btnModel);
    }

    public void load23(ActionEvent event){
        loadScene(event,"23",btnModel);
    }

    public void load24(ActionEvent event){
        loadScene(event,"24",btnModel);
    }

    public void load25(ActionEvent event){
        loadScene(event,"25",btnModel);
    }

    public void load26(ActionEvent event){
        loadScene(event,"26",btnModel);
    }

    public void loadDespedida(ActionEvent event){
        loadScene(event,"despedida",btnModel);
    }
}
