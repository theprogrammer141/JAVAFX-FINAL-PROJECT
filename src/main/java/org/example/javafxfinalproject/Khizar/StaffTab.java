package org.example.javafxfinalproject.Khizar;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StaffTab extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Header
        Label headerLabel = new Label("Staff Menu");
        headerLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: #000;");

        // Buttons
        Button btnAddStaff = new Button("Add Staff");
        btnAddStaff.setStyle("fx-border-color: white; -fx-border-radius: 40px; -fx-background-color: blue; -fx-text-fill: white; -fx-background-radius: 30px");
        addStaff staffInput = new addStaff();
        btnAddStaff.setOnAction(event ->{
            staffInput.start(new Stage());
            primaryStage.close();
        });


        Button btnRemoveStaff = new Button("Remove Staff");
        btnRemoveStaff.setStyle("fx-border-color: white; -fx-border-radius: 40px; -fx-background-color: blue; -fx-text-fill: white; -fx-background-radius: 30px");
        RemoveStaff removeStaff = new RemoveStaff();
        btnRemoveStaff.setOnAction(event ->{
            removeStaff.start(new Stage());
            primaryStage.close();
        });

        Button btnUpdateData = new Button("Update Data");
        btnUpdateData.setStyle("fx-border-color: white; -fx-border-radius: 40px; -fx-background-color: blue; -fx-text-fill: white; -fx-background-radius: 30px");
        UpdateStaff updateStaff =new UpdateStaff();
        btnUpdateData.setOnAction(event ->{
            updateStaff.start(new Stage());
            primaryStage.close();
        });

        Button btnDisplayRecord = new Button("Display Record");
        btnDisplayRecord.setStyle("fx-border-color: white; -fx-border-radius: 40px; -fx-background-color: blue; -fx-text-fill: white; -fx-background-radius: 30px");
        DisplayStaff displayStaff = new DisplayStaff();
        btnDisplayRecord.setOnAction(event ->{
            displayStaff.start(new Stage());
            primaryStage.close();
        });

        Button btnViewStaff = new Button("View Staff");
        btnViewStaff.setStyle("fx-border-color: white; -fx-border-radius: 40px; -fx-background-color: blue; -fx-text-fill: white; -fx-background-radius: 30px");
        ViewStaff viewStaff = new ViewStaff();
        btnViewStaff.setOnAction(actionEvent -> {
            viewStaff.start(new Stage());
            primaryStage.close();
        });

        Button btnReturn = new Button("Return");
        btnReturn.setStyle("fx-border-color: white; -fx-border-radius: 40px; -fx-background-color: blue; -fx-text-fill: white; -fx-background-radius: 30px");
        MainMenu mainMenu = new MainMenu();
        btnReturn.setOnAction(actionEvent -> {
            mainMenu.start(new Stage());
            primaryStage.close();
        });

        HBox buttonRow1 = new HBox(10, btnAddStaff, btnRemoveStaff, btnUpdateData);
        HBox buttonRow2 = new HBox(10, btnDisplayRecord, btnViewStaff, btnReturn);
        buttonRow1.setAlignment(Pos.CENTER);
        buttonRow2.setAlignment(Pos.CENTER);

        VBox buttonBox = new VBox(10, buttonRow1, buttonRow2);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(20));

        Image StaffImage = new Image("file:///JAVAFX FINAL PROJECT/createaccount.png");
        BackgroundImage image = new BackgroundImage(
                StaffImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );

        // Footer
        Label footerLabel = new Label("Credits: JAVA X DEVELOPERS");
        footerLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #000;");

        // Layout
        BorderPane root = new BorderPane();
        root.setTop(headerLabel);
        BorderPane.setAlignment(headerLabel, Pos.TOP_CENTER);
        root.setCenter(buttonBox);
        root.setStyle("-fx-background-color: #ADD8E6;-fx-font-size: 26;-fx-font-weight: bold"); // Light blue background
        root.setBottom(footerLabel);
        root.setBackground(new Background(image));

        BorderPane.setAlignment(footerLabel, Pos.BOTTOM_CENTER);
        BorderPane.setMargin(buttonBox, new Insets(0, 0, 15, 0));
        // Bind header and footer font size to the width of the scene
        headerLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", root.widthProperty().divide(25).asString(), "px; -fx-text-fill: #000;"));
        footerLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", root.widthProperty().divide(40).asString(), "px; -fx-text-fill: #000;"));

        // Bind button sizes to the width and height of the scene
        btnAddStaff.prefWidthProperty().bind(root.widthProperty().divide(4));
        btnAddStaff.prefHeightProperty().bind(root.heightProperty().divide(10));

        btnRemoveStaff.prefWidthProperty().bind(root.widthProperty().divide(4));
        btnRemoveStaff.prefHeightProperty().bind(root.heightProperty().divide(10));

        btnUpdateData.prefWidthProperty().bind(root.widthProperty().divide(4));
        btnUpdateData.prefHeightProperty().bind(root.heightProperty().divide(10));

        btnDisplayRecord.prefWidthProperty().bind(root.widthProperty().divide(4));
        btnDisplayRecord.prefHeightProperty().bind(root.heightProperty().divide(10));

        btnViewStaff.prefWidthProperty().bind(root.widthProperty().divide(4));
        btnViewStaff.prefHeightProperty().bind(root.heightProperty().divide(10));

        btnReturn.prefWidthProperty().bind(root.widthProperty().divide(4));
        btnReturn.prefHeightProperty().bind(root.heightProperty().divide(10));

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), root);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(20);

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(3), root);
        translateTransition.setFromY(-primaryStage.getHeight());
        translateTransition.setToY(0);

        ParallelTransition parallelTransition = new ParallelTransition(fadeTransition, translateTransition);
        parallelTransition.play();

        // Scene
        Scene scene = new Scene(root);
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Orphanage Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
