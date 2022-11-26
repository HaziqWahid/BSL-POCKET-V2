package home;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;

public class Main extends Application {
    private double x, y;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //tmpt nk load root fxml, paneRoot tapak fxml
        Parent root = FXMLLoader.load(getClass().getResource("paneRoot.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene((scene));

        //make border corner ,remove hujung putih
        scene.setFill(Color.TRANSPARENT);
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        //make fix size
        primaryStage.setWidth(1050);
        primaryStage.setHeight(576);
        primaryStage.setResizable(false);

        //play music
        playMusic();

        //set borderless - not used
        /*primaryStage.initStyle(StageStyle.UNDECORATED);*/

        //drag it here
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {

            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);

        });
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

    //METHOD TO PLAY MUSIC
    private void  playMusic() {
        //MUSIC
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        // System.out.println("Current absolute path is: " + s);
        String path = s + "/src/videos/japaneseBgm.mp3";

        //Instantiating Media class
        Media mediaMusic = new Media(new File(path).toURI().toString());

        //Instantiating MediaPlayer class
        MediaPlayer mediaPlayerMusic = new MediaPlayer(mediaMusic);

        //by setting this property to true, the audio will be played
        mediaPlayerMusic.setAutoPlay(true);

    }

}
