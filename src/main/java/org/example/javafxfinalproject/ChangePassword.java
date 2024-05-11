package org.example.javafxfinalproject;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ChangePassword extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Change Password");

        // Create the registration form layout pane
        GridPane gridPane = createRegistrationFormPane();

        Scene scene = new Scene(gridPane, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createRegistrationFormPane() {
        Image backgroundImage = new Image("file:///JAVAFX FINAL PROJECT/createaccount.png");

        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );

        Background backgroundWithImage = new Background(background);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(50, 50, 50, 50));
        gridPane.setHgap(20);
        gridPane.setVgap(10);
        gridPane.setBackground(backgroundWithImage);

        // Add UI controls
        Label titleLabel = new Label("CREATE NEW PASSWORD");
        titleLabel.setFont(Font.font("TIMES NEW ROMAN", 40));

        Label oldPasswordLabel = new Label("Old Password:");
        oldPasswordLabel.setFont(Font.font("Impact", 15));

        Label passwordLabel = new Label("New Password:");
        passwordLabel.setFont(Font.font("Impact", 15));

        Label confirmPasswordLabel = new Label("Confirm Password:");
        confirmPasswordLabel.setFont(Font.font("Impact", 15));

        TextField oldPasswordField = new TextField();
        oldPasswordField.setPromptText("Enter Old Password");
        oldPasswordField.setStyle("-fx-text-fill: white; -fx-background-color: transparent; -fx-background-radius: 30px; -fx-border-color: black; -fx-border-radius: 40px; -fx-prompt-text-fill: black");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter New Password");
        passwordField.setStyle("-fx-text-fill: white; -fx-background-color: transparent; -fx-background-radius: 30px; -fx-border-color: black; -fx-border-radius: 40px; -fx-prompt-text-fill: black");

        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Confirm Password");
        confirmPasswordField.setStyle("-fx-text-fill: white; -fx-background-color: transparent; -fx-background-radius: 30px; -fx-border-color: black; -fx-border-radius: 40px; -fx-prompt-text-fill: black");

        Button changePasswordbutton = new Button("Change Password");
        changePasswordbutton.setStyle(" -fx-text-fill: white;-fx-background-color: blue; -fx-background-radius: 30px; -fx-border-color: black; -fx-border-radius: 40px");

        // Add controls to the grid
        gridPane.add(titleLabel, 0,0,2,1);
        gridPane.add(oldPasswordLabel, 0, 1);
        gridPane.add(oldPasswordField, 1, 1);
        gridPane.add(passwordLabel, 0, 2);
        gridPane.add(passwordField, 1, 2);
        gridPane.add(confirmPasswordLabel, 0, 3);
        gridPane.add(confirmPasswordField, 1, 3);
        gridPane.add(changePasswordbutton, 1, 4);

        // Set column constraints
        gridPane.getColumnConstraints().add(new ColumnConstraints(100, 100, Double.MAX_VALUE));
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.CENTER);
        gridPane.getColumnConstraints().add(columnOneConstraints);

        // Set row constraints (if needed)

        return gridPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
