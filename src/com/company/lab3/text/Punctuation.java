package com.company.lab3.text;

/**
 * Created by Valera on 28.05.2014.
 */
public class Punctuation extends PartOfSentence {

    private String punctuation;

    public Punctuation(int position, String punctuation) {
        this.position = position;
        this.punctuation = punctuation;
    }

    public String getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(String punctuation) {
        this.punctuation = punctuation;
    }

    @Override
    public String toString() {
        return punctuation;
    }
}