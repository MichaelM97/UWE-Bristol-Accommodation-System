/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accommodation.application;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author MichaelM97
 */
public class AccommodationApplication extends Application {
    
    //List used for storing table data
    private ObservableList<Table> tableList =
                        FXCollections.observableArrayList();
    
    //Lists used for storing object instances
    private ArrayList<Halls> hallList = new ArrayList();
    private ArrayList<Room> roomList = new ArrayList();
    private ArrayList<Student> studentList = new ArrayList();
    private ArrayList<Lease> leaseList = new ArrayList();
    
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {  
        
        //Load file data
        try {
            getFileData();
        } catch (IOException ex) {
            Logger.getLogger(AccommodationApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Fill tableList with data               
        getTableData();  
        
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
                //Switch stage
                primaryStage.close();
                Stage managerStage = new Stage();
                
                //Text Area Labels
                Label hallNameLabel = new Label("Hall Name:");
                Label roomNumberLabel = new Label("Room Number:");
                Label occupancyLabel = new Label("Occupancy:");
                Label leaseNumberLabel = new Label("Lease Number:");
                Label studentNameLabel = new Label("Student Name:");
                Label cleanStatusLabel = new Label("Clean Status:");
                hallNameLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                hallNameLabel.setLayoutX(50);
                hallNameLabel.setLayoutY(337.5);
                roomNumberLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15)); 
                roomNumberLabel.setLayoutX(15);
                roomNumberLabel.setLayoutY(382.5);
                occupancyLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15)); 
                occupancyLabel.setLayoutX(42.5);
                occupancyLabel.setLayoutY(427.5);
                leaseNumberLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15)); 
                leaseNumberLabel.setLayoutX(265);
                leaseNumberLabel.setLayoutY(337.5);
                studentNameLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15)); 
                studentNameLabel.setLayoutX(265);
                studentNameLabel.setLayoutY(382.5);
                cleanStatusLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15)); 
                cleanStatusLabel.setLayoutX(277.5);
                cleanStatusLabel.setLayoutY(427.5);                
                
                //Text Areas & Combo Boxes
                TextArea hallNameArea = new TextArea();
                TextArea roomNumberArea = new TextArea(); 
                ComboBox occupancyCombo = new ComboBox();
                TextArea leaseNumberArea = new TextArea();
                ComboBox studentNameCombo = new ComboBox(); 
                TextArea cleanStatusArea = new TextArea();
                hallNameArea.setEditable(false);
                hallNameArea.setPrefSize(100, 40);
                hallNameArea.setLayoutX(150);
                hallNameArea.setLayoutY(330);
                hallNameArea.setStyle("-fx-control-inner-background: #D6D6D6");
                roomNumberArea.setEditable(false);
                roomNumberArea.setPrefSize(100, 40);
                roomNumberArea.setLayoutX(150);
                roomNumberArea.setLayoutY(375);    
                roomNumberArea.setStyle("-fx-control-inner-background: #D6D6D6");
                occupancyCombo.setEditable(true);
                occupancyCombo.setPrefSize(140, 40);
                occupancyCombo.setLayoutX(400);
                occupancyCombo.setLayoutY(420);
                occupancyCombo.getItems().addAll(
                        "Occupied",
                        "Unoccupied"
                    );
                leaseNumberArea.setEditable(true);
                leaseNumberArea.setPrefSize(140, 40);
                leaseNumberArea.setLayoutX(400);
                leaseNumberArea.setLayoutY(330);
                studentNameCombo.setEditable(true);
                studentNameCombo.setPrefSize(140, 40);
                studentNameCombo.setLayoutX(400);
                studentNameCombo.setLayoutY(375);
                for (Student currentStudent : studentList) {                    
                    studentNameCombo.getItems().add(currentStudent.getStudentName());
                }
                cleanStatusArea.setEditable(false);
                cleanStatusArea.setPrefSize(100, 40);
                cleanStatusArea.setLayoutX(150);
                cleanStatusArea.setLayoutY(420);
                cleanStatusArea.setStyle("-fx-control-inner-background: #D6D6D6");
                
                //Table label
                Label tableLabel = new Label("Room/lease information:");
                tableLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));  
                
                //Create table columns and set fill data
                TableView table = new TableView();
                table.setEditable(true);
                TableColumn hallNameCol = new TableColumn("Hall Name");
                hallNameCol.setCellValueFactory(
                    new PropertyValueFactory<Table, String>("hallName"));
                TableColumn roomNumCol = new TableColumn("Room Number");
                roomNumCol.setCellValueFactory(
                    new PropertyValueFactory<Table, Integer>("roomNumber"));
                TableColumn occupancyCol = new TableColumn("Occupancy Status");
                occupancyCol.setCellValueFactory(
                    new PropertyValueFactory<Table, String>("occupancy"));
                TableColumn leaseNumCol = new TableColumn("Lease Number");
                leaseNumCol.setCellValueFactory(
                    new PropertyValueFactory<Table, Integer>("leaseNumber"));
                TableColumn studentNameCol = new TableColumn("Student Name");
                studentNameCol.setCellValueFactory(
                    new PropertyValueFactory<Table, String>("studentName"));
                TableColumn cleaningCol = new TableColumn("Cleaning Status");
                cleaningCol.setCellValueFactory(
                    new PropertyValueFactory<Table, String>("cleanStatus")); 
                table.setItems(tableList);
                table.getColumns().addAll(hallNameCol, roomNumCol,
                        occupancyCol, leaseNumCol, studentNameCol, cleaningCol);                
                
                //Detect row selection, fill text areas with corresponding data
                table.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        for (Table currentTable : tableList) {
                            if(currentTable == 
                                    table.getSelectionModel()
                                            .getSelectedItem()) {
                                hallNameArea.setText(
                                        currentTable.getHallName());
                                roomNumberArea.setText(Integer.toString(
                                        currentTable.getRoomNumber()));
                                occupancyCombo.getSelectionModel().select(
                                        currentTable.getOccupancy());
                                leaseNumberArea.setText(
                                        currentTable.getLeaseNumber());
                                studentNameCombo.getSelectionModel().select(
                                        currentTable.getStudentName());
                                cleanStatusArea.setText(
                                        currentTable.getCleanStatus());
                                break;
                            }
                        }
                    }                    
                });                
                
                //Form table                
                VBox tableVbox = new VBox();
                tableVbox.setSpacing(5);
                tableVbox.getChildren().addAll(tableLabel, table);
                tableVbox.setLayoutX(20);
                tableVbox.setLayoutY(20);   
                tableVbox.setPrefSize(585, 300);
                
                //Update button
                Button updateBtn = new Button();
                updateBtn.setText("Update");
                updateBtn.setPrefSize(100, 30);
                updateBtn.setStyle("-fx-font-size: 1em; ");
                updateBtn.setLayoutX(520);
                updateBtn.setLayoutY(465); 
                //Change data in Table & relevant classes when button pressed
                updateBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                        for (Table currentTable : tableList) {
                            if(currentTable == table.getSelectionModel()
                                    .getSelectedItem()) {
                                //Create popup used for error display
                                Stage errorDialog = new Stage();
                                errorDialog.initModality(Modality.APPLICATION_MODAL);
                                errorDialog.initOwner(primaryStage);
                                errorDialog.setTitle("ERROR");
                                VBox dialogVbox = new VBox(20);
                                Scene dialogScene = new Scene(dialogVbox, 300, 50);
                                errorDialog.setScene(dialogScene);   
                                Text errorText = new Text();
                                errorText.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                                
                                try {
                                    //Check if lease number valid int
                                    errorText.setText("Invalid lease number.");
                                    int leaseNumInt = Integer.parseInt(
                                            leaseNumberArea.getText());                                  
                                    dialogVbox.getChildren().clear();
                                    //Check if student name in use
                                    for (Table tableStudentCheck : tableList) {
                                        if (studentNameCombo.getValue().toString().equalsIgnoreCase(tableStudentCheck.getStudentName())) {
                                            errorText.setText("Student already has a lease.");
                                            throw new NumberFormatException();
                                        } 
                                    }
                                    
                                    //Check if room clean status
                                    if (cleanStatusArea.getText().equals("Offline")) {
                                        errorText.setText("Room is offline.");
                                        throw new NumberFormatException();
                                    }
                                    
                                    //Change data in Table Class
                                    currentTable.setLeaseNumber(
                                        leaseNumberArea.getText());
                                    currentTable.setOccupancy(
                                        occupancyCombo.getValue().toString());                                        
                                    currentTable.setStudentName(studentNameCombo
                                            .getValue().toString());  
                                    table.refresh();
                                    
                                    //Change data in other classes
                                    for (Halls currentHall : hallList) {
                                        for (Room currentRoom : roomList) {
                                            if (currentRoom.getHallID() == currentHall.getHallID()) {
                                                currentRoom.setOccupancy(occupancyCombo.getValue().toString());
                                                for (Lease currentLease : leaseList) {
                                                    if (currentLease.getRoomNumber() == currentRoom.getRoomNumber()){
                                                        currentLease.setLeaseNumber(leaseNumInt);
                                                        for (Student currentStudent : studentList) {
                                                            if (currentLease.getStudentID() == currentStudent.getStudentID()) {
                                                                currentStudent.setStudentName(studentNameCombo.getValue().toString());
                                                                break;
                                                            }
                                                        }
                                                        break;
                                                    }
                                                }   
                                                break;
                                            }                                            
                                        }
                                    }
                                    
                                } catch (NumberFormatException eNum) {                                    
                                    errorText.setTextAlignment(TextAlignment.CENTER);
                                    dialogVbox.getChildren().add(errorText);                                    
                                    dialogVbox.setAlignment(Pos.CENTER);
                                    errorDialog.show();
                                }
                                break;
                            } 
                        }
                    }
                });
                
                
                //Back button
                Button backBtn = new Button();
                backBtn.setText("Back");
                backBtn.setPrefSize(100, 30);
                backBtn.setStyle("-fx-font-size: 1em; ");
                backBtn.setLayoutX(5);
                backBtn.setLayoutY(465);                
                
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
                root.getChildren().add(updateBtn);
                root.getChildren().add(backBtn);
                root.getChildren().addAll(tableVbox);
                root.getChildren().add(hallNameArea);
                root.getChildren().add(roomNumberArea);
                root.getChildren().add(occupancyCombo);
                root.getChildren().add(leaseNumberArea);
                root.getChildren().add(studentNameCombo);
                root.getChildren().add(cleanStatusArea);
                root.getChildren().addAll(hallNameLabel,
                            roomNumberLabel,
                            occupancyLabel,
                            leaseNumberLabel,
                            studentNameLabel,
                            cleanStatusLabel
                        );
                
                //Set scene dimensions and title
                Scene scene = new Scene(root, 625, 500);        
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
    
    public void getFileData() throws IOException {
        String hallsFile = "./resources/data/halls.csv";
        String roomsFile = "./resources/data/rooms.csv";
        String studentsFile = "./resources/data/students.csv";
        String leasesFile = "./resources/data/leases.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        //Get HALLS data
        try {
            br = new BufferedReader(new FileReader(hallsFile));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                int hallID = Integer.parseInt(data[1]);
                hallList.add(new Halls(data[0], hallID, data[2], data[3]));                
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR -- File containing Halls data missing");
            System.exit(1);
        }
        
        //Get ROOMS data
        try {
            br = new BufferedReader(new FileReader(roomsFile));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                int roomNumber = Integer.parseInt(data[0]);
                double monthlyRent = Double.parseDouble(data[1]);
                int hallID = Integer.parseInt(data[2]);
                roomList.add(new Room(roomNumber, monthlyRent, hallID, data[3]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR -- File containing Rooms data missing");
            System.exit(1);
        }

        //Get STUDENTS data
        try {
            br = new BufferedReader(new FileReader(studentsFile));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                int studentID = Integer.parseInt(data[1]);
                studentList.add(new Student(data[0], studentID));
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR -- File containing Students data missing");
            System.exit(1);
        }
        
        //Get LEASES data
        try {
            br = new BufferedReader(new FileReader(leasesFile));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                int leaseNumber = Integer.parseInt(data[0]);
                int leaseDuration = Integer.parseInt(data[1]);
                int hallID = Integer.parseInt(data[2]);
                int roomNumber = Integer.parseInt(data[3]);
                int studentID = Integer.parseInt(data[4]);
                leaseList.add(new Lease(leaseNumber, leaseDuration, hallID,
                    roomNumber, studentID));
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR -- File containing Leases data missing");
            System.exit(1);
        }
    }
    
    public void getTableData() {        
        //Variables
        String hallName, occupancy, cleanStatus, leaseNumber = "N/A",
                studentName = "N/A";
        int roomNumber;
        
        //Load data into table class & list
        for (Room room : roomList) {
            for (Halls hall : hallList) {
                //Find the hall that the room is in
                if (hall.getHallID() == room.getHallID()) {
                    hallName = hall.getHallName();
                    roomNumber = room.getRoomNumber();
                    occupancy = room.getOccupancy();
                    cleanStatus = room.getCleanStatus();
                    //Find a lease that may exist for this room
                    for (Lease lease : leaseList) {
                        if ((lease.getRoomNumber() ==
                                room.getRoomNumber()) &&
                                (lease.getHallID() ==
                                hall.getHallID())) {
                            leaseNumber =
                                    Integer.toString(lease.getLeaseNumber());
                            //Find the student associated with the lease
                            for (Student student : studentList) {
                                if (student.getStudentID() ==
                                        lease.getStudentID()) {
                                    studentName = student.getStudentName();
                                    break;
                                }
                            }
                            break;
                        } else {
                            leaseNumber = "N/A";
                            studentName = "N/A";
                        }
                    }
                    tableList.add(new Table(hallName, roomNumber, occupancy,
                            cleanStatus, leaseNumber, studentName));
                    break;
                }
            }
        }   
    }   
}
