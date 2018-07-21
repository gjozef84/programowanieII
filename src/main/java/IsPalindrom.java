public class IsPalindrom {

    public static void main(String[] args) {
        String str = "iwi";

        if (isPalindrom(str)) System.out.println(str+" jest palindromem");
        else System.out.println(str + " nie jest palindromem");
    }

    public static boolean isPalindrom(String s){
        boolean wynik=false;

        for (int i=0; i < s.length(); i++){

                if(s.charAt(i)==s.charAt(s.length()-1-i)) wynik=true;
                else wynik=false;

        }
        return wynik;
    }
}
