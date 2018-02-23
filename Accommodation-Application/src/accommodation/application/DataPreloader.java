/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accommodation.application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javafx.application.Preloader;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author Michael McCormick (15012271)
 */
public class DataPreloader extends Preloader {

    ProgressBar bar;
    Stage stage;

    private Scene createPreloaderScene() {
        bar = new ProgressBar();
        BorderPane p = new BorderPane();
        p.setCenter(bar);
        return new Scene(p, 300, 150);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setScene(createPreloaderScene());
        stage.show();
        
        //Get data from csv files and load into objects
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
                Halls hall = new Halls(data[0], hallID, data[2], data[3]);
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
                Room room = new Room(roomNumber, monthlyRent, hallID, data[3]);
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
                Student student = new Student(data[0], studentID);
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
                Lease lease = new Lease(leaseNumber, leaseDuration, hallID,
                    roomNumber, studentID);
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR -- File containing Leases data missing");
            System.exit(1);
        }

    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification scn) {
        if (scn.getType() == StateChangeNotification.Type.BEFORE_START) {
            stage.hide();
        }
    }

    @Override
    public void handleProgressNotification(ProgressNotification pn) {
        bar.setProgress(pn.getProgress());
    }

}
