package ua.edu.ucu.tries;

import ua.edu.ucu.autocomplete.PrefixMatches;

/**
 * Created by pryho on 09-Jan-17.
 */
public class Main {
    public static void main(String[] args) {
        PrefixMatches dic = new PrefixMatches(new RWayTrie());
        dic.load("abc", "abce", "abcd", "abcde", "abcdef");

        String pref = "abcd";
        System.out.println(dic.wordsWithPrefix(pref));

    }
}
