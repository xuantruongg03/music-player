package com.example.demo1;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class WavMusic extends Music {
    private Clip player;

    public WavMusic(String musicLocation) {
        super(musicLocation);
        try {
            player = AudioSystem.getClip();
            player.open(AudioSystem.getAudioInputStream(musicPath));
            player.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public void play() {
        try {
            player = AudioSystem.getClip();
            player.open(AudioSystem.getAudioInputStream(musicPath));
            player.setMicrosecondPosition(musicTimePosition);
            player.start();
            player.loop(Clip.LOOP_CONTINUOUSLY);
            pause = false;
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public void pause() {
        musicTimePosition = player.getMicrosecondPosition();
        player.stop();
        pause = true;
    }

    @Override
    public long getMusicTimeLength() {
        return player.getMicrosecondLength();
    }

    public long getMusicTimePosition() {
        if (player.getMicrosecondPosition() > player.getMicrosecondLength())
            player.setMicrosecondPosition(0);
        return player.getMicrosecondPosition();
    }

    @Override
    public double getMusicTimePercent() {
        return (double) player.getMicrosecondPosition() / player.getMicrosecondLength();
    }

    @Override
    public void setMusicTimePercent(double timePercent) {
        musicTimePosition = (long) (timePercent * player.getMicrosecondLength());
    }

    @Override
    public void setVolume(float volume) {
        FloatControl gainControl = (FloatControl) player.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(20f * (float) Math.log10(volume));
    }

    @Override
    public float getVolume() {
        FloatControl gainControl = (FloatControl) player.getControl(FloatControl.Type.MASTER_GAIN);
        return (float) Math.pow(10f, gainControl.getValue() / 20f);
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
