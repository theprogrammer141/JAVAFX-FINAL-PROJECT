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

public class DisplayItems extends Application {

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

        // Create Background with Image
        Background background = new Background(backgroundImage);

        // Main Layout - BorderPane
        //BorderPane borderPane = new BorderPane();
        //grid.setBackground(background);

        GridPane grid = new GridPane();
        grid.setBackground(background);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        grid.setVisible(true);
        Text scenetitle = new Text("-----Item Details-----");
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        scenetitle.setFill(Color.NAVY);
        grid.add(scenetitle,2,0);
        Label accID2 = new Label("Name");
        grid.add(accID2,1,1);
        TextField tx1 = new TextField();
        grid.add(tx1,2,1);
        Label accID = new Label("Price");
        grid.add(accID,1,2);
        TextField tx2 = new TextField();
        grid.add(tx2,2,2);
        Label bal = new Label("Quantity");
        grid.add(bal,1,3);
        TextField tx3 = new TextField();
        grid.add(tx3,2,3);
        Label accT = new Label("Item Type");
        grid.add(accT,1,4);
        TextField tx4 = new TextField();
        grid.add(tx4,2,4);

        //borderPane.setCenter(grid);

        Button br = new Button("Return");
        br.setTextFill(Color.NAVY);
        br.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        grid.add(br,4,6);
        //borderPane.setBottom(returnB);
        Scene scene = new Scene(grid,600,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Display Account");
        primaryStage.show();

    }
}
