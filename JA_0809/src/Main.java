public class Main {
    public static void main(String[] args) {
        System.out.println(getFactorial(5));
    }
    //сделать рекурсивное получение всех подмножеств из инт массива

    public static int getFactorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        return getFactorial(num - 1) * num;
    }



}