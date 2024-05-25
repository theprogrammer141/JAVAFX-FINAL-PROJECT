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
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.javafxfinalproject.Khizar.MainMenu;

public class InventoryItemsMenu extends Application {


    @Override
    public void start(Stage primaryStage) {

        Image image2 = new Image("file:///JAVAFX FINAL PROJECT/pr.jpeg");
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

        Label titleLabel = new Label("INVENTORY MENU");
        titleLabel.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-text-fill: white; -fx-font-family: 'Arial';"); // Increased font size

        topHBox.getChildren().add(titleLabel);
        borderPane.setTop(topHBox);

        Button addItems = new Button("Add Item");
        addItems.setStyle("-fx-background-color: navy; -fx-text-fill: white; -fx-font-size: 18px; -fx-font-family: 'Arial';");
        addItems.setPrefSize(180, 45);
        addItems.setOnAction(e->{
            AddItems addItems1 = new AddItems();
            addItems1.start(new Stage());
            primaryStage.close();
        });

        Button removeItems = new Button("Remove Item");
        removeItems.setStyle("-fx-background-color: navy; -fx-text-fill: white; -fx-font-size: 18px; -fx-font-family: 'Arial';");
        removeItems.setPrefSize(180, 45);
        removeItems.setOnAction(e->{
            RemoveItems removeItems1 = new RemoveItems();
            removeItems1.start(new Stage());
            primaryStage.close();
        });

        Button displayItems = new Button("Display Item");
        displayItems.setStyle("-fx-background-color: navy; -fx-text-fill: white; -fx-font-size: 18px; -fx-font-family: 'Arial';");
        displayItems.setPrefSize(180, 45);
        displayItems.setOnAction(e->{
            DisplayItems displayItems1 = new DisplayItems();
            displayItems1.start(new Stage());
            primaryStage.close();
        });

        Button updateItems = new Button("Update Item");
        updateItems.setStyle("-fx-background-color: navy; -fx-text-fill: white; -fx-font-size: 18px; -fx-font-family: 'Arial';");
        updateItems.setPrefSize(180, 45);
        updateItems.setOnAction(e->{
            UpdateItems updateItems1= new UpdateItems();
            updateItems1.start(new Stage());
            primaryStage.close();
        });

        // Adjusted Bottom HBox for Return Button
        Button returnButton = new Button("Return");
        returnButton.setStyle("-fx-background-color: navy; -fx-text-fill: white; -fx-font-size: 18px; -fx-font-family: 'Arial';");
        returnButton.setPrefSize(180, 45);
        returnButton.setOnAction(e->{
            MainMenu mainMenu = new MainMenu();
            mainMenu.start(new Stage());
            primaryStage.close();
        });

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        vBox.getChildren().addAll(addItems, removeItems, updateItems, displayItems, returnButton);
        borderPane.setCenter(vBox);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), borderPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(20);

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(3), borderPane);
        translateTransition.setFromY(-primaryStage.getHeight());
        translateTransition.setToY(0);

        ParallelTransition parallelTransition = new ParallelTransition(fadeTransition, translateTransition);
        parallelTransition.play();

        // Scene Setup
        Scene scene = new Scene(borderPane);
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Inventory Menu");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
