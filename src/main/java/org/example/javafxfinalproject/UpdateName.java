package org.example.javafxfinalproject;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class UpdateName extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        // Load Background Image
        Image image = new Image("file:///D:/JAVA/JAVAFX-FINAL-PROJECT/src/rec.jpeg");

        // Background Image Settings
        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );

        // Create Background with Image
        Background background = new Background(backgroundImage);

        // Main Layout - BorderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setBackground(background);

        // Center Layout - GridPane
        GridPane centerGrid = new GridPane();
        centerGrid.setAlignment(Pos.CENTER);
        centerGrid.setPadding(new Insets(25));
        centerGrid.setVgap(10); // Vertical gap between rows
        centerGrid.setHgap(10); // Horizontal gap between columns

        // Title Label "Update Item"
        Label titleLabel = new Label("--Update Name--");
        titleLabel.setStyle("-fx-text-fill: white; -fx-font-size: 24px;");
        centerGrid.add(titleLabel, 0, 0, 2, 1); // ColumnSpan: 2, RowSpan: 1

        // Label "Enter ID to Update Item:"
        Label enterIdLabel = new Label("Previous Name:");
        enterIdLabel.setStyle("-fx-text-fill: white; -fx-font-size: 18px;");
        centerGrid.add(enterIdLabel, 0, 1);

        // Text Field for Entering ID
        TextField idTextField = new TextField();
        centerGrid.add(idTextField, 1, 1);

        // Label "Choose attribute to update:"
        Label chooseAttributeLabel = new Label("New Name");
        chooseAttributeLabel.setStyle("-fx-text-fill: white; -fx-font-size: 18px;");
        centerGrid.add(chooseAttributeLabel, 0, 2);

        // Combo Box for Attribute Selection
        TextField idTextField2 = new TextField();
        centerGrid.add(idTextField2, 1, 2);


        // Button "Update"
        Button updateButton = new Button("Update");
        updateButton.setStyle("-fx-background-color: #FF6347; -fx-text-fill: white; -fx-font-size: 16px;");
        centerGrid.add(updateButton, 0, 3, 2, 1); // ColumnSpan: 2, RowSpan: 1

        // Button "Return"
        Button returnButton = new Button("Return");
        returnButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        centerGrid.add(returnButton, 0, 4, 2, 1); // ColumnSpan: 2, RowSpan: 1

        // Add Center Layout to Main BorderPane
        borderPane.setCenter(centerGrid);

        // Set Up Scene
        Scene scene = new Scene(borderPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Update Name");
        primaryStage.show();
    }
}
