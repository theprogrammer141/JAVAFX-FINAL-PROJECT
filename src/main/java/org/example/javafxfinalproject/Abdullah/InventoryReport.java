package org.example.javafxfinalproject.Abdullah;

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
import javaxdevelopers.OOMS.InventoryItem;
import javaxdevelopers.OOMS.OOM;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class InventoryReport extends Application {
    OOM organization = new OOM();
    ArrayList<InventoryItem> inventoryItems = new ArrayList<>();

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

        Label title = new Label("INVENTORY REPORT");
        title.setFont(Font.font("Impact", 40));
        root.getChildren().add(title);

        Label totalItemsLabel = new Label("Total Items: " + organization.getItemsList().size());
        totalItemsLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        totalItemsLabel.setFont(Font.font(20));
        root.getChildren().add(totalItemsLabel);

        if(inventoryItems != null)
        {
            for(InventoryItem item : inventoryItems)
            {
                Label itemNumberLabel = new Label("Item #: " + item.getItemID());
                itemNumberLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
                root.getChildren().add(itemNumberLabel);

                Label itemNameLabel = new Label("Item Name: " + item.getItemName());
                itemNameLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
                root.getChildren().add(itemNameLabel);

                Label itemPriceLabel = new Label("Item Price: " + item.getItemPrice());
                itemPriceLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
                root.getChildren().add(itemPriceLabel);

                Label itemQuantityLabel = new Label("Item Quantity: " + item.getQuantity());
                itemQuantityLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
                root.getChildren().add(itemQuantityLabel);

                Label itemTypeLabel = new Label("Item Type: " + item.getItemType());
                itemTypeLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
                root.getChildren().add(itemTypeLabel);

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

        Scene scene = new Scene(scrollPane, 800, 600);
        primaryStage.setTitle("Inventory Report");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadInventoryData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("itemData.ser"))) {
            inventoryItems = (ArrayList<InventoryItem>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
