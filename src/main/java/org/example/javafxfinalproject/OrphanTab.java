package org.example.javafxfinalproject;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class OrphanTab extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Header
        Label headerLabel = new Label("Orphan Menu");
        headerLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: #000;");

        // Buttons
        Button btnAddOrphan = new Button("Add Orphan");
        btnAddOrphan.setStyle("fx-border-color: white; -fx-border-radius: 40px; -fx-background-color: blue; -fx-text-fill: white; -fx-background-radius: 30px");
        addOrphan OrphanInput = new addOrphan();
        btnAddOrphan.setOnAction(event ->{
            OrphanInput.start(new Stage());
            primaryStage.close();
        });

        Button btnRemoveOrphan = new Button("Remove Orphan");
        btnRemoveOrphan.setStyle("fx-border-color: white; -fx-border-radius: 40px; -fx-background-color: blue; -fx-text-fill: white; -fx-background-radius: 30px");
        RemoveOrphan removeOrphan = new RemoveOrphan();
        btnRemoveOrphan.setOnAction(event ->{
            removeOrphan.start(new Stage());
            primaryStage.close();
        });

        Button btnUpdateData = new Button("Update Data");
        btnUpdateData.setStyle("fx-border-color: white; -fx-border-radius: 40px; -fx-background-color: blue; -fx-text-fill: white; -fx-background-radius: 30px");
        UpdateOrphan updateOrphan =new UpdateOrphan();
        btnUpdateData.setOnAction(event ->{
            updateOrphan.start(new Stage());
            primaryStage.close();
        });

        Button btnDisplayRecord = new Button("Display Record");
        btnDisplayRecord.setStyle("fx-border-color: white; -fx-border-radius: 40px; -fx-background-color: blue; -fx-text-fill: white; -fx-background-radius: 30px");
        DisplayOrphan displayOrphan = new DisplayOrphan();
        btnDisplayRecord.setOnAction(event ->{
            displayOrphan.start(new Stage());
            primaryStage.close();
        });

        Button btnViewOrphan = new Button("View Orphan");
        btnViewOrphan.setStyle("fx-border-color: white; -fx-border-radius: 40px; -fx-background-color: blue; -fx-text-fill: white; -fx-background-radius: 30px");
        ViewOrphan viewOrphan = new ViewOrphan();
        btnViewOrphan.setOnAction(actionEvent -> {
            viewOrphan.start(new Stage());
            primaryStage.close();
        });

        Button btnReturn = new Button("Return");
        btnReturn.setStyle("fx-border-color: white; -fx-border-radius: 40px; -fx-background-color: blue; -fx-text-fill: white; -fx-background-radius: 30px");
        MainMenu mainMenu = new MainMenu();
        btnReturn.setOnAction(actionEvent -> {
            mainMenu.start(new Stage());
            primaryStage.close();
        });

        HBox buttonRow1 = new HBox(10, btnAddOrphan, btnRemoveOrphan, btnUpdateData);
        HBox buttonRow2 = new HBox(10, btnDisplayRecord, btnViewOrphan, btnReturn);
        buttonRow1.setAlignment(Pos.CENTER);
        buttonRow2.setAlignment(Pos.CENTER);

        VBox buttonBox = new VBox(10, buttonRow1, buttonRow2);
        buttonBox.setAlignment(Pos.CENTER);

        buttonBox.setPadding(new Insets(20));

        Image orphanImage = new Image("file:///JAVAFX FINAL PROJECT/createaccount.png");
        BackgroundImage image = new BackgroundImage(
                orphanImage,
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
        root.setBackground(new Background(image));

        root.setBottom(footerLabel);
        BorderPane.setAlignment(footerLabel, Pos.BOTTOM_CENTER);
        BorderPane.setMargin(buttonBox, new Insets(0, 0, 15, 0));
        // Bind header and footer font size to the width of the scene
        headerLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", root.widthProperty().divide(25).asString(), "px; -fx-text-fill: #000;"));
        footerLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", root.widthProperty().divide(40).asString(), "px; -fx-text-fill: #000;"));

        // Bind button sizes to the width and height of the scene
        btnAddOrphan.prefWidthProperty().bind(root.widthProperty().divide(4));
        btnAddOrphan.prefHeightProperty().bind(root.heightProperty().divide(10));

        btnRemoveOrphan.prefWidthProperty().bind(root.widthProperty().divide(4));
        btnRemoveOrphan.prefHeightProperty().bind(root.heightProperty().divide(10));

        btnUpdateData.prefWidthProperty().bind(root.widthProperty().divide(4));
        btnUpdateData.prefHeightProperty().bind(root.heightProperty().divide(10));

        btnDisplayRecord.prefWidthProperty().bind(root.widthProperty().divide(4));
        btnDisplayRecord.prefHeightProperty().bind(root.heightProperty().divide(10));

        btnViewOrphan.prefWidthProperty().bind(root.widthProperty().divide(4));
        btnViewOrphan.prefHeightProperty().bind(root.heightProperty().divide(10));

        btnReturn.prefWidthProperty().bind(root.widthProperty().divide(4));
        btnReturn.prefHeightProperty().bind(root.heightProperty().divide(10));

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Orphanage Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
