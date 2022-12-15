package com.example.demo1;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Music {
    private long musicTimePosition;
    private File musicPath;
    private Media media;
    private MediaPlayer player;
    private boolean pause;

    public Music(String musicLocation) {
        try {
            musicPath = new File(musicLocation);
            if (musicPath.exists()) {
                this.musicTimePosition = 0;
                pause = true;
            }
            media = new Media(musicPath.toURI().toString());
            player = new MediaPlayer(media);
        } catch (Exception e) {
            System.out.println("Music path doesn't exist.");
        }
    }

    public long getMusicTimePosition() {
        return (long) player.getCurrentTime().toSeconds();
    }

    public boolean isPause() {
        return pause;
    }

    public void play() {
        player.play();
        pause = false;
    }

    ;

    public void pause() {
        player.pause();
        pause = true;
    }

    ;

    public void stop() {
        player.stop();
        pause = true;
    }

    ;

    public long getMusicTimeLength() {
        return (long) player.getTotalDuration().toSeconds();
    }

    ;

    public double getMusicTimePercent() {
        return (double) player.getCurrentTime().toSeconds() / player.getTotalDuration().toSeconds();
    }

    public void setMusicTimePercent(double timePercent) {
        player.seek(player.getTotalDuration().multiply(timePercent));

    }

    ;

    public float getVolume() {
        return (float) player.getVolume();
    }

    ;

    public void setVolume(float volume) {
        player.setVolume(volume);
    }

    ;
}
