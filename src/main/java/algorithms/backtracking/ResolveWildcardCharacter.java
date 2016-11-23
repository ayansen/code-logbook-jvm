package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aysen on 11/3/16.
 */
public class ResolveWildcardCharacter {


    public List<String> resolveWildcards(String wildcardString) {

        List<String> resolvedStrings = new ArrayList<>();
        if (wildcardString != null && !wildcardString.isEmpty()) {
            resolveWildcardsRecursively(wildcardString, "", resolvedStrings);
        }
        return resolvedStrings;
    }


    private void resolveWildcardsRecursively(String wildcardString, String pathTraversed, List<String> resolvedStrings) {


        char firstCharacter = wildcardString.charAt(0);


        if (wildcardString.length() == 1) {
            if (firstCharacter == '?' ) {
                resolvedStrings.add(pathTraversed + "1");
                resolvedStrings.add(pathTraversed + "0");
            } else {
                resolvedStrings.add(pathTraversed + firstCharacter);
            }
        } else {


            if (firstCharacter == '?' ) {
                resolveWildcardsRecursively(wildcardString.substring(1, wildcardString.length()), pathTraversed.concat("1"), resolvedStrings);
                resolveWildcardsRecursively(wildcardString.substring(1, wildcardString.length()), pathTraversed.concat("0"), resolvedStrings);
            } else {
                resolveWildcardsRecursively(wildcardString.substring(1, wildcardString.length()), pathTraversed + firstCharacter, resolvedStrings);
            }
        }
    }
}
