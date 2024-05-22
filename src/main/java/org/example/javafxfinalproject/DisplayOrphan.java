package org.example.javafxfinalproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javaxdevelopers.OOMS.OOM;
import javaxdevelopers.OOMS.Orphan;

import java.util.ArrayList;

public class DisplayOrphan extends Application {
    OOM organization = new OOM();
    static  int id=0;
    ArrayList<Orphan> orphansList= organization.getOrphansList();
    Label name;
    Label age;
    Label gender;
    Label dateOfEnrollment;
    Label status;
    Label degree;
    Label institute;
    Label skillName;
    Label skillDescription;



    @Override
    public void start(Stage primaryStage) {
        Image image = new Image("file:///D:\\2nd sem\\OOPs\\JAVAFX-FINAL-PROJECT-FX\\createaccount.png");
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
        outerLayout.setStyle("-fx-border-width: 3px; -fx-border-color: black;");
        outerLayout.setPadding(new Insets(10,60,30,60));

        Label titleLabel = new Label("Display Orphan");
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
        Label dateOfEnrollmentLabel = new Label("Date Of Enrollment:");
        dateOfEnrollment = new Label();


        HBox personalHeadingBox = new HBox(personalHeading);
        HBox nameBox = new HBox(nameLabel, name);
        HBox genderBox = new HBox(genderLabel, gender);
        HBox ageBox = new HBox(ageLabel, age);
        HBox dateBox = new HBox(dateOfEnrollmentLabel, dateOfEnrollment);

        VBox personalDetails = new VBox(personalHeadingBox, nameBox, genderBox, ageBox, dateBox);
        personalDetails.setSpacing(7);
        nameBox.setSpacing(10);
        ageBox.setSpacing(10);
        genderBox.setSpacing(10);
        dateBox.setSpacing(10);
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

        //skill details
        Label skillHeading = new Label("Skill Details:");
        skillHeading.setStyle("-fx-font-weight: bold;-fx-font-size: 24px");
        Label skillNameLabel = new Label("Skill Name: ");
        skillName = new Label();
        Label skillDescriptionLabel = new Label("Skill Description: ");
        skillDescription = new Label();

        HBox skillHeadingBox = new HBox(skillHeading);
        HBox skillNameBox = new HBox(skillNameLabel, skillName);
        HBox skillDescriptionBox = new HBox(skillDescriptionLabel, skillDescription);
        VBox skillDetails = new VBox(skillHeadingBox, skillNameBox, skillDescriptionBox);
        skillDetails.setSpacing(7);
        skillNameBox.setSpacing(10);
        skillDescriptionBox.setSpacing(10);
        skillDetails.setPadding(new Insets(10,0,10,80));
        skillHeadingBox.setAlignment(Pos.CENTER);
        skillDetails.setMaxHeight(100);
        //skillDetails.setStyle("-fx-border-color: black;-fx-border-width: 1px;-fx-border-radius: 10%;");
        mainContent.getChildren().add(skillDetails);

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


        display();
        nextButton.setOnAction(e ->{
            if (id<orphansList.size()-1 && id >=0) {
                id++;
                display();
            }
        });
        previousButton.setOnAction(e ->{
            if (id<orphansList.size() && id >0) {
                id--;
                display();
            }
        });
        returnButton.setOnAction(e -> {
            new OrphanTab().start(new Stage());
            primaryStage.close();
        });

        Scene scene = new Scene(outerLayout);
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Display Orphan");
        primaryStage.show();
    }
    public void display() {
        name.setText("");
        age.setText("");
        gender.setText("");
        dateOfEnrollment.setText("");
        status.setText("");
        degree.setText("");
        institute.setText("");
        skillName.setText("");
        skillDescription.setText("");

            Orphan orphan = orphansList.get(id);

            name.setText(orphan.getName());
            age.setText(Integer.toString(orphan.getAge()));
            dateOfEnrollment.setText(orphan.getEntryDate());
            gender.setText(orphan.getGender());
            if (orphan.getEducation().getEducationLevel() == null) {
                status.setText("Non-educated");
            } else {
                status.setText("Educated");
                degree.setText(orphan.getEducation().getEducationLevel());
                institute.setText(orphan.getEducation().getInstitute());
            }
            if (!orphan.getSkillSet().isEmpty()) {
                skillName.setText(orphan.getSkillSet().getFirst().getSkillName());
                skillDescription.setText(orphan.getSkillSet().getFirst().getSkillDescription());
            }
    }



    public static void main(String[] args) {
        launch(args);
    }
}