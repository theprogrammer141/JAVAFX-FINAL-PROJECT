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
import javaxdevelopers.OOMS.Admin;
import javaxdevelopers.OOMS.OOM;
import org.example.javafxfinalproject.Khizar.MainMenu;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SignUp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("SignUp Form");

        GridPane gridPane = createRegistrationFormPane(primaryStage);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), gridPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(20);

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(5), gridPane);
        translateTransition.setFromY(-primaryStage.getHeight());
        translateTransition.setToY(0);

        ParallelTransition parallelTransition = new ParallelTransition(fadeTransition, translateTransition);
        parallelTransition.play();

        Scene scene = new Scene(gridPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createRegistrationFormPane(Stage primaryStage) {
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


        Label titleLabel = new Label("CREATE ACCOUNT");
        titleLabel.setFont(Font.font("TIMES NEW ROMAN", 40));
        titleLabel.setTextFill(Paint.valueOf("white"));

        Label userNameLabel = new Label("Username:");
        userNameLabel.setFont(Font.font("Impact", 13));
        userNameLabel.setTextFill(Paint.valueOf("white"));

        Label passwordLabel = new Label("Password:");
        passwordLabel.setFont(Font.font("Impact", 13));
        passwordLabel.setTextFill(Paint.valueOf("white"));

        Label confirmPasswordLabel = new Label("Confirm Password:");
        confirmPasswordLabel.setFont(Font.font("Impact", 12));
        confirmPasswordLabel.setTextFill(Paint.valueOf("white"));

        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter Username");
        usernameField.setStyle("-fx-text-fill: white; -fx-background-color: transparent; -fx-background-radius: 30px; -fx-border-color: white; -fx-border-radius: 40px; -fx-prompt-text-fill: white");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter Password");
        passwordField.setStyle("-fx-text-fill: white; -fx-background-color: transparent; -fx-background-radius: 30px; -fx-border-color: white; -fx-border-radius: 40px; -fx-prompt-text-fill: white");

        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Confirm Password");
        confirmPasswordField.setStyle("-fx-text-fill: white; -fx-background-color: transparent; -fx-background-radius: 30px; -fx-border-color: white; -fx-border-radius: 40px; -fx-prompt-text-fill: white");

        Button signupButton = new Button("SignUp");
        signupButton.setStyle(" -fx-text-fill: white;-fx-background-color: purple; -fx-background-radius: 30px; -fx-border-color: black; -fx-border-radius: 10px");
        GridPane.setHalignment(signupButton, HPos.RIGHT);

        Button backButton = new Button("Back");
        backButton.setStyle(" -fx-text-fill: white;-fx-background-color: purple; -fx-background-radius: 30px; -fx-border-color: black; -fx-border-radius: 10px");
        backButton.setAlignment(Pos.BOTTOM_LEFT);

        gridPane.add(titleLabel, 0,0,2,1);
        gridPane.add(userNameLabel, 0, 1);
        gridPane.add(usernameField, 1, 1);
        gridPane.add(passwordLabel, 0, 2);
        gridPane.add(passwordField, 1, 2);
        gridPane.add(confirmPasswordLabel, 0, 3);
        gridPane.add(confirmPasswordField, 1, 3);
        gridPane.add(signupButton, 1, 10);
        gridPane.add(backButton, 0, 10);

        gridPane.getColumnConstraints().add(new ColumnConstraints(100, 100, Double.MAX_VALUE));
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.CENTER);
        gridPane.getColumnConstraints().add(columnOneConstraints);

        signupButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                String confirmPassword = confirmPasswordField.getText();

                if(password.length() > 8)
                {
                   showAlert(Alert.AlertType.ERROR, "Limit Exceeded", "Password must not exceed 8 characters!");
                }
                else if(password.equals(confirmPassword) && !username.isBlank() && !password.isBlank() && !confirmPassword.isBlank())
                {
                    OOM organization = new OOM();
                    ArrayList<Admin> admins = organization.getAdministrators();
                    ArrayList<String> passwords = new ArrayList<>();
                    passwords.add(password);
                    Admin newAdmin = new Admin(username, passwords);
                    admins.add(newAdmin);
                    Admin.writeAdminToFile(admins);
                    showAlert(Alert.AlertType.CONFIRMATION, "Success", "You have been registered!");
                    new MainMenu().start(new Stage());
                    primaryStage.close();
                }
                else if(username.isBlank() && password.isBlank() && confirmPassword.isBlank())
                {
                    showAlert(Alert.AlertType.WARNING, "Empty Credentials", "Please enter required credentials!");
                }
                else if(!password.equals(confirmPassword))
                {
                    showAlert(Alert.AlertType.ERROR, "Error", "Passwords do not match!Please try again!");
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


    private  void saveAdmin(Admin admin)
    {
        try(FileOutputStream fos = new FileOutputStream("adminData.ser", true);
            ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
           oos.writeObject(admin);
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
