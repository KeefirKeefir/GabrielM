module com.example.gabrielm {
    requires javafx.controls;
    requires org.commonmark;
    requires javafx.web;

    opens com.example.gabrielm to javafx.fxml;
    exports com.example.gabrielm;
}