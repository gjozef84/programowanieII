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

        if (input.equals(""))
            return 0;
        else {
            return addNumbers(getValues(input));
        }
        //else return Integer.parseInt(input);
    }

    private int addNumbers(String[] inputNumbers) {
        int sumNumbers = 0;

        for (String inputNumber : inputNumbers) {
            if (!throwOnNegatives(inputNumbers, start)) {
                if (Integer.parseInt(inputNumber) < 1000)
                    sumNumbers += Integer.parseInt(inputNumber);
            }
        }
        return sumNumbers;
    }


    public boolean throwOnNegatives(String[] inputNumbers, int begin) {

        ArrayList<String> tabNegatives = new ArrayList<String>();
        int j = 0;

        for (int i = begin; i < inputNumbers.length; i++) {
            if (Integer.parseInt(inputNumbers[i]) < 0) {
                tabNegatives.add(inputNumbers[i]);
                j++;
            }
        }

        if (tabNegatives.size() > 0) {
            throw new IllegalArgumentException("Negatives not allowed: " + tabNegatives);
        } else return false;
    }


    public String[] getValues(String text) {
        if (text.startsWith("//[")) {
            return hasMultipleCustomSeparators(text);

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

    private String[] hasMultipleCustomSeparators(String text) {
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
    }
}