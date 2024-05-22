package org.example.javafxfinalproject.Abdullah;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javaxdevelopers.OOMS.Donation;
import javaxdevelopers.exceptionhandlers.NoNegativeValueException;
import org.example.javafxfinalproject.Khizar.MainMenu;

import java.io.*;
import java.util.ArrayList;

public class AddDonation extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image("file:///JAVAFX FINAL PROJECT/pr.jpeg");

        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );

        VBox mainLayout = new VBox(20);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setPadding(new Insets(25, 25, 25, 25));
        mainLayout.setBackground(new Background(backgroundImage));

        Text title = new Text("ADD DONATION");
        title.setFont(Font.font("Helvetica", 45));
        title.setStyle("-fx-font-weight: bold;");
        title.setFill(Paint.valueOf("white"));

        HBox titleBox = new HBox();
        titleBox.setAlignment(Pos.CENTER);
        titleBox.getChildren().add(title);

        GridPane formGrid = new GridPane();
        formGrid.setAlignment(Pos.CENTER);
        formGrid.setHgap(10);
        formGrid.setVgap(10);

        Label donationID = new Label("Donation ID:");
        donationID.setFont(Font.font("Helvetica", 15));
        donationID.setTextFill(Paint.valueOf("white"));
        TextField donationIDField = new TextField();
        donationIDField.setPromptText("Enter Donation ID");
        donationIDField.setStyle("-fx-background-color: rgb(255,255,255,0.25); -fx-background-radius: 30px; -fx-border-color: white; -fx-border-radius: 10px; -fx-text-fill: white; -fx-prompt-text-fill: white");

        Label donorName = new Label("Donor Name:");
        donorName.setFont(Font.font("Helvetica", 15));
        donorName.setTextFill(Paint.valueOf("white"));
        TextField donorNameField = new TextField();
        donorNameField.setPromptText("Enter Donor Name");
        donorNameField.setStyle("-fx-background-color: rgb(255,255,255,0.25); -fx-background-radius: 30px; -fx-border-color: white; -fx-border-radius: 10px; -fx-text-fill: white; -fx-prompt-text-fill: white");

        Label donationAmount = new Label("Donation Amount:");
        donationAmount.setFont(Font.font("Helvetica", 15));
        donationAmount.setTextFill(Paint.valueOf("white"));
        TextField donationAmountField = new TextField();
        donationAmountField.setPromptText("Enter Donation Amount");
        donationAmountField.setStyle("-fx-background-color: rgb(255,255,255,0.25); -fx-background-radius: 30px; -fx-border-color: white; -fx-border-radius: 10px; -fx-text-fill: white; -fx-prompt-text-fill: white");

        Label donationDate = new Label("Donation Date:");
        donationDate.setFont(Font.font("Helvetica", 15));
        donationDate.setTextFill(Paint.valueOf("white"));
        DatePicker donationDatePick = new DatePicker();
        donationDatePick.setPromptText("Enter Donation Date");
        donationDatePick.getEditor().setStyle("-fx-control-inner-background: rgb(255,255,255,0.05); -fx-prompt-text-fill: white; -fx-text-fill: black");

        formGrid.add(donationID, 0, 0);
        formGrid.add(donationIDField, 1, 0);
        formGrid.add(donorName, 0, 1);
        formGrid.add(donorNameField, 1, 1);
        formGrid.add(donationAmount, 0, 2);
        formGrid.add(donationAmountField, 1, 2);
        formGrid.add(donationDate, 0, 3);
        formGrid.add(donationDatePick, 1, 3);

        HBox buttonsBox = new HBox(15);
        buttonsBox.setAlignment(Pos.CENTER);

        Button add = new Button("Add");
        add.setStyle("-fx-background-color: darkblue; -fx-background-radius: 30px; -fx-border-color: white; -fx-border-radius: 10px; -fx-text-fill: white");
        add.setOnAction(handler ->
        {
            String getDonationID = donationIDField.getText();
            String getDonorName = donorNameField.getText();
            String getDonationAmount = donationAmountField.getText();
            String getDonationDate = donationDatePick.getEditor().getText();

            try
            {
                double amountOfDonation = Double.parseDouble(getDonationAmount);
                int idOfDonation = Integer.parseInt(getDonationID);

                if(idOfDonation < 0 || idOfDonation == 0 || getDonorName.isEmpty() || amountOfDonation == 0 || getDonationDate.isEmpty()) {
                    showAlert(Alert.AlertType.WARNING, "Empty Credentials", "Please enter the required credentials!");
                }

                Donation newDonation = new Donation();
                newDonation.setDonationId(idOfDonation);
                newDonation.setDonorName(getDonorName);
                newDonation.setDonationAmount(amountOfDonation);
                newDonation.setDate(getDonationDate);

                ArrayList<Donation> donations = readDonationsFromFile();
                donations.add(newDonation);
                writeDonationsToFile(donations);

                showAlert(Alert.AlertType.CONFIRMATION, "Success", "Donation added successfully");

                donationIDField.clear();
                donorNameField.clear();
                donationAmountField.clear();
                donationDatePick.getEditor().clear();
            }
            catch (NumberFormatException | NoNegativeValueException e)
            {
                e.printStackTrace();
            }
        });

        Button cancel = new Button("Cancel");
        cancel.setStyle("-fx-background-color: darkblue; -fx-background-radius: 30px; -fx-border-color: white; -fx-border-radius: 10px; -fx-text-fill: white");

        cancel.setOnAction(handler ->
        {
            donationIDField.clear();
            donorNameField.clear();
            donationAmountField.clear();
            donationDatePick.getEditor().clear();

            showAlert(Alert.AlertType.INFORMATION, "Abort", "Operation Cancelled");
        });

        Button back = new Button("Back");
        back.setStyle("-fx-background-color: darkblue; -fx-background-radius: 30px; -fx-border-color: white; -fx-border-radius: 10px; -fx-text-fill: white");
        buttonsBox.getChildren().addAll(add, cancel, back);
        buttonsBox.setAlignment(Pos.BASELINE_CENTER);

        back.setOnAction(handler ->
        {
            new MainMenu().start(new Stage());
            stage.close();
        });

        mainLayout.getChildren().addAll(titleBox, formGrid, buttonsBox);

        Scene scene = new Scene(mainLayout, 800, 600);
        stage.setTitle("Add Donation");
        stage.setScene(scene);
        stage.show();
    }

    public static ArrayList<Donation> readDonationsFromFile() {
        ArrayList<Donation> donations = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("donationData.ser"))) {
            donations = (ArrayList<Donation>) ois.readObject();
        } catch (FileNotFoundException e) {
            // File not found, meaning no donations yet, return empty list
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return donations;
    }

    public static void writeDonationsToFile(ArrayList<Donation> donations) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("donationData.ser"))) {
            oos.writeObject(donations);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
