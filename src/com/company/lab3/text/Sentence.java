package com.company.lab3.text;

import java.util.*;

/**
 * Created by Valera on 28.05.2014.
 */
public class Sentence extends PartOfText {
    private ArrayList<PartOfSentence> partsOfSentence;

    public Sentence(int position, ArrayList<PartOfSentence> partsOfSentence) {
        this.position = position;
        this.partsOfSentence = partsOfSentence;
    }

    public ArrayList<PartOfSentence> getPartsOfSentence() {
        return partsOfSentence;
    }

    public void setPartsOfSentence(ArrayList<PartOfSentence> partsOfSentence) {
        this.partsOfSentence = partsOfSentence;
    }

    @Override
    public String toString() {
        StringBuilder sentence = new StringBuilder();
        for (PartOfSentence part : partsOfSentence) {
            if (!(part instanceof Code)) {
                sentence.append(part+" ");
            }
        }
        return sentence.toString();
    }
}
