package com.company.lab3.text;

/**
 * Created by Valera on 28.05.2014.
 */
public class PartOfSentence {

    public int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int compareTo(PartOfSentence o) {
        return this.position - o.position;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }
}
