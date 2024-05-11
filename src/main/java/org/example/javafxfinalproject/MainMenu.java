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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Header
        Label headerLabel = new Label("Main Menu");
        headerLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: #000;");

        // Buttons
        Button btnAddOrphan = new Button("Staff");
        Button btnRemoveOrphan = new Button("Orphan");
        Button btnUpdateData = new Button("Inventry");
        Button btnDisplayRecord = new Button("Account");
        Button btnViewOrphan = new Button("Donation");
        Button btnReturn = new Button("Report Generator");
        Button btnLogOut = new Button("Logout");
        btnLogOut.setStyle("-fx-background-color: #d06f6f");

        HBox buttonRow1 = new HBox(10, btnAddOrphan, btnRemoveOrphan, btnUpdateData);
        HBox buttonRow2 = new HBox(10, btnDisplayRecord, btnViewOrphan, btnReturn);
        buttonRow1.setAlignment(Pos.CENTER);
        buttonRow2.setAlignment(Pos.CENTER);
        HBox buttonRow3 = new HBox(10,btnLogOut);
        buttonRow3.setAlignment(Pos.BASELINE_RIGHT);

        VBox buttonBox = new VBox(10, buttonRow1, buttonRow2,buttonRow3);
        buttonBox.setAlignment(Pos.CENTER);

        //buttonBox.prefHeightProperty().bind(primaryStage.heightProperty().multiply(0.1));

        //buttonBox.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        buttonBox.setPadding(new Insets(20));
        //buttonBox.setStyle("-fx-fit-to-width: TRUE");
        //buttonBox.setMaxWidth(350);
        //buttonBox.setMaxHeight(150);


        Image orphanImage = new Image("file:path/C:/Users/khizar/Pictures/Camera Roll/WhatsApp Image 2023-09-27 at 13.36.01.jpg"); // Replace with your image path
        ImageView imageView = new ImageView(orphanImage);

        // Footer
        Label footerLabel = new Label("Credits: Your Name or Organization");
        footerLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #000;");

        // Layout
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #225580;"); // Light blue background
        root.setTop(headerLabel);
        BorderPane.setAlignment(headerLabel, Pos.TOP_CENTER);
        root.setCenter(buttonBox);

        root.setBottom(footerLabel);
        BorderPane.setAlignment(footerLabel, Pos.BOTTOM_CENTER);
        root.setMargin(imageView, new Insets(20, 0, 20, 0));
        root.setMargin(buttonBox, new Insets(0, 0, 15, 0));
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
        // Repeat the above two lines for each button
        btnLogOut.prefWidthProperty().bind(root.widthProperty().divide(8));
        btnLogOut.prefHeightProperty().bind(root.heightProperty().divide(16));
        // Repeat the above two lines for each button

        // Scene
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Orphanage Management System");
        primaryStage.setScene(scene);
        primaryStage.show();


        // Scene
        //Scene scene = new Scene(root, 600, 400);
        //primaryStage.setTitle("Orphanage Management System");
        //primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
