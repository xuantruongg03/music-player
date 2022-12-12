package com.example.demo1;

import java.io.File;

public abstract class Music {
    protected long musicTimePosition;
    protected File musicPath;
    protected String musicType;
    protected boolean pause;

    public Music(String musicLocation) {
        try {
            musicPath = new File(musicLocation);
            if (musicPath.exists()) {
                this.musicTimePosition = 0;
                musicType = musicLocation.substring(musicLocation.length() - 3, musicLocation.length());
                pause = true;
            }
        } catch (Exception e) {
            System.out.println("Music path doesn't exist.");
        }
    }

    public long getMusicTimePosition() {
        return musicTimePosition;
    }

    public boolean isPause() {
        return pause;
    }

    public abstract void play();

    public abstract void pause();

    public abstract void stop();

    // Lấy tổng thời gian bài hát (microsecond)
    public abstract long getMusicTimeLength();

    // Lấy phần trăm hiện tại của bài hát (0.0 - 1.0)
    public abstract double getMusicTimePercent();

    // Đặt phần trăm hiện tại của bài hát (0.0 - 1.0)
    public abstract void setMusicTimePercent(double timePercent);

    // Lấy thông số volume hiện tại (0.0f - 1.0f)
    public abstract float getVolume();

    // Đặt thông số volume hiện tại (0.0f - 1.0f)
    public abstract void setVolume(float volume);
}
