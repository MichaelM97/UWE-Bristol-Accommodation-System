/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accommodation.application;

import java.awt.Image;
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author MichaelM97
 */
public class AccommodationApplication extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        
        
        //Main page text
        Text txt = new Text ("Please select how you wish to view the data:");
        txt.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        txt.setLayoutX(50);
        txt.setLayoutY(100);
        
        //Main page Hall Manager button
        Button managerBtn = new Button();
        managerBtn.setText("Hall Manager");
        managerBtn.setPrefSize(175, 40);
        managerBtn.setStyle("-fx-font-size: 2em; ");
        managerBtn.setLayoutX(30);
        managerBtn.setLayoutY(175);
        
        //Main page Warden button
        Button wardenBtn = new Button();
        wardenBtn.setText("Warden");
        wardenBtn.setPrefSize(175, 40);
        wardenBtn.setStyle("-fx-font-size: 2em; ");
        wardenBtn.setLayoutX(212.5);
        wardenBtn.setLayoutY(175);
        
        //Main page All button
        Button allBtn = new Button();
        allBtn.setText("All");
        allBtn.setPrefSize(175, 40);
        allBtn.setStyle("-fx-font-size: 2em; ");
        allBtn.setLayoutX(395);
        allBtn.setLayoutY(175);
        
        /*** HALL MANAGER Stage Handling ***/
        managerBtn.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {                
                primaryStage.close();
                Stage managerStage = new Stage();
                
                
                //Create pane and add objects depending on scene
                Pane root = new Pane();
                
                //Set scene dimensions and title
                Scene scene = new Scene(root, 600, 400);        
                managerStage.setTitle("Manager View - Accommodation System");

                //Set scene to stage and show
                managerStage.setScene(scene);
                managerStage.show();
            }
        });       
     
        
        /*** WARDEN Stage Handling ***/
        wardenBtn.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {
                
            }
        });        
        
        
        /*** ALL Stage Handling ***/
        allBtn.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {
                
            }
        });
        
        //Create pane and add objects depending on scene
        Pane root = new Pane();
        root.getChildren().add(managerBtn);
        root.getChildren().add(wardenBtn);
        root.getChildren().add(allBtn);
        root.getChildren().add(txt);

        
        //Set scene dimensions and title
        Scene scene = new Scene(root, 600, 350);        
        primaryStage.setTitle("UWE Bristol - Accommodation System");
        
        //Set scene to stage and show
        primaryStage.setScene(scene);
        primaryStage.show();
    }   
    
}
