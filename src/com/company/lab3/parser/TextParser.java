package com.company.lab3.parser;


import com.company.lab3.text.*;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Valera on 28.05.2014.
 */

public class TextParser {
    private static final String TEXT_REGEXP = "([^.!?]+[.!?])";
    private static final String CODE_REGEXP = "(\\{[^}]+})";
    private static final String WORD_REGEXP = " (\\w+)|(\\W+)";

    private TextParser(){}

    public static ArrayList<PartOfText> parseText(File f) throws IOException {
        return parseText(readFile(f.getAbsolutePath(), Charset.forName("UTF-8")));
    }

    public static ArrayList<PartOfText> parseText(String text) {

        ArrayList<PartOfText> partsOfText = new ArrayList<PartOfText>();

        Pattern pattern = Pattern.compile(TEXT_REGEXP);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String match = matcher.group();
            Sentence sentence = new Sentence(matcher.start(), parseSentence(match));
            partsOfText.add(sentence);
        }

        return partsOfText;
    }

    public static ArrayList<PartOfSentence> parseSentence(String sentence) {

        sentence = sentence.replaceAll("\r", "\n");

        ArrayList<PartOfSentence> parts = new ArrayList<PartOfSentence>();

        Pattern codePattern = Pattern.compile(CODE_REGEXP);
        Matcher codeMatcher = codePattern.matcher(sentence);
        while (codeMatcher.find()) {
            if (codeMatcher.group(1) != null) {
                Code code = new Code(codeMatcher.start(1), codeMatcher.group(1));
                parts.add(code);
            }
        }

        Pattern wordPattern = Pattern.compile(WORD_REGEXP);
        Matcher wordMatcher = wordPattern.matcher(sentence);
        while (wordMatcher.find()) {
            if (wordMatcher.group(1) != null) {
                Word word = new Word(wordMatcher.start(1), wordMatcher.group(1));
                parts.add(word);
            }
            if (wordMatcher.group(2) != null) {
                Punctuation punctuation = new Punctuation(wordMatcher.start(2), wordMatcher.group(2));
                parts.add(punctuation);
            }
        }

        return parts;
    }


    private static String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return encoding.decode(ByteBuffer.wrap(encoded)).toString();
    }
}