module com.example.restaurantmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.restaurantmanagementsystem to javafx.fxml;
    exports com.example.restaurantmanagementsystem;
}