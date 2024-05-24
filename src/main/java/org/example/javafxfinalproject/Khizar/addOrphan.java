package org.example.javafxfinalproject.Khizar;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;
import javaxdevelopers.OOMS.Education;
import javaxdevelopers.OOMS.OOM;
import javaxdevelopers.OOMS.Orphan;
import javaxdevelopers.OOMS.Skill;
import javaxdevelopers.exceptionhandlers.InvalidAgeException;
import javaxdevelopers.exceptionhandlers.NoNegativeValueException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class addOrphan extends Application {
    OOM organization = new OOM();
    ArrayList<Orphan> orphanArrayList = organization.getOrphansList();
    TextField nameField = new TextField();
    TextField ageField = new TextField();
    DatePicker date = new DatePicker();
    ToggleGroup group = new ToggleGroup();
    ToggleGroup educationGroup = new ToggleGroup();
    TextField degreeName = new TextField();
    TextField instituteName = new TextField();
    TextField skillName = new TextField();
    TextArea skillDescription = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        Image image = new Image("file:///D:\\2nd sem\\OOPs\\JAVAFX-FINAL-PROJECT-FX\\createaccount.png");
        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );
        Background background = new Background(backgroundImage);
        BorderPane outerLayout = new BorderPane();
        outerLayout.setBackground(background);

        outerLayout.setStyle(" -fx-border-color: black; -fx-border-width: 3px;-fx-font-size: 18");

        // Title
        Label titleLabel = new Label("Orphan Registration Form");
        titleLabel.setStyle("-fx-font-size: 26px; -fx-text-fill: Black; -fx-alignment: center; -fx-font-family: 'Arial Black';-fx-font-weight: bold");
        titleLabel.setMaxWidth(Double.MAX_VALUE);
        titleLabel.setAlignment(Pos.CENTER);
        outerLayout.setTop(titleLabel);
        BorderPane.setAlignment(titleLabel, Pos.CENTER);
        BorderPane.setMargin(titleLabel, new Insets(12, 0, 12, 0));

        // Main content VBox
        VBox mainContent = new VBox(2);
        mainContent.setAlignment(Pos.TOP_CENTER);
        mainContent.setPadding(new Insets(10, 150, 10, 150));
        mainContent.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.5));
        mainContent.prefHeightProperty().bind(primaryStage.heightProperty().multiply(0.7));
        outerLayout.setCenter(mainContent);

        // Personal Details Section
        VBox personalDetailsSection = new VBox(5);
        personalDetailsSection.setStyle("-fx-background-color: lightblue; -fx-border-color: black; -fx-border-width: 2;-fx-background-radius: 30px;-fx-border-radius: 30px");
        personalDetailsSection.setAlignment(Pos.TOP_CENTER);
        personalDetailsSection.setPadding(new Insets(15));

        Label title = new Label("Personal Details");
        title.setStyle("-fx-font-size: 20px; -fx-text-fill: black;-fx-font-weight: bold");
        personalDetailsSection.getChildren().add(title);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        addFormField(gridPane, "Orphan Name:", nameField, 0);
        gridPane.add(new Label("Gender:"),0,1);
        gridPane.add(createGenderRadioButtons(), 1, 1);
        addFormField(gridPane, "Orphan Age:", ageField, 2);
        addFormField(gridPane, "Date of Enrollment:", date, 3);
        personalDetailsSection.getChildren().add(gridPane);
        mainContent.getChildren().add(personalDetailsSection);

        // Education Details Section
        VBox educationDetailsSection = new VBox(5);
        educationDetailsSection.setStyle("-fx-background-color: lightblue; -fx-border-color: black; -fx-border-width: 2;-fx-background-radius: 30px;-fx-border-radius: 30px");
        educationDetailsSection.setAlignment(Pos.TOP_CENTER);
        educationDetailsSection.setPadding(new Insets(15));

        Label educationTitle = new Label("Education Details");
        educationTitle.setStyle("-fx-font-size: 20px; -fx-text-fill: black;-fx-font-weight: bold");
        educationDetailsSection.getChildren().add(educationTitle);

        GridPane educationGridPane = new GridPane();
        educationGridPane.setAlignment(Pos.CENTER);
        educationGridPane.setHgap(10);
        educationGridPane.setVgap(10);

        educationGridPane.add(new Label("Education status:"),0,0);
        educationGridPane.add(createEducationStatusRadioButtons(),1,0);
        addFormField(educationGridPane, "Degree name: ",degreeName,1);
        addFormField(educationGridPane,"Institute Name: ", instituteName,2);
        educationDetailsSection.getChildren().add(educationGridPane);
        mainContent.getChildren().add(educationDetailsSection);

        // Skill Details Section
        VBox skillDetailsSection = new VBox(5);
        skillDetailsSection.setStyle("-fx-background-color: lightblue; -fx-border-color: black; -fx-border-width: 2;-fx-background-radius: 30px;-fx-border-radius: 30px");
        skillDetailsSection.setAlignment(Pos.TOP_CENTER);
        skillDetailsSection.setPadding(new Insets(15));

        Label skillTitle = new Label("Skill Details: ");
        skillTitle.setStyle("-fx-font-size: 20px; -fx-text-fill: black;-fx-font-weight: bold");
        skillDetailsSection.getChildren().add(skillTitle);

        GridPane skillGridPane = new GridPane();
        skillGridPane.setAlignment(Pos.CENTER);
        skillGridPane.setHgap(10);
        skillGridPane.setVgap(10);

        addFormField(skillGridPane, "Skill Name:", skillName, 0);
        addFormField(skillGridPane, "Skill Description:", skillDescription, 1);
        skillDetailsSection.getChildren().add(skillGridPane);
        mainContent.getChildren().add(skillDetailsSection);

        // Buttons
        HBox buttonBox = new HBox(50);
        buttonBox.setAlignment(Pos.CENTER);
        Button addButton = new Button("Add Orphan");
        addButton.setStyle("-fx-background-radius: 30px;-fx-border-width: 1px;-fx-border-color: black;-fx-border-radius: 30px");

        Button resetButton = new Button("Reset Data");
        resetButton.setStyle("-fx-background-radius: 30px;-fx-border-width: 1px;-fx-border-color: black;-fx-border-radius: 30px");

        Button closeButton = new Button("Close Tab");
        closeButton.setStyle("-fx-background-radius: 30px;-fx-border-width: 1px;-fx-border-color: black;-fx-border-radius: 30px");

        buttonBox.getChildren().addAll(addButton, resetButton, closeButton);
        mainContent.getChildren().add(buttonBox);

        mainContent.setMaxWidth(1000);
        addButton.setOnAction(new inputData());
        closeButton.setOnAction(e -> {
            new OrphanTab().start(new Stage());
            primaryStage.close();
        });
        resetButton.setOnAction(e ->{
           resetData();
        });

        // Scene and Stage setup
        Scene scene = new Scene(outerLayout);
        primaryStage.setTitle("Orphan Registration Form");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
    public void resetData(){
        nameField.setText("");
        ageField.setText("");
        degreeName.setText("");
        instituteName.setText("");
        skillDescription.setText("");
        skillName.setText("");
        if (group.getSelectedToggle()!=null)
            group.getSelectedToggle().setSelected(false);
        if (educationGroup.getSelectedToggle()!=null)
            educationGroup.getSelectedToggle().setSelected(false);
        date.getEditor().clear();
        date.setValue(null);
    }
    class inputData implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {

            if (nameField.getText().isEmpty() || educationGroup.getSelectedToggle()==null || ageField.getText().isEmpty() || date.getValue() ==null || group.getSelectedToggle() ==null){
                showAlert(Alert.AlertType.WARNING, "Empty fields", "Fill all compulsory fields");
            }else {
                Orphan orphan = new Orphan();
                orphan.setId(orphanArrayList.size()+1);
                orphan.setName(nameField.getText());

                RadioButton selectedGender = (RadioButton) group.getSelectedToggle();
                orphan.setGender(selectedGender.getText());
                String dateValue = date.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                orphan.setEntryDate(dateValue);
                try {
                    orphan.setAge(Integer.parseInt(ageField.getText()));
                } catch (NoNegativeValueException | InvalidAgeException e) {
                    throw new RuntimeException(e);
                }
                Education education = new Education();
                RadioButton educationButton = (RadioButton) educationGroup.getSelectedToggle();
                if (educationButton.getText().equals("Educated")){
                    education.setEducationLevel(degreeName.getText());
                    education.setInstitute(instituteName.getText());
                }else {
                    education.setEducationLevel("None");
                    education.setInstitute("None");
                }
                orphan.setEducation(education);
                ArrayList<Skill> skillArrayList = new ArrayList<>();
                Skill skill = new Skill();
                if (!skillName.getText().isEmpty())
                    skill.setSkillName(skillName.getText());
                if (!skillDescription.getText().isEmpty())
                    skill.setSkillDescription(skillDescription.getText());
                skill.setSkillID(0);
                skillArrayList.add(skill);
                orphan.setSkillSet(skillArrayList);
                showAlert(Alert.AlertType.CONFIRMATION, "Orphan added", "Orphan added successfully ");
                orphanArrayList.add(orphan);
                Orphan.writeOrphanToFile(orphanArrayList);
                resetData();
            }
        }
    }
    private void addFormField(GridPane gridPane, String labelText, Control inputControl, int rowIndex) {
        Label label = new Label(labelText);
        if (inputControl instanceof TextArea){
            inputControl.setMaxWidth(250);
            inputControl.setMaxHeight(300);
        }
        gridPane.add(label, 0, rowIndex);
        gridPane.add(inputControl, 1, rowIndex);
    }

    private HBox createGenderRadioButtons() {
        RadioButton male = new RadioButton("Male");
        male.setToggleGroup(group);
        RadioButton female = new RadioButton("Female");
        female.setToggleGroup(group);
        RadioButton other = new RadioButton("Other");
        other.setToggleGroup(group);
        HBox hbox = new HBox(10, male, female, other);
        hbox.setAlignment(Pos.CENTER_LEFT);
        return hbox;
    }

    private HBox createEducationStatusRadioButtons() {
        RadioButton educated = new RadioButton("Educated");
        educated.setToggleGroup(educationGroup);
        RadioButton notEducated = new RadioButton("Not Educated");
        notEducated.setToggleGroup(educationGroup);
        HBox hbox = new HBox(10, educated, notEducated);
        hbox.setAlignment(Pos.CENTER_LEFT);
        return hbox;
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