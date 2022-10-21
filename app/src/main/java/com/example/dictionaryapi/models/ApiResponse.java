package com.example.dictionaryapi.models;

import java.io.Serializable;
import java.util.List;

public class ApiResponse implements Serializable {
    private String word;
    private List<Phonetics> phonetics;
    private List<Meanings> meanings;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<Phonetics> getPhonetics() {
        return phonetics;
    }

    public void setPhonetics(List<Phonetics> phonetics) {
        this.phonetics = phonetics;
    }

    public List<Meanings> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meanings> meanings) {
        this.meanings = meanings;
    }
}
