module com.example.sae201 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.exemple.sae201 to javafx.fxml;
    exports com.exemple.sae201;
    exports com.exemple.sae201.Model;
    opens com.exemple.sae201.Model to javafx.fxml;
    exports com.exemple.sae201.Controller;
    opens com.exemple.sae201.Controller to javafx.fxml;
}