package org.example.javafxfinalproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class DisplayStaff extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Outermost layout with dark green background and black border
        BorderPane outerLayout = new BorderPane();
        outerLayout.setStyle("-fx-background-color: #47a690; -fx-border-color: black; -fx-border-width: 1;");

        // Title
        Label titleLabel = new Label("Display Staff");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: white; -fx-alignment: center;");
        titleLabel.setMaxWidth(Double.MAX_VALUE);
        titleLabel.setAlignment(Pos.CENTER);
        outerLayout.setTop(titleLabel);
        BorderPane.setAlignment(titleLabel, Pos.CENTER);
        BorderPane.setMargin(titleLabel, new Insets(12, 0, 12, 0));

        // Main content VBox
        VBox mainContent = new VBox(2);
        mainContent.setAlignment(Pos.TOP_CENTER);
        mainContent.setPadding(new Insets(10, 150, 10, 150));
        mainContent.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.5));
        mainContent.prefHeightProperty().bind(primaryStage.heightProperty().multiply(0.7));
        outerLayout.setCenter(mainContent);

        // Personal Details Section
        VBox personalDetailsSection = createSection("Personal Details", "lightblue");
        mainContent.getChildren().add(personalDetailsSection);

        // Education Details Section
        VBox educationDetailsSection = createSection("Education Details", "lightblue");
        mainContent.getChildren().add(educationDetailsSection);

        // Skill Details Section
        VBox skillDetailsSection = createSection("Office Details", "lightblue");
        mainContent.getChildren().add(skillDetailsSection);

        // Buttons
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        Button addButton = new Button("Previous");
        Button resetButton = new Button("Return");
        Button closeButton = new Button("Next");
        buttonBox.getChildren().addAll(addButton, resetButton, closeButton);
        buttonBox.setSpacing(60);
        mainContent.getChildren().add(buttonBox);

        mainContent.setMaxWidth(1000);

        // Scene and Stage setup
        Scene scene = new Scene(outerLayout, 800, 600);
        primaryStage.setTitle("Staff Registration System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createSection(String titleText, String color) {
        VBox section = new VBox(5);
        section.setStyle("-fx-background-color: " + color + "; -fx-border-color: black; -fx-border-width: 1;");
        section.setAlignment(Pos.TOP_CENTER);
        section.setPadding(new Insets(15));

        Label title = new Label(titleText);
        title.setStyle("-fx-font-size: 18px; -fx-text-fill: black;");
        section.getChildren().add(title);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        if ("Personal Details".equals(titleText)) {
            addFormField(gridPane, "Staff Name:", new TextField(), 0);
            gridPane.add(new Label("Gender:"),0,1);
            gridPane.add(createGenderRadioButtons(), 1, 1);
            addFormField(gridPane, "Staff Age:", new TextField(), 2);
            addFormField(gridPane, "Date of Joining:", new DatePicker(), 3);
        } else if ("Education Details".equals(titleText)) {
            gridPane.add(new Label("Education status:"),0,0);
            gridPane.add(createEducationStatusRadioButtons(),1,0);
            addFormField(gridPane, "Degree name: ",new TextField(),1);
            addFormField(gridPane,"Institute Name: ", new TextField(),2);
        } else if ("Office Details".equals(titleText)) {
            addFormField(gridPane, "Role:", new TextField(), 0);
            addFormField(gridPane, "Pay:", new TextField(), 1);
            addFormField(gridPane, "Contact:", new TextField(), 2);
        }

        section.getChildren().add(gridPane);
        return section;
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