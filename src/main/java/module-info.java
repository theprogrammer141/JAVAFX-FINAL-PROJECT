module org.example.javafxfinalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.desktop;


    opens org.example.javafxfinalproject to javafx.fxml;
    exports org.example.javafxfinalproject;
    exports org.example.javafxfinalproject.Khizar;
    exports org.example.javafxfinalproject.Abdullah to javafx.graphics;
    exports org.example.javafxfinalproject.Bilal to javafx.graphics;
    opens org.example.javafxfinalproject.Khizar to javafx.fxml;
   // exports org.example.javafxfinalproject.Bilal;
    opens org.example.javafxfinalproject.Bilal to javafx.fxml;
}