package org.example.javafxfinalproject.Khizar;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import javaxdevelopers.OOMS.OOM;
import javaxdevelopers.OOMS.Staff;

import java.util.ArrayList;

public class DisplayStaff extends Application {
    OOM organization = new OOM();
    static  int id=0;
    ArrayList<Staff> staffList = organization.getStaffList();
    Label name;
    Label age;
    Label gender;
    Label status;
    Label degree;
    Label institute;
    Label pay;
    Label role;
    Label contact;



    @Override
    public void start(Stage primaryStage) {

        BorderPane outerLayout = new BorderPane();
        outerLayout.setStyle("-fx-border-width: 3px; -fx-border-color: black;-fx-background-color: #7CB9E8");
        outerLayout.setPadding(new Insets(10,60,30,60));

        Label titleLabel = new Label("Display Staff");
        titleLabel.setStyle("-fx-font-size: 30px; -fx-font-family: Arial");
        outerLayout.setTop(titleLabel);
        BorderPane.setAlignment(titleLabel, Pos.CENTER);

        VBox mainContent = new VBox();
        mainContent.setStyle("-fx-border-color: black; -fx-border-width: 2px;-fx-border-radius: 15%;-fx-padding: 10px;-fx-font-size: 22px");
        outerLayout.setCenter(mainContent);
        BorderPane.setAlignment(mainContent, Pos.CENTER);
        BorderPane.setMargin(mainContent, new Insets(20, 150, 20, 150));
        mainContent.setSpacing(20);


        Label personalHeading = new Label("Personal Details:");
        personalHeading.setStyle("-fx-font-weight: bold;-fx-font-size: 24px");
        Label nameLabel = new Label("Name: ");
        name = new Label();
        Label genderLabel = new Label("Gender: ");
        gender = new Label();
        Label ageLabel = new Label("Age:");
        age = new Label();



        HBox personalHeadingBox = new HBox(personalHeading);
        HBox nameBox = new HBox(nameLabel, name);
        HBox genderBox = new HBox(genderLabel, gender);
        HBox ageBox = new HBox(ageLabel, age);

        VBox personalDetails = new VBox(personalHeadingBox, nameBox, genderBox, ageBox);
        personalDetails.setSpacing(7);
        nameBox.setSpacing(10);
        ageBox.setSpacing(10);
        genderBox.setSpacing(10);
        personalDetails.setPadding(new Insets(10,0,10,80));
        personalHeadingBox.setAlignment(Pos.CENTER);
        //personalDetails.setStyle("-fx-border-color: black;-fx-border-width: 1px;-fx-border-radius: 15%;-fx-min-height: 200px");
        mainContent.getChildren().add(personalDetails);

        //Education details

        Label educationHeading = new Label("Education Details:");
        educationHeading.setStyle("-fx-font-weight: bold;-fx-font-size: 24px");
        Label statusLabel = new Label("Education Status: ");
        status = new Label();
        Label degreeLabel = new Label("Highest Degree: ");
        degree = new Label();
        Label instituteLabel = new Label("Institute name:");
        institute = new Label();

        HBox educationHeadingBox = new HBox(educationHeading);
        HBox statusBox = new HBox(statusLabel, status);
        HBox degreeBox = new HBox(degreeLabel, degree);
        HBox instituteBox = new HBox(instituteLabel, institute);
        VBox educationDetails = new VBox(educationHeadingBox, statusBox, degreeBox, instituteBox);
        educationDetails.setSpacing(7);
        statusBox.setSpacing(10);
        degreeBox.setSpacing(10);
        instituteBox.setSpacing(10);
        educationDetails.setPadding(new Insets(10,0,10,80));
        educationHeadingBox.setAlignment(Pos.CENTER);
        // educationDetails.setStyle("-fx-border-color: black;-fx-border-width: 1px;-fx-border-radius: 15%;-fx-min-height: 200px");
        mainContent.getChildren().add(educationDetails);

        //Office details
        Label officeHeading = new Label("Office Details:");
        officeHeading.setStyle("-fx-font-weight: bold;-fx-font-size: 24px");
        Label payLabel = new Label("Pay: ");
        pay = new Label();
        Label roleLabel = new Label("Role: ");
        role = new Label();
        Label contactLabel = new Label("Contact: ");
        contact = new Label();


        HBox officeHeadingBox = new HBox(officeHeading);
        HBox roleBox = new HBox(roleLabel, role);
        HBox payBox = new HBox(payLabel, pay);
        HBox contactBox = new HBox(contactLabel,contact);
        VBox officeDetails = new VBox(officeHeadingBox, roleBox, payBox,contactBox);
        officeDetails.setSpacing(7);
        roleBox.setSpacing(10);
        payBox.setSpacing(10);
        contactBox.setSpacing(10);
        officeDetails.setPadding(new Insets(10,0,10,80));
        officeHeadingBox.setAlignment(Pos.CENTER);
        //skillDetails.setMaxHeight(100);
        //skillDetails.setStyle("-fx-border-color: black;-fx-border-width: 1px;-fx-border-radius: 10%;");
        mainContent.getChildren().add(officeDetails);

        // Button
        Button previousButton = new Button("Previous Record");
        Button returnButton = new Button("Return");
        Button nextButton = new Button("Next Record");

        previousButton.setStyle("-fx-background-radius: 30px;-fx-border-color: black;-fx-border-width: 1px;-fx-border-radius: 40px;-fx-background-color: #47d247");
        returnButton.setStyle("-fx-background-radius: 30px;-fx-border-color: black;-fx-border-width: 1px;-fx-border-radius: 40px;-fx-background-color: #da4444");
        nextButton.setStyle("-fx-background-radius: 30px;-fx-border-color: black;-fx-border-width: 1px;-fx-border-radius: 40px;-fx-background-color: #47d247");

        HBox buttonBox = new HBox(previousButton, returnButton, nextButton);
        buttonBox.setSpacing(50);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setStyle("-fx-font-size: 15");
        outerLayout.setBottom(buttonBox);

        mainContent.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.5));
        mainContent.prefHeightProperty().bind(primaryStage.heightProperty().multiply(0.7));


        display(0);
        nextButton.setOnAction(e ->{
            id++;
            if (id<staffList.size() && id >=0) {

                display(id);
            }else{
                resetData();
                showAlert(Alert.AlertType.WARNING, "Staff not found", "No more Staff Record available");
            }
        });
        previousButton.setOnAction(e ->{
            id--;
            if (id<staffList.size() && id >=0) {
                display(id);
            }else {
                resetData();
                showAlert(Alert.AlertType.WARNING, "Staff not found", "No more Staff Record available");
            }
        });
        returnButton.setOnAction(e -> {
            new StaffTab().start(new Stage());
            primaryStage.close();
        });

        ScrollPane scrollable = new ScrollPane(outerLayout);
        scrollable.setFitToHeight(true);
        scrollable.setFitToWidth(true);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), scrollable);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(20);

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(3), scrollable);
        translateTransition.setFromY(-primaryStage.getHeight());
        translateTransition.setToY(0);

        ParallelTransition parallelTransition = new ParallelTransition(fadeTransition, translateTransition);
        parallelTransition.play();

        Scene scene = new Scene(scrollable);
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Display Orphan");
        primaryStage.show();
    }
    public void resetData(){
        name.setText("");
        age.setText("");
        gender.setText("");
        pay.setText("");
        status.setText("");
        degree.setText("");
        institute.setText("");
        role.setText("");
        contact.setText("");
    }
    public void display(int value) {
       //resetData();
        name.setText("");
        age.setText("");
        gender.setText("");
        pay.setText("");
        status.setText("");
        degree.setText("");
        institute.setText("");
        role.setText("");
        contact.setText("");

        Staff staff = staffList.get(value);

        name.setText(staff.getName());
        age.setText(Integer.toString(staff.getAge()));
        gender.setText(staff.getGender());
        if (staff.getEducation().getEducationLevel() == null) {
            status.setText("Non-educated");
            degree.setText("None");
            institute.setText("None");
        } else {
            status.setText("Educated");
            degree.setText(staff.getEducation().getEducationLevel());
            institute.setText(staff.getEducation().getInstitute());
        }
        pay.setText(Double.toString(staff.getPay()));
        role.setText(staff.getRole());
        contact.setText(staff.getContact());

    }
    public static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }



    public static void main(String[] args) {
        launch(args);
    }
}