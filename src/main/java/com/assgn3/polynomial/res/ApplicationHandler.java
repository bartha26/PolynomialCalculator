package com.assgn3.polynomial.res;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;

import com.assgn3.polynomial.JFXBaseApplication;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ApplicationHandler {
    private final HashMap<SCENE_IDENTIFIER, Pane> views = new HashMap();
    private Stage stage;
    public static ApplicationHandler instance = null;

    private ApplicationHandler() {
    }

    public void startApplication(Stage stage) {
        this.initializeViews();
        this.stage = stage;
        this.stage.setTitle(Environment.APP_TITLE);
        this.stage.setFullScreen(Environment.IS_FULLSCREEN);
        this.stage.setScene(new Scene((Parent)this.views.get(SCENE_IDENTIFIER.HELLO), 800.0, 800.0));
        this.stage.show();
        Logger.info("Application started..");
    }

    public void changeScene(SCENE_IDENTIFIER newScene) {
        this.stage.getScene().setRoot((Parent)this.views.get(newScene));
    }

    public void closeApplication() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to exit!");
        alert.setContentText("Are you sure?");
        if (alert.showAndWait().get() == ButtonType.OK) {
            Platform.exit();
            System.exit(0);
        }

    }

    private void initializeViews() {
        try {
            SCENE_IDENTIFIER[] var1 = SCENE_IDENTIFIER.values();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                SCENE_IDENTIFIER value = var1[var3];
                System.out.println(value);
                this.views.put(value, (Pane)FXMLLoader.load((URL)Objects.requireNonNull(JFXBaseApplication.class.getResource(value.label))));
            }
        } catch (NullPointerException | IOException var5) {
            Logger.error("Could not initialize views. Please check resource folder.");
            this.closeApplication();
        }

    }

    public static ApplicationHandler getInstance() {
        if (instance == null) {
            instance = new ApplicationHandler();
        }

        return instance;
    }
}
