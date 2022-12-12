module com.example.binding {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.binding to javafx.fxml;
    exports com.example.binding;
}