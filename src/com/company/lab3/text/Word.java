package com.company.lab3.text;

/**
 * Created by Valera on 28.05.2014.
 */
public class Word extends PartOfSentence {

    private String word;

    public Word(int position, String word) {
        this.position = position;
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return word;
    }
}
