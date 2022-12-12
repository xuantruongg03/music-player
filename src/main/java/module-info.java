module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires fontawesomefx;
    requires com.jfoenix;
    requires java.desktop;
    requires javafx.media;

    opens com.example.demo1 to javafx.fxml;
    exports com.example.demo1;
}