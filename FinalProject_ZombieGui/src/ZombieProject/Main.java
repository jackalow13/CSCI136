package ZombieProject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {
    private static final int tileSize = 40;
    private static final int xTiles = 10;
    private static final int yTiles = 10;





    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ZombieGui.fxml"));
        primaryStage.setTitle("Zombie Simulation");
        Scene mainScene = new Scene(root, 900, 600);
        primaryStage.setScene(mainScene);
        primaryStage.show();

    }



    public static void main(String[] args) {
        launch(args);
    }
}
