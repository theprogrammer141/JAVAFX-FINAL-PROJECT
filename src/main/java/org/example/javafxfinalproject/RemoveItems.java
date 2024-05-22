package org.example.javafxfinalproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
import javaxdevelopers.OOMS.OOM;
import javaxdevelopers.OOMS.InventoryItem;

import java.util.ArrayList;

public class RemoveItems extends Application {

    private OOM organization = new OOM();
    private int itemIdToRemove = -1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Load Background Image
        Image image = new Image("file:///D:/JAVA/JAVAFX-FINAL-PROJECT/src/rec.jpeg");
        // Background Image Settings
        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );

        // Create Background with Image
        Background background = new Background(backgroundImage);

        // Main Layout - BorderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setBackground(background);

        // Center Layout - VBox
        VBox centerBox = new VBox(10); // Spacing between components
        centerBox.setAlignment(Pos.CENTER);
        centerBox.setPadding(new Insets(25));

        // Title Label "Remove Item"
        Label titleLabel = new Label("--Remove Item--");
        titleLabel.setStyle("-fx-text-fill: white; -fx-font-size: 24px;");
        centerBox.getChildren().add(titleLabel);

        // Label "Enter ID to remove Item"
        Label enterIDLabel = new Label("Enter ID to remove Item:");
        enterIDLabel.setStyle("-fx-text-fill: white; -fx-font-size: 18px;");
        centerBox.getChildren().add(enterIDLabel);

        // HBox for Text Field and Label
        HBox textFieldBox = new HBox(10); // Spacing between components
        textFieldBox.setAlignment(Pos.CENTER);

        // Text Field for Entering Item ID
        TextField idTextField = new TextField();
        textFieldBox.getChildren().addAll(enterIDLabel, idTextField);
        centerBox.getChildren().add(textFieldBox);

        // Button "Remove"
        Button removeButton = new Button("Remove");
        removeButton.setStyle("-fx-background-color: #FF6347; -fx-text-fill: white; -fx-font-size: 16px;");
        removeButton.setOnAction(e -> {
            String idText = idTextField.getText();
            if (idText.isEmpty()) {
                showAlert(AlertType.ERROR, "Input Error", "ID field cannot be empty.");
                return;
            }

            try {
                itemIdToRemove = Integer.parseInt(idText);
                boolean found = false;

                for (InventoryItem item : organization.getItemsList()) {
                    if (item.getItemID() == itemIdToRemove) {
                        found = true;
                        showConfirmationDialog(item, primaryStage);
                        break;
                    }
                }

                if (!found) {
                    showAlert(AlertType.ERROR, "Not Found", "Item with ID " + itemIdToRemove + " not found!");
                }
            } catch (NumberFormatException ex) {
                showAlert(AlertType.ERROR, "Invalid Input", "Please enter a valid numerical ID.");
            }
        });

        // Button "Return"
        Button returnButton = new Button("Return");
        returnButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        returnButton.setOnAction(e -> {
            InventoryItemsMenu inventoryItemsMenu = new InventoryItemsMenu();
            inventoryItemsMenu.start(primaryStage);
        });

        centerBox.getChildren().addAll(removeButton, returnButton);

        // Add Center Layout to Main BorderPane
        borderPane.setCenter(centerBox);

        // Set Up Scene
        Scene scene = new Scene(borderPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Remove Item");
        primaryStage.show();
    }

    private void showAlert(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showConfirmationDialog(InventoryItem item, Stage primaryStage) {
        Stage confirmationStage = new Stage();

        // Load Background Image
        Image image = new Image("file:///JAVAFX FINAL PROJECT/rec.jpeg");
        // Background Image Settings
        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );

        // Create Background with Image
        Background background = new Background(backgroundImage);

        // Main Layout - GridPane
        GridPane grid = new GridPane();
        grid.setBackground(background);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        // Title
        Text scenetitle = new Text("-----Item Details-----");
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        scenetitle.setFill(Color.CYAN);
        grid.add(scenetitle, 2, 0);

        // Item Details
        addItemDetail(grid, "Name", item.getItemName(), 1);
        addItemDetail(grid, "Price", String.valueOf(item.getItemPrice()), 2);
        addItemDetail(grid, "Quantity", String.valueOf(item.getQuantity()), 3);
        addItemDetail(grid, "Item Type", item.getItemType(), 4);

        // Confirmation Message
        Text scenetitle2 = new Text("ARE YOU SURE TO DELETE THIS ITEM?");
        scenetitle2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        scenetitle2.setFill(Color.CYAN);
        grid.add(scenetitle2, 2, 5);

        // Confirmation Buttons
        HBox hBox = new HBox();
        hBox.setSpacing(20);
        hBox.setAlignment(Pos.CENTER);

        Button yesButton = new Button("Yes");
        yesButton.setOnAction(e -> {
            removeItem();
            confirmationStage.close();
            showAlert(AlertType.INFORMATION, "Success", "Item removed successfully!");
        });

        Button noButton = new Button("No");
        noButton.setOnAction(e -> confirmationStage.close());

        hBox.getChildren().addAll(yesButton, noButton);
        grid.add(hBox, 2, 6);

        Scene scene = new Scene(grid, 600, 600);
        confirmationStage.setScene(scene);
        confirmationStage.setTitle("ARE YOU SURE?");
        confirmationStage.show();
    }

    private void addItemDetail(GridPane grid, String label, String value, int row) {
        Label lbl = new Label(label);
        lbl.setTextFill(Color.CYAN);
        grid.add(lbl, 1, row);

        TextField tx = new TextField(value);
        tx.setMaxSize(150, 20);
        tx.setEditable(false);
        grid.add(tx, 2, row);
    }

    private void removeItem() {
        ArrayList<InventoryItem> inventoryItemsList = organization.getItemsList();
        inventoryItemsList.removeIf(item -> item.getItemID() == itemIdToRemove);
        InventoryItem.writeItemToFile(inventoryItemsList);
    }
}
