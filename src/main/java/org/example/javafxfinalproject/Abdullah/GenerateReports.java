package org.example.javafxfinalproject.Abdullah;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GenerateReports extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Report Generator");

        Image backgroundImage = new Image("file:///JAVAFX FINAL PROJECT/ReportGeneratorBackground.jpeg");
        BackgroundImage image = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(40, 40, 40, 40));
        grid.setBackground(new Background(image));

        Text title = new Text("REPORT GENERATOR");
        title.setFont(Font.font("Impact", 40));

        Button orphanReportButton = new Button("Generate Orphans Report");
        orphanReportButton.setStyle("-fx-text-fill: white; -fx-background-color: black; -fx-border-color: white; -fx-border-radius: 40px; -fx-background-radius: 30px");

        orphanReportButton.setOnAction(handler ->
        {
            new OrphansReport().start(new Stage());
            primaryStage.close();
        });

        Button staffReportButton = new Button("Generate Staff Report");
        staffReportButton.setStyle("-fx-text-fill: white; -fx-background-color: black; -fx-border-color: white; -fx-border-radius: 40px; -fx-background-radius: 30px");

        staffReportButton.setOnAction(handler ->
        {
            new StaffReport().start(new Stage());
            primaryStage.close();
        });

        Button inventoryReportButton = new Button("Generate Inventory Report");
       inventoryReportButton.setStyle("-fx-text-fill: white; -fx-background-color: black; -fx-border-color: white; -fx-border-radius: 40px; -fx-background-radius: 30px");

       inventoryReportButton.setOnAction(handler ->
       {
           new InventoryReport().start(new Stage());
           primaryStage.close();
       });

       Button donationReportButton = new Button("Generate Donation Report");
        donationReportButton.setStyle("-fx-text-fill: white; -fx-background-color: black; -fx-border-color: white; -fx-border-radius: 40px; -fx-background-radius: 30px");

        donationReportButton.setOnAction(handler ->
        {
            new DonationsReport().start(new Stage());
            primaryStage.close();
        });

        Button backButton = new Button("Back");
        backButton.setStyle(" -fx-text-fill: white;-fx-background-color: black; -fx-background-radius: 30px; -fx-border-color: white; -fx-border-radius: 40px");

        backButton.setOnAction(handler ->
        {
            new GenerateReports().start(new Stage());
            primaryStage.close();
        });

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(
                title,
                orphanReportButton,
                staffReportButton,
                inventoryReportButton,
                donationReportButton,
                backButton
        );

        grid.add(root, 0, 0);

        Scene scene = new Scene(grid, 800, 600);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
