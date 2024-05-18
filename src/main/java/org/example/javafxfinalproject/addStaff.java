package org.example.javafxfinalproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javaxdevelopers.OOMS.OOM;
import javaxdevelopers.OOMS.Staff;

import java.util.ArrayList;

public class addStaff extends Application {

    @Override
    public void start(Stage primaryStage){
        Image image = new Image("file:///D:\\2nd sem\\OOPs\\JAVAFX-FINAL-PROJECT-FX\\staffBackground.jpg");
        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );
        Background background = new Background(backgroundImage);
        BorderPane outerLayout = new BorderPane();
        outerLayout.setBackground(background);

        //title label
        Label titleLabel = new Label("Staff Registration");
        titleLabel.setStyle("-fx-font-size: 26;-fx-font-weight: bold;");
        outerLayout.setTop(titleLabel);
        BorderPane.setAlignment(titleLabel,Pos.CENTER);
        BorderPane.setMargin(titleLabel,new Insets(10,0,30,0));

        VBox mainContent = new VBox();
        outerLayout.setCenter(mainContent);
        mainContent.setAlignment(Pos.TOP_CENTER);
        mainContent.setStyle("-fx-font-size: 16px;");
        mainContent.setMaxWidth(700);
        mainContent.setSpacing(10);



        // name input
        Label nameLabel = new Label("Staff Name");
        TextField nameField = new TextField();
        nameField.setStyle("-fx-background-radius: 20px;-fx-border-radius: 20px;-fx-border-color: black;-fx-border-width: 1px");
        HBox nameBox = new HBox(nameLabel,nameField);
        nameBox.setSpacing(80);

        //gender input
        RadioButton male = new RadioButton("Male");
        RadioButton feMale = new RadioButton("Female");
        RadioButton other = new RadioButton("Other");
        ToggleGroup genderGroup = new ToggleGroup();
        male.setToggleGroup(genderGroup);
        feMale.setToggleGroup(genderGroup);
        other.setToggleGroup(genderGroup);
        Label genderLabel = new Label("Gender");
        HBox genders = new HBox(male,feMale,other);
        genders.setSpacing(15);
        HBox genderBox = new HBox(genderLabel,genders);
        genderBox.setSpacing(110);

        //Age input
        Label ageLabel = new Label("Age");
        TextField ageField = new TextField();
        ageField.setStyle("-fx-background-radius: 20px;-fx-border-radius: 20px;-fx-border-color: black;-fx-border-width: 1px");
        HBox ageBox = new HBox(ageLabel,ageField);
        ageBox.setSpacing(125);

        //personal Details title
        Label personalTitle = new Label("Personal Details");
        personalTitle.setStyle("-fx-font-size: 22px;-fx-font-family: 'Arial Black'");
        HBox personalHeadingBox = new HBox(personalTitle);
        personalHeadingBox.setAlignment(Pos.TOP_CENTER);

        //personal details
        VBox personalDetails = new VBox(personalHeadingBox,nameBox,genderBox,ageBox);
        personalDetails.setStyle("-fx-border-width: 2px;-fx-border-color: black;-fx-border-radius: 40px;-fx-background-radius: 40px;-fx-background-color: #21bbc0");
        personalDetails.setSpacing(10);
        personalDetails.setPadding(new Insets(10,10,10,30));
        mainContent.getChildren().add(personalDetails);

        //input education status
        Label educationHeading = new Label("Education Details:");
        educationHeading.setStyle("-fx-font-size: 22px;-fx-font-family: 'Arial Black'");

        Label statusLabel = new Label("Education Status: ");
        RadioButton educated = new RadioButton("Educated");
        RadioButton nonEducated = new RadioButton("Non-Educated");
        ToggleGroup education = new ToggleGroup();
        educated.setToggleGroup(education);
        nonEducated.setToggleGroup(education);
        HBox educationStatus = new HBox(educated,nonEducated);
        educationStatus.setSpacing(20);

        Label degreeLabel = new Label("Highest Degree: ");
        TextField degree = new TextField();
        degree.setStyle("-fx-background-radius: 20px;-fx-border-radius: 20px;-fx-border-color: black;-fx-border-width: 1px");

        Label instituteLabel = new Label("Institute name:");
        TextField institute = new TextField();
        institute.setStyle("-fx-background-radius: 20px;-fx-border-radius: 20px;-fx-border-color: black;-fx-border-width: 1px");


        HBox educationHeadingBox = new HBox(educationHeading);
        educationHeadingBox.setAlignment(Pos.TOP_CENTER);
        HBox statusBox = new HBox(statusLabel, educationStatus);
        HBox degreeBox = new HBox(degreeLabel, degree);
        HBox instituteBox = new HBox(instituteLabel, institute);
        VBox educationDetails = new VBox(educationHeadingBox, statusBox, degreeBox, instituteBox);
        educationDetails.setSpacing(10);
        statusBox.setSpacing(26);
        degreeBox.setSpacing(33);
        instituteBox.setSpacing(45);
        educationDetails.setPadding(new Insets(10,10,10,30));
        educationDetails.setStyle("-fx-border-width: 2px;-fx-border-color: black;-fx-border-radius: 40px;-fx-background-radius: 40px;-fx-background-color: #21bbc0");
        mainContent.getChildren().add(educationDetails);

        //Office details
        Label officeHeading = new Label("Office Details:");
        officeHeading.setStyle("-fx-font-weight: bold;-fx-font-size: 24px");

        Label payLabel = new Label("Pay: ");
        TextField pay = new TextField();
        pay.setStyle("-fx-background-radius: 20px;-fx-border-radius: 20px;-fx-border-color: black;-fx-border-width: 1px");

        Label roleLabel = new Label("Role: ");
        TextField role = new TextField();
        role.setStyle("-fx-background-radius: 20px;-fx-border-radius: 20px;-fx-border-color: black;-fx-border-width: 1px");

        Label contactLabel = new Label("Contact: ");
        TextField contact = new TextField();
        contact.setStyle("-fx-background-radius: 20px;-fx-border-radius: 20px;-fx-border-color: black;-fx-border-width: 1px");

        HBox officeHeadingBox = new HBox(officeHeading);
        officeHeadingBox.setAlignment(Pos.TOP_CENTER);
        HBox roleBox = new HBox(roleLabel, role);
        HBox payBox = new HBox(payLabel, pay);
        HBox contactBox = new HBox(contactLabel,contact);

        VBox officeDetails = new VBox(officeHeadingBox, roleBox, payBox,contactBox);
        officeDetails.setSpacing(10);
        roleBox.setSpacing(107);
        payBox.setSpacing(111);
        contactBox.setSpacing(85);
        officeDetails.setPadding(new Insets(10,10,10,30));
        officeDetails.setStyle("-fx-border-width: 2px;-fx-border-color: black;-fx-border-radius: 40px;-fx-background-radius: 40px;-fx-background-color: #21bbc0");
        mainContent.getChildren().add(officeDetails);

        //Buttons
        HBox buttonBox = new HBox(70);
        buttonBox.setAlignment(Pos.CENTER);
        Button addButton = new Button("Add Staff");
        addButton.setStyle("-fx-background-radius: 30px;-fx-border-width: 1px;-fx-border-color: black;-fx-border-radius: 30px");

        Button resetButton = new Button("Reset Data");
        resetButton.setStyle("-fx-background-radius: 30px;-fx-border-width: 1px;-fx-border-color: black;-fx-border-radius: 30px");

        Button closeButton = new Button("Close Tab");
        closeButton.setStyle("-fx-background-radius: 30px;-fx-border-width: 1px;-fx-border-color: black;-fx-border-radius: 30px");

        buttonBox.getChildren().addAll(addButton, resetButton, closeButton);
        mainContent.getChildren().add(buttonBox);

        primaryStage.setTitle("Add Staff");
        Scene scene = new Scene(outerLayout);
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);

        addButton.setOnAction(new InputData(nameField,ageField,genderGroup,education,degree,institute,pay,role,contact));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
class InputData implements EventHandler<ActionEvent>{
    TextField nameField;
    TextField age;
    ToggleGroup gender;
    ToggleGroup educationStatus;
    TextField degree;
    TextField institute;
    TextField pay;
    TextField role;
    TextField contact;


    public InputData(TextField nameField, TextField age, ToggleGroup gender, ToggleGroup educationStatus, TextField degree, TextField institute, TextField pay, TextField role, TextField contact) {
        this.nameField = nameField;
        this.age = age;
        this.gender = gender;
        this.educationStatus = educationStatus;
        this.degree = degree;
        this.institute = institute;
        this.pay = pay;
        this.role = role;
        this.contact = contact;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        OOM organization = new OOM();
        ArrayList<Staff> staffList = organization.getStaffList();
        Staff staff = new Staff();
        staff.setId(staffList.size()+1);
        if(!nameField.getText().isEmpty())
            staff.setName(nameField.getText());

    }
}