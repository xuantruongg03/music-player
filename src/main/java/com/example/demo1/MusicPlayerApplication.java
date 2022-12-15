package com.example.demo1;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MusicPlayerApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MusicPlayerApplication.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 820, 610);

        ChangeListener<Number> stageSizeListener = (observable, oldValue, newValue) -> {
            if (stage.getHeight() < 610 || stage.getHeight() > 610) {
                stage.setHeight(610);
            }
            if (stage.getWidth() < 820 || stage.getWidth() > 820) {
                stage.setWidth(820);
            }
        };

        File file = new File("src/logo.jpg");
        Image img = new Image(file.toURI().toString());
        stage.widthProperty().addListener(stageSizeListener);
        stage.heightProperty().addListener(stageSizeListener);
        stage.setTitle("Music Player");
        stage.getIcons().add(img);
        stage.setScene(scene);
        stage.show();

        stage.getScene().getWindow().setOnCloseRequest(event -> {
            System.exit(0);
        });

    }

    public static void main(String[] args) {
        launch();
    }

}