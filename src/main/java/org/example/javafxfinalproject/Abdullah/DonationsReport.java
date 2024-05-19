package org.example.javafxfinalproject.Abdullah;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javaxdevelopers.OOMS.Donation;
import javaxdevelopers.OOMS.OOM;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DonationsReport extends Application {
    OOM organization = new OOM();
    ArrayList<Donation> donations = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        loadInventoryData();

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
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setBackground(new Background(image));


        VBox root = new VBox(10);

        Label title = new Label("DONATIONS REPORT");
        title.setFont(Font.font("Impact", 40));
        root.getChildren().add(title);

        Label totalItemsLabel = new Label("Total Items: " + organization.getDonationsList().size());
        totalItemsLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        totalItemsLabel.setFont(Font.font(20));
        root.getChildren().add(totalItemsLabel);

        if(donations != null)
        {
            for(Donation donation : donations)
            {
                Label donationNumberLabel = new Label("Donation #: " + donation.getDonationId());
                donationNumberLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
                root.getChildren().add(donationNumberLabel);

                Label donorNameLabel = new Label("Donor Name: " + donation.getDonorName());
                donorNameLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
                root.getChildren().add(donorNameLabel);

                Label donationAmountLabel = new Label("Donation Amount: " + donation.getDonationAmount());
                donationAmountLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
                root.getChildren().add(donationAmountLabel);

                Label donationDateLabel = new Label("Donation Date: " + donation.getDate());
                donationDateLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
                root.getChildren().add(donationDateLabel);

                Label line = new Label("----------------------");
                line.setStyle("-fx-font-weight: bold; -fx-font-size: 20");
                root.getChildren().add(line);
            }
        }

        Button backButton = new Button("Back");
        backButton.setStyle(" -fx-text-fill: white;-fx-background-color: black; -fx-background-radius: 30px; -fx-border-color: white; -fx-border-radius: 40px");

        backButton.setOnAction(handler ->
        {
            new GenerateReports().start(new Stage());
            primaryStage.close();
        });

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), grid);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(20);

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(5), grid);
        translateTransition.setFromY(-primaryStage.getHeight());
        translateTransition.setToY(0);

        ParallelTransition parallelTransition = new ParallelTransition(fadeTransition, translateTransition);
        parallelTransition.play();

        grid.add(root, 0, 0);
        grid.add(backButton, 0 ,10);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(grid);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        Scene scene = new Scene(scrollPane, 800, 600);
        primaryStage.setTitle("Donations Report");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadInventoryData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("donationData.ser"))) {
            donations = (ArrayList<Donation>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
