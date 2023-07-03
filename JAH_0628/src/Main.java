import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(Arrays.toString(arr));
        System.out.println("After increment +1");
        System.out.println(Arrays.toString(addNumAsArray(arr))); //[1, 2, 4]
        System.out.println("------------------");

        int[] arr1 = {9,9,9};
        System.out.println(Arrays.toString(arr1));
        System.out.println("After increment +1");
        System.out.println(Arrays.toString(addNumAsArray(arr1))); //[1, 0, 0, 0]
        System.out.println("------------------");

        int[] arr2 = new int[0];
        System.out.println(Arrays.toString(arr2));
        System.out.println("After increment +1");
        System.out.println(Arrays.toString(addNumAsArray(arr2)));
        System.out.println("------------------"); // [1]

        int[] arr3 = {-1,0,9};
        System.out.println(Arrays.toString(arr3));
        System.out.println("After increment +1");
        System.out.println(Arrays.toString(addNumAsArray(arr3))); //Arrays has wrong numbers, new int[]
        System.out.println("------------------");
    }

    public static int[] addNumAsArray(int[] arr) {
        if (arr.length == 0) {
            int[] res = new int[1];
            res[0] = 1;
            return res;
        }

        if (Arrays.stream(arr).anyMatch(num -> num < 0)) {
            System.out.println("Arrays has wrong numbers");
            return new int[0];
        }

        if (Arrays.stream(arr).allMatch(num -> num == 9)) {
            int[] res = new int[arr.length+1];
            res[0] = 1;
            return res;
        }

        for (int i = arr.length-1; i > 0 ; i--) {
            if (arr[i] == 9 ) {
                arr[i] = 0;
            } else {
                arr[i] = arr[i] + 1;
                break;
            }
        }
        return arr;
    }
}

//Task 2*. Дано число, которое задано своими разрядами, расположенными в массиве. Прибавить к этому числу 1.
//        Example 1:
//        Input: digits = [1,2,3]
//        Output: [1,2,4]
//        Explanation: The array represents the integer 123
//        Incrementing by one gives 123 + 1 = 124. Thus, the result should be [1,2,4].