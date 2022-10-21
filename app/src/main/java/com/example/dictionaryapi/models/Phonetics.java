package com.example.dictionaryapi.models;

import java.io.Serializable;

public class Phonetics implements Serializable {
    private String text;
    private String audio;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }
}
