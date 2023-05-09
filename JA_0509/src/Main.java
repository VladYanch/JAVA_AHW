import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] arr1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] arr2 = {{1, 2, 3, 4}, {4, 5, 6, 7}, {9, 8, 9, 6}};
        int[][] arr3 = {{1, 2, 3}, {4, 5, 6}};
        int[] arr4 = {2, 4, 6, 8, 1, 3, 5, 7};
//        System.out.println(minus(arr1));
//        System.out.println(minus(arr2));
//
//        rotate90r(arr1);
//        transpose(arr3);
        System.out.println(Arrays.toString(arr4));
        sortDummy(arr4);
        sort(arr4);
    }
//                 *      * 1 2 3
//                 *      * 4 5 6
//                 *      *
//                 *      * 1 4
//                 *      * 2 5
//                 *      * 3 6
//                 *      */

    /**{2, 4, 6, 8, 1, 3, 5, 7};
     * [2 2 4 6 8 1 1 3 5 7 9]
     * [4 2 5 7] --> [4 5 2 7]
     */

    private static void sortDummy(int[] arr) {
        int[] arrRes = new int[arr.length];
        int index =0;
        for (int i = 0; i < arr.length/2; i++) {
                arrRes[index+i] = arr[i];
                arrRes[index+i+1] = arr[arr.length/2+i];
                index +=1;
            }
        System.out.println(Arrays.toString(arrRes));
    }

    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length/2; i+=2) {
                int temp = arr[i];
                arr[i] = arr[arr.length/2+i-1];
                arr[arr.length/2+i-1]=temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void transpose(int[][] arr ) {
        int[][] arrRes = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arrRes[j][i] = arr[i][j];
            }
        }
            Arrays.stream(arrRes).forEach(x-> System.out.println(Arrays.toString(x)));
    }

    /**
     * 1 2 3 4
     * 4 5 6 7
     * 9 8 9 6
     * 3 6 5 8
     * <p>
     * /**
     * 1 2 3
     * 4 5 6
     * 9 8 9
     * <p>
     * (1 + 5 + 9) - (3 + 5 + 9) =
     *
     *      * ***************

     */
    private static void rotate90r(int[][] arr) {
        int[][] arrRes = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arrRes[i][j] = arr[j][i];
            }
            System.out.println(Arrays.toString(arrRes[i]));
        }
    }
    private static int minus(int[][] arr) {
        if (arr[0].length != arr.length) {
            System.out.println("Not square");
            return 0;
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < arr.length; i++) {
            left  += arr[i][i];
            right += arr[i][arr.length - i - 1];
        }
        return left - right;
    }
}