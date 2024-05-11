package org.example.javafxfinalproject;

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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Login extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Orphanage Organization Management System");

        Image backgroundImage = new Image("file:///JAVAFX FINAL PROJECT/background.jpeg");

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
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setBackground(backgroundWithImage);

        Text scenetitle = new Text("WELCOME TO ORPHANAGE ORGANIZATION MANAGEMENT SYSTEM");
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("Username:");
        userName.setFont(Font.font("Tahoma", 15));
        userName.setStyle("-fx-text-fill: black");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        userTextField.setPromptText("Enter Username");
        userTextField.setStyle("-fx-background-color: transparent;-fx-border-radius: 20px; -fx-border-color: black; -fx-text-fill: white; -fx-prompt-text-fill: black");
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        pw.setFont(Font.font("Tahoma", 15));
        pw.setStyle("-fx-text-fill: black");
        grid.add(pw, 0, 2);

        PasswordField passwordBox = new PasswordField();
        passwordBox.setPromptText("Enter Password");
        passwordBox.setStyle("-fx-background-color: transparent; -fx-border-radius: 20px; -fx-border-color: black; -fx-text-fill: white; -fx-prompt-text-fill: black");
        grid.add(passwordBox, 1, 2);

        Button forgotPassword = new Button("Forgot Password?");
        forgotPassword.setStyle("-fx-border-color: black; -fx-border-radius: 40px; -fx-background-color: green; -fx-text-fill: white; -fx-background-radius: 30px");

        HBox fpbtn = new HBox(10);
        fpbtn.setAlignment(Pos.BOTTOM_LEFT);
        fpbtn.getChildren().add(forgotPassword);
        grid.add(fpbtn, 1, 4);

        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-border-radius: 40px; -fx-border-color: black; -fx-background-color: green; -fx-text-fill: white; -fx-background-radius: 30px");

        HBox lgBtn = new HBox(10);
        lgBtn.setAlignment(Pos.BOTTOM_RIGHT);
        lgBtn.getChildren().add(loginButton);
        grid.add(lgBtn, 1, 4);

        Button signupButton = new Button("Sign Up");
        signupButton.setStyle("-fx-text-fill: white; -fx-background-color: green;");

        Label signUplabel = new Label("Don't have an account?");
        signUplabel.setAlignment(Pos.BOTTOM_RIGHT);
        signUplabel.setFont(Font.font("Tahoma", 15));
        signUplabel.setStyle("-fx-text-fill: black; -fx-background-radius: 30px; -fx-background-color: transparent;");

        HBox signupBtn = new HBox(10);
        signupBtn.setAlignment(Pos.BOTTOM_RIGHT);
        signupBtn.getChildren().addAll(signUplabel, signupButton);
        grid.add(signUplabel, 1, 20);
        grid.add(signupBtn, 1, 20);


//        final Text actionTarget = new Text();
//        grid.add(actionTarget, 1, 6);


//        loginButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent e) {
//                String enteredUsername = userTextField.getText();
//                String enteredPassword = passwordBox.getText();
//
//                if (enteredUsername.equals(username) && enteredPassword.equals(password)) {
//                    actionTarget.setFill(Color.GREEN);
//                    actionTarget.setText("Login Successful");
//                } else {
//                    actionTarget.setFill(Color.RED);
//                    actionTarget.setText("Invalid username or password");
//                }
//
//                userTextField.clear();
//                passwordBox.clear();
//            }
//        });

        Scene scene = new Scene(grid, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
