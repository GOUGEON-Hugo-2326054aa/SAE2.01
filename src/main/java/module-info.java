module com.example.sae201 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.exemple.sae201 to javafx.fxml;
    exports com.exemple.sae201;
}