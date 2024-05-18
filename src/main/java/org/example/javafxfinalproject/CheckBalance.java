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
        Image image = new Image("file:///JAVAFX FINAL PROJECT/rec.jpeg");
        // Background Image Settings
        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );
        Background background = new Background(backgroundImage);
        GridPane grid = new GridPane();
        grid.setBackground(background);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        Text scenetitle = new Text("ARE YOU SURE TO REMOVE THIS ITEM");
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        scenetitle.setFill(Color.NAVY);
        grid.add(scenetitle,2,0);
        Text accID2 = new Text("ITEM NAME :");
        accID2.setFill(Color.NAVY);
        grid.add(accID2,1,3);
        TextField tx1 = new TextField();
        grid.add(tx1,2,3);
        Button br = new Button("Return");
        br.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        grid.add(br,4,7);
        //borderPane.setBottom(returnB);
        Scene scene = new Scene(grid,600,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Display Balance");
        primaryStage.show();


    }
}
