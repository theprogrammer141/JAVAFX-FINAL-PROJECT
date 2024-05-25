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
import javaxdevelopers.OOMS.Account;
import javaxdevelopers.OOMS.OOM;

public class WithdrawMoney extends Application {

    @Override
    public void start(Stage primaryStage) {
        Image image = new Image("file:///JAVAFX FINAL PROJECT/pr.jpeg");
        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );
        Background background = new Background(backgroundImage);

        BorderPane borderPane = new BorderPane();
        borderPane.setBackground(background);

        VBox centerBox = new VBox(10);
        centerBox.setAlignment(Pos.CENTER);
        centerBox.setPadding(new Insets(25));

        Label titleLabel = new Label("Withdraw Money");
        titleLabel.setStyle("-fx-text-fill: white; -fx-font-size: 24px;");
        centerBox.getChildren().add(titleLabel);

        Label enterAmountLabel = new Label("Enter Amount to Withdraw:");
        enterAmountLabel.setStyle("-fx-text-fill: white; -fx-font-size: 18px;");
        centerBox.getChildren().add(enterAmountLabel);

        HBox textFieldBox = new HBox(10);
        textFieldBox.setAlignment(Pos.CENTER);

        TextField amountTextField = new TextField();
        textFieldBox.getChildren().addAll(enterAmountLabel, amountTextField);
        centerBox.getChildren().add(textFieldBox);

        Button withdrawButton = new Button("Withdraw");
        withdrawButton.setStyle("-fx-background-color: darkblue; -fx-text-fill: white; -fx-font-size: 16px;");
        withdrawButton.setOnAction(e -> handleWithdraw(primaryStage, amountTextField.getText()));
        centerBox.getChildren().add(withdrawButton);

        Button returnButton = new Button("Return");
        returnButton.setOnAction(e -> {
            AccountMenu accountMenu = new AccountMenu();
            accountMenu.start(new Stage());
            primaryStage.close();
        });
        returnButton.setStyle("-fx-background-color: darkblue; -fx-text-fill: white; -fx-font-size: 16px;");
        centerBox.getChildren().add(returnButton);

        borderPane.setCenter(centerBox);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), borderPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(20);

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(3), borderPane);
        translateTransition.setFromY(-primaryStage.getHeight());
        translateTransition.setToY(0);

        ParallelTransition parallelTransition = new ParallelTransition(fadeTransition, translateTransition);
        parallelTransition.play();

        Scene scene = new Scene(borderPane);
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Withdraw Money");
        primaryStage.show();
    }

    private void handleWithdraw(Stage stage, String amountText) {
        try {
            double amount = Double.parseDouble(amountText);
            if (amount <= 0) {
                showAlert(Alert.AlertType.ERROR, "Invalid Amount", "Please enter a positive amount.");
                return;
            }
            OOM oom = new OOM();
            Account account = oom.getBankAccount();
            account.withdrawMoney(amount);
            showAlert(Alert.AlertType.INFORMATION, "Success", "Amount " + amount + " withdrawn successfully.");
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter a valid number.");
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Withdrawal Failed", e.getMessage());
        }
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
