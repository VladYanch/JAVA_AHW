public class Main {
    public static void main(String[] args) {
        int[][] arr = new int[][] {{1,2,5,7,8,4},{9,6,2,8,2}};
        System.out.println(findMaxArray(arr));

        int[] arr1 = new int[] {1,-2,5,7,8,4,9,6,2,8,2};
        System.out.println(findMaxDiff(arr1));

    }

    //2
    public static int findMaxArray(int[][] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) max = arr[i][j];
            }
        }
        return max;
    }

    //3
    public static int findMaxDiff(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length-1; j++) {
                if (Math.abs(arr[i]-arr[j]) > max) max = Math.abs(arr[i]-arr[j]);
            }
        }
        return max;
    }

    //5*
    public static void printSortedSquares2(int[] arr) {
        int minAbs = Integer.MAX_VALUE;
        int minAbsIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            int abs = Math.abs(arr[i]);
            if (abs < minAbs) {
                minAbs = abs;
                minAbsIndex = i;
            }
        }
        int right = minAbsIndex;
        int left = minAbsIndex - 1;
        while (right < arr.length || left >= 0) {
            if (left < 0) {
                System.out.println(arr[right] * arr[right]);
                right++;
                continue;
            }
            if (right == arr.length) {
                System.out.println(arr[left] * arr[left]);
                left--;
                continue;
            }
            if (arr[left] * arr[left] <= arr[right] * arr[right]) {
                System.out.println(arr[left] * arr[left]);
                left--;
            } else {
                System.out.println(arr[right] * arr[right]);
                right++;
            }
        }
    }
}

// 1. Проверить что числа массива находятся в неубывающем порядке.
// 2. Найти максимальный элемент в двумерном массиве.
// 3. Дан массив целых чисел. Нужно найти наибольшую разницу между любыми двумя элементами
// массива
// 4. Найти дубликаты чисел в массиве.
// 5. Дан массив чисел в отсортированном порядке (от меньшему к большему).
// Нужно вывести квадраты этих чисел в отсортированном порядке.