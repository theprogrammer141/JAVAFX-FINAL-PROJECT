module org.example.javafxfinalproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.javafxfinalproject to javafx.fxml;
    exports org.example.javafxfinalproject;
}