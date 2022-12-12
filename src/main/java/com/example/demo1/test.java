package com.example.demo1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class test {
    public static void main(String[] args) throws IOException {
        Media pick = new Media("file:///" + System.getProperty("user.dir").replace('\\', '/') + "/" + "src/main/java/sound/test.mp3"); // replace this with your own audio file
        MediaPlayer player = new MediaPlayer(pick);
        player.play();
    }
}
