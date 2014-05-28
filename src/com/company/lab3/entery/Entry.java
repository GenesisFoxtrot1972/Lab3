package com.company.lab3.entery;

import java.io.File;
import java.io.IOException;
import com.company.lab3.text.Text;
import com.company.lab3.parser.TextParser;
import com.company.lab3.task.*;
/**
 * Created by Valera on 28.05.2014.
 */

public class Entry {
    public static void main(String[] args) {
        File f = new File("test.txt");
        try {
            Text text = new Text(TextParser.parseText(f));
            text.printText();

            Task task = new Task5();
            task.execute(text);

            Task task2 = new Task3();
            task2.execute(text);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
