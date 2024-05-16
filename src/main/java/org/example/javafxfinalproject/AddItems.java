package org.example.javafxfinalproject;

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

public class AddItems extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Image image = new Image("file:///D:/JAVA/JAVAFX-FINAL-PROJECT/src/pr.jpeg");
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
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);
        grid.setBackground(background);

        Text scenetitle = new Text("---Enter Item Details---");
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        scenetitle.setFill(Color.WHITE);
        grid.add(scenetitle, 1, 0);

        // Bank Name Label and ComboBox
        Label lbl1 = new Label("Name:");
        lbl1.setFont(Font.font("Tahoma", 15));
        lbl1.setTextFill(Color.WHITE);
        grid.add(lbl1, 0, 1);

        TextField tx1 = new TextField();
        tx1.setMaxSize(150,20);
        grid.add(tx1,1,1);

        Label lbl2 = new Label("Price:");
        lbl2.setFont(Font.font("Tahoma", 15));
        lbl2.setTextFill(Color.WHITE);
        grid.add(lbl2, 0, 2);

        TextField tx2 = new TextField();
        tx2.setMaxSize(150,20);
        grid.add(tx2,1,2);

        Label lbl3 = new Label("Quantity:");
        lbl3.setFont(Font.font("Tahoma", 15));
        lbl3.setTextFill(Color.WHITE);
        grid.add(lbl3, 0, 3);

        TextField tx3 = new TextField();
        tx3.setMaxSize(150,20);
        grid.add(tx3,1,3);

        Label lbl4 = new Label("Item Type:");
        lbl4.setFont(Font.font("Tahoma", 15));
        lbl4.setTextFill(Color.WHITE);
        grid.add(lbl4, 0, 4);

        TextArea tx4 = new TextArea();
        tx4.setMaxSize(300,150);
        grid.add(tx4,1,4);

        Button rtrn = new Button("Return");
        Button add = new Button("Add Item");
        rtrn.setStyle("-fx-background-color: Navy");
        add.setStyle("-fx-background-color: cyan");
        rtrn.setTextFill(Color.CYAN);
        add.setTextFill(Color.NAVY);
        grid.add(rtrn,6,8);
        grid.add(add,4,8);


        Scene scene = new Scene(grid, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Add Item");
        primaryStage.show();

    }
}
