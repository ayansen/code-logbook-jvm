package dp;

import java.util.List;

/**
 * Created by aysen on 11/1/16.
 */
public class PrintStringInDictionary {


    public static int StringInDictionary(char[][] dictionary, String stringToMatch) {

        Integer[][] prefixMap = createPrefixMap(dictionary, stringToMatch);
        int count = 0;

        for (int i = 0; i < dictionary.length; i++) {
            for (int j = 0; j < dictionary[i].length; j++) {
                if (prefixMap[i][j] == stringToMatch.length()) {
                    count++;
                }
            }
        }
        return count;
    }

    private static Integer[][] createPrefixMap(char[][] dictionary, String stringToMatch) {
        Integer[][] prefixMap = new Integer[dictionary.length][dictionary[0].length];
        for (int i = 0; i < dictionary.length; i++) {
            for (int j = 0; j < dictionary[i].length; j++) {
                int indexOfChar = stringToMatch.indexOf(prefixMap[i][j]);
                if (indexOfChar != -1 && findSubstring(stringToMatch.substring(0, indexOfChar), i, j, dictionary)) {
                    prefixMap[i][j] = indexOfChar;
                } else {
                    prefixMap[i][j] = -1;
                }
            }
        }
        return prefixMap;
    }

    private static boolean findSubstring(String subString, int i, int j, char[][] dictionary) {

        if (i > dictionary.length || j > dictionary[i].length) {
            return false;

        }
        char lastCharacter = subString.charAt(subString.length() - 1);

        return (dictionary[i - 1][j] == lastCharacter && findSubstring(subString.substring(0, subString.length() - 1), i - 1, j, dictionary)) ||
                (dictionary[i][j - 1] == lastCharacter && findSubstring(subString.substring(0, subString.length() - 1), i, j - 1, dictionary)) ||
                (dictionary[i + 1][j] == lastCharacter && findSubstring(subString.substring(0, subString.length() - 1), i + 1, j, dictionary)) ||
                (dictionary[i][j + 1] == lastCharacter && findSubstring(subString.substring(0, subString.length() - 1), i, j + 1, dictionary));
    }


}


