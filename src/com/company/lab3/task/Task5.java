package com.company.lab3.task;

import com.company.lab3.text.*;

import java.util.ArrayList;

/**
 * Created by Valera on 28.05.2014.
 */
public class Task5 implements Task {
    @Override
    public void execute(Text text) {
       ArrayList<PartOfText> textArray =  text.getPartsOfText();
       for (PartOfText sentence : textArray){
           if (sentence instanceof Sentence){
               ArrayList<PartOfSentence> sentenceArray = ((Sentence) sentence).getPartsOfSentence();
               PartOfSentence first = null, last = null;
               int ls=0, fr=0, i =0;
               for (PartOfSentence p : sentenceArray){
                   if (p instanceof Word){
                      last = p;
                      ls = i;
                      if (first==null){
                          first = p;
                          fr = i;
                      }
                   }
                   i++;
               }
               if (ls!=0){
                   sentenceArray.set(ls,first);
                   sentenceArray.set(fr,last);
               }
           }
       }
    }
}
