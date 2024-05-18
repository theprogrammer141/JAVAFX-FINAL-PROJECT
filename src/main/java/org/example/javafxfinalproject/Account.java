package org.example.javafxfinalproject;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Account extends Application {

    public void start(Stage primaryStage) {
        // Background Image
        Image backgroundImage = new Image("file:///JAVAFX FINAL PROJECT/xd.jpeg");
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );
        Background backgroundWithImage = new Background(background);

        // Grid Setup
        GridPane grid = new GridPane();
        GridPane grid2 = new GridPane();
        GridPane grid3 = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid2.setHgap(10);
        grid2.setHgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setBackground(backgroundWithImage);

        // Title
        Text scenetitle = new Text("------Bank Account-------");
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        scenetitle.setFill(Color.WHITE);
        grid.add(scenetitle, 1, 0);

        // Bank Name Label and ComboBox
        Label bankNameLabel = new Label("Bank Name:");
        bankNameLabel.setFont(Font.font("Tahoma", 15));
        bankNameLabel.setTextFill(Color.WHITE);
        grid2.add(bankNameLabel, 0, 1);

        ComboBox<String> comboBox = new ComboBox<>();
        ObservableList<String> options = FXCollections.observableArrayList("HBL");
        comboBox.setStyle("-fx-background-color: transparent;-fx-border-radius: 20px; -fx-border-color: black; -fx-text-fill: white");
        comboBox.setItems(options);
        comboBox.setPromptText("Bank Name");
        grid2.add(comboBox, 1, 1);

        // Account ID Label and ComboBox
        Label accountIdLabel = new Label("Account ID:");
        accountIdLabel.setFont(Font.font("Tahoma", 15));
        accountIdLabel.setTextFill(Color.WHITE);
        grid2.add(accountIdLabel, 0, 2);

        ComboBox<String> comboBox2 = new ComboBox<>();
        ObservableList<String> options2 = FXCollections.observableArrayList("abl234245534343");
        comboBox2.setStyle("-fx-background-color: transparent;-fx-border-radius: 20px; -fx-border-color: black; -fx-text-fill: white");
        comboBox2.setItems(options2);
        comboBox2.setPromptText("Account ID");
        grid2.add(comboBox2, 1, 2);

        // BorderPane Setup
        BorderPane borderPane = new BorderPane();
        grid3.add(borderPane, 0, 3);

        // Buttons Setup
        Button depositMoney = new Button("Deposit Money");
        Button withdrawMoney = new Button("Withdraw Money");
        Button checkMoney = new Button("Check Balance");
        Button displayAccount = new Button("Display Account");

        // Top Button
        HBox topBox = new HBox();
        topBox.setAlignment(Pos.CENTER);
        topBox.getChildren().add(withdrawMoney);
        borderPane.setTop(topBox);

        // Left Button
        VBox leftBox = new VBox();
        leftBox.setAlignment(Pos.CENTER_RIGHT);
        leftBox.getChildren().add(displayAccount);
        leftBox.setSpacing(20);
        borderPane.setLeft(leftBox);

        // Bottom Button
        HBox bottomBox = new HBox();
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.getChildren().add(checkMoney);
        borderPane.setBottom(bottomBox);

        // Right Button
        VBox rightBox = new VBox();
        rightBox.setAlignment(Pos.CENTER_RIGHT);
        rightBox.getChildren().add(depositMoney);
        rightBox.setSpacing(20);
        borderPane.setRight(rightBox);

        grid.add(grid2,1,1);
        grid.add(grid3,1,3);
        Button Return = new Button("Return");
        grid.add(Return,6,5);

        // Scene Setup
        Scene scene = new Scene(grid, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
