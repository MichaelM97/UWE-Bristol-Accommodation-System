/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accommodation.application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
    private ObservableList<Table> tableList
            = FXCollections.observableArrayList();

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
        Text mainText = new Text("Please select how you wish to view the data:");
        mainText.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        mainText.setLayoutX(50);
        mainText.setLayoutY(100);

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

        //Main page warning label
        Label warningLabel = new Label("WARNING! Please do not use this "
                + "program with any data files open!");
        warningLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        warningLabel.setLayoutX(15);
        warningLabel.setLayoutY(300);
        warningLabel.setTextFill(Color.web("#FF0000"));

        /**
         * * HALL MANAGER Stage Handling **
         */
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
                Label subLeaseNumLabel = new Label("(1 - 999,999)");
                Label subLeaseDurLabel = new Label("(Months)");
                Label leaseDurationLabel = new Label("Lease Duration:");
                Label studentNameLabel = new Label("Student Name:");
                Label cleanStatusLabel = new Label("Clean Status:");
                hallNameLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                hallNameLabel.setLayoutX(50);
                hallNameLabel.setLayoutY(337.5);
                roomNumberLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                roomNumberLabel.setLayoutX(15);
                roomNumberLabel.setLayoutY(382.5);
                occupancyLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                occupancyLabel.setLayoutX(442.5);
                occupancyLabel.setLayoutY(427.5);
                leaseNumberLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                leaseNumberLabel.setLayoutX(405);
                leaseNumberLabel.setLayoutY(337.5);
                subLeaseNumLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
                subLeaseNumLabel.setLayoutX(422.5);
                subLeaseNumLabel.setLayoutY(360);
                leaseDurationLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                leaseDurationLabel.setLayoutX(240);
                leaseDurationLabel.setLayoutY(490);
                subLeaseDurLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
                subLeaseDurLabel.setLayoutX(275);
                subLeaseDurLabel.setLayoutY(512.5);
                studentNameLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                studentNameLabel.setLayoutX(405);
                studentNameLabel.setLayoutY(382.5);
                cleanStatusLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                cleanStatusLabel.setLayoutX(30);
                cleanStatusLabel.setLayoutY(427.5);

                //Text Areas & Combo Boxes
                TextArea hallNameArea = new TextArea();
                TextArea roomNumberArea = new TextArea();
                ComboBox occupancyCombo = new ComboBox();
                TextArea leaseNumberArea = new TextArea();
                TextArea leaseDurationArea = new TextArea();
                ComboBox studentNameCombo = new ComboBox();
                TextArea cleanStatusArea = new TextArea();
                hallNameArea.setEditable(false);
                hallNameArea.setPrefSize(140, 40);
                hallNameArea.setLayoutX(150);
                hallNameArea.setLayoutY(330);
                hallNameArea.setStyle("-fx-control-inner-background: #D6D6D6");
                roomNumberArea.setEditable(false);
                roomNumberArea.setPrefSize(140, 40);
                roomNumberArea.setLayoutX(150);
                roomNumberArea.setLayoutY(375);
                roomNumberArea.setStyle("-fx-control-inner-background: #D6D6D6");
                occupancyCombo.setEditable(true);
                occupancyCombo.setPrefSize(140, 40);
                occupancyCombo.setLayoutX(550);
                occupancyCombo.setLayoutY(420);
                occupancyCombo.getItems().addAll(
                        "Occupied",
                        "Unoccupied"
                );
                leaseNumberArea.setEditable(true);
                leaseNumberArea.setPrefSize(140, 40);
                leaseNumberArea.setLayoutX(550);
                leaseNumberArea.setLayoutY(330);
                leaseDurationArea.setEditable(true);
                leaseDurationArea.setPrefSize(140, 40);
                leaseDurationArea.setLayoutX(382.5);
                leaseDurationArea.setLayoutY(480);
                studentNameCombo.setEditable(true);
                studentNameCombo.setPrefSize(140, 40);
                studentNameCombo.setLayoutX(550);
                studentNameCombo.setLayoutY(375);
                for (Student currentStudent : studentList) {
                    studentNameCombo.getItems().add(currentStudent.getStudentName());
                }
                cleanStatusArea.setEditable(false);
                cleanStatusArea.setPrefSize(140, 40);
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
                        new PropertyValueFactory<Table, String>("leaseNumber"));
                TableColumn leaseDurCol = new TableColumn("Lease Duration");
                leaseDurCol.setCellValueFactory(
                        new PropertyValueFactory<Table, String>("leaseDuration"));
                TableColumn studentNameCol = new TableColumn("Student Name");
                studentNameCol.setCellValueFactory(
                        new PropertyValueFactory<Table, String>("studentName"));
                TableColumn cleaningCol = new TableColumn("Cleaning Status");
                cleaningCol.setCellValueFactory(
                        new PropertyValueFactory<Table, String>("cleanStatus"));
                table.setItems(tableList);
                table.getColumns().addAll(hallNameCol, roomNumCol,
                        occupancyCol, leaseNumCol, leaseDurCol,
                        studentNameCol, cleaningCol);

                //Detect row selection, fill text areas with corresponding data
                table.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        for (Table currentTable : tableList) {
                            if (currentTable
                                    == table.getSelectionModel()
                                            .getSelectedItem()) {
                                hallNameArea.setText(
                                        currentTable.getHallName());
                                roomNumberArea.setText(Integer.toString(
                                        currentTable.getRoomNumber()));
                                occupancyCombo.getSelectionModel().select(
                                        currentTable.getOccupancy());
                                leaseNumberArea.setText(
                                        currentTable.getLeaseNumber());
                                leaseDurationArea.setText(
                                        currentTable.getLeaseDuration()
                                                .replace(" Months", ""));
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
                tableVbox.setPrefSize(685, 300);

                //Update button
                Button updateBtn = new Button();
                updateBtn.setText("Update");
                updateBtn.setPrefSize(100, 30);
                updateBtn.setStyle("-fx-font-size: 1em; ");
                updateBtn.setLayoutX(620);
                updateBtn.setLayoutY(525);
                //Change data in Table & relevant classes when button pressed
                updateBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        for (Table currentTable : tableList) {
                            if (currentTable == table.getSelectionModel()
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
                                errorText.setFont(Font.font("Verdana", FontWeight.BOLD, 13));

                                try {
                                    //Check if lease number is valid int
                                    errorText.setText("Invalid lease number.");
                                    int leaseNumInt = Integer.parseInt(
                                            leaseNumberArea.getText());
                                    dialogVbox.getChildren().clear();

                                    //Check if lease number is greater than 0
                                    errorText.setText("Lease number must be \n between 1 - 999,999.");
                                    if (leaseNumInt < 1 || leaseNumInt > 999999) {
                                        throw new NumberFormatException();
                                    }
                                    dialogVbox.getChildren().clear();

                                    //Check if lease duration is valid int
                                    errorText.setText("Invalid lease duration.");
                                    int leaseDurInt = Integer.parseInt(
                                            leaseDurationArea.getText().replace(" Months", ""));
                                    dialogVbox.getChildren().clear();

                                    //Check if lease duration is greater than 0
                                    errorText.setText("Lease duration must be\nbetween 1 - 48 months.");
                                    if (leaseDurInt < 1 || leaseDurInt > 48) {
                                        throw new NumberFormatException();
                                    }
                                    dialogVbox.getChildren().clear();

                                    //Check if room clean status
                                    if (cleanStatusArea.getText().equals("Offline")) {
                                        errorText.setText("Room is offline.");
                                        throw new NumberFormatException();
                                    }

                                    //Check if lease number in use
                                    if (leaseNumberArea.getText().equals(currentTable.getLeaseNumber())) {
                                    } else {
                                        for (Table tableLeaseCheck : tableList) {
                                            if (leaseNumberArea.getText().equalsIgnoreCase(tableLeaseCheck.getLeaseNumber())) {
                                                errorText.setText("Lease number already in use.");
                                                throw new NumberFormatException();
                                            }
                                        }
                                    }

                                    //Check if student name in use
                                    if (studentNameCombo.getValue().toString().equals(currentTable.getStudentName())) {
                                    } else {
                                        for (Table tableStudentCheck : tableList) {
                                            if (studentNameCombo.getValue().toString().equalsIgnoreCase(tableStudentCheck.getStudentName())) {
                                                errorText.setText("Student already has a lease.");
                                                throw new NumberFormatException();
                                            }
                                        }
                                    }

                                    //Change data in relevant classes                                   
                                    for (Halls currentHall : hallList) {
                                        for (Room currentRoom : roomList) {
                                            if ((hallNameArea.getText().equals(currentHall.getHallName()))
                                                    && (currentRoom.getRoomNumber() == Integer.parseInt(roomNumberArea.getText()))) {
                                                currentRoom.setOccupancy(occupancyCombo.getValue().toString());
                                                //Get student ID
                                                int studentID = 0;
                                                for (Student currentStudent : studentList) {
                                                    if (studentNameCombo.getValue().toString().equals(currentStudent.getStudentName())) {
                                                        studentID = currentStudent.getStudentID();
                                                        break;
                                                    }
                                                }
                                                if (currentTable.getLeaseNumber().equals("N/A")) {//Create new lease if needed                                                                                                   
                                                    int leaseNumber = Integer.parseInt(leaseNumberArea.getText());
                                                    int leaseDuration = Integer.parseInt(leaseDurationArea.getText());
                                                    int hallID = currentHall.getHallID();
                                                    int roomNumber = currentRoom.getRoomNumber();
                                                    leaseList.add(new Lease(leaseNumber, leaseDuration, hallID,
                                                            roomNumber, studentID));
                                                    break;
                                                } else { //Append existing lease
                                                    for (Lease currentLease : leaseList) {
                                                        if (leaseNumberArea.getText().equals(Integer.toString(currentLease.getLeaseNumber()))) {
                                                            currentLease.setLeaseNumber(Integer.parseInt(leaseNumberArea.getText()));
                                                            currentLease.setLeaseDuration(Integer.parseInt(leaseDurationArea.getText()));
                                                            currentLease.setStudentID(studentID);
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    //Change data in Table Class
                                    currentTable.setLeaseNumber(
                                            leaseNumberArea.getText());
                                    currentTable.setLeaseDuration(
                                            leaseDurationArea.getText());
                                    currentTable.setOccupancy(
                                            occupancyCombo.getValue().toString());
                                    currentTable.setStudentName(studentNameCombo
                                            .getValue().toString());
                                    table.refresh();

                                } catch (NumberFormatException eNum) {
                                    errorText.setTextAlignment(TextAlignment.CENTER);
                                    dialogVbox.getChildren().add(errorText);
                                    dialogVbox.setAlignment(Pos.CENTER);
                                    errorDialog.show();
                                }
                                break;
                            }
                        }
                        try {
                            saveFileData();
                        } catch (IOException ex) {
                            Logger.getLogger(AccommodationApplication.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });

                //Delete button
                Button deleteBtn = new Button();
                deleteBtn.setText("Delete");
                deleteBtn.setPrefSize(100, 30);
                deleteBtn.setStyle("-fx-font-size: 1em; ");
                deleteBtn.setLayoutX(515);
                deleteBtn.setLayoutY(525);
                deleteBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        for (Table currentTable : tableList) {
                            if (currentTable == table.getSelectionModel()
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
                                errorText.setFont(Font.font("Verdana", FontWeight.BOLD, 13));

                                //Check if lease present
                                if (currentTable.getLeaseNumber().equals("N/A")) {
                                    errorText.setText("No lease to delete.");
                                    errorText.setTextAlignment(TextAlignment.CENTER);
                                    dialogVbox.getChildren().add(errorText);
                                    dialogVbox.setAlignment(Pos.CENTER);
                                    errorDialog.show();
                                } else {
                                    //Remove lease from system 
                                    for (Halls currentHall : hallList) {
                                        for (Room currentRoom : roomList) {
                                            if ((hallNameArea.getText().equals(currentHall.getHallName()))
                                                    && (currentRoom.getRoomNumber() == Integer.parseInt(roomNumberArea.getText()))) {
                                                currentRoom.setOccupancy("Unoccupied");
                                                for (Lease currentLease : leaseList) {
                                                    if (leaseNumberArea.getText().equals(Integer.toString(currentLease.getLeaseNumber()))) {
                                                        leaseList.remove(currentLease);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    try {
                                        saveFileData();
                                    } catch (IOException ex) {
                                        Logger.getLogger(AccommodationApplication.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                    //Change data in Table Class
                                    currentTable.setLeaseNumber("N/A");
                                    currentTable.setLeaseDuration("N/A");
                                    currentTable.setOccupancy("Unoccupied");
                                    currentTable.setStudentName("N/A");
                                    table.refresh();
                                }
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
                backBtn.setLayoutY(525);

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
                root.getChildren().add(deleteBtn);
                root.getChildren().add(backBtn);
                root.getChildren().addAll(tableVbox);
                root.getChildren().addAll(hallNameLabel, //Labels
                        roomNumberLabel,
                        occupancyLabel,
                        leaseNumberLabel,
                        subLeaseNumLabel,
                        leaseDurationLabel,
                        subLeaseDurLabel,
                        studentNameLabel,
                        cleanStatusLabel
                );
                root.getChildren().addAll(hallNameArea, //Text areas & Combos
                        roomNumberArea,
                        occupancyCombo,
                        leaseNumberArea,
                        leaseDurationArea,
                        studentNameCombo,
                        cleanStatusArea
                );

                //Set scene dimensions and title
                Scene scene = new Scene(root, 725, 560);
                managerStage.setTitle("Manager View - Accommodation System");

                //Set scene to stage and show
                managerStage.setScene(scene);
                managerStage.show();
            }
        }
        );

        /**
         * * WARDEN Stage Handling **
         */
        wardenBtn.setOnAction(
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event
            ) {
                //Switch stage
                primaryStage.close();
                Stage wardenStage = new Stage();

                //Text Area Labels
                Label hallNameLabel = new Label("Hall Name:");
                Label roomNumberLabel = new Label("Room Number:");
                Label occupancyLabel = new Label("Occupancy:");
                Label leaseNumberLabel = new Label("Lease Number:");
                Label leaseDurationLabel = new Label("Lease Duration:");
                Label studentNameLabel = new Label("Student Name:");
                Label cleanStatusLabel = new Label("Clean Status:");
                hallNameLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                hallNameLabel.setLayoutX(50);
                hallNameLabel.setLayoutY(337.5);
                roomNumberLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                roomNumberLabel.setLayoutX(15);
                roomNumberLabel.setLayoutY(382.5);
                occupancyLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                occupancyLabel.setLayoutX(442.5);
                occupancyLabel.setLayoutY(427.5);
                leaseNumberLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                leaseNumberLabel.setLayoutX(405);
                leaseNumberLabel.setLayoutY(337.5);
                leaseDurationLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                leaseDurationLabel.setLayoutX(240);
                leaseDurationLabel.setLayoutY(490);
                studentNameLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                studentNameLabel.setLayoutX(405);
                studentNameLabel.setLayoutY(382.5);
                cleanStatusLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                cleanStatusLabel.setLayoutX(30);
                cleanStatusLabel.setLayoutY(427.5);

                //Text Areas & Combo Boxes
                TextArea hallNameArea = new TextArea();
                TextArea roomNumberArea = new TextArea();
                TextArea occupancyArea = new TextArea();
                TextArea leaseNumberArea = new TextArea();
                TextArea leaseDurationArea = new TextArea();
                TextArea studentNameArea = new TextArea();
                ComboBox cleanStatusCombo = new ComboBox();
                hallNameArea.setEditable(false);
                hallNameArea.setPrefSize(140, 40);
                hallNameArea.setLayoutX(150);
                hallNameArea.setLayoutY(330);
                hallNameArea.setStyle("-fx-control-inner-background: #D6D6D6");
                roomNumberArea.setEditable(false);
                roomNumberArea.setPrefSize(140, 40);
                roomNumberArea.setLayoutX(150);
                roomNumberArea.setLayoutY(375);
                roomNumberArea.setStyle("-fx-control-inner-background: #D6D6D6");
                occupancyArea.setEditable(false);
                occupancyArea.setPrefSize(140, 40);
                occupancyArea.setLayoutX(550);
                occupancyArea.setLayoutY(420);
                occupancyArea.setStyle("-fx-control-inner-background: #D6D6D6");
                leaseNumberArea.setEditable(false);
                leaseNumberArea.setPrefSize(140, 40);
                leaseNumberArea.setLayoutX(550);
                leaseNumberArea.setLayoutY(330);
                leaseNumberArea.setStyle("-fx-control-inner-background: #D6D6D6");
                leaseDurationArea.setEditable(false);
                leaseDurationArea.setPrefSize(140, 40);
                leaseDurationArea.setLayoutX(382.5);
                leaseDurationArea.setLayoutY(480);
                leaseDurationArea.setStyle("-fx-control-inner-background: #D6D6D6");
                studentNameArea.setEditable(false);
                studentNameArea.setPrefSize(140, 40);
                studentNameArea.setLayoutX(550);
                studentNameArea.setLayoutY(375);
                studentNameArea.setStyle("-fx-control-inner-background: #D6D6D6");
                cleanStatusCombo.setEditable(true);
                cleanStatusCombo.setPrefSize(140, 40);
                cleanStatusCombo.setLayoutX(150);
                cleanStatusCombo.setLayoutY(420);
                cleanStatusCombo.getItems().addAll(
                        "Clean",
                        "Dirty",
                        "Offline"
                );

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
                        new PropertyValueFactory<Table, String>("leaseNumber"));
                TableColumn leaseDurCol = new TableColumn("Lease Duration");
                leaseDurCol.setCellValueFactory(
                        new PropertyValueFactory<Table, String>("leaseDuration"));
                TableColumn studentNameCol = new TableColumn("Student Name");
                studentNameCol.setCellValueFactory(
                        new PropertyValueFactory<Table, String>("studentName"));
                TableColumn cleaningCol = new TableColumn("Cleaning Status");
                cleaningCol.setCellValueFactory(
                        new PropertyValueFactory<Table, String>("cleanStatus"));
                table.setItems(tableList);
                table.getColumns().addAll(hallNameCol, roomNumCol,
                        occupancyCol, leaseNumCol, leaseDurCol,
                        studentNameCol, cleaningCol);

                //Detect row selection, fill text areas with corresponding data
                table.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        for (Table currentTable : tableList) {
                            if (currentTable
                                    == table.getSelectionModel()
                                            .getSelectedItem()) {
                                hallNameArea.setText(
                                        currentTable.getHallName());
                                roomNumberArea.setText(Integer.toString(
                                        currentTable.getRoomNumber()));
                                occupancyArea.setText(
                                        currentTable.getOccupancy());
                                leaseNumberArea.setText(
                                        currentTable.getLeaseNumber());
                                leaseDurationArea.setText(
                                        currentTable.getLeaseDuration()
                                                .replace(" Months", ""));
                                studentNameArea.setText(
                                        currentTable.getStudentName());
                                cleanStatusCombo.getSelectionModel().select(
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
                tableVbox.setPrefSize(685, 300);

                //Update button
                Button updateBtn = new Button();
                updateBtn.setText("Update");
                updateBtn.setPrefSize(100, 30);
                updateBtn.setStyle("-fx-font-size: 1em; ");
                updateBtn.setLayoutX(620);
                updateBtn.setLayoutY(525);
                //Change data in Table & relevant classes when button pressed                 
                updateBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        for (Table currentTable : tableList) {
                            if (currentTable == table.getSelectionModel()
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
                                errorText.setFont(Font.font("Verdana", FontWeight.BOLD, 13));

                                //Update clean status
                                try {
                                    //Check if room is occupied (cant be offline)
                                    if (leaseNumberArea.getText().equals("N/A")) {
                                    } else {
                                        if (cleanStatusCombo.getValue().toString().equals("Offline")) {
                                            throw new NoSuchMethodException();
                                        }
                                    }
                                    //Change clean status in Room class                                               
                                    int roomNumber = currentTable.getRoomNumber();
                                    int hallID = 0;
                                    for (Halls currentHall : hallList) {
                                        if (currentTable.getHallName().equals(currentHall.getHallName())) {
                                            hallID = currentHall.getHallID();
                                        }
                                    }
                                    for (Room currentRoom : roomList) {
                                        if ((currentRoom.getHallID() == hallID) && (currentRoom.getRoomNumber() == roomNumber)) {
                                            currentRoom.setCleanStatus(cleanStatusCombo.getValue().toString());
                                            break;
                                        }
                                    }
                                    //Save to file
                                    try {
                                        saveFileData();
                                    } catch (IOException ex) {
                                        Logger.getLogger(AccommodationApplication.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    //Change clean status in Table Class
                                    currentTable.setCleanStatus(cleanStatusCombo.getValue().toString());
                                    table.refresh();

                                } catch (NoSuchMethodException offline) {
                                    errorText.setText("An occupied room cannot\nbe set to Offline.");
                                    errorText.setTextAlignment(TextAlignment.CENTER);
                                    dialogVbox.getChildren().add(errorText);
                                    dialogVbox.setAlignment(Pos.CENTER);
                                    errorDialog.show();
                                }
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
                backBtn.setLayoutY(525);
                //Back button handling
                backBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        wardenStage.close();
                        primaryStage.show();
                    }
                });

                //Create pane and add objects depending on scene
                Pane root = new Pane();
                root.getChildren().add(updateBtn);
                root.getChildren().add(backBtn);
                root.getChildren().addAll(tableVbox);
                root.getChildren().addAll(hallNameLabel, //Labels
                        roomNumberLabel,
                        occupancyLabel,
                        leaseNumberLabel,
                        leaseDurationLabel,
                        studentNameLabel,
                        cleanStatusLabel
                );
                root.getChildren().addAll(hallNameArea, //Text areas & Combos
                        roomNumberArea,
                        occupancyArea,
                        leaseNumberArea,
                        leaseDurationArea,
                        studentNameArea,
                        cleanStatusCombo
                );

                //Set scene dimensions and title
                Scene scene = new Scene(root, 725, 560);
                wardenStage.setTitle("Warden View - Accommodation System");

                //Set scene to stage and show
                wardenStage.setScene(scene);
                wardenStage.show();

            }
        }
        );

        /**
         * * ALL Stage Handling **
         */
        allBtn.setOnAction(
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event
            ) {
                //Switch stage
                primaryStage.close();
                Stage allStage = new Stage();

                /**
                 * * ADD HALL Handling **
                 */
                Button addHallBtn = new Button();
                addHallBtn.setText("Add New Hall");
                addHallBtn.setPrefSize(175, 40);
                addHallBtn.setStyle("-fx-font-size: 2em; ");
                addHallBtn.setLayoutX(212.5);
                addHallBtn.setLayoutY(100);
                addHallBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        allStage.close();
                        Stage addHallStage = new Stage();

                        //Create an observable list for hall data
                        ObservableList<Halls> observableHallList
                                = FXCollections.observableArrayList(hallList);

                        //Text Area Labels
                        Label hallNameLabel = new Label("Hall Name");
                        Label hallIdLabel = new Label("Hall ID");
                        Label phoneNumberLabel = new Label("Phone Number");
                        Label addressLabel = new Label("Address");
                        Label postCodeLabel = new Label("Post Code");
                        hallNameLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                        hallNameLabel.setLayoutX(40);
                        hallNameLabel.setLayoutY(285);
                        hallIdLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                        hallIdLabel.setLayoutX(202.5);
                        hallIdLabel.setLayoutY(285);
                        phoneNumberLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                        phoneNumberLabel.setLayoutX(322.5);
                        phoneNumberLabel.setLayoutY(285);
                        addressLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                        addressLabel.setLayoutX(125);
                        addressLabel.setLayoutY(355);
                        postCodeLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                        postCodeLabel.setLayoutX(270);
                        postCodeLabel.setLayoutY(355);

                        //Text Areas & Combo Boxes
                        TextArea hallNameArea = new TextArea();
                        TextArea hallIdArea = new TextArea();
                        TextArea phoneNumberArea = new TextArea();
                        TextArea addressArea = new TextArea();
                        TextArea postCodeArea = new TextArea();
                        hallNameArea.setEditable(true);
                        hallNameArea.setPrefSize(140, 40);
                        hallNameArea.setLayoutX(15);
                        hallNameArea.setLayoutY(310);
                        hallIdArea.setEditable(true);
                        hallIdArea.setPrefSize(140, 40);
                        hallIdArea.setLayoutX(165);
                        hallIdArea.setLayoutY(310);
                        phoneNumberArea.setEditable(true);
                        phoneNumberArea.setPrefSize(140, 40);
                        phoneNumberArea.setLayoutX(315);
                        phoneNumberArea.setLayoutY(310);
                        addressArea.setEditable(true);
                        addressArea.setPrefSize(140, 40);
                        addressArea.setLayoutX(90);
                        addressArea.setLayoutY(380);
                        postCodeArea.setEditable(true);
                        postCodeArea.setPrefSize(140, 40);
                        postCodeArea.setLayoutX(242.5);
                        postCodeArea.setLayoutY(380);

                        //Table label
                        Label tableLabel = new Label("Halls:");
                        tableLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

                        //Create table columns and set fill data
                        TableView table = new TableView();
                        table.setEditable(true);
                        TableColumn hallNameCol = new TableColumn("Hall Name");
                        hallNameCol.setCellValueFactory(
                                new PropertyValueFactory<Halls, String>("hallName"));
                        TableColumn hallIdCol = new TableColumn("Hall ID");
                        hallIdCol.setCellValueFactory(
                                new PropertyValueFactory<Halls, Integer>("hallID"));
                        TableColumn addressCol = new TableColumn("Address");
                        addressCol.setCellValueFactory(
                                new PropertyValueFactory<Halls, String>("hallAddress"));
                        TableColumn postCodeCol = new TableColumn("Post Code");
                        postCodeCol.setCellValueFactory(
                                new PropertyValueFactory<Halls, String>("hallPostCode"));
                        TableColumn phoneNumberCol = new TableColumn("Phone Number");
                        phoneNumberCol.setCellValueFactory(
                                new PropertyValueFactory<Halls, String>("phoneNumber"));
                        table.setItems(observableHallList);
                        table.getColumns().addAll(hallNameCol, hallIdCol,
                                addressCol, postCodeCol, phoneNumberCol);

                        //Form table                
                        VBox tableVbox = new VBox();
                        tableVbox.setSpacing(5);
                        tableVbox.getChildren().addAll(tableLabel, table);
                        tableVbox.setLayoutX(20);
                        tableVbox.setLayoutY(20);
                        tableVbox.setPrefSize(430, 250);

                        //Add button
                        Button addBtn = new Button();
                        addBtn.setText("Add");
                        addBtn.setPrefSize(100, 30);
                        addBtn.setStyle("-fx-font-size: 1em; ");
                        addBtn.setLayoutX(365);
                        addBtn.setLayoutY(445);
                        //Change data in Table & relevant classes when button pressed                 
                        addBtn.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                //Create popup used for error display
                                Stage errorDialog = new Stage();
                                errorDialog.initModality(Modality.APPLICATION_MODAL);
                                errorDialog.initOwner(primaryStage);
                                errorDialog.setTitle("ERROR");
                                VBox dialogVbox = new VBox(20);
                                Scene dialogScene = new Scene(dialogVbox, 300, 50);
                                errorDialog.setScene(dialogScene);
                                Text errorText = new Text();
                                errorText.setFont(Font.font("Verdana", FontWeight.BOLD, 13));

                                //Get new data to be added 
                                String newHallName = hallNameArea.getText();
                                String newHallId = hallIdArea.getText();
                                String newPhoneNum = phoneNumberArea.getText();
                                String newAddress = addressArea.getText();
                                String newPostCode = postCodeArea.getText();

                                //Check if text entries are empty                              
                                if ((newHallName != null && !newHallName.isEmpty())
                                        && (newHallId != null && !newHallId.isEmpty())
                                        && (newPhoneNum != null && !newPhoneNum.isEmpty())
                                        && (newAddress != null && !newAddress.isEmpty())
                                        && (newPostCode != null && !newPostCode.isEmpty())) {
                                    //Check if text entries contain commas
                                    if (newHallName.contains(",")
                                            || newHallId.contains(",")
                                            || newPhoneNum.contains(",")
                                            || newAddress.contains(",")
                                            || newPostCode.contains(",")) {
                                        errorText.setText("Data cannot contain commas.");
                                        errorText.setTextAlignment(TextAlignment.CENTER);
                                        dialogVbox.getChildren().add(errorText);
                                        dialogVbox.setAlignment(Pos.CENTER);
                                        errorDialog.show();
                                    } else {
                                        try {
                                            //Check if hall name/ID in use
                                            int newHallIdInt = Integer.parseInt(
                                                    newHallId);
                                            boolean alreadyExists = false;
                                            for (Halls hall : hallList) {
                                                if (hall.getHallName().equals(newHallName)) {
                                                    errorText.setText("Hall name already\nin use.");
                                                    errorText.setTextAlignment(TextAlignment.CENTER);
                                                    dialogVbox.getChildren().add(errorText);
                                                    dialogVbox.setAlignment(Pos.CENTER);
                                                    errorDialog.show();
                                                    alreadyExists = true;
                                                    break;
                                                } else if (hall.getHallID() == newHallIdInt) {
                                                    errorText.setText("Hall ID already\nin use.");
                                                    errorText.setTextAlignment(TextAlignment.CENTER);
                                                    dialogVbox.getChildren().add(errorText);
                                                    dialogVbox.setAlignment(Pos.CENTER);
                                                    errorDialog.show();
                                                    alreadyExists = true;
                                                    break;
                                                }
                                            }
                                            //Add new data
                                            if (alreadyExists == false) {
                                                hallList.add(new Halls(newHallName,
                                                        newHallIdInt,
                                                        newAddress,
                                                        newPostCode,
                                                        newPhoneNum
                                                ));
                                                saveFileData();
                                                addHallStage.close();
                                                addHallBtn.fire();
                                            }
                                            //Check if new hall ID is valid int
                                        } catch (NumberFormatException eNum) {
                                            errorText.setText("Hall ID must be a\nwhole number.");
                                            errorText.setTextAlignment(TextAlignment.CENTER);
                                            dialogVbox.getChildren().add(errorText);
                                            dialogVbox.setAlignment(Pos.CENTER);
                                            errorDialog.show();
                                        } catch (IOException ex) {
                                            Logger.getLogger(AccommodationApplication.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                } else {
                                    errorText.setText("All fields must contain\ndata.");
                                    errorText.setTextAlignment(TextAlignment.CENTER);
                                    dialogVbox.getChildren().add(errorText);
                                    dialogVbox.setAlignment(Pos.CENTER);
                                    errorDialog.show();
                                }
                            }
                        });

                        //Back button
                        Button backBtn = new Button();
                        backBtn.setText("Back");
                        backBtn.setPrefSize(100, 30);
                        backBtn.setStyle("-fx-font-size: 1em; ");
                        backBtn.setLayoutX(5);
                        backBtn.setLayoutY(445);
                        //Back button handling
                        backBtn.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                addHallStage.close();
                                allStage.show();
                            }
                        });

                        //Create pane and add objects depending on scene
                        Pane root = new Pane();
                        root.getChildren().add(tableVbox);
                        root.getChildren().add(addBtn);
                        root.getChildren().add(backBtn);
                        root.getChildren().addAll(hallNameLabel,
                                hallIdLabel,
                                phoneNumberLabel,
                                addressLabel,
                                postCodeLabel
                        );
                        root.getChildren().addAll(hallNameArea,
                                hallIdArea,
                                phoneNumberArea,
                                addressArea,
                                postCodeArea
                        );

                        //Set scene dimensions and title
                        Scene scene = new Scene(root, 470, 480);
                        addHallStage.setTitle("Add Hall - Accommodation System");

                        //Set scene to stage and show
                        addHallStage.setScene(scene);
                        addHallStage.show();
                    }
                });

                /**
                 * * ADD ROOM Handling **
                 */
                Button addRoomBtn = new Button();
                addRoomBtn.setText("Add New\nRoom");
                addRoomBtn.setPrefSize(175, 80);
                addRoomBtn.setStyle("-fx-font-size: 2em; ");
                addRoomBtn.setLayoutX(100);
                addRoomBtn.setLayoutY(175);
                addRoomBtn.setTextAlignment(TextAlignment.CENTER);
                addRoomBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        allStage.close();
                        Stage addRoomStage = new Stage();

                        //Create an observable list for hall data
                        ObservableList<Room> observableRoomList
                                = FXCollections.observableArrayList(roomList);

                        //Text Area Labels
                        Label roomNumberLabel = new Label("Room Number");
                        Label monthlyRentLabel = new Label("Monthly Rent");
                        Label hallIdLabel = new Label("Hall ID");
                        Label cleanStatusLabel = new Label("Clean Status");
                        Label occupancyLabel = new Label("Occupancy");
                        roomNumberLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                        roomNumberLabel.setLayoutX(25);
                        roomNumberLabel.setLayoutY(285);
                        monthlyRentLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                        monthlyRentLabel.setLayoutX(180);
                        monthlyRentLabel.setLayoutY(285);
                        hallIdLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                        hallIdLabel.setLayoutX(350);
                        hallIdLabel.setLayoutY(285);
                        cleanStatusLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                        cleanStatusLabel.setLayoutX(110);
                        cleanStatusLabel.setLayoutY(355);
                        occupancyLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                        occupancyLabel.setLayoutX(265);
                        occupancyLabel.setLayoutY(355);

                        //Text Areas & Combo Boxes
                        TextArea roomNumberArea = new TextArea();
                        TextArea monthlyRentArea = new TextArea();
                        TextArea hallIdArea = new TextArea();
                        TextArea cleanStatusArea = new TextArea();
                        TextArea occupancyArea = new TextArea();
                        roomNumberArea.setEditable(true);
                        roomNumberArea.setPrefSize(140, 40);
                        roomNumberArea.setLayoutX(15);
                        roomNumberArea.setLayoutY(310);
                        monthlyRentArea.setEditable(true);
                        monthlyRentArea.setPrefSize(140, 40);
                        monthlyRentArea.setLayoutX(165);
                        monthlyRentArea.setLayoutY(310);
                        hallIdArea.setEditable(true);
                        hallIdArea.setPrefSize(140, 40);
                        hallIdArea.setLayoutX(315);
                        hallIdArea.setLayoutY(310);
                        cleanStatusArea.setEditable(false);
                        cleanStatusArea.setPrefSize(140, 40);
                        cleanStatusArea.setLayoutX(90);
                        cleanStatusArea.setLayoutY(380);
                        cleanStatusArea.setText("Offline");
                        cleanStatusArea.setStyle("-fx-control-inner-background: #D6D6D6");
                        occupancyArea.setEditable(false);
                        occupancyArea.setPrefSize(140, 40);
                        occupancyArea.setLayoutX(242.5);
                        occupancyArea.setLayoutY(380);
                        occupancyArea.setText("Unoccupied");
                        occupancyArea.setStyle("-fx-control-inner-background: #D6D6D6");

                        //Table label
                        Label tableLabel = new Label("Rooms:");
                        tableLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

                        //Create table columns and set fill data
                        TableView table = new TableView();
                        table.setEditable(true);
                        TableColumn roomNumCol = new TableColumn("Room Number");
                        roomNumCol.setCellValueFactory(
                                new PropertyValueFactory<Room, Integer>("roomNumber"));
                        TableColumn monthlyRentCol = new TableColumn("Monthly Rent");
                        monthlyRentCol.setCellValueFactory(
                                new PropertyValueFactory<Room, Double>("monthlyRent"));
                        TableColumn hallIdCol = new TableColumn("Hall ID");
                        hallIdCol.setCellValueFactory(
                                new PropertyValueFactory<Room, String>("hallID"));
                        TableColumn cleanStatusCol = new TableColumn("Clean Status");
                        cleanStatusCol.setCellValueFactory(
                                new PropertyValueFactory<Room, String>("cleanStatus"));
                        TableColumn occupancyCol = new TableColumn("Occupancy");
                        occupancyCol.setCellValueFactory(
                                new PropertyValueFactory<Room, String>("occupancy"));
                        table.setItems(observableRoomList);
                        table.getColumns().addAll(roomNumCol, monthlyRentCol,
                                hallIdCol, cleanStatusCol, occupancyCol);

                        //Form table                
                        VBox tableVbox = new VBox();
                        tableVbox.setSpacing(5);
                        tableVbox.getChildren().addAll(tableLabel, table);
                        tableVbox.setLayoutX(20);
                        tableVbox.setLayoutY(20);
                        tableVbox.setPrefSize(430, 250);

                        //Add button
                        Button addBtn = new Button();
                        addBtn.setText("Add");
                        addBtn.setPrefSize(100, 30);
                        addBtn.setStyle("-fx-font-size: 1em; ");
                        addBtn.setLayoutX(365);
                        addBtn.setLayoutY(445);
                        //Change data in Table & relevant classes when button pressed   
                        addBtn.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                //Create popup used for error display
                                Stage errorDialog = new Stage();
                                errorDialog.initModality(Modality.APPLICATION_MODAL);
                                errorDialog.initOwner(primaryStage);
                                errorDialog.setTitle("ERROR");
                                VBox dialogVbox = new VBox(20);
                                Scene dialogScene = new Scene(dialogVbox, 300, 50);
                                errorDialog.setScene(dialogScene);
                                Text errorText = new Text();
                                errorText.setFont(Font.font("Verdana", FontWeight.BOLD, 13));

                                //Get new data to be added 
                                String newRoomNum = roomNumberArea.getText();
                                String newMonthlyRent = monthlyRentArea.getText();
                                String newHallId = hallIdArea.getText();
                                String newCleanStatus = cleanStatusArea.getText();
                                String newOccupancy = occupancyArea.getText();

                                //Check if text entries are empty                              
                                if ((newRoomNum != null && !newRoomNum.isEmpty())
                                        && (newMonthlyRent != null && !newMonthlyRent.isEmpty())
                                        && (newHallId != null && !newHallId.isEmpty())
                                        && (newCleanStatus != null && !newCleanStatus.isEmpty())
                                        && (newOccupancy != null && !newOccupancy.isEmpty())) {
                                    //Check if text entries contain commas
                                    if (newRoomNum.contains(",")
                                            || newMonthlyRent.contains(",")
                                            || newHallId.contains(",")
                                            || newCleanStatus.contains(",")
                                            || newOccupancy.contains(",")) {
                                        errorText.setText("Data cannot contain commas.");
                                        errorText.setTextAlignment(TextAlignment.CENTER);
                                        dialogVbox.getChildren().add(errorText);
                                        dialogVbox.setAlignment(Pos.CENTER);
                                        errorDialog.show();
                                    } else {
                                        boolean validRoomNum = false;
                                        boolean validRent = false;
                                        boolean roomExists = false;
                                        boolean hallExists = false;
                                        try {
                                            //Check int's/double valid                                            
                                            int newRoomNumInt = Integer.parseInt(
                                                    newRoomNum);
                                            validRoomNum = true;
                                            double newMonthlyRentDouble
                                                    = Double.parseDouble(newMonthlyRent);
                                            validRent = true;
                                            int newHallIdInt = Integer.parseInt(
                                                    newHallId);
                                            //Check if hall exists                                            
                                            for (Halls hall : hallList) {
                                                if (hall.getHallID() == newHallIdInt) {
                                                    hallExists = true;
                                                    break;
                                                }
                                            }
                                            if (hallExists == true) {
                                                //Check if room already exists
                                                for (Room room : roomList) {
                                                    if ((room.getHallID() == newHallIdInt)
                                                            && (room.getRoomNumber() == newRoomNumInt)) {
                                                        errorText.setText("Room already exists.");
                                                        errorText.setTextAlignment(TextAlignment.CENTER);
                                                        dialogVbox.getChildren().add(errorText);
                                                        dialogVbox.setAlignment(Pos.CENTER);
                                                        errorDialog.show();
                                                        roomExists = true;
                                                        break;
                                                    }
                                                    //Add new data
                                                    if (roomExists == false) {
                                                        roomList.add(new Room(newRoomNumInt,
                                                                newMonthlyRentDouble,
                                                                newHallIdInt,
                                                                newCleanStatus,
                                                                newOccupancy
                                                        ));
                                                        saveFileData();
                                                        getTableData();
                                                        addRoomStage.close();
                                                        addRoomBtn.fire();
                                                    }
                                                }
                                            } else {
                                                errorText.setText("Hall with that ID\ndoes not exist.");
                                                errorText.setTextAlignment(TextAlignment.CENTER);
                                                dialogVbox.getChildren().add(errorText);
                                                dialogVbox.setAlignment(Pos.CENTER);
                                                errorDialog.show();
                                            }
                                        } catch (NumberFormatException eNum) {
                                            if (validRoomNum == true) {
                                                errorText.setText("Room number must be\na whole number.");
                                            } else if (validRent == true) {
                                                errorText.setText("Monthly Rent must be\na decimal number.");
                                            } else {
                                                errorText.setText("Hall ID must be\na whole number.");
                                            }
                                            errorText.setTextAlignment(TextAlignment.CENTER);
                                            dialogVbox.getChildren().add(errorText);
                                            dialogVbox.setAlignment(Pos.CENTER);
                                            errorDialog.show();
                                        } catch (IOException ex) {
                                            Logger.getLogger(AccommodationApplication.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                } else {
                                    errorText.setText("All fields must contain\ndata.");
                                    errorText.setTextAlignment(TextAlignment.CENTER);
                                    dialogVbox.getChildren().add(errorText);
                                    dialogVbox.setAlignment(Pos.CENTER);
                                    errorDialog.show();
                                }
                            }
                        }
                        );

                        //Back button
                        Button backBtn = new Button();

                        backBtn.setText("Back");
                        backBtn.setPrefSize(100, 30);
                        backBtn.setStyle("-fx-font-size: 1em; ");
                        backBtn.setLayoutX(5);
                        backBtn.setLayoutY(445);
                        //Back button handling
                        backBtn.setOnAction(
                                new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event
                            ) {
                                addRoomStage.close();
                                allStage.show();
                            }
                        }
                        );

                        //Create pane and add objects depending on scene
                        Pane root = new Pane();

                        root.getChildren().add(tableVbox);
                        root.getChildren().add(addBtn);
                        root.getChildren().add(backBtn);
                        root.getChildren().addAll(roomNumberLabel,
                                        monthlyRentLabel,
                                        hallIdLabel,
                                        cleanStatusLabel,
                                        occupancyLabel
                                );
                        root.getChildren().addAll(roomNumberArea,
                                        monthlyRentArea,
                                        hallIdArea,
                                        cleanStatusArea,
                                        occupancyArea
                                );

                        //Set scene dimensions and title
                        Scene scene = new Scene(root, 470, 480);
                        addRoomStage.setTitle("Add Room - Accommodation System");

                        //Set scene to stage and show
                        addRoomStage.setScene(scene);
                        addRoomStage.show();
                    }
                }
                );

                /**
                 * * ADD STUDENT Handling **
                 */
                Button addStudentBtn = new Button();
                addStudentBtn.setText("Add New\nStudent");
                addStudentBtn.setPrefSize(175, 80);
                addStudentBtn.setStyle("-fx-font-size: 2em; ");
                addStudentBtn.setLayoutX(325);
                addStudentBtn.setLayoutY(175);
                addStudentBtn.setTextAlignment(TextAlignment.CENTER);
                addStudentBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        allStage.close();
                        Stage addStudentStage = new Stage();

                        //Create an observable list for hall data
                        ObservableList<Student> observableStudentList
                                = FXCollections.observableArrayList(studentList);

                        //Text Area Labels
                        Label studentNameLabel = new Label("Student Name");
                        Label studentIdLabel = new Label("Student ID");
                        studentNameLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                        studentNameLabel.setLayoutX(100);
                        studentNameLabel.setLayoutY(300);
                        studentIdLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                        studentIdLabel.setLayoutX(265);
                        studentIdLabel.setLayoutY(300);                        

                        //Text Areas & Combo Boxes
                        TextArea studentNameArea = new TextArea();
                        TextArea studentIdArea = new TextArea();
                        studentNameArea.setEditable(true);
                        studentNameArea.setPrefSize(140, 40);
                        studentNameArea.setLayoutX(90);
                        studentNameArea.setLayoutY(325);
                        studentIdArea.setEditable(true);
                        studentIdArea.setPrefSize(140, 40);
                        studentIdArea.setLayoutX(242.5);
                        studentIdArea.setLayoutY(325);

                        //Table label
                        Label tableLabel = new Label("Students:");
                        tableLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

                        //Create table columns and set fill data
                        TableView table = new TableView();
                        table.setEditable(true);
                        TableColumn studentNameCol = new TableColumn("Student Name");
                        studentNameCol.setCellValueFactory(
                                new PropertyValueFactory<Student, String>("studentName"));
                        TableColumn studentIdCol = new TableColumn("Student ID");
                        studentIdCol.setCellValueFactory(
                                new PropertyValueFactory<Student, String>("studentID"));                        
                        table.setItems(observableStudentList);
                        table.getColumns().addAll(studentNameCol, studentIdCol);

                        //Form table                
                        VBox tableVbox = new VBox();
                        tableVbox.setSpacing(5);
                        tableVbox.getChildren().addAll(tableLabel, table);
                        tableVbox.setLayoutX(20);
                        tableVbox.setLayoutY(20);
                        tableVbox.setPrefSize(430, 250);

                        //Add button
                        Button addBtn = new Button();
                        addBtn.setText("Add");
                        addBtn.setPrefSize(100, 30);
                        addBtn.setStyle("-fx-font-size: 1em; ");
                        addBtn.setLayoutX(365);
                        addBtn.setLayoutY(445);
                        //Change data in Table & relevant classes when button pressed                           
                        addBtn.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                //Create popup used for error display
                                Stage errorDialog = new Stage();
                                errorDialog.initModality(Modality.APPLICATION_MODAL);
                                errorDialog.initOwner(primaryStage);
                                errorDialog.setTitle("ERROR");
                                VBox dialogVbox = new VBox(20);
                                Scene dialogScene = new Scene(dialogVbox, 300, 50);
                                errorDialog.setScene(dialogScene);
                                Text errorText = new Text();
                                errorText.setFont(Font.font("Verdana", FontWeight.BOLD, 13));

                                //Get new data to be added 
                                String newStudentName = studentNameArea.getText();
                                String newStudentId = studentIdArea.getText();

                                //Check if text entries are empty                              
                                if ((newStudentName != null && !newStudentName.isEmpty())
                                        && (newStudentId != null && !newStudentId.isEmpty())) {
                                    //Check if text entries contain commas
                                    if (newStudentName.contains(",")
                                            || newStudentId.contains(",")) {
                                        errorText.setText("Data cannot contain commas.");
                                        errorText.setTextAlignment(TextAlignment.CENTER);
                                        dialogVbox.getChildren().add(errorText);
                                        dialogVbox.setAlignment(Pos.CENTER);
                                        errorDialog.show();
                                    } else {
                                        boolean studentIdExists = false;
                                        try {
                                            //Check int's/double valid                                            
                                            int newStudentIdInt = Integer.parseInt(
                                                    newStudentId);
                                            
                                            //Check if student ID is in use                                            
                                            for (Student student : studentList) {
                                                if (student.getStudentID()
                                                        == newStudentIdInt) {
                                                    studentIdExists = true;
                                                    errorText.setText("Student ID already\nin use.");
                                                    errorText.setTextAlignment(TextAlignment.CENTER);
                                                    dialogVbox.getChildren().add(errorText);
                                                    dialogVbox.setAlignment(Pos.CENTER);
                                                    errorDialog.show();
                                                    break;
                                                }
                                            }
                                            if (studentIdExists != true) {
                                                //Add new data                                                
                                                studentList.add(new Student(newStudentName,
                                                        newStudentIdInt
                                                ));
                                                saveFileData();
                                                addStudentStage.close();
                                                addStudentBtn.fire();
                                            }
                                        } catch (NumberFormatException eNum) {
                                            errorText.setText("Student ID must be\na whole number.");
                                            errorText.setTextAlignment(TextAlignment.CENTER);
                                            dialogVbox.getChildren().add(errorText);
                                            dialogVbox.setAlignment(Pos.CENTER);
                                            errorDialog.show();
                                        } catch (IOException ex) {
                                            Logger.getLogger(AccommodationApplication.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                } else {
                                    errorText.setText("All fields must contain\ndata.");
                                    errorText.setTextAlignment(TextAlignment.CENTER);
                                    dialogVbox.getChildren().add(errorText);
                                    dialogVbox.setAlignment(Pos.CENTER);
                                    errorDialog.show();
                                }
                            }
                        }
                        );

                        //Back button
                        Button backBtn = new Button();

                        backBtn.setText("Back");
                        backBtn.setPrefSize(100, 30);
                        backBtn.setStyle("-fx-font-size: 1em; ");
                        backBtn.setLayoutX(5);
                        backBtn.setLayoutY(445);
                        //Back button handling
                        backBtn.setOnAction(
                                new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event
                            ) {
                                addStudentStage.close();
                                allStage.show();
                            }
                        }
                        );

                        //Create pane and add objects depending on scene
                        Pane root = new Pane();

                        root.getChildren().add(tableVbox);
                        root.getChildren().add(addBtn);
                        root.getChildren().add(backBtn);
                        root.getChildren().addAll(studentNameLabel,
                                        studentIdLabel
                                );
                        root.getChildren().addAll(studentNameArea,
                                        studentIdArea
                                );

                        //Set scene dimensions and title
                        Scene scene = new Scene(root, 470, 480);
                        addStudentStage.setTitle("Add Student - Accommodation System");

                        //Set scene to stage and show
                        addStudentStage.setScene(scene);
                        addStudentStage.show();
                    }
                }
                );

                //Back button
                Button backBtn = new Button();
                backBtn.setText("Back");
                backBtn.setPrefSize(100, 30);
                backBtn.setStyle("-fx-font-size: 1em; ");
                backBtn.setLayoutX(5);
                backBtn.setLayoutY(315);
                //Back button handling
                backBtn.setOnAction(
                        new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event
                    ) {
                        allStage.close();
                        primaryStage.show();
                    }
                }
                );

                //Create pane and add objects depending on scene
                Pane root = new Pane();
                root.getChildren().addAll(addHallBtn,
                                addRoomBtn,
                                addStudentBtn,
                                backBtn);

                //Set scene dimensions and title
                Scene scene = new Scene(root, 600, 350);
                allStage.setTitle("All View - Accommodation System");

                //Set scene to stage and show
                allStage.setScene(scene);
                allStage.show();
            }
        }
        );

        //Create pane and add objects depending on scene
        Pane root = new Pane();

        root.getChildren()
                .add(managerBtn);
        root.getChildren()
                .add(wardenBtn);
        root.getChildren()
                .add(allBtn);
        root.getChildren()
                .add(warningLabel);
        root.getChildren()
                .add(mainText);

        //Set scene dimensions and title
        Scene scene = new Scene(root, 600, 350);

        primaryStage.setTitle(
                "UWE Bristol - Accommodation System");

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
            br.readLine();//Skips header line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                int hallID = Integer.parseInt(data[1]);
                hallList.add(new Halls(data[0], hallID, data[2],
                        data[3], data[4]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR -- File containing Halls data missing");
            System.exit(1);
        }

        //Get ROOMS data
        try {
            br = new BufferedReader(new FileReader(roomsFile));
            br.readLine();//Skips header line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                int roomNumber = Integer.parseInt(data[0]);
                double monthlyRent = Double.parseDouble(data[1]);
                int hallID = Integer.parseInt(data[2]);
                roomList.add(new Room(roomNumber, monthlyRent, hallID,
                        data[3], data[4]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR -- File containing Rooms data missing");
            System.exit(1);
        }

        //Get STUDENTS data
        try {
            br = new BufferedReader(new FileReader(studentsFile));
            br.readLine();//Skips header line
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
            br.readLine();//Skips header line
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

    public void saveFileData() throws IOException {
        String hallsFile = "./resources/data/halls.csv";
        String roomsFile = "./resources/data/rooms.csv";
        String studentsFile = "./resources/data/students.csv";
        String leasesFile = "./resources/data/leases.csv";
        FileWriter hallWriter = new FileWriter(hallsFile);
        FileWriter roomWriter = new FileWriter(roomsFile);
        FileWriter studentWriter = new FileWriter(studentsFile);
        FileWriter leaseWriter = new FileWriter(leasesFile);

        //HALLS file headers
        List<String> hallHeaders = new ArrayList<>();
        hallHeaders.add("Hall Name");
        hallHeaders.add("Hall ID");
        hallHeaders.add("Address");
        hallHeaders.add("Post Code");
        hallHeaders.add("Phone Number");
        String hallHeaderLine = hallHeaders.stream().collect(Collectors.joining(","));
        hallWriter.write(hallHeaderLine);
        hallWriter.write(System.getProperty("line.separator"));        
        
        //Save HALLS data       
        for (Halls hall : hallList) {
            //List of data to be saved
            List<String> hallData = new ArrayList<>();
            hallData.add(hall.getHallName());
            hallData.add(Integer.toString(hall.getHallID()));
            hallData.add(hall.getHallAddress());
            hallData.add(hall.getHallPostCode());
            hallData.add(hall.getPhoneNumber());

            //Write to file
            String hallLine = hallData.stream().collect(Collectors.joining(","));
            hallWriter.write(hallLine);
            hallWriter.write(System.getProperty("line.separator"));
        }
        hallWriter.close();

        //ROOMS file headers
        List<String> roomHeaders = new ArrayList<>();
        roomHeaders.add("Room Number");
        roomHeaders.add("Monthly Rent (£)");
        roomHeaders.add("Hall ID");
        roomHeaders.add("Clean Status");
        roomHeaders.add("Occupancy");
        String roomHeaderLine = roomHeaders.stream().collect(Collectors.joining(","));
        roomWriter.write(roomHeaderLine);
        roomWriter.write(System.getProperty("line.separator"));        
        
        //Save ROOMS data
        for (Room room : roomList) {
            //List of data to be saved
            List<String> roomData = new ArrayList<>();
            roomData.add(Integer.toString(room.getRoomNumber()));
            roomData.add(Double.toString(room.getMonthlyRent()));
            roomData.add(Integer.toString(room.getHallID()));
            roomData.add(room.getCleanStatus());
            roomData.add(room.getOccupancy());

            //Write to file
            String roomLine = roomData.stream().collect(Collectors.joining(","));
            roomWriter.write(roomLine);
            roomWriter.write(System.getProperty("line.separator"));
        }
        roomWriter.close();
        
        //STUDENTS file headers
        List<String> studentHeaders = new ArrayList<>();
        studentHeaders.add("Student Name");
        studentHeaders.add("Student ID");
        String studentHeaderLine = studentHeaders.stream().collect(Collectors.joining(","));
        studentWriter.write(studentHeaderLine);
        studentWriter.write(System.getProperty("line.separator"));        

        //Save STUDENTS data
        for (Student student : studentList) {
            //List of data to be saved
            List<String> studentData = new ArrayList<>();
            studentData.add(student.getStudentName());
            studentData.add(Integer.toString(student.getStudentID()));

            //Write to file
            String studentLine = studentData.stream().collect(Collectors.joining(","));
            studentWriter.write(studentLine);
            studentWriter.write(System.getProperty("line.separator"));
        }
        studentWriter.close();
        
        //LEASES file headers
        List<String> leaseHeaders = new ArrayList<>();
        leaseHeaders.add("Lease Number");
        leaseHeaders.add("Lease Duration (Months)");
        leaseHeaders.add("Hall ID");
        leaseHeaders.add("Room Number");
        leaseHeaders.add("Student ID");
        String leaseHeaderLine = leaseHeaders.stream().collect(Collectors.joining(","));
        leaseWriter.write(leaseHeaderLine);
        leaseWriter.write(System.getProperty("line.separator"));     

        //Save LEASES data
        for (Lease lease : leaseList) {
            //List of data to be saved
            List<String> leaseData = new ArrayList<>();
            leaseData.add(Integer.toString(lease.getLeaseNumber()));
            leaseData.add(Integer.toString(lease.getLeaseDuration()));
            leaseData.add(Integer.toString(lease.getHallID()));
            leaseData.add(Integer.toString(lease.getRoomNumber()));
            leaseData.add(Integer.toString(lease.getStudentID()));

            //Write to file
            String leaseLine = leaseData.stream().collect(Collectors.joining(","));
            leaseWriter.write(leaseLine);
            leaseWriter.write(System.getProperty("line.separator"));
        }
        leaseWriter.close();
    }

    public void getTableData() {
        //Variables
        String hallName, occupancy, cleanStatus, leaseNumber = "N/A",
                studentName = "N/A", leaseDuration = "N/A";
        int roomNumber;
        
        //Clear table before loading data
        tableList.clear();

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
                        if ((lease.getRoomNumber()
                                == room.getRoomNumber())
                                && (lease.getHallID()
                                == hall.getHallID())) {
                            leaseNumber
                                    = Integer.toString(lease.getLeaseNumber());
                            leaseDuration
                                    = Integer.toString(lease.getLeaseDuration());
                            //Find the student associated with the lease
                            for (Student student : studentList) {
                                if (student.getStudentID()
                                        == lease.getStudentID()) {
                                    studentName = student.getStudentName();
                                    break;
                                }
                            }
                            break;
                        } else {
                            leaseNumber = "N/A";
                            leaseDuration = "N/A";
                            studentName = "N/A";
                        }
                    }
                    tableList.add(new Table(hallName, roomNumber, occupancy,
                            cleanStatus, leaseNumber, leaseDuration,
                            studentName));
                    break;
                }
            }
        }
    }
}
