package com.company.lab3.text;

/**
 * Created by Valera on 28.05.2014.
 */
public class Code extends PartOfSentence {

    private String code;

    public Code(int position, String code) {
        super.setPosition(position);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String word) {
        this.code = word;
    }

    @Override
    public String toString() {
        return code;
    }
}
