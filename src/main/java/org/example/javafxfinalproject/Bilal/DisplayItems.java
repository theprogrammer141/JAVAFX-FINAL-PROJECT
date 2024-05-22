package org.example.javafxfinalproject.Bilal;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DisplayItems extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Background Image Settings
        Image image = new Image("file:///D:/JAVA/JAVAFX-FINAL-PROJECT/src/op.jpeg");
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
        scenetitle.setFill(Color.NAVY);
        grid.add(scenetitle, 0, 0, 2, 1); // Column span for centering

        // Labels and TextFields
        createLabelAndTextField(grid, "Name", 0, 1, Color.NAVY);
        createLabelAndTextField(grid, "Price", 0, 2, Color.NAVY);
        createLabelAndTextField(grid, "Quantity", 0, 3, Color.NAVY);
        createLabelAndTextField(grid, "Item Type", 0, 4, Color.NAVY);

        // Return Button
        Button br = new Button("Return");
        br.setStyle("-fx-background-color: lightgray; -fx-text-fill: navy; -fx-font-size: 16px; -fx-font-family: 'Arial';");
        br.setPrefWidth(100);
        grid.add(br, 1, 5);
        GridPane.setMargin(br, new Insets(20, 0, 0, 0));

        // Scene Setup
        Scene scene = new Scene(grid, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Display Item");
        primaryStage.show();
    }

    private void createLabelAndTextField(GridPane grid, String labelText, int col, int row, Color color) {
        Label label = new Label(labelText);
        label.setTextFill(color);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        TextField textField = new TextField();
        textField.setMaxWidth(200);
        grid.add(label, col, row);
        grid.add(textField, col + 1, row);
    }
}
