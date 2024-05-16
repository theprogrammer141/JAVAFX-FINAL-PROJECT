package org.example.javafxfinalproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class RemoveItems extends Application {

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

    // Center Layout - VBox
    VBox centerBox = new VBox(10); // Spacing between components
        centerBox.setAlignment(Pos.CENTER);
        centerBox.setPadding(new Insets(25));

    // Title Label "Withdraw Money"
    Label titleLabel = new Label("--Remove Item--");
        titleLabel.setStyle("-fx-text-fill: white; -fx-font-size: 24px;");
        centerBox.getChildren().add(titleLabel);

    // Label "Enter Amount to Withdraw"
    Label enterAmountLabel = new Label("Enter ID to remove Item:");
        enterAmountLabel.setStyle("-fx-text-fill: white; -fx-font-size: 18px;");
        centerBox.getChildren().add(enterAmountLabel);

    // HBox for Text Field and Label
    HBox textFieldBox = new HBox(10); // Spacing between components
        textFieldBox.setAlignment(Pos.CENTER);

    // Text Field for Entering Amount to Withdraw
    TextField amountTextField = new TextField();
        textFieldBox.getChildren().addAll( enterAmountLabel,amountTextField);
        centerBox.getChildren().add(textFieldBox);

    // Button "Withdraw"
    Button withdrawButton = new Button("Remove");
        withdrawButton.setStyle("-fx-background-color: #FF6347; -fx-text-fill: white; -fx-font-size: 16px;");
        centerBox.getChildren().add(withdrawButton);

    // Button "Return"
    Button returnButton = new Button("Return");
        returnButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        centerBox.getChildren().add(returnButton);

    // Add Center Layout to Main BorderPane
        borderPane.setCenter(centerBox);

    // Set Up Scene
    Scene scene = new Scene(borderPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Remove Item");
        primaryStage.show();
}


}
