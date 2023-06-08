package fr.epita.assistants;

import fr.epita.assistants.classics.Classics;

public class Main {
    public static void main(String[] args) {
        System.out.println(Classics.factorial(16));
        System.out.println(Classics.tribonacci(8));
        System.out.println(Classics.isPalindrome("kayak"));
        String test1 = "kayak";
        String test2 = "kayak";
        System.out.println(Classics.combine(test1, test2));
    }
}
