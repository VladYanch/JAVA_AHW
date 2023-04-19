import java.util.Arrays;

public class Main {
    /**
     * int[] arr = [-1 0 -9 8 11 -3 1 5]
     * int target = X
     * <p>
     * Найти сумму трех чисел которые в сумме дадут target.
     * Если такого числа нет, то найти сумму трех чисел, сумма которых максимально
     * близка к значению target.
     */

    public static void main(String[] args) {
        int[] arr = {-1, 0, -9, 8, 11, -3, 1, 5};
//      int[] arr = {-9, -3, -1, 0, 1, 5, 8, 11}; //sorted
//        int target = 1; //Exactly = 1 : -9, -1, 11
//        int target = 2; //Exactly = 2 : -9, 0, 11
//        int target = 3; //Exactly = 3 : -9, 1, 11
//        int target = 4; //Exactly = 4 : -9, 5, 8
//        int target = 5; //Exactly = 5 : -3, -3, 11
//        int target = 6; //Exactly = 6 : -3, 1, 8
//        int target = 7; //Exactly = 7 : -9, 5, 11
//        int target = 8; //Exactly = 8 : -3, 0, 11
//        int target = 9; //Exactly = 9 : -3, 1, 11
//        int target = 9; //Exactly = 9 : 0, 8, 1 in not sorted
//        int target = 10; //Exactly = 10 : -9, 8, 11

//        int target = 20; //Exactly = 20 : 1, 8, 11
//        int target = 22; //Target: 22 nearest = 20 : 1, 8, 11
//        int target = 23; //Target: 23 nearest = 24 : 5, 8, 11

//        int target = 25; //Target: 25 nearest = 24 : 5, 8, 11
//        int target = 30; //Target: 30 nearest = 24 : 5, 8, 11

//        int target = -7; //Exactly = -7 : -9, -3, 5
        int target = -15; //Target: -15 nearest = -13 : -9, -3, -1
//        int target = -30; //Target: -30 nearest = -13 : -9, -3, -1

        findSum(arr, target);
    }

    public static void findSum(int[] incArr, int target) {
        int[] res = new int[4];
        int[] arr = Arrays.stream(incArr).sorted().toArray();
//        int[] arr = incArr;
        System.out.println(Arrays.toString(incArr));
        System.out.println(Arrays.toString(arr));

        res[0] = 0;
        int sum = 0;
        int delta = 0;
        res[1] = arr[0];
        res[2] = arr[1];
        res[3] = arr[2];
        sum = res[1] + res[2] + res[3];
        delta = Math.abs(arr[arr.length-1]+arr[arr.length-2]+arr[arr.length-3]);

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i+1; j < arr.length; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    sum = arr[i] + arr[j] + arr[k];
                    if (sum == target) {
                        System.out.println("Exactly = " + target + " : " + arr[i] + ", " + arr[j] + ", " + arr[k]);
                        return;
                    } else if (Math.abs(sum - target) < delta) {
                        res[0] = sum;
                        res[1] = arr[i];
                        res[2] = arr[j];
                        res[3] = arr[k];
                        delta = Math.abs(sum - target);
                    }
                }
            }
        }
        System.out.println("Target: "+target+ " nearest = " + res[0] + " : " + res[1] + ", " + res[2] + ", " + res[3]);
    }
}