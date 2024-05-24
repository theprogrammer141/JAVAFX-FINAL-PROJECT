
package org.example.javafxfinalproject.Bilal;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class InventoryItems extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Image image = new Image("file:///JAVAFX FINAL PROJECT/pr.jpeg");
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true);
        BackgroundImage background = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background2 = new Background(background);

        // Create Background with Image
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);

        BorderPane borderPane = new BorderPane();
        borderPane.setBackground(background2);

        VBox vBox = new VBox();
        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);

        Button AddItems = new Button("Add Item");
        AddItems.setStyle("-fx-text-fill: white;-fx-background-color: navy;");

        Button RemoveItems = new Button("Remove Item");
        RemoveItems.setStyle("-fx-text-fill: white;-fx-background-color: navy;");
        RemoveItems.setTextFill(Color.WHITE);

        VBox vBox1 = new VBox();
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(10);

        Button displayItems = new Button("Display Item");
        displayItems.setStyle("-fx-text-fill: white;-fx-background-color: navy");

        Button updateItems = new Button("Update Item");
        updateItems.setStyle("-fx-text-fill: white;-fx-background-color: navy");
        updateItems.setTextFill(Color.WHITE);

        Button rb = new Button("Return");
        rb.setStyle("-fx-text-fill: white;-fx-background-color: darkblue");

        vBox1.getChildren().addAll(AddItems, RemoveItems, displayItems,updateItems, rb);
        borderPane.setCenter(vBox1);

        Scene scene = new Scene(borderPane,600,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Inventory");
        primaryStage.show();


    }
}