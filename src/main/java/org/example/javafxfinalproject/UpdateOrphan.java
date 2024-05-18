package org.example.javafxfinalproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class UpdateOrphan extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Outermost layout with dark green background and black border
        BorderPane outerLayout = new BorderPane();
        outerLayout.setStyle("-fx-background-color: #47a690; -fx-border-color: black; -fx-border-width: 1;");

        // Title
        Label titleLabel = new Label("Update Orphan");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: white; -fx-alignment: center;");
        titleLabel.setMaxWidth(Double.MAX_VALUE);
        titleLabel.setAlignment(Pos.CENTER);
        outerLayout.setTop(titleLabel);
        BorderPane.setAlignment(titleLabel, Pos.CENTER);
        BorderPane.setMargin(titleLabel, new Insets(12, 0, 12, 0));

        Label update = new Label("Make Desired Changes!");
        update.setStyle("-fx-font-size: 24px; -fx-text-fill: yellow;");
        update.setAlignment(Pos.CENTER);
        update.setMaxWidth(Double.MAX_VALUE);

        // Main content VBox
        VBox mainContent = new VBox(2);
        mainContent.getChildren().add(update);
        mainContent.setAlignment(Pos.TOP_CENTER);
        mainContent.setPadding(new Insets(0, 50, 10, 0));

        VBox searchSection = new VBox(2);
        searchSection.setStyle("-fx-background-color: lightblue; -fx-border-color: black; -fx-border-width: 1;");
        searchSection.setAlignment(Pos.TOP_CENTER);
        searchSection.setPadding(new Insets(5));

        Label searchLabel = new Label("To Update an Orphan");
        searchLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: black;");
        searchLabel.setAlignment(Pos.CENTER);

        HBox idBox = new HBox(5);
        Label idLabel = new Label("Search Orphan by ID:");
        TextField idField = new TextField();
        idBox.getChildren().addAll(idLabel, idField);
        idBox.setAlignment(Pos.CENTER);
        idBox.setSpacing(12);
        searchSection.getChildren().add(idBox);

        HBox nameBox = new HBox(5);
        Label nameLabel = new Label("Search Orphan by Name:");
        TextField searchNameField = new TextField();
        nameBox.getChildren().addAll(nameLabel,searchNameField);
        nameBox.setAlignment(Pos.CENTER);
        searchSection.getChildren().add(nameBox);

        Button confirmButton = new Button("Search");
        confirmButton.setAlignment(Pos.BASELINE_RIGHT);
        searchSection.getChildren().add(confirmButton);
        searchSection.setMaxHeight(180);
        searchSection.setMaxWidth(500);
        searchSection.setSpacing(10);
        searchSection.setAlignment(Pos.CENTER);

        searchSection.setPadding(new Insets(0,50,10,0));
        searchSection.setMinHeight(180);

        HBox contentBox = new HBox();
        contentBox.getChildren().addAll(searchSection,mainContent);
        contentBox.setSpacing(20);
        contentBox.setPadding(new Insets(35,0,0,60));
        outerLayout.setCenter(contentBox);

        mainContent.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.6));
        mainContent.prefHeightProperty().bind(primaryStage.heightProperty().multiply(0.7));
        searchSection.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.5));
        searchSection.prefHeightProperty().bind(primaryStage.heightProperty().multiply(0.7));
        contentBox.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.6));
        contentBox.prefHeightProperty().bind(primaryStage.heightProperty().multiply(0.7));



        // Personal Details Section
        VBox personalDetailsSection = new VBox(5);
        personalDetailsSection.setStyle("-fx-background-color: lightblue; -fx-border-color: black; -fx-border-width: 1;");
        personalDetailsSection.setAlignment(Pos.TOP_CENTER);
        personalDetailsSection.setPadding(new Insets(15));

        Label title = new Label("Personal Details");
        title.setStyle("-fx-font-size: 18px; -fx-text-fill: black;");
        personalDetailsSection.getChildren().add(title);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        TextField nameField = new TextField();
        TextField ageField = new TextField();
        DatePicker date = new DatePicker();
        addFormField(gridPane, "Orphan Name:", nameField, 0);
        gridPane.add(new Label("Gender:"),0,1);
        gridPane.add(createGenderRadioButtons(), 1, 1);
        addFormField(gridPane, "Orphan Age:", ageField, 2);
        addFormField(gridPane, "Date of Enrollment:", date, 3);
        personalDetailsSection.getChildren().add(gridPane);
        mainContent.getChildren().add(personalDetailsSection);

        // Education Details Section
        VBox educationDetailsSection = new VBox(5);
        educationDetailsSection.setStyle("-fx-background-color: lightblue; -fx-border-color: black; -fx-border-width: 1;");
        educationDetailsSection.setAlignment(Pos.TOP_CENTER);
        educationDetailsSection.setPadding(new Insets(15));


        Label educationTitle = new Label("Education Details");
        educationTitle.setStyle("-fx-font-size: 18px; -fx-text-fill: black;");
        educationDetailsSection.getChildren().add(educationTitle);

        GridPane educationGridPane = new GridPane();
        educationGridPane.setAlignment(Pos.CENTER);
        educationGridPane.setHgap(10);
        educationGridPane.setVgap(10);

        TextField degreeName = new TextField();
        TextField instituteName = new TextField();

        educationGridPane.add(new Label("Education status:"),0,0);
        educationGridPane.add(createEducationStatusRadioButtons(),1,0);
        addFormField(educationGridPane, "Degree name: ",degreeName,1);
        addFormField(educationGridPane,"Institute Name: ", instituteName,2);
        educationDetailsSection.getChildren().add(educationGridPane);
        mainContent.getChildren().add(educationDetailsSection);

        // Skill Details Section
        VBox skillDetailsSection = new VBox(5);
        skillDetailsSection.setStyle("-fx-background-color: lightblue; -fx-border-color: black; -fx-border-width: 1;");
        skillDetailsSection.setAlignment(Pos.TOP_CENTER);
        skillDetailsSection.setPadding(new Insets(15));

        Label skillTitle = new Label("Skill Details: ");
        skillTitle.setStyle("-fx-font-size: 18px; -fx-text-fill: black;");
        skillDetailsSection.getChildren().add(skillTitle);

        GridPane skillGridPane = new GridPane();
        skillGridPane.setAlignment(Pos.CENTER);
        skillGridPane.setHgap(10);
        skillGridPane.setVgap(10);

        TextField skillName = new TextField();
        TextArea skillDescription = new TextArea();

        addFormField(skillGridPane, "Skill Name:", skillName, 0);
        addFormField(skillGridPane, "Skill Description:", skillDescription, 1);
        skillDetailsSection.getChildren().add(skillGridPane);
        mainContent.getChildren().add(skillDetailsSection);

        // Buttons
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);

        Button closeButton = new Button("Close");
        buttonBox.getChildren().addAll(closeButton);
        mainContent.getChildren().add(buttonBox);


        // Scene and Stage setup
        Scene scene = new Scene(outerLayout, 870, 700);
        primaryStage.setTitle("Orphan Registration System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addFormField(GridPane gridPane, String labelText, Control inputControl, int rowIndex) {
        Label label = new Label(labelText);
        if (inputControl instanceof TextArea){
            inputControl.setMaxWidth(250);
            inputControl.setMaxHeight(300);
        }
        gridPane.add(label, 0, rowIndex);
        gridPane.add(inputControl, 1, rowIndex);
    }

    private HBox createGenderRadioButtons() {
        ToggleGroup group = new ToggleGroup();
        RadioButton male = new RadioButton("Male");
        male.setToggleGroup(group);
        RadioButton female = new RadioButton("Female");
        female.setToggleGroup(group);
        RadioButton other = new RadioButton("Other");
        other.setToggleGroup(group);
        HBox hbox = new HBox(10, male, female, other);
        hbox.setAlignment(Pos.CENTER_LEFT);
        return hbox;
    }

    private HBox createEducationStatusRadioButtons() {
        ToggleGroup group = new ToggleGroup();
        RadioButton educated = new RadioButton("Educated");
        educated.setToggleGroup(group);
        RadioButton notEducated = new RadioButton("Not Educated");
        notEducated.setToggleGroup(group);
        HBox hbox = new HBox(10, educated, notEducated);
        hbox.setAlignment(Pos.CENTER_LEFT);
        return hbox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}