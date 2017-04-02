
package ua.edu.ucu.autocomplete;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.tries.RWayTrie;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Andrii_Rodionov
 */
public class PrefixMatchesITTest {

    private PrefixMatches pm;

    @Before
    public void init() {
        pm = new PrefixMatches(new RWayTrie());
        pm.load("abc", "abce", "abcd", "abcde", "abcdef");
    }

    @Test
    public void testWordsWithPrefix_String() {
        String pref = "ab";
        Iterable<String> result = pm.wordsWithPrefix(pref);
        String[] expResult = {"abc", "abce", "abcd", "abcde", "abcdef"};
        assertThat(result, containsInAnyOrder(expResult));
    }

    @Test
    public void testWordsWithPrefix_String_and_K() {
        String pref = "abc";
        int k = 3;
        Iterable<String> result = pm.wordsWithPrefix(pref, k);
        String[] expResult = {"abc", "abce", "abcd", "abcde"};
        assertThat(result, containsInAnyOrder(expResult));
    }


    @Test
    public void testLoadWithDifferentParameters() {
        String str = "Mother";
        String str1 = "Waterfallman";
        String str2 = "Shark Mothers";
        String[] strArray = new String[]{"Sharks"};

        int result = pm.load(str, str1);
        assertEquals(2, result);

        result = pm.load(str2);
        assertEquals(2, result);

        result = pm.load(strArray);
        assertEquals(1, result);
    }

    @Test
    public void testContainsTrueOrFalse() {

        boolean result = pm.contains("abce");
        assertEquals(true, result);

        result = pm.contains("Sharks");
        assertEquals(false, result);
    }

    @Test
    public void testDelete() {
        boolean result = pm.delete("abce");
        assertEquals(true, result);
    }

    @Test
    public void testSize() {
        int result = pm.size();
        assertEquals(5, result);
    }

}
