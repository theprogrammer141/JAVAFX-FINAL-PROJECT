package org.example.javafxfinalproject.Abdullah;

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
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ChangePassword extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Change Password");

        GridPane gridPane = changePasswordPane();

        Scene scene = new Scene(gridPane, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane changePasswordPane() {
        Image backgroundImage = new Image("file:///JAVAFX FINAL PROJECT/background2.jpg");

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


        Label titleLabel = new Label("CREATE NEW PASSWORD");
        titleLabel.setFont(Font.font("TIMES NEW ROMAN", 40));
        titleLabel.setTextFill(Paint.valueOf("white"));

        Label oldPasswordLabel = new Label("Old Password:");
        oldPasswordLabel.setFont(Font.font("Impact", 15));
        oldPasswordLabel.setTextFill(Paint.valueOf("white"));


        Label passwordLabel = new Label("New Password:");
        passwordLabel.setFont(Font.font("Impact", 15));
        passwordLabel.setTextFill(Paint.valueOf("white"));

        Label confirmPasswordLabel = new Label("Confirm Password:");
        confirmPasswordLabel.setFont(Font.font("IMPACT", 12));
        confirmPasswordLabel.setTextFill(Paint.valueOf("white"));

        TextField oldPasswordField = new TextField();
        oldPasswordField.setPromptText("Enter Old Password");
        oldPasswordField.setStyle("-fx-text-fill: white; -fx-background-color: transparent; -fx-background-radius: 30px; -fx-border-color: white; -fx-border-radius: 40px; -fx-prompt-text-fill: white");
        oldPasswordField.setMaxWidth(200);

        PasswordField newPasswordField = new PasswordField();
        newPasswordField.setPromptText("Enter New Password");
        newPasswordField.setStyle("-fx-text-fill: white; -fx-background-color: transparent; -fx-background-radius: 30px; -fx-border-color: white; -fx-border-radius: 40px; -fx-prompt-text-fill: white");
        newPasswordField.setMaxWidth(200);

        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Confirm Password");
        confirmPasswordField.setStyle("-fx-text-fill: white; -fx-background-color: transparent; -fx-background-radius: 30px; -fx-border-color: white; -fx-border-radius: 40px; -fx-prompt-text-fill: white");
        confirmPasswordField.setMaxWidth(200);

        Button changePasswordbutton = new Button("Change Password");
        changePasswordbutton.setStyle(" -fx-text-fill: white;-fx-background-color: purple; -fx-background-radius: 30px; -fx-border-color: black; -fx-border-radius: 10px");

        Button backButton = new Button("Back");
        backButton.setStyle(" -fx-text-fill: white;-fx-background-color: purple; -fx-background-radius: 30px; -fx-border-color: black; -fx-border-radius: 10px");
        backButton.setAlignment(Pos.BOTTOM_LEFT);


        gridPane.add(titleLabel, 0,0,2,1);
        gridPane.add(oldPasswordLabel, 0, 1);
        gridPane.add(oldPasswordField, 1, 1);
        gridPane.add(passwordLabel, 0, 2);
        gridPane.add(newPasswordField, 1, 2);
        gridPane.add(confirmPasswordLabel, 0, 3);
        gridPane.add(confirmPasswordField, 1, 3);
        gridPane.add(changePasswordbutton, 1, 10);
        gridPane.add(backButton, 0, 10);


        gridPane.getColumnConstraints().add(new ColumnConstraints(100, 100, Double.MAX_VALUE));
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.CENTER);
        gridPane.getColumnConstraints().add(columnOneConstraints);


        return gridPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
