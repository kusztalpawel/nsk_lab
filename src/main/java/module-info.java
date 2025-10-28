module org.example.nsk {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.nsk to javafx.fxml;
    exports org.example.nsk;
}