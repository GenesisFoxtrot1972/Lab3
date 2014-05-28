package com.company.lab3.text;


import com.company.lab3.text.*;

/**
 * Created by Valera on 28.05.2014.
 */

import java.util.*;
public class Text {
   private ArrayList<PartOfText> partsOfText = new ArrayList();
    public Text(ArrayList<PartOfText> partsOfText) {
        this.partsOfText = partsOfText;
    }

    public void printText() {
        for (PartOfText part : partsOfText) {
            System.out.print(part+" ");
        }
        System.out.println();
    }

    public ArrayList<PartOfText> getPartsOfText() {
        return partsOfText;
    }

    public void setPartsOfText(ArrayList<PartOfText> partsOfText) {
        this.partsOfText = partsOfText;
    }

}
