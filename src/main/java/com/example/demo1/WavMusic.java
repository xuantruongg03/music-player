package com.example.demo1;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class WavMusic extends Music {
//    private Clip player;
    private Media media;
    private MediaPlayer player;

    public WavMusic(String musicLocation) {
        super(musicLocation);
        try {
            media = new Media(musicPath.toURI().toString());
            player = new MediaPlayer(media);
            player.setVolume(0.5);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public void play() {
        try {
//            player = AudioSystem.getClip();
//            player.open(AudioSystem.getAudioInputStream(musicPath));
//            player.setMicrosecondPosition(musicTimePosition);
//            player.start();
//            player.loop(Clip.LOOP_CONTINUOUSLY);
//            pause = false;
            player.play();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public void pause() {
//        musicTimePosition = player.getMicrosecondPosition();
//        player.stop();
        player.pause();
        pause = true;
    }

    @Override
    public long getMusicTimeLength() {
        return (long) player.getTotalDuration().toMillis();
    }

    public long getMusicTimePosition() {
        return (long) player.getCurrentTime().toMillis();
    }

    @Override
    public double getMusicTimePercent() {
        return (double) player.getTotalDuration().toMillis() / player.getCurrentTime().toMillis();
    }

    @Override
    public void setMusicTimePercent(double timePercent) {
        musicTimePosition = (long) (timePercent * player.getTotalDuration().toMillis());
    }

    @Override
    public void setVolume(float volume) {
        player.setVolume(volume);
    }

    @Override
    public float getVolume() {
        return (float) player.getVolume();
    }

    @Override
    public void stop() {
        player.stop();
        pause = true;
    }

}

class PlaySoundException extends Exception {
    public PlaySoundException() {
        super("Error: Play Sound Exception");
    }
}
