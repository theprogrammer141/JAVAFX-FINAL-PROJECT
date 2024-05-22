package org.example.javafxfinalproject;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CheckBalance extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Image image = new Image("file:///D:/JAVA/JAVAFX-FINAL-PROJECT/src/xd.jpeg");

        // Create Background Image Settings
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true);
        Image image = new Image("file:///JAVAFX FINAL PROJECT/rec.jpeg");
        // Background Image Settings
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

        Text scenetitle = new Text("----Available Balance----");
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        scenetitle.setFill(Color.BLACK);
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


        Button rtrn = new Button("Return");

        rtrn.setStyle("-fx-background-color: Navy");

        rtrn.setTextFill(Color.CYAN);

        grid.add(rtrn,4,6);

        Scene scene = new Scene(grid, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Display Balance");
        primaryStage.show();
    }
}