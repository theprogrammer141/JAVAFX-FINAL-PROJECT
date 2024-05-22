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
import javaxdevelopers.OOMS.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class OrphansReport extends Application {
    OOM organization = new OOM();
    ArrayList<Orphan> orphans = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        loadOrphanData();

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

        Label title = new Label("ORPHANS REPORT");
        title.setFont(Font.font("Impact", 40));
        root.getChildren().add(title);

        Label totalOrphansLabel = new Label("Total Orphans: " + organization.getOrphansList().size());
        totalOrphansLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 20px");
        totalOrphansLabel.setFont(Font.font(20));
        root.getChildren().add(totalOrphansLabel);

        if(orphans != null)
        {
            for(Orphan orphan : orphans) {
                Label orphanIdLabel = new Label("Orphan ID: " + orphan.getId());
                orphanIdLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 15px");
                root.getChildren().add(orphanIdLabel);

                Label orphanNameLabel = new Label("Name: " + orphan.getName());
                orphanNameLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
                root.getChildren().add(orphanNameLabel);

                Label orphanAgeLabel = new Label("Age: " + orphan.getAge());
                orphanAgeLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
                root.getChildren().add(orphanAgeLabel);

                Label orphanGenderLabel = new Label("Gender: " + orphan.getGender());
                orphanGenderLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
                root.getChildren().add(orphanGenderLabel);

                Label orphanEducationLevelLabel = new Label("Education Level: " + orphan.getEducation().getEducationLevel());
                orphanEducationLevelLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
                root.getChildren().add(orphanEducationLevelLabel);

                Label orphanEducationInstituteLabel = new Label("Education Institute: " + orphan.getEducation().getInstitute());
                orphanEducationInstituteLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
                root.getChildren().add(orphanEducationInstituteLabel);

                Label line = new Label("----------------------");
                line.setStyle("-fx-font-weight: bold; -fx-font-size: 20");
                root.getChildren().add(line);
            }
        }

        Button backButton = new Button("Back");
        backButton.setStyle(" -fx-text-fill: white;-fx-background-color: black; -fx-background-radius: 30px; -fx-border-color: white; -fx-border-radius: 40px");

        grid.add(root, 0, 0);
        grid.add(backButton, 0, 10);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(grid);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

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

        Scene scene = new Scene(scrollPane, 800, 600);
        primaryStage.setTitle("Orphans Report");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadOrphanData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("OrphanData.ser"))) {
            orphans = (ArrayList<Orphan>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
