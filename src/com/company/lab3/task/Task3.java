package com.company.lab3.task;

import com.company.lab3.text.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Created by Valera on 28.05.2014.
 */
public class Task3 implements Task {
    @Override
    public void execute(Text text) {
        ArrayList<Sentence> sentences = extractSentences(text);

        System.out.println();
        Iterator<Sentence> iterator = sentences.iterator();
        ArrayList<Word> potencialWords = extractWord(iterator.next());
        while (iterator.hasNext()) {
            ArrayList<Word> deletedWord = extractWord(iterator.next());
            potencialWords.removeAll(deletedWord);
        }
        for (Word word : potencialWords) {
            System.out.println(word);
        }
    }

    private ArrayList<Sentence> extractSentences(Text text) {
        ArrayList<PartOfText> partOfTexts = new ArrayList<PartOfText>(text.getPartsOfText());
        ArrayList<Sentence> sentences = new ArrayList<Sentence>();
        for (PartOfText part : partOfTexts) {
            if (part instanceof Sentence) {
                sentences.add((Sentence)part);
            }
        }
        return sentences;
    }

    private ArrayList<Word> extractWord(Sentence sentence) {
        ArrayList<PartOfSentence> partOfSentences = new ArrayList<PartOfSentence>(sentence.getPartsOfSentence());
        ArrayList<Word> words = new ArrayList<Word>();
        for (PartOfSentence part : partOfSentences) {
            if (part instanceof Word) {
                words.add((Word)part);
            }
        }
        return words;
    }
}