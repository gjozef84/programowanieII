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

        if (input.equals("")) // why no braces here?
            return 0;
        else if (input.length() >= 3) {
            return addNumbers(getValues(input));
        }
        else return Integer.parseInt(input); // can't this be handled with addNumbers(getValues(input));?
    }

    private int addNumbers(String[] inputNumbers) {
        int sumNumbers = 0;

        for (String inputNumber : inputNumbers) {
            if (!checkNegatives(inputNumbers, start)) { // this if is not necessary cuz checkNegatives will throw excetpion on negatives and the funciton will return immidiately
                if (Integer.parseInt(inputNumber) < 1000)
                    sumNumbers += Integer.parseInt(inputNumber);
            }
        }
        return sumNumbers;
    }


    public boolean checkNegatives(String[] inputNumbers, int begin) { // rename to throwOnNegatives()?

        ArrayList<String> tabNegatives = new ArrayList<String>();
        int j = 0;

        for (int i = begin; i < inputNumbers.length; i++) {
            if (Integer.parseInt(inputNumbers[i]) < 0) {
                tabNegatives.add(inputNumbers[i]);
                j++; // to be removed?
            }
        }

        if (tabNegatives.size() > 0) {
            throw new IllegalArgumentException("Negatives not allowed: " + tabNegatives); // how exactly does this message looks like? you're using ArrayList.toString(), I think it will return something unreadable
// this should be a custom exception
        } else return false;
    }


    public String[] getValues(String text) {
        if (text.startsWith("//[")) { // could be extracted to hasMultipleCustomSeparators()
            Matcher m = Pattern.compile("//\\[(.*)\\]\n(.*)").matcher(text);
            m.matches();
            String[] separators = m.group(1).split("\\]\\[");
            String values = m.group(2);
            String separator = "";
            for (int i = 0; i < separators.length; i++) {
                if (i < separators.length - 1) separator += separators[i] + "|"; // will this work for separators like //[*][.] ?
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
