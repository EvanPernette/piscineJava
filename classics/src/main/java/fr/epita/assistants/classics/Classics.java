package fr.epita.assistants.classics;

public class Classics {
    /**
     * Computes the factorial of n.
     * @param n the nth value to compute, negative values should return -1
     *
     * @return the long value of n!
     */
    public static long factorial(int n) {
        if (n < 0){
            return -1;
        }
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    /**
     * Computes the nth value of the tribonacci suite.
     * f(0) = 0, f(1) = 1, f(2) = 1, f(n+3) = f(n) + f(n+1) + f(n+2)
     *
     * @param n the nth sequence to compute
     */
    public static long tribonacci(int n) {
        long f0 = 0;
        long f1 = 1;
        long f2 = 1;
        long aux = 0;
        if (n == 0) {
            return f0;
        } else if (n == 1) {
            return f1;
        } else if (n == 2) {
            return f2;
        } else {
            for (int i = 3; i <= n; i++) {
                aux = f0 + f1 + f2;
                f0 = f1;
                f1 = f2;
                f2 = aux;
            }
            return aux;
        }
    }

    /**
     * Checks if a word is a palindrome.
     *
     * @param word the string to check
     * @return true if the word is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String word) {
        int i = 0;
        int j = word.length() - 1;
        while (i < j) {
            while (word.charAt(i) == ' ')
                i++;
            while (word.charAt(j) == ' ')
                j--;
            if (Character.toLowerCase(word.charAt(i)) != Character.toLowerCase(word.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * Sorts an array using an insertion sort.
     *
     * @param array the array to sort in place
     */
    public static void insertionSort(int[] array) {
        int j;
        int key;
        for (int i = 1; i < array.length; i++) {
            key = array[i];
            j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    /**
     * Combines two strings by alternating their characters. Must use a StringBuilder.
     * If the strings do not have the same length, appends the remaining characters at the end of the result.
     * For instance, combine("abc", "def") returns "adbecf"
     */
    public static String combine(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        int alen = a.length();
        int blen = b.length();
        while (i < alen && j < blen) {
            sb.append(a.charAt(i));
            sb.append(b.charAt(j));
            i++;
            j++;
        }
        if (i < alen) {
            sb.append(a.substring(i));
        } else if (j < blen) {
            sb.append(b.substring(j));
        }
        return sb.toString();
    }
}
