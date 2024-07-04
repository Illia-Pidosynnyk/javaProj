module com.java_example {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.java_example to javafx.fxml;
    exports com.java_example;
}
