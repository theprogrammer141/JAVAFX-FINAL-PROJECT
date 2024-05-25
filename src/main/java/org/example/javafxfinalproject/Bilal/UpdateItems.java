package org.example.javafxfinalproject.Bilal;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javaxdevelopers.OOMS.InventoryItem;
import javaxdevelopers.OOMS.OOM;
import javaxdevelopers.exceptionhandlers.NoNegativeValueException;

import java.io.*;
import java.util.ArrayList;

public class UpdateItems extends Application {

    private OOM organization; // Assuming this is your main data structure

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        organization = new OOM();

        Image image = new Image("file:///JAVAFX FINAL PROJECT/pr.jpeg");

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

        // Center Layout - GridPane
        GridPane centerGrid = new GridPane();
        centerGrid.setAlignment(Pos.CENTER);
        centerGrid.setPadding(new Insets(25));
        centerGrid.setVgap(10); // Vertical gap between rows
        centerGrid.setHgap(10); // Horizontal gap between columns

        // Title Label "Update Item"
        Label titleLabel = new Label("--Update Item--");
        titleLabel.setStyle("-fx-text-fill: white; -fx-font-size: 24px;");
        centerGrid.add(titleLabel, 0, 0, 2, 1); // ColumnSpan: 2, RowSpan: 1

        // Label "Enter ID to Update Item:"
        Label enterIdLabel = new Label("Enter ID to Update Item:");
        enterIdLabel.setStyle("-fx-text-fill: white; -fx-font-size: 18px;");
        centerGrid.add(enterIdLabel, 0, 1);

        // Text Field for Entering ID
        TextField idTextField = new TextField();
        centerGrid.add(idTextField, 1, 1);

        // Label "Choose attribute to update:"
        Label chooseAttributeLabel = new Label("Choose attribute to update:");
        chooseAttributeLabel.setStyle("-fx-text-fill: white; -fx-font-size: 18px;");
        centerGrid.add(chooseAttributeLabel, 0, 2);

        // Combo Box for Attribute Selection
        ComboBox<String> attributeComboBox = new ComboBox<>(FXCollections.observableArrayList("Name", "Price", "Quantity", "Type"));
        centerGrid.add(attributeComboBox, 1, 2);
        attributeComboBox.setPromptText("Select");

        // Text Field for New Value
        TextField newValueTextField = new TextField();
        centerGrid.add(newValueTextField, 1, 3);

        // Button "Update"
        Button updateButton = new Button("Update");
        updateButton.setStyle("-fx-background-color: darkblue; -fx-text-fill: white; -fx-font-size: 16px;");
        centerGrid.add(updateButton, 0, 4, 2, 1); // ColumnSpan: 2, RowSpan: 1

        // Button "Return"
        Button returnButton = new Button("Return");
        returnButton.setStyle("-fx-background-color: darkblue; -fx-text-fill: white; -fx-font-size: 16px;");
        returnButton.setOnAction(e -> {
            InventoryItemsMenu inventoryItemsMenu = new InventoryItemsMenu();
            inventoryItemsMenu.start(primaryStage);
        });
        centerGrid.add(returnButton, 0, 5, 2, 1); // ColumnSpan: 2, RowSpan: 1

        // Add Center Layout to Main BorderPane
        borderPane.setCenter(centerGrid);

        // Set Up Scene
        Scene scene = new Scene(borderPane);
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Update Item");
        primaryStage.show();

        // Event handling for the Update button
        updateButton.setOnAction(e -> {
            int id = Integer.parseInt(idTextField.getText());
            String attribute = attributeComboBox.getValue();
            String newValue = newValueTextField.getText();

            // Find the item by ID
            InventoryItem itemToUpdate = findItemByID(id);
            if (itemToUpdate == null) {
                showAlert(Alert.AlertType.ERROR, "Item not found", "Item with ID " + id + " not found.");
                return;
            }

            // Update the chosen attribute
            switch (attribute) {
                case "Name":
                    itemToUpdate.setItemName(newValue);
                    break;
                case "Price":
                    try {
                        double newPrice = Double.parseDouble(newValue);
                        itemToUpdate.setItemPrice(newPrice);
                    } catch (NumberFormatException | NoNegativeValueException ex) {
                        showAlert(Alert.AlertType.ERROR, "Invalid input", "Please enter a valid price.");
                        return;
                    }
                    break;
                case "Quantity":
                    try {
                        int newQuantity = Integer.parseInt(newValue);
                        itemToUpdate.setQuantity(newQuantity);
                    } catch (NumberFormatException | NoNegativeValueException ex) {
                        showAlert(Alert.AlertType.ERROR, "Invalid input", "Please enter a valid quantity.");
                        return;
                    }
                    break;
                case "Type":
                    itemToUpdate.setItemType(newValue);
                    break;
                default:
                    showAlert(Alert.AlertType.ERROR, "Invalid attribute", "Please select a valid attribute.");
                    return;
            }

            // Update the item in the organization and save to file
            updateItemInOrganization(itemToUpdate);
            writeItemToFile(organization.getItemsList());
            showAlert(Alert.AlertType.INFORMATION, "Success", "Item updated successfully!");
        });
    }

    private InventoryItem findItemByID(int id) {
        for (InventoryItem item : organization.getItemsList()) {
            if (item.getItemID() == id) {
                return item;
            }
        }
        return null;
    }

    private void updateItemInOrganization(InventoryItem updatedItem) {
        for (int i = 0; i < organization.getItemsList().size(); i++) {
            if (organization.getItemsList().get(i).getItemID() == updatedItem.getItemID()) {
                organization.getItemsList().set(i, updatedItem);
                return;
            }
        }
    }

    private void writeItemToFile(ArrayList<InventoryItem> items) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("itemData.ser"))) {
            oos.writeObject(items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
