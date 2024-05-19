package org.example.javafxfinalproject.Abdullah;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;

public class ChangePassword extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Change Password");

        GridPane gridPane = changePasswordPane(primaryStage);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), gridPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(20);

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(5), gridPane);
        translateTransition.setFromY(-primaryStage.getHeight());
        translateTransition.setToY(0);

        ParallelTransition parallelTransition = new ParallelTransition(fadeTransition, translateTransition);
        parallelTransition.play();

        Scene scene = new Scene(gridPane, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane changePasswordPane(Stage primaryStage) {
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

        changePasswordbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String oldPassword = oldPasswordField.getText();
                String newPassword = newPasswordField.getText();
                String confirmPassword = confirmPasswordField.getText();

                if(verifyOldPassword(oldPassword))
                {
                    if(newPassword.equals(confirmPassword))
                    {
                        writeToFile(newPassword);
                        showAlert(Alert.AlertType.CONFIRMATION, "Success", "Password Changed Successfully!");
                        new Login().start(new Stage());
                        primaryStage.close();
                    }
                }
                else if(oldPassword.isBlank() || newPassword.isBlank() || confirmPassword.isBlank()) {
                    showAlert(Alert.AlertType.WARNING, "Empty Credentials", "Please enter required credentials!");
                }
                else
                {
                    writeToFile(oldPassword);
                    showAlert(Alert.AlertType.ERROR, "Invalid Old Password", "Old Password Does Not Match!");
                }
            }
        });

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                new Login().start(new Stage());
                primaryStage.close();
            }
        });


        return gridPane;
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private boolean verifyOldPassword(String oldPassword)
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("adminData.ser"));
            String storedPassword = br.readLine();
            br.close();
            return oldPassword.equals(storedPassword);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    private void writeToFile(String newPassword)
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter("adminData.ser"));
            bw.write(newPassword);
            bw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
