package ua.edu.ucu.autocomplete;

import ua.edu.ucu.tries.Trie;
import ua.edu.ucu.tries.Tuple;

/**
 *
 * @author andrii
 */
public class PrefixMatches {

    private Trie trie;

    public PrefixMatches(Trie trie) {
        this.trie = trie;
    }

    public int load(String... strings) {
        int count = 0;
        for (String array : strings) {
            for (String string : array.split(" ")) {
                if (string.length() > 2) {
                    trie.add(new Tuple(string, string.length()));
                    count++;
                }
            }
        }
        return count;
    }

    public boolean contains(String word) {
        return trie.contains(word);
    }

    public boolean delete(String word) {
        return trie.delete(word);
    }

    public Iterable<String> wordsWithPrefix(String pref) {
        return trie.wordsWithPrefix(pref);
    }

    public Iterable<String> wordsWithPrefix(String pref, int k) {
        Iterable<String> stringIterable = trie.wordsWithPrefix(pref);
        Queue<String> stringQueue = new Queue<>();
        for (String array : stringIterable) {
            if (k > array.length() - pref.length()) {
                stringQueue.enqueue(array);
            }
        }
        return stringQueue;
    }

    public int size() {
        return trie.size();
    }
}
