package org.example.javafxfinalproject.Khizar;

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

public class ViewOrphan extends Application {
    OOM organization = new OOM();
    ArrayList<Orphan> orphanArrayList = organization.getOrphansList();
    Label name;
    TextField idSearch;
    TextField nameSearch;
    Label age;
    Label gender;
    Label dateOfEnrollment;
    Label degree;
    Label institute;
    Label status;
    Label skillName;
    Label skillDescription;


    @Override
    public void start(Stage primaryStage){
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
        outerLayout.setStyle("-fx-border-width: 5px; -fx-border-color: black;");

        Label titleLabel = new Label("Search an Orphan");
        titleLabel.setStyle("-fx-font-size: 30px; -fx-font-family: Arial");
        outerLayout.setTop(titleLabel);
        outerLayout.setPadding(new Insets(20));
        BorderPane.setAlignment(titleLabel,Pos.CENTER);

        HBox content = new HBox();
        outerLayout.setCenter(content);
        content.setStyle("-fx-padding: 20px;");
        content.setSpacing(20);


        Label searchLabel = new Label("Search Orphan: ");
        searchLabel.setStyle("-fx-font-size: 24;-fx-font-weight: bold");
        Label searchByID = new Label("Search by id: ");
        searchByID.setStyle("-fx-font-size: 18px");
        idSearch = new TextField();
        Label searchByName = new Label("Search By Name: ");
        searchByName.setStyle("-fx-font-size: 18px");
        nameSearch = new TextField();
        Button search = new Button("Search Orphan");
        search.setStyle("-fx-background-radius: 30px;-fx-background-color: #2abd2a;-fx-border-width: 2px;-fx-border-color: black;-fx-border-radius: 40px");
        Button returnButton = new Button("Return");
        returnButton.setStyle("-fx-background-radius: 30px;-fx-background-color: #c04141;-fx-border-width: 2px;-fx-border-color: black;-fx-border-radius: 40px");
        HBox buttonBox = new HBox(search,returnButton);
        buttonBox.setStyle("-fx-font-size: 15px");
        buttonBox.setSpacing(65);

        HBox warningBox = new HBox();
        Label warning = new Label("Cannot find Orphan!");
        warningBox.getChildren().add(warning);
        warning.setStyle("-fx-font-size: 20px;-fx-text-fill: red;-fx-font-weight: bold");
        warningBox.setStyle("visibility: false");

        HBox searchTitle = new HBox(searchLabel);
        HBox idSearchBox = new HBox(searchByID,idSearch);
        idSearchBox.setSpacing(46);
        HBox nameSearchBox = new HBox(searchByName,nameSearch);
        nameSearchBox.setSpacing(12);
        VBox searchBox = new VBox(searchTitle,idSearchBox,nameSearchBox,buttonBox,warningBox);
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
        Label dateOfEnrollmentLabel = new Label("Date Of Enrollment:");
        dateOfEnrollment = new Label();



        HBox personalHeadingBox = new HBox(personalHeading);
        HBox nameBox = new HBox(nameLabel, name);
        HBox genderBox = new HBox(genderLabel,gender);
        HBox ageBox = new HBox(ageLabel,age);
        HBox dateBox = new HBox(dateOfEnrollmentLabel,dateOfEnrollment);

        VBox personalDetails = new VBox(personalHeadingBox,nameBox,genderBox,ageBox,dateBox);
        personalDetails.setSpacing(7);
        nameBox.setSpacing(10);
        ageBox.setSpacing(10);
        genderBox.setSpacing(10);
        dateBox.setSpacing(10);

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
        Label skillHeading = new Label("Skill Details:");
        skillHeading.setStyle("-fx-font-weight: bold;-fx-font-size: 24px");
        Label skillNameLabel = new Label("Skill Name: ");
        skillName = new Label();
        Label skillDescriptionLabel = new Label("Skill Description: ");
        skillDescription = new Label();

        HBox skillHeadingBox = new HBox(skillHeading);
        HBox skillNameBox = new HBox(skillNameLabel, skillName);
        HBox skillDescriptionBox = new HBox(skillDescriptionLabel,skillDescription);
        VBox skillDetails = new VBox(skillHeadingBox,skillNameBox,skillDescriptionBox);
        skillDetails.setSpacing(7);
        skillNameBox.setSpacing(10);
        skillDescriptionBox.setSpacing(10);
        skillDetails.setPadding(new Insets(10,0,10,60));
        skillHeadingBox.setAlignment(Pos.CENTER);
        skillDetails.setMaxHeight(100);
        mainContent.getChildren().add(skillDetails);

        mainContent.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.5));
        mainContent.prefHeightProperty().bind(primaryStage.heightProperty().multiply(0.7));


        search.setOnAction(e -> setValues(warningBox));
        returnButton.setOnAction(e ->
        {
            new OrphanTab().start(new Stage());
            primaryStage.close();
        }
        );

        primaryStage.setMaximized(true);
        Scene scene = new Scene(outerLayout);
        primaryStage.setScene(scene);
        primaryStage.setTitle("View Orphan");

        primaryStage.show();
    }
    public void setValues(HBox warning){
        Orphan orphan = searchOrphan();

        name.setText("");
        age.setText("");
        gender.setText("");
        dateOfEnrollment.setText("");
        status.setText("");
        degree.setText("");
        institute.setText("");
        skillName.setText("");
        skillDescription.setText("");

        if (orphan == null){
            warning.setStyle("visibility: true");
        }else {
            warning.setStyle("visibility: false");
            name.setText(orphan.getName());
            age.setText(Integer.toString(orphan.getAge()));
            dateOfEnrollment.setText(orphan.getEntryDate());
            gender.setText(orphan.getGender());
            if (orphan.getEducation().getEducationLevel() == null) {
                status.setText("Non-educated");
                degree.setText("None");
                institute.setText("None");
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
    }
    public Orphan searchOrphan(){

        if (!idSearch.getText().isEmpty()){
            for (Orphan orphan1: orphanArrayList){
                if (orphan1.getId()==Integer.parseInt(idSearch.getText()))
                    return orphan1;
            }
        } else if (!nameSearch.getText().isEmpty()){
            for (Orphan orphan1: orphanArrayList){
                if (orphan1.getName().equalsIgnoreCase(nameSearch.getText()))
                    return orphan1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        launch(args);
    }
}