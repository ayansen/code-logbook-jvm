package algorithm.backtracking;

import algorithms.backtracking.FindStringInDictionary;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by aysen on 11/23/16.
 */
public class FindStringInDictionaryTest {
    @Test
    public void TestFindStringInDictionary() {
        Character[][] matrix = new Character[][]{
                {'a', 'b', 'c'},
                {'a', 'b', 'c'},
                {'a', 'a', 'c'}
        };
        Assert.assertEquals(FindStringInDictionary.StringInDictionary(matrix, "abc").size(), 3);
    }

}
