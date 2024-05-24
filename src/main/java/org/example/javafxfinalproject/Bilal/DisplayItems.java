package org.example.javafxfinalproject.Bilal;

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
import javaxdevelopers.OOMS.InventoryItem;
import javaxdevelopers.OOMS.OOM;
import java.util.Optional;

public class DisplayItems extends Application {
    private TextField itemIdField;
    private TextField nameField;
    private TextField priceField;
    private TextField quantityField;
    private TextField itemTypeField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Background Image Settings
        Image image = new Image("file:///JAVAFX FINAL PROJECT/pr.jpeg");
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
        scenetitle.setFill(Color.WHITE);
        grid.add(scenetitle, 0, 0, 2, 1); // Column span for centering

        // Labels and TextFields
        itemIdField = new TextField();
        createLabelAndTextField(grid, "Item ID", 0, 1, itemIdField, Color.WHITE);

        nameField = new TextField();
        createLabelAndTextField(grid, "Name", 0, 2, nameField, Color.WHITE);

        priceField = new TextField();
        createLabelAndTextField(grid, "Price", 0, 3, priceField, Color.WHITE);

        quantityField = new TextField();
        createLabelAndTextField(grid, "Quantity", 0, 4, quantityField, Color.WHITE);

        itemTypeField = new TextField();
        createLabelAndTextField(grid, "Item Type", 0, 5, itemTypeField, Color.WHITE);

        // Search Button
        Button searchButton = new Button("Search");
        searchButton.setStyle("-fx-background-color: lightgray; -fx-text-fill: navy; -fx-font-size: 16px; -fx-font-family: 'Arial';");
        searchButton.setPrefWidth(100);
        searchButton.setOnAction(e -> displayItemDetails());
        grid.add(searchButton, 1, 6);
        GridPane.setMargin(searchButton, new Insets(20, 0, 0, 0));

        // Return Button
        Button returnButton = new Button("Return");
        returnButton.setStyle("-fx-background-color: lightgray; -fx-text-fill: navy; -fx-font-size: 16px; -fx-font-family: 'Arial';");
        returnButton.setPrefWidth(100);
        returnButton.setOnAction(e -> {
            InventoryItemsMenu inventoryItemsMenu = new InventoryItemsMenu();
            inventoryItemsMenu.start(primaryStage);
        });
        grid.add(returnButton, 1, 7);
        GridPane.setMargin(returnButton, new Insets(20, 0, 0, 0));

        // Scene Setup
        Scene scene = new Scene(grid, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Display Item");
        primaryStage.show();
    }

    private void createLabelAndTextField(GridPane grid, String labelText, int col, int row, TextField textField, Color color) {
        Label label = new Label(labelText);
        label.setTextFill(color);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        textField.setMaxWidth(200);
        grid.add(label, col, row);
        grid.add(textField, col + 1, row);
    }

    private void displayItemDetails() {
        String itemIdText = itemIdField.getText();
        if (itemIdText.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Item ID cannot be empty");
            return;
        }

        int itemId;
        try {
            itemId = Integer.parseInt(itemIdText);
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Invalid Item ID");
            return;
        }

        OOM organization = loadOrganizationData(); // Assuming you have a method to load organization data
        Optional<InventoryItem> itemOpt = organization.getItemsList().stream()
                .filter(item -> item.getItemID() == itemId)
                .findFirst();

        if (itemOpt.isPresent()) {
            InventoryItem item = itemOpt.get();
            nameField.setText(item.getItemName());
            priceField.setText(String.valueOf(item.getItemPrice()));
            quantityField.setText(String.valueOf(item.getQuantity()));
            itemTypeField.setText(item.getItemType());
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Item not found");
        }
    }

    private OOM loadOrganizationData() {
        // Load the organization data (e.g., from a file or database)
        // For now, we'll just create a new instance with sample data for demonstration purposes
        OOM organization = new OOM();
        // Add sample items to the organization
        // This should be replaced with actual data loading logic
        return organization;
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
