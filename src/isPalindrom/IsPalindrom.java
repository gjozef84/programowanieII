package isPalindrom;

import java.security.InvalidParameterException;

public class IsPalindrom {

    public static boolean isPalindrom(String input) {

        if (input == null || input.equals("")) {
            throw new InvalidParameterException();
        } else {
            int leftIndex=0;
            int rightIndex=input.length() - 1;

            while(true){

                char left = input.charAt(leftIndex);
                char right = input.charAt(rightIndex);

                if(left!=right) return false;

                leftIndex++;
                rightIndex--;

                if(leftIndex>rightIndex) return true;

            }
        }
    }
}
