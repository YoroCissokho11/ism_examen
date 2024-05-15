module sn.ismonline.ism_examen {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens sn.ismonline.ism_examen to javafx.fxml;
    exports sn.ismonline.ism_examen;
}