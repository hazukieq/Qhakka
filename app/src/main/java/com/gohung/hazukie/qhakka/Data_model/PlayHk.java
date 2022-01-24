package com.gohung.hazukie.qhakka.Data_model;

public class PlayHk {
    String hkp,audioIndex;
    public PlayHk(String hkp,String audioIndex){
        this.audioIndex=audioIndex;
        this.hkp=hkp;
    }

    public String getHkp() {
        return hkp;
    }

    public String getAudioIndex() {
        return audioIndex;
    }
}
