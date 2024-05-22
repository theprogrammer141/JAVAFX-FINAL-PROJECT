package org.example.javafxfinalproject.Bilal;

import javafx.scene.control.*;
import javaxdevelopers.OOMS.OOM;
import javaxdevelopers.OOMS.InventoryItem;
import javaxdevelopers.exceptionhandlers.NoNegativeValueException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AddItems extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Image image = new Image("file:///JAVAFX FINAL PROJECT/pr.jpeg");
        // Background Image Settings
        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );

        Background background = new Background(backgroundImage);
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);
        grid.setBackground(background);

        Text scenetitle = new Text("---Enter Item Details---");
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        scenetitle.setFill(Color.WHITE);
        grid.add(scenetitle, 1, 0);

        // Name Label and TextField
        Label lbl1 = new Label("Name:");
        lbl1.setFont(Font.font("Tahoma", 15));
        lbl1.setTextFill(Color.WHITE);
        grid.add(lbl1, 0, 1);

        TextField tx1 = new TextField();
        tx1.setMaxSize(150, 20);
        grid.add(tx1, 1, 1);

        // Price Label and TextField
        Label lbl2 = new Label("Price:");
        lbl2.setFont(Font.font("Tahoma", 15));
        lbl2.setTextFill(Color.WHITE);
        grid.add(lbl2, 0, 2);

        TextField tx2 = new TextField();
        tx2.setMaxSize(150, 20);
        grid.add(tx2, 1, 2);

        // Quantity Label and TextField
        Label lbl3 = new Label("Quantity:");
        lbl3.setFont(Font.font("Tahoma", 15));
        lbl3.setTextFill(Color.WHITE);
        grid.add(lbl3, 0, 3);

        TextField tx3 = new TextField();
        tx3.setMaxSize(150, 20);
        grid.add(tx3, 1, 3);

        // Item Type Label and TextArea
        Label lbl4 = new Label("Item Type:");
        lbl4.setFont(Font.font("Tahoma", 15));
        lbl4.setTextFill(Color.WHITE);
        grid.add(lbl4, 0, 4);

        TextArea tx4 = new TextArea();
        tx4.setMaxSize(300, 150);
        grid.add(tx4, 1, 4);

        // Return and Add Buttons
        Button rtrn = new Button("Return");
        rtrn.setOnAction(e -> {
            InventoryItemsMenu inventoryItemsMenu = new InventoryItemsMenu();
            inventoryItemsMenu.start(primaryStage);
        });
        Button add = new Button("Add Item");
        add.setOnAction(new InputData(tx1, tx2, tx3, tx4));
        rtrn.setStyle("-fx-background-color: Navy");
        add.setStyle("-fx-background-color: cyan");
        rtrn.setTextFill(Color.CYAN);
        add.setTextFill(Color.NAVY);
        grid.add(rtrn, 6, 8);
        grid.add(add, 4, 8);

        Scene scene = new Scene(grid, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Add Item");
        primaryStage.show();
    }

    class InputData implements EventHandler<ActionEvent> {
        TextField name;
        TextField price;
        TextField quantity;
        TextArea itemType;

        public InputData(TextField name, TextField price, TextField quantity, TextArea itemType) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            this.itemType = itemType;
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            OOM organization = new OOM();
            ArrayList<InventoryItem> inventoryItemArrayListList = organization.getItemsList();
            InventoryItem inventoryItem = new InventoryItem();
            inventoryItem.setItemID(inventoryItemArrayListList.size() + 1);

            String nameInput = name.getText();
            String priceInput = price.getText();
            String quantityInput = quantity.getText();
            String itemTypeInput = itemType.getText();

            if (nameInput.isEmpty() || priceInput.isEmpty() || quantityInput.isEmpty() || itemTypeInput.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Input Error", "All fields must be filled.");
                return;
            }

            inventoryItem.setItemName(nameInput);

            try {
                double itemPrice = Double.parseDouble(priceInput);
                inventoryItem.setItemPrice(itemPrice);
            } catch (NumberFormatException | NoNegativeValueException e) {
                showAlert(Alert.AlertType.ERROR, "Invalid input", "Please enter a valid price.");
                return;
            }

            try {
                int itemQuantity = Integer.parseInt(quantityInput);
                inventoryItem.setQuantity(itemQuantity);
            } catch (NumberFormatException | NoNegativeValueException e) {
                showAlert(Alert.AlertType.ERROR, "Invalid input", "Please enter a valid quantity.");
                return;
            }

            inventoryItem.setItemType(itemTypeInput);

            inventoryItemArrayListList.add(inventoryItem);
            InventoryItem.writeItemToFile(inventoryItemArrayListList);

            showAlert(Alert.AlertType.INFORMATION, "Success", "Item added successfully!");
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
