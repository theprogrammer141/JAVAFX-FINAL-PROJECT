package org.example.javafxfinalproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AreYouSure extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Background Image Settings
        Image image = new Image("file:///D:/JAVA/JAVAFX-FINAL-PROJECT/src/rec.jpeg");
        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );
        Background background = new Background(backgroundImage);

        // Main Layout - GridPane
        GridPane grid = new GridPane();
        grid.setBackground(background);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        grid.setAlignment(Pos.CENTER);

        // Scene Title
        Text scenetitle = new Text("-----Item Details-----");
        scenetitle.setFont(Font.font("Arial", FontWeight.BOLD, 26));
        scenetitle.setFill(Color.CYAN);
        grid.add(scenetitle, 1, 0, 2, 1); // Column span for centering

        // Labels and TextFields
        createLabelAndTextField(grid, "Name", 1, 1, Color.CYAN);
        createLabelAndTextField(grid, "Price", 1, 2, Color.CYAN);
        createLabelAndTextField(grid, "Quantity", 1, 3, Color.CYAN);
        createLabelAndTextField(grid, "Item Type", 1, 4, Color.CYAN);

        // Confirmation Title
        Text scenetitle2 = new Text("ARE YOU SURE TO DELETE THIS ITEM?");
        scenetitle2.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        scenetitle2.setFill(Color.CYAN);
        grid.add(scenetitle2, 1, 5, 2, 1); // Column span for centering

        // Radio Buttons
        HBox hBox = new HBox();
        hBox.setSpacing(20);
        hBox.setAlignment(Pos.CENTER);

        RadioButton rb = new RadioButton("Yes");
        rb.setTextFill(Color.CYAN);
        RadioButton rb2 = new RadioButton("No");
        rb2.setTextFill(Color.CYAN);

        ToggleGroup toggleGroup = new ToggleGroup();
        rb.setToggleGroup(toggleGroup);
        rb2.setToggleGroup(toggleGroup);

        hBox.getChildren().addAll(rb, rb2);
        grid.add(hBox, 1, 6, 2, 1); // Column span for centering

        // Return Button
        Button br = new Button("Return");
        br.setTextFill(Color.NAVY);
        br.setStyle("-fx-font-size: 16px; -fx-background-color: lightgray;");
        grid.add(br, 1, 7, 2, 1); // Column span for centering
        GridPane.setMargin(br, new Insets(20, 0, 0, 0));

        // Scene Setup
        Scene scene = new Scene(grid, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ARE YOU SURE?");
        primaryStage.show();
    }

    private void createLabelAndTextField(GridPane grid, String labelText, int col, int row, Color color) {
        Label label = new Label(labelText);
        label.setTextFill(color);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        TextField textField = new TextField();
        textField.setMaxSize(150, 20);
        grid.add(label, col, row);
        grid.add(textField, col + 1, row);
    }
}
