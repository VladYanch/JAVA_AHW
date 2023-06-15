import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CT1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Hello");
        list.add("Mama");
        list.add("Sarah");
        list.add("Artem");
        list.add("Artem");
        list.add("Evg");
        list.add("Java");
        list.add("Java");
        list.add("Hi");
        list.add("Hi");
//        System.out.println(findDup(list));

//        System.out.println(findString(list, "good"));
//        System.out.println(findString(list, "bye"));


        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(2);
        set.add(4);
        set.add(6);
        set.add(1);
        set.add(9);
        set.add(10);
//        System.out.println(sumSet(set));


        List<String> list1 = new ArrayList<>();
        list1.add("Hello");
//        System.out.println(isContains(list1, "He"));

        System.out.println(findCombine(list, set));
        System.out.println(findCombine(list, set).size());
    }


    //Найти все дубликаты в List<String> и вернуть их в виде нового списка.
    public static List<String> findDup(List<String> list) {
        List<String> dupList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {

            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).equals(list.get(i))) {
                    dupList.add(list.get(j));
                }
            }
        }
        return dupList;
    }


    //Проверить, содержит ли List<String> заданную строку
    // и вернуть ее индекс. Если строка не найдена, вернуть -1.
    public static int findString(List<String> list, String str) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(str)) {
                return i;
            }
        }
        return -1;
    }


    //Найти сумму всех элементов в Set<Integer>, которые являются четными числами.

    public static int sumSet(Set<Integer> set) {
        int sum = 0;
        for (int numbers : set) {
            if (numbers % 2 == 0) {
                sum += numbers;
            }
        }
        return sum;
    }
    //Проверить, содержит ли List<String> хотя бы
    // одну строку, которая начинается с заданного префикса.

    // эта штука вернет тру в случае, есть строка просто содержит значение, неважно где
    public static boolean isContains(List<String> list, String prefix) {
        for (String item : list) {
            if (item.contains(prefix)){
                return true;
            }
        }
        return false;
    }
    //Проверить, содержит ли List<String> хотя бы
    // одну строку, которая начинается с заданного префикса.
    public static boolean findDupl(List<String> list, String prefix) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > prefix.length() && list.get(i).substring(0, prefix.length()).equals(prefix)) {
                return true;
            }
        }
        return false;
    }



    //Получить все возможные комбинации из List<String> и Set<Integer>,
    //где каждая комбинация представляет собой строку и число, объединенные вместе.
    public static List<String> findCombine(List<String> list, Set<Integer> set) {
        List<String> listRes = new ArrayList<>();
        for (String str : list) {
            for (Integer num : set) {
                listRes.add(str + num);
            }
        }
        return listRes;
    }

}
