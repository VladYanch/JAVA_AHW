import java.util.*;

public class Main {

    public static void main(String[] args) {
//        char[][] c = {{'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}};
//        String s1 = "SEES";
//        String s2 = "ABCB";
//        System.out.println(exist(c, s2));

//        String inp = "abbaca";
//        System.out.println(removeDup(inp));
//
        String[] s = {"cat", "hat", "bat"};
        String a = "ctathab";
        System.out.println(includeChar(s, a));
        a = "ctathabthab";
        System.out.println(includeChar(s, a));
    }

    /**
     * String[] s = {"cat", "hat", "bat"}
     * String a = "ctathab"
     */

    public static List<String> includeChar(String[] s, String str) {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> mapStr = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
                mapStr.merge(str.charAt(i), 1, Integer::sum);
        }
        Map<Character, Integer> temp = new HashMap<>(mapStr);
        boolean skip = false;
        for (String word : s) {
            for (int i = 0; i < word.length(); i++) {
                if (mapStr.containsKey(word.charAt(i))) {
                    if (temp.get(word.charAt(i)) <= 0) {
                        skip = true;
                        temp = new HashMap<>(mapStr);
                        continue;
                    }
                    temp.merge(word.charAt(i), -1, Integer::sum);
                }
            }
            if (!skip) {
                result.add(word);
                skip = false;
            }
            mapStr = new HashMap<>(temp);
        }
        return result;
    }

    // String inp = "abbaca";
    //abbaca -> a__aca -> aaca -> __ca -> ca
    // String output = "ca";
    // String s1 = "yanmmnap"
    // String f = "yp"
    //ищем повторы пока они есть
    //преобразуем стрингу

    private static String removeDup(String s) {
        String result = s;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                if (i == 1) {
                    result = removeDup(s.substring(i + 1, s.length()));
                } else {
                    result = removeDup(s.substring(0, i - 1) + s.substring(i + 1, s.length()));
                }
                break;
            }
        }
        return result;
    }

    private static boolean exist(char[][] chars, String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                map.merge(chars[i][j], 1, Integer::sum);
            }
        }

        for (int i = 0; i < word.length(); i++) {
            map.merge(word.charAt(i), -1, Integer::sum);
        }
        return map.values().stream().noneMatch(v -> v < 0);
    }

}