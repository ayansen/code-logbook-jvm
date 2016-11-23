package algorithm.backtracking;

import algorithms.backtracking.ResolveWildcardCharacter;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by aysen on 11/23/16.
 */
public class ResolveWildcardCharacterTest {

    @Test
    public void TestResolveWildcardCharacter() {
        String wildcardString = "01?01";
        ResolveWildcardCharacter resolveWildcardCharacter = new ResolveWildcardCharacter();
        Assert.assertEquals(resolveWildcardCharacter.resolveWildcards(wildcardString).size(), 2);
    }
}
