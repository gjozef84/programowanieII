package isPalindrom;

import java.security.InvalidParameterException;

public class IsPalindrom {

    public static void main(String[] args) {
        String str = "iwi";

        if (isPalindrom(str)) System.out.println(str + " jest palindromem");
        else System.out.println(str + " nie jest palindromem");
    }

    public static boolean isPalindrom(String s) {

        if (s == null || s.equals("")) {
            throw new InvalidParameterException();
        } else {
            boolean result = false;

            for (int i = 0; i < s.length(); i++) {

                if (s.charAt(i) == s.charAt(s.length() - 1 - i)) result = true;
                else return false;

            }
            return result;
        }
    }
}
