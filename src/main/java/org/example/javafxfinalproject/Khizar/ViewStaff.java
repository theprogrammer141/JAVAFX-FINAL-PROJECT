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
import javaxdevelopers.OOMS.Orphan;
import javaxdevelopers.OOMS.Staff;

import java.util.ArrayList;

public class ViewStaff extends Application {
    OOM organization = new OOM();
    ArrayList<Staff> staffArrayList = organization.getStaffList();
    Label name;
    TextField idSearch;
    TextField nameSearch;
    Label age;
    Label gender;
    Label degree;
    Label institute;
    Label status;
    Label role;
    Label pay;
    Label contact;


    @Override
    public void start(Stage primaryStage){

        BorderPane outerLayout = new BorderPane();
        outerLayout.setStyle("-fx-border-width: 5px; -fx-border-color: black;-fx-background-color: #7CB9E8");

        Label titleLabel = new Label("Search a Staff");
        titleLabel.setStyle("-fx-font-size: 30px; -fx-font-family: Arial");
        outerLayout.setTop(titleLabel);
        outerLayout.setPadding(new Insets(20));
        BorderPane.setAlignment(titleLabel,Pos.CENTER);

        HBox content = new HBox();
        outerLayout.setCenter(content);
        content.setStyle("-fx-padding: 20px;");
        content.setSpacing(20);


        Label searchLabel = new Label("Search Staff: ");
        searchLabel.setStyle("-fx-font-size: 24;-fx-font-weight: bold");
        Label searchByID = new Label("Search by id: ");
        searchByID.setStyle("-fx-font-size: 18px");
        idSearch = new TextField();
        Label searchByName = new Label("Search By Name: ");
        searchByName.setStyle("-fx-font-size: 18px");
        nameSearch = new TextField();
        Button search = new Button("Search Staff");
        search.setStyle("-fx-background-radius: 30px;-fx-background-color: #2abd2a;-fx-border-width: 2px;-fx-border-color: black;-fx-border-radius: 40px");
        Button returnButton = new Button("Return");
        returnButton.setStyle("-fx-background-radius: 30px;-fx-background-color: #c04141;-fx-border-width: 2px;-fx-border-color: black;-fx-border-radius: 40px");
        HBox buttonBox = new HBox(search,returnButton);
        buttonBox.setStyle("-fx-font-size: 15px");
        buttonBox.setSpacing(65);

        HBox searchTitle = new HBox(searchLabel);
        HBox idSearchBox = new HBox(searchByID,idSearch);
        idSearchBox.setSpacing(46);
        HBox nameSearchBox = new HBox(searchByName,nameSearch);
        nameSearchBox.setSpacing(12);
        VBox searchBox = new VBox(searchTitle,idSearchBox,nameSearchBox,buttonBox);
        content.getChildren().add(searchBox);
        searchBox.setSpacing(13);
        searchBox.setStyle("-fx-border-color: black; -fx-border-width: 2px;-fx-border-radius: 12%;-fx-padding: 20px;");
        searchBox.setMaxHeight(210);
        searchBox.setMinWidth(300);

        VBox mainContent = new VBox();
        mainContent.setStyle("-fx-border-color: black;-fx-background-radius: 15%; -fx-border-width: 2px;-fx-border-radius: 15%;-fx-padding: 10px;-fx-font-size: 22px");
        BorderPane.setAlignment(mainContent,Pos.CENTER);
        mainContent.setSpacing(20);
        content.getChildren().add(mainContent);


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
        HBox genderBox = new HBox(genderLabel,gender);
        HBox ageBox = new HBox(ageLabel,age);

        VBox personalDetails = new VBox(personalHeadingBox,nameBox,genderBox,ageBox);
        personalDetails.setSpacing(7);
        nameBox.setSpacing(10);
        ageBox.setSpacing(10);
        genderBox.setSpacing(10);

        personalDetails.setPadding(new Insets(10,0,10,60));
        personalHeadingBox.setAlignment(Pos.CENTER);
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
        HBox degreeBox = new HBox(degreeLabel,degree);
        HBox instituteBox = new HBox(instituteLabel,institute);
        VBox educationDetails = new VBox(educationHeadingBox,statusBox,degreeBox,instituteBox);
        educationDetails.setSpacing(7);
        statusBox.setSpacing(10);
        degreeBox.setSpacing(10);
        instituteBox.setSpacing(10);
        educationDetails.setPadding(new Insets(10,0,10,60));
        educationHeadingBox.setAlignment(Pos.CENTER);
        mainContent.getChildren().add(educationDetails);

        //skill details
        Label officeHeading = new Label("Office Details:");
        officeHeading.setStyle("-fx-font-weight: bold;-fx-font-size: 24px");
        Label roleLabel = new Label("Role: ");
        role = new Label();
        Label payLabel = new Label("Pay: ");
        pay = new Label();
        Label contactLabel = new Label("Contact");
        contact = new Label();

        HBox officeHeadingBox = new HBox(officeHeading);
        HBox roleBox = new HBox(roleLabel, role);
        HBox payBox = new HBox(payLabel,pay);
        HBox contactBox = new HBox(contactLabel,contact);
        VBox officeDetails = new VBox(officeHeadingBox,roleBox,payBox,contactBox);
        officeDetails.setSpacing(7);
        roleBox.setSpacing(10);
        payBox.setSpacing(10);
        contactBox.setSpacing(10);
        officeDetails.setPadding(new Insets(10,0,10,60));
        officeHeadingBox.setAlignment(Pos.CENTER);
        officeDetails.setMaxHeight(100);
        mainContent.getChildren().add(officeDetails);

        mainContent.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.5));
        mainContent.prefHeightProperty().bind(primaryStage.heightProperty().multiply(0.7));


        search.setOnAction(e -> setValues());
        returnButton.setOnAction(e ->
                {
                    new StaffTab().start(new Stage());
                    primaryStage.close();
                }
        );

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

        // Scene and Stage setup
        Scene scene = new Scene(scrollable);
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.setTitle("View Staff");

        primaryStage.show();
    }
    public void setValues(){
        Staff staff = searchStaff();

        name.setText("");
        age.setText("");
        gender.setText("");
        status.setText("");
        degree.setText("");
        institute.setText("");
        role.setText("");
        pay.setText("");
        contact.setText("");

        if (staff == null){
            showAlert(Alert.AlertType.WARNING, "Staff not found", "Please enter a valid name or ID ");
        }else {
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
            role.setText(staff.getRole());
            pay.setText(Double.toString(staff.getPay()));
            contact.setText(staff.getContact());
        }
    }
    public Staff searchStaff(){

        if (!idSearch.getText().isEmpty()){
            for (Staff staff: staffArrayList){
                if (staff.getId()==Integer.parseInt(idSearch.getText()))
                    return staff;
            }
        } else if (!nameSearch.getText().isEmpty()){
            for (Staff staff: staffArrayList){
                if (staff.getName().equalsIgnoreCase(nameSearch.getText()))
                    return staff;
            }
        }else
            showAlert(Alert.AlertType.WARNING, "Empty search", "Please enter a name or ID ");

        return null;
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