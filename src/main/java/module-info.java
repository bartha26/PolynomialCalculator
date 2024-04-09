module com.assgn3.polynomial {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.assgn3.polynomial to javafx.fxml;
    exports com.assgn3.polynomial;
    exports com.assgn3.polynomial.controllers;
    opens com.assgn3.polynomial.controllers to javafx.fxml;
}