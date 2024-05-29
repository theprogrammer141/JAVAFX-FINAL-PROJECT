package org.example.javafxfinalproject.Bilal;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.javafxfinalproject.Khizar.MainMenu;

public class AccountMenu extends Application {

    public void start(Stage primaryStage) {
        // Background Image
        Image backgroundImage = new Image("file:///JAVAFX FINAL PROJECT/pr.jpeg");
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );
        Background backgroundWithImage = new Background(background);

        // Main Grid Setup
        GridPane mainGrid = new GridPane();
        mainGrid.setAlignment(Pos.CENTER);
        mainGrid.setHgap(10);
        mainGrid.setVgap(10);
        mainGrid.setPadding(new Insets(25, 25, 25, 25));
        mainGrid.setBackground(backgroundWithImage);

        // Title
        Text scenetitle = new Text("------Bank Account-------");
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
        scenetitle.setFill(Color.WHITE);
        mainGrid.add(scenetitle, 0, 0, 2, 1);
        GridPane.setMargin(scenetitle, new Insets(0, 0, 20, 0));

        // Bank Name Label and ComboBox
        Label bankNameLabel = new Label("Bank Name:");
        bankNameLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        bankNameLabel.setTextFill(Color.WHITE);
        mainGrid.add(bankNameLabel, 0, 1);

        Label comboBox = new Label("HBL");
        comboBox.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-padding: 5;");
        comboBox.setMaxSize(150,20);
        comboBox.setStyle("-fx-background-color: white; -fx-border-radius: 5px; -fx-border-color: gray;");
        mainGrid.add(comboBox, 1, 1);

        // Account ID Label and ComboBox
        Label accountIdLabel = new Label("Account ID:");
        accountIdLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        accountIdLabel.setTextFill(Color.WHITE);
        mainGrid.add(accountIdLabel, 0, 2);

        Label comboBox2 = new Label("abl2234q44344");
        comboBox2.setStyle("-fx-border-color: black; -fx-border-width: 10; -fx-padding: 10;");
        comboBox2.setMaxSize(150,20);
        comboBox2.setStyle("-fx-background-color: white; -fx-border-radius: 5px; -fx-border-color: gray;");
        mainGrid.add(comboBox2, 1, 2);

        // BorderPane for Buttons
        BorderPane borderPane = new BorderPane();
        mainGrid.add(borderPane, 0, 3, 2, 1);

        // Buttons
        Button depositMoney = new Button("Deposit Money");
        depositMoney.setOnAction(e->{
            DepositMoney depositMoney1 = new DepositMoney();
            depositMoney1.start(new Stage());
            primaryStage.close();
        });
        Button withdrawMoney = new Button("Withdraw Money");
        withdrawMoney.setOnAction(e->{
            WithdrawMoney withdraw = new WithdrawMoney();
            withdraw.start(new Stage());
            primaryStage.close();
        });
        Button checkMoney = new Button("Check Balance");
        checkMoney.setOnAction(e->{
            CheckBalance checkBalance = new CheckBalance();
            checkBalance.start(new Stage());
            primaryStage.close();
        });
        Button displayAccount = new Button("Display Account");
        displayAccount.setOnAction(e->{
            DisplayAccountDetails displayAccountDetails = new DisplayAccountDetails();
            displayAccountDetails.start(new Stage());
            primaryStage.close();
        });

        // Button Styles
        String buttonStyle = "-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-size: 15px; -fx-background-radius: 5px; -fx-padding: 10px 20px;";
        depositMoney.setStyle(buttonStyle);
        withdrawMoney.setStyle(buttonStyle);
        checkMoney.setStyle(buttonStyle);
        displayAccount.setStyle(buttonStyle);

        // Top Button
        HBox topBox = new HBox(withdrawMoney);
        topBox.setAlignment(Pos.CENTER);
        borderPane.setTop(topBox);
        BorderPane.setMargin(topBox, new Insets(10, 0, 10, 0));

        // Left Button
        VBox leftBox = new VBox(displayAccount);
        leftBox.setAlignment(Pos.CENTER);
        leftBox.setSpacing(20);
        borderPane.setLeft(leftBox);
        BorderPane.setMargin(leftBox, new Insets(0, 20, 0, 10));

        // Bottom Button
        HBox bottomBox = new HBox(checkMoney);
        bottomBox.setAlignment(Pos.CENTER);
        borderPane.setBottom(bottomBox);
        BorderPane.setMargin(bottomBox, new Insets(10, 0, 10, 0));

        // vBox
        VBox rightBox = new VBox(depositMoney);
        rightBox.setAlignment(Pos.CENTER);
        rightBox.setSpacing(20);
        borderPane.setRight(rightBox);
        BorderPane.setMargin(rightBox, new Insets(0, 10, 0, 20));

        // Return Button
        Button returnButton = new Button("Return");
        returnButton.setOnAction(e->{
            MainMenu mainMenu = new MainMenu();
            mainMenu.start(new Stage());
            primaryStage.close();
        });
        returnButton.setStyle(buttonStyle);
        mainGrid.add(returnButton, 1, 4);
        GridPane.setMargin(returnButton, new Insets(20, 0, 0, 0));

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), mainGrid);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(20);

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(3), mainGrid);
        translateTransition.setFromY(-primaryStage.getHeight());
        translateTransition.setToY(0);

        ParallelTransition parallelTransition = new ParallelTransition(fadeTransition, translateTransition);
        parallelTransition.play();

        // Scene Setup
        Scene scene = new Scene(mainGrid);
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Bank Account Main Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
