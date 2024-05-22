package org.example.javafxfinalproject.Abdullah;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class Login extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Orphanage Organization Management System");

        Image backgroundImage = new Image("file:///JAVAFX FINAL PROJECT/background2.jpg");

        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );

        Background backgroundWithImage = new Background(background);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setBackground(backgroundWithImage);

        Rectangle overlay = new Rectangle();
        overlay.setWidth(600);
        overlay.setHeight(500);
        overlay.setFill(Color.rgb(255,255,255,0.25));

        Text welcomeText = new Text("WELCOME TO OOMS");
        welcomeText.setFont(Font.font("TIMES NEW ROMAN", 30));
        welcomeText.setTextAlignment(TextAlignment.JUSTIFY);

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setPadding(new Insets(20, 0, 0, 0));
        vbox.getChildren().add(welcomeText);

        HBox usernameBox = new HBox(10);
        usernameBox.setAlignment(Pos.CENTER);
        Label usernameLabel = new Label("Username:");
        usernameLabel.setStyle("-fx-font: Verdana; -fx-font-size: 15; -fx-text-fill: white");
        TextField usernameField = new TextField();
        usernameField.setStyle("-fx-background-color: transparent; -fx-background-radius: 30px; -fx-border-color: black; -fx-border-radius: 40px; -fx-text-fill: white");
        usernameBox.getChildren().addAll(usernameLabel, usernameField);

        HBox passwordBox = new HBox(10);
        passwordBox.setAlignment(Pos.CENTER);
        Label passwordLabel = new Label("Password:");
        passwordLabel.setStyle("-fx-font: Verdana; -fx-font-size: 15; -fx-text-fill: white");
        PasswordField passwordField = new PasswordField();
        passwordField.setStyle("-fx-background-color: transparent; -fx-background-radius: 30px; -fx-border-color: black; -fx-border-radius: 40px; -fx-text-fill: white");
        passwordBox.getChildren().addAll(passwordLabel, passwordField);

        vbox.getChildren().addAll(usernameBox, passwordBox);

        HBox buttonBox = new HBox(80);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(20, 0, 0, 0));
        Button forgotPasswordButton = new Button("Forgot Password?");
        forgotPasswordButton.setStyle("-fx-background-color: purple; -fx-background-radius: 50px; -fx-border-color: black; -fx-border-radius: 10px; -fx-text-fill: white");
        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-background-color: purple; -fx-background-radius: 50px; -fx-border-color: black; -fx-border-radius: 10px; -fx-text-fill: white");
        buttonBox.getChildren().addAll(forgotPasswordButton, loginButton);

        vbox.getChildren().add(buttonBox);

        HBox signUpBox = new HBox(10);
        signUpBox.setAlignment(Pos.BOTTOM_RIGHT);
        signUpBox.setPadding(new Insets(20));
        Text signUpText = new Text("Don't have an account?");
        signUpText.setStyle("-fx-font-size: 15; -fx-font: Verdana;");
        signUpText.setFill(Paint.valueOf("white"));
        Button signUpButton = new Button("Sign Up");
        signUpButton.setStyle("-fx-background-color: purple; -fx-background-radius: 50px; -fx-border-color: black; -fx-border-radius: 10px; -fx-text-fill: white");
        signUpBox.getChildren().addAll(signUpText, signUpButton);

        StackPane overlayPane = new StackPane();
        overlayPane.setMaxWidth(600);
        overlayPane.setMaxHeight(500);
        overlayPane.getChildren().addAll(overlay, vbox);

        StackPane bottomRightPane = new StackPane();
        bottomRightPane.getChildren().add(signUpBox);
        StackPane.setAlignment(signUpBox, Pos.BOTTOM_RIGHT);

        StackPane mainPane = new StackPane();
        mainPane.getChildren().addAll(overlayPane, bottomRightPane);

        grid.add(mainPane, 0, 0);

        Scene scene = new Scene(grid, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
