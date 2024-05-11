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

public class StaffReport extends Application {

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


        Label title = new Label("STAFF REPORT");
        title.setFont(Font.font("Impact", 40));

        Label totalStaffLabel = new Label("Total Staff: ");
        totalStaffLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        totalStaffLabel.setFont(Font.font(20));
        Label ageGroupsLabel = new Label("By Age Groups:-");
        ageGroupsLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
        ageGroupsLabel.setFont(Font.font(15));
        Label twentyToTwentyFiveLabel = new Label("(20-25 years): ");
        twentyToTwentyFiveLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        Label TwentyFiveToThirtyLabel = new Label("(25-30 years): ");
        TwentyFiveToThirtyLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        Label thirtyToThirtyFiveLabel = new Label("(35-40 years): ");
        thirtyToThirtyFiveLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        Label fortyPlusLabel = new Label("(40+ years): ");
        fortyPlusLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        Label staffByGenderLabel = new Label("By Gender:-");
        staffByGenderLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
        staffByGenderLabel.setFont(Font.font(15));
        Label maleLabel = new Label("Male Percentage: ");
        maleLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        Label femaleLabel = new Label("Female Percentage: ");
        femaleLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        Label othersLabel = new Label("Others: ");
        othersLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        Label staffByEducationLabel = new Label("By Education:-");
        staffByEducationLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
        staffByEducationLabel.setFont(Font.font(15));
        Label educatedLabel = new Label("Educated: ");
        educatedLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        Label nonEducatedLabel = new Label("Non-Educated: ");
        nonEducatedLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        Label staffBySkillLabel = new Label("By Skill:-");
        staffBySkillLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
        staffBySkillLabel.setFont(Font.font(15));
        Label skilledLabel = new Label("Skilled: ");
        skilledLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        Label nonSkilledLabel = new Label("Non-Skilled: ");
        nonSkilledLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");

        VBox root = new VBox(10);
        root.getChildren().addAll(
                title,
                totalStaffLabel,
                ageGroupsLabel,
                twentyToTwentyFiveLabel,
                TwentyFiveToThirtyLabel,
                thirtyToThirtyFiveLabel,
                fortyPlusLabel,
                staffByGenderLabel,
                maleLabel,
                femaleLabel,
                othersLabel,
                staffByEducationLabel,
                educatedLabel,
                nonEducatedLabel,
                staffBySkillLabel,
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
