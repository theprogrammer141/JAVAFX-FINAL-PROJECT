package org.example.javafxfinalproject.Abdullah;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import javaxdevelopers.OOMS.Admin;
import org.example.javafxfinalproject.Khizar.MainMenu;

import java.util.ArrayList;
import java.util.List;


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
        overlay.setFill(Color.rgb(255, 255, 255, 0.25));
        overlay.setMouseTransparent(true); // Allow mouse events to pass through the overlay

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
        usernameLabel.setStyle("-fx-font-size: 15; -fx-text-fill: white");
        TextField usernameField = new TextField();
        usernameField.setStyle("-fx-background-color: rgb(255,255,255,0.25); -fx-background-radius: 30px; -fx-border-color: white; -fx-border-radius: 10px; -fx-text-fill: white; -fx-prompt-text-fill: white");
        usernameField.setPromptText("Enter Username");
        usernameField.requestFocus();
        usernameBox.getChildren().addAll(usernameLabel, usernameField);

        HBox passwordBox = new HBox(10);
        passwordBox.setAlignment(Pos.CENTER);
        Label passwordLabel = new Label("Password:");
        passwordLabel.setStyle("-fx-font-size: 15; -fx-text-fill: white");
        PasswordField passwordField = new PasswordField();
        passwordField.setStyle("-fx-background-color: rgb(255,255,255,0.25); -fx-background-radius: 30px; -fx-border-color: white; -fx-border-radius: 10px; -fx-text-fill: white; -fx-prompt-text-fill: white");
        passwordField.requestFocus();
        passwordField.setPromptText("Enter Password");
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
        signUpText.setStyle("-fx-font-size: 15;");
        signUpText.setFill(Paint.valueOf("white"));
        Button signUpButton = new Button("Sign Up");
        signUpButton.setStyle("-fx-background-color: purple; -fx-background-radius: 50px; -fx-border-color: black; -fx-border-radius: 10px; -fx-text-fill: white");
        signUpBox.getChildren().addAll(signUpText, signUpButton);

        StackPane overlayPane = new StackPane();
        overlayPane.setMaxWidth(600);
        overlayPane.setMaxHeight(500);
        overlayPane.getChildren().addAll(overlay, vbox);

        grid.add(overlayPane, 0, 0);
        grid.add(signUpBox, 0, 1);

        // Create fade and translate transitions for the login screen
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), overlayPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), overlayPane);
        translateTransition.setFromY(-primaryStage.getHeight());
        translateTransition.setToY(0);

        ParallelTransition parallelTransition = new ParallelTransition(fadeTransition, translateTransition);
        parallelTransition.play();

        forgotPasswordButton.setOnAction(handler ->
        {
            try {
                new ChangePassword().start(new Stage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            primaryStage.close();
        });


        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String username = usernameField.getText();
                String password = passwordField.getText();

                ArrayList<Admin> admins = (ArrayList<Admin>) Admin.readAdminsFromFile();

                boolean loggedIn = logIn(admins, username, password);

                if(username.isEmpty() || password.isEmpty()) {
                    showAlert(Alert.AlertType.WARNING, "Empty Credentials", "Please enter required credentials!");
                }
                else if(loggedIn)
                {
                    showAlert(Alert.AlertType.CONFIRMATION, "Logged in", "Welcome " + username);
                    new MainMenu().start(new Stage());
                    primaryStage.close();
                }
                else
                {
                    showAlert(Alert.AlertType.ERROR, "Error", "Invalid username or password!");
                }
            }
        });

        signUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    new SignUp().start(new Stage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                primaryStage.close();
            }
        });

        Scene scene = new Scene(grid, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static boolean logIn(List<Admin> administrators, String username, String password) {
        for (Admin administrator : administrators) {
            if (username.equalsIgnoreCase(administrator.getAdminName())) {
                for (String storedPassword : administrator.getPasswords()) {
                    if (password.equals(storedPassword)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
