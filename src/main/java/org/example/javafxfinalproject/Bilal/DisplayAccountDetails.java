package org.example.javafxfinalproject.Bilal;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javaxdevelopers.OOMS.OOM;
import javaxdevelopers.OOMS.Account;

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

import java.util.List;
import java.util.stream.Collectors;

public class DisplayAccountDetails extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Image image = new Image("file:///JAVAFX FINAL PROJECT/pr.jpeg");

        // Create Background Image Settings
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize
        );

        // Create Background with Image
        Background background = new Background(backgroundImage);
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        // Set the size of the GridPane to match the size of the scene
        grid.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        grid.setBackground(background);

        Text scenetitle = new Text("----Account Details----");
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        scenetitle.setFill(Color.WHITE);
        grid.add(scenetitle, 1, 0);

        // Bank Name Label and ComboBox
        Label lbl1 = new Label("Account ID:");
        lbl1.setFont(Font.font("Tahoma", 15));
        lbl1.setTextFill(Color.WHITE);
        grid.add(lbl1, 0, 1);

        TextField tx1 = new TextField();
        tx1.setMaxSize(150,20);
        grid.add(tx1,1,1);

        Label lbl2 = new Label("Name:");
        lbl2.setFont(Font.font("Tahoma", 15));
        lbl2.setTextFill(Color.WHITE);
        grid.add(lbl2, 0, 2);

        TextField tx2 = new TextField();
        tx2.setMaxSize(150,20);
        grid.add(tx2,1,2);

        Label lbl3 = new Label("Balance:");
        lbl3.setFont(Font.font("Tahoma", 15));
        lbl3.setTextFill(Color.WHITE);
        grid.add(lbl3, 0, 3);

        TextField tx3 = new TextField();
        tx3.setMaxSize(150,20);
        grid.add(tx3,1,3);

        Label lbl4 = new Label("Transaction History:");
        lbl4.setFont(Font.font("Tahoma", 15));
        lbl4.setTextFill(Color.WHITE);
        grid.add(lbl4, 0, 4);

        TextArea tx4 = new TextArea();
        tx4.setMaxSize(150,20);
        grid.add(tx4,1,4);

        Button rtrn = new Button("Return");
        rtrn.setOnAction(e->{
            AccountMenu accountMenu = new AccountMenu();
            accountMenu.start(new Stage());
            primaryStage.close();
        });
        rtrn.setStyle("-fx-background-color: Navy");

        rtrn.setTextFill(Color.WHITE);

        grid.add(rtrn,6,8);

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
        primaryStage.setTitle("Account details");
        primaryStage.show();
        displayAccountDetails(tx1, tx2, tx3, tx4);
    }
    private void displayAccountDetails(TextField accountIdField, TextField nameField, TextField balanceField, TextArea transactionHistoryArea) {
        OOM oom = new OOM(); // Assuming OOM is the class managing accounts
        Account account = oom.getBankAccount(); // Fetching the account object

        // Setting account details into UI fields
        accountIdField.setText(String.valueOf(account.getAccountID()));
        nameField.setText(account.getBankName());
        balanceField.setText(String.valueOf(account.getBalance()));
        List<Double> transactions = account.getTransactions();
        String formattedTransactions = transactions.stream()
                .map(amount -> String.format("%.2f",amount)) // Format amounts to two decimal places
                .collect(Collectors.joining("\n")); // Join transactions with newline
        transactionHistoryArea.setText(formattedTransactions);
    }
}
