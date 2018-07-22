package stringcalculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Grzesiek on 21.07.2018.
 **/

public class StringCalculator {
    private int start = 0;


    public int Sum(String input) {

        String[] numbers = getValues(input);

        if (input.equals(""))
            return 0;
        else if (input.length() >= 3) {
            return sumNumbers(numbers);
        } else {
            return Integer.parseInt(input);
        }
    }

    private int sumNumbers(String[] inputText) {
        int sum = 0;

        for (int i = 0; i < inputText.length; i++) {
            if (!checkNegatives(inputText, start)) {
                if (Integer.parseInt(inputText[i]) < 1000)
                    sum += Integer.parseInt(inputText[i]);
            }
        }
        return sum;
    }


    public boolean checkNegatives(String[] inputText, int begin) {

        ArrayList<String> tabNegatives = new ArrayList<String>();
        int j = 0;
        for (int i = begin; i < inputText.length; i++) {
            if (Integer.parseInt(inputText[i]) < 0) {
                tabNegatives.add(inputText[i]);
                j++;
            }
        }

        if (tabNegatives.size() > 0) {
            throw new IllegalArgumentException("negatives not allowed: " + tabNegatives);
        } else return false;
    }


    public String[] getValues(String text) {
        if (text.startsWith("//[")) {
            Matcher m = Pattern.compile("//\\[(.*)\\]\n(.*)").matcher(text);
            m.matches();
            String[] separators = m.group(1).split("\\]\\[");
            String values = m.group(2);
            String separator = "";
            for (int i = 0; i < separators.length; i++) {
                if (i < separators.length - 1) separator += separators[i] + "|";
                else separator += separators[i];
            }

            return values.split(separator);

        } else if (text.startsWith("//")) {
            Matcher m = Pattern.compile("//(.*)\n(.*)").matcher(text);
            m.matches();
            String separator = m.group(1);
            String values = m.group(2);
            return values.split(separator);
        } else {
            String[] values = text.split(",|\n");
            return values;
        }
    }
}





