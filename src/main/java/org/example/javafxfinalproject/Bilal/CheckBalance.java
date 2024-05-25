package org.example.javafxfinalproject.Bilal;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javaxdevelopers.OOMS.Account;
import javaxdevelopers.OOMS.OOM;

import java.util.List;
import java.util.stream.Collectors;

public class CheckBalance extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true);
        Image image = new Image("file:///JAVAFX FINAL PROJECT/pr.jpeg");

        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize
        );


        Background background = new Background(backgroundImage);
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        // Set the size of the GridPane to match the size of the scene
        grid.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        grid.setBackground(background);

        Text scenetitle = new Text("----Available Balance----");
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        scenetitle.setFill(Color.WHITE);
        grid.add(scenetitle, 1, 0);

        // Bank Name Label and ComboBox
        Label lbl1 = new Label("Account ID:");
        lbl1.setFont(Font.font("Tahoma", 15));
        lbl1.setTextFill(Color.WHITE);
        grid.add(lbl1, 0, 1);

        TextField tx1 = new TextField();
        tx1.setMaxSize(200,20);
        grid.add(tx1,1,1);


        Label lbl3 = new Label("Balance:");
        lbl3.setFont(Font.font("Tahoma", 15));
        lbl3.setTextFill(Color.WHITE);
        grid.add(lbl3, 0, 2);

        TextField tx3 = new TextField();
        tx3.setMaxSize(200,20);
        grid.add(tx3,1,2);
        displayAccountDetails(tx1,tx3);


        Button rtrn = new Button("Return");
        rtrn.setStyle("-fx-background-color: Navy");
        rtrn.setTextFill(Color.WHITE);
        rtrn.setOnAction(e ->
        {
            new AccountMenu().start(new Stage());
            primaryStage.close();
        });

        grid.add(rtrn,4,6);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), grid);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(20);

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(3), grid);
        translateTransition.setFromY(-primaryStage.getHeight());
        translateTransition.setToY(0);

        ParallelTransition parallelTransition = new ParallelTransition(fadeTransition, translateTransition);
        parallelTransition.play();

        Scene scene = new Scene(grid);
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Display Balance");
        primaryStage.show();
    }
    private void displayAccountDetails(TextField accountIdField, TextField balanceField) {
        OOM oom = new OOM(); // Assuming OOM is the class managing accounts
        Account account = oom.getBankAccount(); // Fetching the account object

        // Setting account details into UI fields
        accountIdField.setText(String.valueOf(account.getAccountID()));
        balanceField.setText(String.valueOf(account.getBalance()));
    }
}