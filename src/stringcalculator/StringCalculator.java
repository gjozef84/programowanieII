package stringcalculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Grzesiek on 21.07.2018.
 *
**/

public class StringCalculator {
    private boolean isSeparator = false;
    private char separator = ',';
    private int start = 0;
    private String separatortab = "";

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
        System.out.println("suma " + sum);
        return sum;
    }

    /*public int sumString(char separators, String[] input) {
        int sum = 0;


        if (isSeparator) {
            start = 2;
        }
        for (int i = start; i < input.length; i++) {
            if (!checkNegatives(input, start)) {
                if (input[i] != String.valueOf(separator) && input[i] != "\n" && Integer.parseInt(input[i]) < 1000)
                    sum += Integer.parseInt(input[i]);
            }
        }
        return sum;
    }*/

    public boolean checkNegatives(String[] tab, int begin) {

        ArrayList<String> tabNegatives = new ArrayList<String>();
        int j = 0;
        for (int i = begin; i < tab.length; i++) {

            if (Integer.parseInt(tab[i]) < 0) {
                tabNegatives.add(tab[i]);
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
            String separator = m.group(1);
            String values = m.group(2);

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

        /*public String getSeparator(String stringInput) {

        String[] tab = stringInput.split("");
        //String separator = "";
        *//*ArrayList<String> separators = new ArrayList<String>();
        if (tab[0] == "/" && tab[1] == "/" && tab[2] != "[") {
            isSeparator = true;
            separators.add(tab[2]);
        } else {
            int head = stringInput.indexOf('[');
            int tail = stringInput.lastIndexOf(']');
            String seps = stringInput.substring(head, tail);
            String[] sep = seps.split("\\]|\\[");
            //System.out.println(Arrays.toString(sep));

            for (String s : sep) {
                if (!(s.equals(""))) {
                    separators.add(s);
                }
            }

        }*//*
        System.out.println(separator);
        return separator;
    }*/
}





