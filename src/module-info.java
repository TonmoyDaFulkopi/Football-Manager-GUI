module myjfx {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    opens Mains to javafx.graphics, javafx.fxml, javafx.base;
    opens Controllers to javafx.base, javafx.fxml, javafx.graphics;
}