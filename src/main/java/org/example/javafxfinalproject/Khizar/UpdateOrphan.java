package org.example.javafxfinalproject.Khizar;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javaxdevelopers.OOMS.Education;
import javaxdevelopers.OOMS.OOM;
import javaxdevelopers.OOMS.Orphan;
import javaxdevelopers.OOMS.Skill;
import javaxdevelopers.exceptionhandlers.InvalidAgeException;
import javaxdevelopers.exceptionhandlers.NoNegativeValueException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class UpdateOrphan extends Application {
    OOM organization = new OOM();
    ArrayList<Orphan> orphanArrayList = organization.getOrphansList();
    Orphan orphan;
    TextField name;
    TextField idSearch;
    TextField nameSearch;
    TextField age;
    RadioButton female;
    RadioButton male;
    RadioButton other;
    ToggleGroup gender;
    TextField dateOfEnrollment;
    TextField degree;
    TextField institute;
    ToggleGroup status;
    RadioButton educated;
    RadioButton notEducated;
    TextField skillName;
    TextArea skillDescription;

    @Override
    public void start(Stage primaryStage) {
        // Outermost layout with dark green background and black border
        BorderPane outerLayout = new BorderPane();
        outerLayout.setStyle("-fx-background-color: #47a690; -fx-border-color: black; -fx-border-width: 1;-fx-font-size: 15");

        // Title
        Label titleLabel = new Label("Update Orphan");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: white; -fx-alignment: center;");
        titleLabel.setMaxWidth(Double.MAX_VALUE);
        titleLabel.setAlignment(Pos.CENTER);
        outerLayout.setTop(titleLabel);
        BorderPane.setAlignment(titleLabel, Pos.CENTER);
        BorderPane.setMargin(titleLabel, new Insets(12, 0, 12, 0));

        Label update = new Label("Make Desired Changes!");
        update.setStyle("-fx-font-size: 24px; -fx-text-fill: black;");
        update.setAlignment(Pos.CENTER);
        update.setMaxWidth(Double.MAX_VALUE);

        // Main content VBox
        VBox mainContent = new VBox(2);
        mainContent.getChildren().add(update);
        mainContent.setAlignment(Pos.TOP_CENTER);
        mainContent.setPadding(new Insets(0, 50, 10, 0));

        VBox searchSection = new VBox(2);
        searchSection.setStyle("-fx-background-color: lightblue; -fx-border-color: black; -fx-border-width: 1;");
        searchSection.setAlignment(Pos.TOP_CENTER);
        searchSection.setPadding(new Insets(5));

        Label searchLabel = new Label("To Update an Orphan");
        searchLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: black;");
        searchLabel.setAlignment(Pos.CENTER);

        HBox idBox = new HBox(5);
        Label idLabel = new Label("Search Orphan by ID:");
        idSearch = new TextField();
        idBox.getChildren().addAll(idLabel, idSearch);
        idBox.setAlignment(Pos.CENTER);
        idBox.setSpacing(12);
        searchSection.getChildren().add(idBox);

        HBox nameBox = new HBox(5);
        Label nameLabel = new Label("Search Orphan by Name:");
         nameSearch = new TextField();
        nameBox.getChildren().addAll(nameLabel,nameSearch);
        nameBox.setAlignment(Pos.CENTER);
        searchSection.getChildren().add(nameBox);

        Button searchButton = new Button("Search");
        searchButton.setAlignment(Pos.BASELINE_RIGHT);
        searchSection.getChildren().add(searchButton);
        searchSection.setMaxHeight(180);
        searchSection.setMaxWidth(500);
        searchSection.setSpacing(10);
        searchSection.setAlignment(Pos.CENTER);

        searchSection.setPadding(new Insets(0,50,10,0));
        searchSection.setMinHeight(180);


        HBox contentBox = new HBox();
        contentBox.getChildren().addAll(searchSection,mainContent);
        HBox.setMargin(searchSection,new Insets(38,0,0,0));
        contentBox.setSpacing(20);
        contentBox.setPadding(new Insets(35,0,0,60));
        outerLayout.setCenter(contentBox);

        mainContent.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.6));
        mainContent.prefHeightProperty().bind(primaryStage.heightProperty().multiply(0.7));
        searchSection.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.5));
        searchSection.prefHeightProperty().bind(primaryStage.heightProperty().multiply(0.7));
        contentBox.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.6));
        contentBox.prefHeightProperty().bind(primaryStage.heightProperty().multiply(0.7));



        // Personal Details Section
        VBox personalDetailsSection = new VBox(5);
        personalDetailsSection.setStyle("-fx-background-color: lightblue; -fx-border-color: black; -fx-border-width: 1;");
        personalDetailsSection.setAlignment(Pos.TOP_CENTER);
        personalDetailsSection.setPadding(new Insets(15));

        Label title = new Label("Personal Details");
        title.setStyle("-fx-font-size: 18px; -fx-text-fill: black;");
        personalDetailsSection.getChildren().add(title);

        gender = new ToggleGroup();
         male = new RadioButton("Male");
        male.setToggleGroup(gender);
         female = new RadioButton("Female");
        female.setToggleGroup(gender);
         other = new RadioButton("Other");
        other.setToggleGroup(gender);
        HBox hbox = new HBox(10, male, female, other);
        hbox.setAlignment(Pos.CENTER_LEFT);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        name = new TextField();
        age = new TextField();
        dateOfEnrollment = new TextField();
        addFormField(gridPane, "Orphan Name:", name, 0);
        gridPane.add(new Label("Gender:"),0,1);
        gridPane.add(hbox, 1, 1);
        addFormField(gridPane, "Orphan Age:", age, 2);
        addFormField(gridPane, "Date of Enrollment:", dateOfEnrollment, 3);
        personalDetailsSection.getChildren().add(gridPane);
        mainContent.getChildren().add(personalDetailsSection);

        // Education Details Section
        VBox educationDetailsSection = new VBox(5);
        educationDetailsSection.setStyle("-fx-background-color: lightblue; -fx-border-color: black; -fx-border-width: 1;");
        educationDetailsSection.setAlignment(Pos.TOP_CENTER);
        educationDetailsSection.setPadding(new Insets(15));


        Label educationTitle = new Label("Education Details");
        educationTitle.setStyle("-fx-font-size: 18px; -fx-text-fill: black;");
        educationDetailsSection.getChildren().add(educationTitle);

        GridPane educationGridPane = new GridPane();
        educationGridPane.setAlignment(Pos.CENTER);
        educationGridPane.setHgap(10);
        educationGridPane.setVgap(10);

        degree = new TextField();
        institute = new TextField();

        status = new ToggleGroup();
         educated = new RadioButton("Educated");
        educated.setToggleGroup(status);
         notEducated = new RadioButton("Not Educated");
        notEducated.setToggleGroup(status);
        HBox Educationhbox = new HBox(10, educated, notEducated);
        Educationhbox.setAlignment(Pos.CENTER_LEFT);

        educationGridPane.add(new Label("Education status:"),0,0);
        educationGridPane.add(Educationhbox,1,0);
        addFormField(educationGridPane, "Degree name: ",degree,1);
        addFormField(educationGridPane,"Institute Name: ", institute,2);
        educationDetailsSection.getChildren().add(educationGridPane);
        mainContent.getChildren().add(educationDetailsSection);

        // Skill Details Section
        VBox skillDetailsSection = new VBox(5);
        skillDetailsSection.setStyle("-fx-background-color: lightblue; -fx-border-color: black; -fx-border-width: 1;");
        skillDetailsSection.setAlignment(Pos.TOP_CENTER);
        skillDetailsSection.setPadding(new Insets(15));

        Label skillTitle = new Label("Skill Details: ");
        skillTitle.setStyle("-fx-font-size: 18px; -fx-text-fill: black;");
        skillDetailsSection.getChildren().add(skillTitle);

        GridPane skillGridPane = new GridPane();
        skillGridPane.setAlignment(Pos.CENTER);
        skillGridPane.setHgap(10);
        skillGridPane.setVgap(10);

        skillName = new TextField();
        skillDescription  = new TextArea();

        addFormField(skillGridPane, "Skill Name:", skillName, 0);
        addFormField(skillGridPane, "Skill Description:", skillDescription, 1);
        skillDetailsSection.getChildren().add(skillGridPane);
        mainContent.getChildren().add(skillDetailsSection);

        // Buttons
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);

        Button closeButton = new Button("Close");
        Button saveChanges = new Button("Save changes");
        buttonBox.getChildren().addAll(closeButton,saveChanges);
        mainContent.getChildren().add(buttonBox);

        searchButton.setOnAction(e -> setValues());
        saveChanges.setOnAction(new inputData());
        closeButton.setOnAction(e ->{
            new OrphanTab().start(new Stage());
            primaryStage.close();
        });

        // Scene and Stage setup
        ScrollPane scrollable = new ScrollPane(outerLayout);
        scrollable.setFitToHeight(true);
        scrollable.setFitToWidth(true);

        // Scene and Stage setup
        Scene scene = new Scene(scrollable);
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Orphan Registration System");
        primaryStage.setScene(scene);
        primaryStage.show();
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
    public void resetValues(){
        name.setText("");
        age.setText("");
        if (gender.getSelectedToggle()!=null)
            gender.getSelectedToggle().setSelected(false);
        if (status.getSelectedToggle()!=null)
            status.getSelectedToggle().setSelected(false);        dateOfEnrollment.setText("");
        degree.setText("");
        institute.setText("");
        skillName.setText("");
        skillDescription.setText("");
    }
    public void setValues(){
        orphan = searchOrphan();



        if (orphan == null){
            showAlert(Alert.AlertType.WARNING,"Orphan not found","Please enter a valid id or name");
        }else {
            name.setText(orphan.getName());
            age.setText(Integer.toString(orphan.getAge()));
            dateOfEnrollment.setText(orphan.getEntryDate());
            String genderValue = orphan.getGender();
            if (genderValue.equalsIgnoreCase("Male"))
                male.setSelected(true);
            else if (genderValue.equalsIgnoreCase("Female"))
                female.setSelected(true);
            else other.setSelected(true);
            //gender.setText(orphan.getGender());
            if (orphan.getEducation().getEducationLevel() == null) {
                notEducated.setSelected(true);
                degree.setText("None");
                institute.setText("None");
            } else {
                educated.setSelected(true);
                degree.setText(orphan.getEducation().getEducationLevel());
                institute.setText(orphan.getEducation().getInstitute());
            }
            if (!orphan.getSkillSet().isEmpty()) {
                skillName.setText(orphan.getSkillSet().getFirst().getSkillName());
                skillDescription.setText(orphan.getSkillSet().getFirst().getSkillDescription());
            }
        }
    }
    public Orphan searchOrphan(){

        if (!idSearch.getText().isEmpty()){
            for (Orphan orphan1: orphanArrayList){
                if (orphan1.getId()==Integer.parseInt(idSearch.getText()))
                    return orphan1;
            }
        } else if (!nameSearch.getText().isEmpty()){
            for (Orphan orphan1: orphanArrayList){
                if (orphan1.getName().equalsIgnoreCase(nameSearch.getText()))
                    return orphan1;
            }
        }
        return null;
    }
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    class inputData implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {

            if (name.getText().isEmpty() || status.getSelectedToggle()==null || age.getText().isEmpty() || dateOfEnrollment.getText().isEmpty() || gender.getSelectedToggle() ==null){
                showAlert(Alert.AlertType.WARNING, "Empty fields", "Fill all compulsory fields");
            }else {
                orphan = searchOrphan();
                //orphan.setId(orphanArrayList.size()+1);
                orphan.setName(name.getText());

                RadioButton selectedGender = (RadioButton) gender.getSelectedToggle();
                orphan.setGender(selectedGender.getText());
                String dateValue = dateOfEnrollment.getText();
                orphan.setEntryDate(dateValue);
                try {
                    orphan.setAge(Integer.parseInt(age.getText()));
                } catch (NoNegativeValueException | InvalidAgeException e) {
                    throw new RuntimeException(e);
                }
                Education education = new Education();
                RadioButton educationButton = (RadioButton) status.getSelectedToggle();
                if (educationButton.getText().equals("Educated")){
                    education.setEducationLevel(degree.getText());
                    education.setInstitute(institute.getText());
                }else {
                    education.setEducationLevel("None");
                    education.setInstitute("None");
                }
                orphan.setEducation(education);
                ArrayList<Skill> skillArrayList = new ArrayList<>();
                Skill skill = new Skill();
                skill.setSkillName(skillName.getText());
                skill.setSkillDescription(skillDescription.getText());
                skill.setSkillID(0);
                skillArrayList.add(skill);
                orphan.setSkillSet(skillArrayList);
                showAlert(Alert.AlertType.CONFIRMATION, "Orphan Updated", "Orphan Updated successfully ");
                Orphan.writeOrphanToFile(orphanArrayList);
                resetValues();
            }
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}