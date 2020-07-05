package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.stage.Stage;



public class Main extends Application{
    private static PerspectiveCamera camera = new PerspectiveCamera();

    @Override
    public void start(Stage primaryStage) throws Exception{
            Media song = new Media(getClass().getResource("/sample/music/algorithm.mp3").toString());
            AudioClip mediaPlayer = new AudioClip(song.getSource());
            mediaPlayer.setCycleCount(AudioClip.INDEFINITE);
            mediaPlayer.play();
            Parent root = FXMLLoader.load(getClass().getResource("/sample/Views/sample.fxml"));
            Scene scene1 = new Scene(root, 600, 400,true);
            primaryStage.setTitle("Desafio de programacion - 00122717");
            primaryStage.setResizable(false);
            primaryStage.setScene(scene1);
            primaryStage.show();
        }

    public static void main(String[] args) {
        launch(args);
    }

}
