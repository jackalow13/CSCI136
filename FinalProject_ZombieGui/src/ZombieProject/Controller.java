package ZombieProject;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.function.ToDoubleBiFunction;

public class Controller implements Initializable {
    // Now world object
    World myWorld = new World(100, 90);

    @FXML private GridPane boardGridPane;
    @FXML private TextField populationField;
    @FXML private TextField iterationField;
    @FXML private TextField healthyField;
    @FXML private TextField sickField;
    @FXML private Button start;
    @FXML private Button stop;
    @FXML private GridPane mainGrid;
    @FXML private GridPane rightGrid;

    //Tile Array to hold Tile Objects
    private static Tile[][] tiles = new Tile[10][10];

    // Tile/Stackpane class - Holds zombie or human picture to represent world array
    private static class Tile extends StackPane {
        private int x,y;
        private boolean infected = false;
        public Tile(int x, int y, boolean infected){
            this.x=x;
            this.y=y;
            // if infection param is false - tile contains person picture
            if (!infected){
                Image healthyPerson = new Image("file:Person.png", false);
                ImageView hPerson = new ImageView(healthyPerson);
                hPerson.setFitHeight(50);
                hPerson.setFitWidth(50);
                getChildren().addAll(hPerson);
            }
            // else tile contains a zombie picture
            else {
                Image healthyPerson = new Image("file:ZombieMan.png", false);
                ImageView hPerson = new ImageView(healthyPerson);
                hPerson.setFitHeight(50);
                hPerson.setFitWidth(50);
                getChildren().addAll(hPerson);}
        }
    }

    // starts infection
    public void startButtonPushed() throws InterruptedException {
        //System.out.println("Start Pushed");
        myWorld.infect(myWorld.worldArr,5,5,90);
    }

    // Method to try and slow down and/or update the scene
    public void pause() throws InterruptedException {
        Thread.sleep(1000);
    }

    // Method to change a person tile into a zombie tile
    //     - Takes index of grid which equals both worldArr and tileArr
    public void changeBoard(int i, int j, int iteration) throws InterruptedException {
        //pause();

        // removes human tile
        boardGridPane.getChildren().remove(tiles[i][j]);

        // creates zombie tile
        Tile toAdd = new Tile(i,j,true);

        // adds zombie tile to grid
        boardGridPane.add(toAdd, i , j);

        // adds zombie tile to tileArr
        tiles[i][j] = toAdd;

        // tried to update field - doesn't work
        iterationField.setText(Integer.toString(iteration));

        //TODO add feature to pause thread, then update screen


    }


// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  WORLD ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // World object that runs application
    public class World {

        // hardcoded population due to scene builder - could't make grid dynamic w/ pictures
        public int population = 100;

        // array to hold persons and zombies - both grid and tileArr mirror this
        Person[][] worldArr;
        public int numInfected=0;

        // Threshold for Immunity: Immune Strength is 0-100. Currently if a person is >90 they are immune
        public int immuneThreshold;

        // World Class constructor
        World(int population, int immuneThreshold){
            //this.worldArr = new Person[(int)(Math.sqrt(population))][(int)(Math.sqrt(population))];
            this.worldArr = new Person[10][10];
            this.immuneThreshold = immuneThreshold;
        };

        // Fills Array with People with random attributes - see person class
        public void fillWorldArr(int i, int j){
            worldArr[i][j] = new Person();
            System.out.print("H:"+i+j);
        }

        // Method used to avoid using Try-Catch Loop
        public boolean checkInBounds(Person[][] w, int checkRow, int checkCol){
            // checks negative X & Y
            if (checkRow >= 0 && checkCol >= 0){
                // checks Positive X & Y
                return checkRow < w.length && checkCol < w[checkRow].length;
            }
            return false;
        }

        // Method to turn People into Zombies
        //  - copies worldArr person object, creates new person.zombie with same attributes
        //  - calls change board method to reflect changes
        public void Sick(Person[][] w, int row, int col, int imuThresh, int iteration) throws InterruptedException {
            if (w[row][col].immuneStrength < imuThresh) {
                Zombie newZombie = new Zombie(w[row][col].age, w[row][col].gender, w[row][col].immuneStrength);
                w[row][col] = newZombie;
                changeBoard(row, col, iteration);
            }
        }

    public int [] WorldStatus(Person[][] w, int iteration){
        int numHealthy = 0;
        int numInfected = 0;
        for (int i = 0; i < w.length; i++){
            for(int j = 0; j < w[i].length; j++){
                if (w[i][j].getClass().getName().equals("Zombies.Person")){
                    numHealthy+=1;
                }
                else if (w[i][j].getClass().getName().equals("Zombies.Zombie")){
                    numInfected +=1;
                }
            }
        }
        return new int[]{iteration, numHealthy, numInfected};
    }

        // Infection Method adapted from code on Moodle
        // Instead of using try catch loops, it calls the checkInbounds method
        public void infect(Person[][] w, int sRow, int sCol, int immuneThreshold) throws InterruptedException {
            int row = 0, col = 0;
            // iteration back to 1 for infection
            int numIterations = 1;
            // I was unsure about this while loop. Maybe use a rate of change?
            while(numIterations < 8) {
                for( row = sRow-numIterations; row<=sRow+numIterations; row ++) {
                    for (col = sCol-numIterations; col<=sCol+numIterations; col++) {
                        // Call to make sure its not out of bounds
                        if (checkInBounds(w, row, col)){
                            Sick(w, row, col, immuneThreshold, numIterations);
                            System.out.println("Iteration:"+numIterations+" Index: "+row+col);
                        }
                    }
                }
                int[] stats = WorldStatus(w, numIterations);
                iterationField.setText(Integer.toString(stats[0]));
                healthyField.setText(Integer.toString(stats[1]));
                sickField.setText(Integer.toString(stats[2]));
                numIterations++;
            }

        }
    }

//~~~~~~~~~~~~~~~~~~~~~~~~ END WORLD ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populationField.setText("100");
        for(int i=0; i<10; i++){
            for(int j = 0; j<10; j++){
                Tile toAdd = new Tile(i,j, false);
                boardGridPane.add(toAdd, i, j);
                tiles[i][j] = toAdd;
                myWorld.fillWorldArr(i ,j);
            }
            System.out.println();
        }
    }
}
