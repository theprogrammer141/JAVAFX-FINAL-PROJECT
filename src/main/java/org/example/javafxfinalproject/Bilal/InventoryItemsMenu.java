package org.example.javafxfinalproject.Bilal;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class InventoryItemsMenu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //OOM organization = new OOM();
        // Background Image
        Image image2 = new Image("file:///D:/JAVA/JAVAFX-FINAL-PROJECT/src/tf.jpeg");
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true);
        BackgroundImage background = new BackgroundImage(image2, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background2 = new Background(background);

        // BorderPane Setup
        BorderPane borderPane = new BorderPane();
        borderPane.setBackground(background2);

        // Top HBox for Label
        HBox topHBox = new HBox();
        topHBox.setAlignment(Pos.CENTER);
        topHBox.setPadding(new Insets(40, 20, 20, 20)); // Adjusted padding to move label down

        Label titleLabel = new Label("<----( Inventory Menu )---->");
        titleLabel.setStyle("-fx-font-size: 36px; -fx-font-weight: bold; -fx-text-fill: cyan; -fx-font-family: 'Arial';"); // Increased font size

        topHBox.getChildren().add(titleLabel);
        borderPane.setTop(topHBox);

        // Right VBox for Add and Remove Buttons
        VBox rightVBox = new VBox();
        rightVBox.setSpacing(20);
        rightVBox.setAlignment(Pos.CENTER);
        rightVBox.setPadding(new Insets(20));

        Button addItems = new Button("Add Item");
        addItems.setStyle("-fx-background-color: cyan; -fx-text-fill: black; -fx-font-size: 18px; -fx-font-family: 'Arial';");
        addItems.setPrefSize(180, 45);
        addItems.setOnAction(e->{
            AddItems addItems1 = new AddItems();
            addItems1.start(primaryStage);
        });

        Button removeItems = new Button("Remove Item");
        removeItems.setStyle("-fx-background-color: navy; -fx-text-fill: white; -fx-font-size: 18px; -fx-font-family: 'Arial';");
        removeItems.setPrefSize(180, 45);
        removeItems.setOnAction(e->{
            RemoveItems removeItems1 = new RemoveItems();
            removeItems1.start(primaryStage);
        });

        rightVBox.getChildren().addAll(addItems, removeItems);
        borderPane.setRight(rightVBox);

        // Left VBox for Display and Update Buttons
        VBox leftVBox = new VBox();
        leftVBox.setAlignment(Pos.CENTER);
        leftVBox.setSpacing(20);
        leftVBox.setPadding(new Insets(20));

        Button displayItems = new Button("Display Item");
        displayItems.setStyle("-fx-background-color: cyan; -fx-text-fill: black; -fx-font-size: 18px; -fx-font-family: 'Arial';");
        displayItems.setPrefSize(180, 45);
        displayItems.setOnAction(e->{
            DisplayItems displayItems1 = new DisplayItems();
            displayItems1.start(primaryStage);
        });

        Button updateItems = new Button("Update Item");
        updateItems.setStyle("-fx-background-color: navy; -fx-text-fill: white; -fx-font-size: 18px; -fx-font-family: 'Arial';");
        updateItems.setPrefSize(180, 45);
        updateItems.setOnAction(e->{
            UpdateItems updateItems1= new UpdateItems();
            updateItems1.start(primaryStage);
        });

        leftVBox.getChildren().addAll(displayItems, updateItems);
        borderPane.setLeft(leftVBox);

        // Adjusted Bottom HBox for Return Button
        Button returnButton = new Button("Return");
        returnButton.setStyle("-fx-background-color: lime; -fx-text-fill: black; -fx-font-size: 18px; -fx-font-family: 'Arial';");
        returnButton.setPrefSize(180, 45);
        returnButton.setOnAction(e->{
            MainMenu mainMenu = new MainMenu();
            mainMenu.start(primaryStage);
        });

        HBox bottomHBox = new HBox(returnButton);
        bottomHBox.setAlignment(Pos.CENTER);
        bottomHBox.setPadding(new Insets(20, 0, 40, 0)); // Moderate adjustment upwards

        borderPane.setBottom(bottomHBox);

        // Scene Setup
        Scene scene = new Scene(borderPane, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Inventory Menu");
        primaryStage.show();
    }
}
