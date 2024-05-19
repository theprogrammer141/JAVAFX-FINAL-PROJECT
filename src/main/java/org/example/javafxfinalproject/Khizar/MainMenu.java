package org.example.javafxfinalproject.Khizar;

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

public class MainMenu extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Header
        Label headerLabel = new Label("Welcome To Main Menu");
        headerLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: #000;");

        // Buttons
        Button btnStaff = new Button("Staff");
        btnStaff.setStyle("-fx-border-color: white; -fx-border-radius: 40px; -fx-background-color: green; -fx-text-fill: white; -fx-background-radius: 30px");

        Button btnOrphan = new Button("Orphan");
        btnOrphan.setStyle("-fx-border-color: white; -fx-border-radius: 40px; -fx-background-color: green; -fx-text-fill: white; -fx-background-radius: 30px");

        Button btnInventory = new Button("Inventory");
        btnInventory.setStyle("-fx-border-color: white; -fx-border-radius: 40px; -fx-background-color: green; -fx-text-fill: white; -fx-background-radius: 30px");

        Button btnAccount = new Button("Account");
        btnAccount.setStyle("-fx-border-color: white; -fx-border-radius: 40px; -fx-background-color: green; -fx-text-fill: white; -fx-background-radius: 30px");

        Button btnDonation = new Button("Donation");
        btnDonation.setStyle("-fx-border-color: white; -fx-border-radius: 40px; -fx-background-color: green; -fx-text-fill: white; -fx-background-radius: 30px");

        Button btnReportGenerator = new Button("Report Generator");
        btnReportGenerator.setStyle("-fx-border-color: white; -fx-border-radius: 40px; -fx-background-color: green; -fx-text-fill: white; -fx-background-radius: 30px");

        Button btnLogOut = new Button("Logout");
        btnLogOut.setStyle("-fx-background-color: red; -fx-background-radius: 30px; -fx-border-color: white; -fx-border-radius: 40px; -fx-text-fill: white;");

        HBox buttonRow1 = new HBox(10, btnStaff, btnOrphan, btnInventory);
        HBox buttonRow2 = new HBox(10, btnAccount, btnDonation, btnReportGenerator);
        buttonRow1.setAlignment(Pos.CENTER);
        buttonRow2.setAlignment(Pos.CENTER);
        HBox buttonRow3 = new HBox(10,btnLogOut);
        buttonRow3.setAlignment(Pos.BASELINE_RIGHT);

        VBox buttonBox = new VBox(10, buttonRow1, buttonRow2,buttonRow3);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(20));

        Image backgroundImage = new Image("file:///JAVAFX FINAL PROJECT/background.jpeg");
        BackgroundImage image = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );

        // Footer
        Label footerLabel = new Label("Credits: JAVA X DEVELOPERS");
        footerLabel.setStyle("-fx-font: Impact;-fx-font-size: 15px; -fx-text-fill: black;");

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
        btnStaff.prefWidthProperty().bind(root.widthProperty().divide(4));
        btnStaff.prefHeightProperty().bind(root.heightProperty().divide(10));

        btnOrphan.prefWidthProperty().bind(root.widthProperty().divide(4));
        btnOrphan.prefHeightProperty().bind(root.heightProperty().divide(10));

        btnInventory.prefWidthProperty().bind(root.widthProperty().divide(4));
        btnInventory.prefHeightProperty().bind(root.heightProperty().divide(10));

        btnAccount.prefWidthProperty().bind(root.widthProperty().divide(4));
        btnAccount.prefHeightProperty().bind(root.heightProperty().divide(10));

        btnDonation.prefWidthProperty().bind(root.widthProperty().divide(4));
        btnDonation.prefHeightProperty().bind(root.heightProperty().divide(10));

        btnReportGenerator.prefWidthProperty().bind(root.widthProperty().divide(4));
        btnReportGenerator.prefHeightProperty().bind(root.heightProperty().divide(10));
        // Repeat the above two lines for each button
        btnLogOut.prefWidthProperty().bind(root.widthProperty().divide(8));
        btnLogOut.prefHeightProperty().bind(root.heightProperty().divide(16));
        // Repeat the above two lines for each button

        // Scene
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Orphanage Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
