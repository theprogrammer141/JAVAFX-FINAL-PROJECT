package org.example.javafxfinalproject.Abdullah;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javaxdevelopers.OOMS.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class StaffReport extends Application {
    OOM organization = new OOM();
    ArrayList<Staff> staff = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        loadStaffData();

        Image backgroundImage = new Image("file:///JAVAFX FINAL PROJECT/background2.jpg");

        BackgroundImage image = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setBackground(new Background(image));

        VBox root = new VBox(10);

        Label title = new Label("STAFF REPORT");
        title.setFont(Font.font("Impact", 40));
        title.setTextFill(Paint.valueOf("white"));
        root.getChildren().add(title);

        Label totalStaffLabel = new Label("Total Staff: " + organization.getStaffList().size());
        totalStaffLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        totalStaffLabel.setFont(Font.font(20));
        root.getChildren().add(totalStaffLabel);

        if(staff != null)
        {
            for(Staff staff1 : staff) {
                Label staffIdLabel = new Label("Staff ID: " + staff1.getId());
                staffIdLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
                root.getChildren().add(staffIdLabel);

                Label staffNameLabel = new Label("Name: " + staff1.getName());
                staffNameLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
                root.getChildren().add(staffNameLabel);

                Label staffAgeLabel = new Label("Age: " + staff1.getAge());
                staffAgeLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
                root.getChildren().add(staffAgeLabel);

                Label staffGenderLabel = new Label("Gender: " + staff1.getGender());
                staffGenderLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
                root.getChildren().add(staffGenderLabel);

                Label staffEducationLevelLabel = new Label("Education Level: " + staff1.getEducation().getEducationLevel());
                staffEducationLevelLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
                root.getChildren().add(staffEducationLevelLabel);

                Label staffEducationInstituteLabel = new Label("Education Institute: " + staff1.getEducation().getInstitute());
                staffEducationInstituteLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
                root.getChildren().add(staffEducationInstituteLabel);

                Label staffContactLabel = new Label("Contact: " + staff1.getContact());
                staffContactLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
                root.getChildren().add(staffContactLabel);

                Label staffRoleLabel = new Label("Role: " + staff1.getRole());
                staffRoleLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
                root.getChildren().add(staffRoleLabel);

                Label staffPayLabel = new Label("Pay: " + staff1.getPay());
                staffPayLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
                root.getChildren().add(staffPayLabel);

                Label line = new Label("----------------------");
                line.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-text-fill: white");
                root.getChildren().add(line);
            }
        }

        Button backButton = new Button("Back");
        backButton.setStyle(" -fx-text-fill: white;-fx-background-color: purple; -fx-background-radius: 30px; -fx-border-color: white; -fx-border-radius: 40px");

        backButton.setOnAction(handler ->
        {
            new GenerateReports().start(new Stage());
            primaryStage.close();
        });

        grid.add(root, 0, 0);
        grid.add(backButton, 0, 20);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(grid);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        Scene scene = new Scene(scrollPane, 800, 600);
        primaryStage.setTitle("Staff Report");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadStaffData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("staffData.ser"))) {
            staff = (ArrayList<Staff>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
