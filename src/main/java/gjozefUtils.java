import java.util.Arrays;

public class gjozefUtils {

    public static void copyArray(int[] source, int[] target) {
        for(int i = 0; i < source.length; i++) {
            target[i] = source[i];
        }
    }

    public static void copyArray(String[] source, String[] target) {
        for(int i = 0; i < source.length; i++) {
            target[i] = source[i];
        }
    }

    /**
     * Funkcja sumuje elementy tablicy "kwadratowej [x][x]" po przekatnej tej tablicy
     *
     * @param array - pobiera tablice dwuwymiarową
     * @return - zwraca sume elementow po przekatnej
     */
    public static int sumArrayElementsInDiagonal(int[][] array) {

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i][i];
        }
        return sum;
    }

    /**
     * Wyswietla tablice dwuwymiarową w postaci macierzy
     *
     * @param array - przyjmuje tablice dwuwymiarowa
     */
    public static void printDoubleArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j < array[i].length - 1) System.out.print(array[i][j] + ",");
                if (j == array[i].length - 1) System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Funkcja sprawdzająca czy ilość spacji w string1 jest taka sama jak w string2
     *
     * @param string1
     * @param string2
     * @return true if space in string1 == space in string2
     */
    public static boolean containTheSameAmountOfSpaces(String string1, String string2) {

        int whichSpaceString1 = 0;
        int whichSpaceString2 = 0;

        for (int i = 0; i < string1.length() && i < string2.length(); i++) {
            if (string1.charAt(i) == ' ') whichSpaceString1++;
            if (string2.charAt(i) == ' ') whichSpaceString2++;
        }

        if (whichSpaceString1 == whichSpaceString2) return true;
        else return false;
    }

    /**
     * Funkcja licząca ile 'character' znajduje się w 'string'
     *
     * @param string
     * @param character
     * @return
     */
    public static int howManyCharacters(String string, char character){

        int whichChar = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == character) whichChar++;
        }
        return whichChar;
    }

    /**
     * Funkcja zwraca tablice elementow mniejszych niz srednia elementow podanej tablicy 'array'
     *
     * @param array
     * @return
     */
    public static int[] ArrayLessThenAverage(int[] array) {

        double average = gjozefUtils.average(array);
        System.out.println("srednia " + average);

        int[] tabLess = new int[gjozefUtils.LessThenAverage(array, average)];
        int j = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < average) {
                tabLess[j] = array[i];
                j++;
            }
        }
        return tabLess;
    }

    /**
     * Funkcja zwraca tablice elementow wiekszych niz srednia elementow podanej tablicy 'array'
     *
     * @param array - tablica z ktorej liczymy srednia i sprawdzamy elementy wieksze od sredniej
     * @return
     */
    public static int[] ArrayMoreThenAverage(int[] array) {

        double average = gjozefUtils.average(array);
        System.out.println("srednia " + average);

        int[] tabLess = new int[gjozefUtils.LessThenAverage(array, average)];
        int j = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > average) {
                tabLess[j] = array[i];
                j++;
            }
        }
        return tabLess;
    }

    /**
     * Funkcja zamienia w tablicy podane elementy a i b
     *
     * @param a     - element ktory ma byc zamieniony
     * @param b     - element ktory ma byc zamieniony
     * @param array - tablica w ktorej maja byc zamienione elementy
     */
    public static void reversArray(int a, int b, int[] array) {
        int temp;
        temp = array[a - 1];
        array[a - 1] = array[b - 1];
        array[b - 1] = temp;
        System.out.println(Arrays.toString(array));
    }

    /**
     * Funkcja znajduje maksymalną wartość w tablicy int[]
     *
     * @param array - tablica ktora ma byc przeszukana w poszukiwaniu max
     * @return - zwraca wartosc max tablicy array
     */
    public static int maxInArray(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * Funkcja znajduje minimalna wartość w tablicy int[]
     *
     * @param array - tablica ktora ma byc przeszukana w poszukiwaniu min
     * @return - zwraca wartosc min tablicy array
     */
    public static int minInArray(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * Funkcja liczy ile elementów tablicy jest większych od 'average'
     *
     * @param array   - tablica elementow ktore beda przeszukane
     * @param average - wartosc od ktorej elementy maja byc wieksze
     * @return count - ilość elementów > 'average'
     */
    public static int MoreThenAverage(int[] array, double average) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > average) {
                count++;
            }
        }
        return count;
    }

    /**
     * Funkcja liczy ile elementów tablicy jest mniejszych od 'average'
     *
     * @param array   - tablica elementow ktore beda przeszukane
     * @param average - wartosc od ktorej elementy maja byc mniejsze
     * @return count - ilość elementów < 'average'
     */
    public static int LessThenAverage(int[] array, double average) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < average) {
                count++;
            }
        }
        return count;
    }

    /**
     * Funkcja liczy srednia wartosc z wszystkich elementow tablicy array
     *
     * @param array - tablica z ktorej elementow bedzie liczona srednia
     * @return zwraca srednia elementow
     */
    public static double average(int[] array) {
        int suma = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            suma += array[i];
            count++;
        }
        return (double) suma / count;
    }

    /**
     * Funkcja zwraca na którym (pierwszym w kolejności) indeksie znajduje się 'a' w tablicy 'array',
     * zwraca -1 gdy 'a' nie znajduje się w 'array'
     *
     * @param array
     * @param a
     * @return
     */
    public static int indexOf(int[] array, int a) {
        int i = -1;
        if (gjozefUtils.ifInArray(a, array)) {
            for (i = 0; i < array.length; i++) {
                if (array[i] == a) return i;
            }
        }
        return i;
    }

    /**
     * Funkcja sprawdza czy 'element' znajduje się w 'array'
     *
     * @param element
     * @param array
     * @return true or false
     */
    public static boolean ifInArray(int element, int[] array) {
        boolean ifIn = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                ifIn = true;
                break;
            }
        }
        return ifIn;
    }

    /**
     * Funkcja sprawdza czy 'element' znajduje się w 'array'
     * wersja funkcji ifInArray dla tablic dwuwymiarowych
     *
     * @param element
     * @param array
     * @return true or false
     */
    public static boolean ifInArray(int element, int[][] array) {
        boolean ifIn = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == element) {
                    ifIn = true;
                    break;
                }
            }
        }
        return ifIn;
    }

    /**
     * Funkcja wyswietla na konsoli wszystkie elementy 'array' większe lub równe niz podany parametr 'a'
     *
     * @param array
     * @param a
     */
    public static void printHigher(int[] array, int a) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= a) System.out.print(array[i] + " ");
        }
    }

    /**
     * Funkcja zwraca tablice 'arrayRet' indeksow na ktorych znajduje sie szukany parametr 'a' w tablicy 'array'
     *
     * @param array tablica int[] w ktorej szukamy 'a'
     * @param a     element ktory bedzie szukany w tablicy 'array'
     * @return arrayRet tablica indeksow
     */
    public static int[] indicesOf(int[] array, int a) {
        int[] arrayRet = new int[howManyInArray(array, a)];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == a) {
                arrayRet[j] = i;
                j++;
            }
        }
        return arrayRet;
    }

    /**
     * Funkcja zwraca ilosc wystapien 'a' w tablicy 'array'
     *
     * @param array
     * @param a
     * @return count
     */
    public static int howManyInArray(int[] array, int a) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == a) count++;
        }
        return count;
    }

    /**
     * Funkcja zwraca true jeśli 'str1' i 'str2' rozpoczynaja sie takim samym ciagiem znakow o dlugosci 'toEndPrefix'
     *
     * @param str1
     * @param str2
     * @param toEndPrefix - ilosc znako poczatkowych ktore maja byc porownywane
     * @return boolean
     */
    public static boolean startWith(String str1, String str2, int toEndPrefix) {
        String[] string1 = str1.split("", toEndPrefix + 1);
        String[] string2 = str2.split("", toEndPrefix + 1);

        boolean result = false;

        for (int i = 0; i < toEndPrefix; i++) {
            result = string1[i].equals(string2[i]);
        }
        return result;
    }

    /**
     * Funkcja sprawdza czy podana liczba 'a' jest liczba doskonala
     *
     * @param a
     * @return
     */
    public static boolean ifPerfectNum(int a) {
        boolean result = false;
        int sum = 0, i = 1;

        for (i = 1; i <= (a / 2); i++) {
            if (a % i == 0) sum += i;
        }

        if (sum == a) {
            return result = true;
        } else return result = false;
    }

    /**
     * Funkcja zwraca nazwe miesiaca o podanym numerze 'wchichMonth'
     *
     * @param whichMonth
     * @return
     */
    public static String returnMonth(int whichMonth) {

        switch (whichMonth) {
            case 1:
                return "Styczeń";
            case 2:
                return "Luty";
            case 3:
                return "Marzec";
            case 4:
                return "Kwiecień";
            case 5:
                return "Maj";
            case 6:
                return "Czerwiec";
            case 7:
                return "Lipiec";
            case 8:
                return "Sierpień";
            case 9:
                return "Wrzesień";
            case 10:
                return "Pażdziernik";
            case 11:
                return "Listopad";
            default:
                return "Grudzień";
        }
    }
}

