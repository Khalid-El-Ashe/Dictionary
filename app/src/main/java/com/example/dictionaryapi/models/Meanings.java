package com.example.dictionaryapi.models;

import java.io.Serializable;
import java.util.List;

public class Meanings implements Serializable {
    private String partOfSpeech;
    private List<Definitions> definitions;

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public List<Definitions> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<Definitions> definitions) {
        this.definitions = definitions;
    }
}
