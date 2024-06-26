package org.example.javafxfinalproject.Bilal;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javaxdevelopers.OOMS.OOM;
import javaxdevelopers.OOMS.Account;

public class DepositMoney extends Application {

    private OOM oom; // Store instance of OOM for accessing account

    @Override
    public void start(Stage primaryStage) {
        oom = new OOM(); // Initialize OOM instance

        // Load background image
        Image image = new Image("file:///JAVAFX FINAL PROJECT/pr.jpeg");
        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );
        Background background = new Background(backgroundImage);

        // Main Layout - BorderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setBackground(background);

        // Center Layout - VBox
        VBox centerBox = new VBox(10);
        centerBox.setAlignment(Pos.CENTER);
        centerBox.setPadding(new Insets(25));

        // Title Label "Deposit Money"
        Label titleLabel = new Label("Deposit Money");
        titleLabel.setStyle("-fx-text-fill: white; -fx-font-size: 24px;");
        centerBox.getChildren().add(titleLabel);

        // Label "Enter Amount to Deposit"
        Label enterAmountLabel = new Label("Enter Amount to Deposit:");
        enterAmountLabel.setStyle("-fx-text-fill: white; -fx-font-size: 18px;");
        centerBox.getChildren().add(enterAmountLabel);

        // TextField for entering amount
        TextField amountTextField = new TextField();
        HBox textFieldBox = new HBox(10);
        textFieldBox.setAlignment(Pos.CENTER);
        textFieldBox.getChildren().addAll(enterAmountLabel, amountTextField);
        centerBox.getChildren().add(textFieldBox);

        // Button "Deposit"
        Button depositButton = new Button("Deposit");
        depositButton.setStyle("-fx-background-color: navy; -fx-text-fill: white; -fx-font-size: 16px;");
        centerBox.getChildren().add(depositButton);
        depositButton.setOnAction(e -> handleDeposit(primaryStage, amountTextField.getText()));

        // Button "Return"
        Button returnButton = new Button("Return");
        returnButton.setOnAction(e -> {
            AccountMenu accountMenu = new AccountMenu();
            accountMenu.start(new Stage());
            primaryStage.close();
        });
        returnButton.setStyle("-fx-background-color: navy; -fx-text-fill: white; -fx-font-size: 16px;");
        centerBox.getChildren().add(returnButton);

        // Add Center Layout to Main BorderPane
        borderPane.setCenter(centerBox);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), borderPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(20);

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(3), borderPane);
        translateTransition.setFromY(-primaryStage.getHeight());
        translateTransition.setToY(0);

        ParallelTransition parallelTransition = new ParallelTransition(fadeTransition, translateTransition);
        parallelTransition.play();

        // Set Up Scene
        Scene scene = new Scene(borderPane);
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Deposit Money");
        primaryStage.show();
    }

    private void handleDeposit(Stage stage, String amountText) {
        try {
            double amount = Double.parseDouble(amountText);
            if (amount <= 0) {
                showAlert(Alert.AlertType.ERROR, "Invalid Amount", "Please enter a positive amount.");
                return;
            }
            Account account = oom.getBankAccount();
            account.depositMoney(amount);
            showAlert(Alert.AlertType.INFORMATION, "Success", "Amount " + amount + " added successfully.");
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter a valid number.");
        }
        //catch (NoNegativeValueException e) {
         //   showAlert(Alert.AlertType.ERROR, "Deposit Failed", e.getMessage());}
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
