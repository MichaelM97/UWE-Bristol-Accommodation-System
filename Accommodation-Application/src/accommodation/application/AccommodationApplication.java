/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accommodation.application;

import java.awt.Image;
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
                
                //Table label
                final Label label = new Label("Room/lease information:");
                label.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
                                
                
                Halls hall = new Halls();
                ObservableList<Halls> hallData =
                        FXCollections.observableArrayList();
                
                //Create table headers
                TableView table = new TableView();
                table.setEditable(false);
                TableColumn hallNameCol = new TableColumn("Hall Name");
                hallNameCol.setCellValueFactory(
                    new PropertyValueFactory<Halls, String>("hallName"));
                TableColumn roomNumCol = new TableColumn("Room Number");
                TableColumn occupancyCol = new TableColumn("Occupancy Status");
                TableColumn leaseNumCol = new TableColumn("Lease Number");
                TableColumn studentNameCol = new TableColumn("Student Name");
                TableColumn cleaningCol = new TableColumn("Cleaning Status");
                table.setItems(hallData);
                table.getColumns().addAll(hallNameCol, roomNumCol,
                        occupancyCol, leaseNumCol, studentNameCol, cleaningCol);                
                
                //Form table
                final VBox tableVbox = new VBox();
                tableVbox.setSpacing(5);
                tableVbox.getChildren().addAll(label, table);
                tableVbox.setLayoutX(20);
                tableVbox.setLayoutY(20);                
                
                //Warden page Back button
                Button backBtn = new Button();
                backBtn.setText("Back");
                backBtn.setPrefSize(100, 30);
                backBtn.setStyle("-fx-font-size: 1em; ");
                backBtn.setLayoutX(20);
                backBtn.setLayoutY(460);                
                
                //Back button handling
                backBtn.setOnAction(new EventHandler<ActionEvent>() {            
                    @Override
                    public void handle(ActionEvent event) {
                        managerStage.close();
                        primaryStage.show();
                    }
                });    
                
                //Create pane and add objects depending on scene
                Pane root = new Pane();
                root.getChildren().add(backBtn);
                root.getChildren().add(tableVbox);
                
                //Set scene dimensions and title
                Scene scene = new Scene(root, 600, 500);        
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
