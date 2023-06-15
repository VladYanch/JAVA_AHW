
/**
 * Найти сумму всех значений(int) в Map<String, Integer>, которые соответствуют заданному ключевому набору.
 *      * public static int calculateSum(Map<String, Integer> inputMap, String[] keys)
 */

import java.util.LinkedHashMap;
import java.util.Map;

public static int calculateSum(Map<String, Integer> inputMap, String[] keys){
        int sum = 0;
        for (int i = 0; i < keys.length; i++) {
        if (inputMap.containsKey(keys[i])){
        sum += inputMap.get(keys[i]);
        }
        }
        return sum;
        }

/**
 * Проверить, все ли значения в Map<Integer, Boolean> равны true.
 * @param inputMap
 * @return
 */
public static boolean allValuesTrue(Map<Integer, Boolean> inputMap){
        int count = 0;
        for (Map.Entry<Integer, Boolean> entryValue : inputMap.entrySet()) {
        if (!entryValue.getValue()){
        return false;
        }
        }
        return true;
        }

/**
 * Проверить, содержит ли Map<String, Integer> хотя бы одну запись, у которой значение больше заданного порога.
 *      * public static boolean hasValueAboveThreshold(Map<String, Integer> inputMap, int threshold)
 * @param inputMap
 * @param threshold
 * @return
 */
public static boolean hasValueAboveThreshold(Map<String, Integer> inputMap, int threshold){
        for (Map.Entry<String, Integer> entry : inputMap.entrySet()) {
        if (entry.getValue() > threshold){
        return true;
        }
        }
        return false;
        }

/**
 * 1. Найти все ключи в Map<String, Integer>, соответствующие заданному значению, и вернуть их в виде списка.
 *      * public static List<String> findKeys(Map<String, Integer> inputMap, int targetValue)
 * @param map
 * @param target
 * @return
 */
public static List<String> findKeys (Map<String, Integer> map, int target){
        List<String> keys = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
        if (entry.getValue() == target){
        keys.add(entry.getKey());
        }
        }
        return keys;
        }

public class CT2 {
    public static void main(String[] args) {
        Map<Integer, Boolean> map = new LinkedHashMap<>();
        map.put(1, true);
        map.put(2, true);
        map.put(8, false);
        map.put(3, false);
        map.put(4, true);
        map.put(5, true);
        map.put(6, false);
        map.put(7, false);

        Map<String, Integer> map1 = new LinkedHashMap<>();
        map1.put("hello", 2);
        map1.put("bye", 3);
        map1.put("ded", 3);
        map1.put("baba", 5);
        map1.put("mama", 2);
        map1.put("papa", 2);
        System.out.println(calculateSum(map1, new String[]{"ded", "mama", "papa"}));

//        System.out.println(findKeys(map, 3));
//        System.out.println(hasValueAboveThreshold(map, 4));

        System.out.println(allValuesTrue(map));


    }
}