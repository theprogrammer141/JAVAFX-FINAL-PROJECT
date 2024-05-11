package org.example.javafxfinalproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class OrphansReport extends Application {

    @Override
    public void start(Stage primaryStage) {
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


        Label title = new Label("ORPHANS REPORT");
        title.setFont(Font.font("Impact", 40));

        Label totalOrphansLabel = new Label("Total Orphans: ");
        totalOrphansLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        totalOrphansLabel.setFont(Font.font(20));
        Label ageGroupsLabel = new Label("By Age Groups:-");
        ageGroupsLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
        ageGroupsLabel.setFont(Font.font(15));
        Label oneToFiveLabel = new Label("(1-5 years): ");
        oneToFiveLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        Label sixToTenLabel = new Label("(6-10 years): ");
        sixToTenLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        Label elevenToFifteenLabel = new Label("(11-15 years): ");
        elevenToFifteenLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        Label sixteenToEighteenLabel = new Label("(16-18 years): ");
        sixteenToEighteenLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        Label orphansByGenderLabel = new Label("By Gender:-");
        orphansByGenderLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
        orphansByGenderLabel.setFont(Font.font(15));
        Label maleLabel = new Label("Male Percentage: ");
        maleLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        Label femaleLabel = new Label("Female Percentage: ");
        femaleLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        Label othersLabel = new Label("Others: ");
        othersLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        Label orphansByEducationLabel = new Label("By Education:-");
        orphansByEducationLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
        orphansByEducationLabel.setFont(Font.font(15));
        Label educatedLabel = new Label("Educated: ");
        educatedLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        Label nonEducatedLabel = new Label("Non-Educated: ");
        nonEducatedLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        Label orphansBySkillLabel = new Label("By Skill:-");
        orphansBySkillLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
        orphansBySkillLabel.setFont(Font.font(15));
        Label skilledLabel = new Label("Skilled: ");
        skilledLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        Label nonSkilledLabel = new Label("Non-Skilled: ");
        nonSkilledLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");

        VBox root = new VBox(10);
        root.getChildren().addAll(
                title,
                totalOrphansLabel,
                ageGroupsLabel,
                oneToFiveLabel,
                sixToTenLabel,
                elevenToFifteenLabel,
                sixteenToEighteenLabel,
                orphansByGenderLabel,
                maleLabel,
                femaleLabel,
                othersLabel,
                orphansByEducationLabel,
                educatedLabel,
                nonEducatedLabel,
                orphansBySkillLabel,
                skilledLabel,
                nonSkilledLabel
        );

        grid.add(root, 0, 0);

        Scene scene = new Scene(grid, 800, 600);
        primaryStage.setTitle("Orphans Report");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
