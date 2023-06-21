public class Main {
    public static void main(String[] args) {
//1 уровень сложности: Task 1. Имея два отсортированных массива размера m и n соответственно, вам нужно найти элемент, который будет находиться на k-й позиции в конечном отсортированном массиве.
//    Массив 1 - 100 112 256 349 770
//    Массив 2 - 72 86 113 119 265 445 892
//    к = 7
//    Вывод : 256
//    Окончательный отсортированный массив -
//            72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
//            7-й элемент этого массива равен 256.
//    Массивы приведены для примера. Алгоритм должен работать и на других массивах.
    int[] arr1 = {100, 112, 256, 349, 770};
    int[] arr2 = {72, 86, 113, 119, 265, 445, 892};
    System.out.println(findNum(arr1, arr2, 7)); //256

    int[] arr3 = {100, 112, 115, 354, 589, 967};
    int[] arr4 = {72, 86, 113, 265, 445, 892};
    System.out.println(findNum(arr3, arr4, 8)); //354

    int[] arr5 = {-10, -7, 0, 7};
    int[] arr6 = {-20, -3, 3, 8, 10, 12};
    System.out.println(findNum(arr5, arr6, 5)); //0
    }

    public static int findNum(int[] arr1, int[] arr2, int pos) {
        int res = 0;
        if (pos < 0 && pos > arr1.length+ arr2.length-1) return res;
        int pos1 = 1;
        int pos2 = 1;
        int current = 1;
        while (pos1+pos2 < pos) {
            if (pos1 == arr1.length && pos2 < arr2.length) return res = arr2[pos-pos1-1];
            else if(pos2 == arr2.length && pos1 < arr1.length) return res = arr1[pos-pos2-1];

            if (arr1[pos1] <= arr2[pos2]) { pos1++; current = 1;}
            else { pos2++; current = 2;}
        }
//        current == 1 ? res = arr1[pos1-1] : res = arr2[pos2-1];
            if (current == 1) res = arr1[pos1-1];
            else res = arr2[pos2-1];
        return res;
    }
}