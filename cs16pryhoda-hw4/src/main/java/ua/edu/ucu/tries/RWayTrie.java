package ua.edu.ucu.tries;

import ua.edu.ucu.autocomplete.Queue;


public class RWayTrie  implements Trie {

    private Node root;
    private int n;

    @Override
    public void add(Tuple t) {
        root = put(root, t.term, t.weight, 0);
    }

    private Node put(Node x, String key, int val, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            if (x.value == null){
                n ++;
                val ++;
                x.value = val;
                return x;
            }
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d+1);
        return x;
    }


    @Override
    public boolean contains(String word) {
        return get(word) != null;
    }

    public Object get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return x.value;
    }
    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d+1);
    }

    @Override
    public boolean delete(String word) {
        root = deleteNode(root, word, 0);
        return true;
    }

    private Node deleteNode(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) {
            if (x.value != null) n--;
            x.value = null;
        }
        else {
            char c = key.charAt(d);
            x.next[c] = deleteNode(x.next[c], key, d+1);
        }

        if (x.value != null) return x;
        for (int c = 0; c < Node.R; c++)
            if (x.next[c] != null)
                return x;
        return null;
    }

    @Override
    public Iterable<String> words() {
        Queue<String> queue = new Queue<String>();
        collect(root, "", queue);
        return queue;
    }


    @Override
    public Iterable<String> wordsWithPrefix(String s) {
        Queue<String> queue = new Queue<String>();
        Node x = get(root, s, 0);
        collect( x, s, queue);
        return queue;
    }

    private void collect(Node x, String s, Queue<String> queue) {
        if (x != null) {
            if (x.value != null && x.value > 0){
                queue.enqueue(s);
            }
            for (int i = 0; i < Node.R; i++) {
                collect(x.next[i], s + (char) (i), queue);
            }
        }
    }

    @Override
    public int size() {
        return n;
    }
}
