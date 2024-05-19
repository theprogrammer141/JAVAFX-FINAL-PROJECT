module org.example.javafxfinalproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.javafxfinalproject to javafx.fxml;
    exports org.example.javafxfinalproject;
    exports org.example.javafxfinalproject.Khizar;
    opens org.example.javafxfinalproject.Khizar to javafx.fxml;
}