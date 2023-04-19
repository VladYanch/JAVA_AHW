import java.util.Arrays;

public class Coordinates {

    public static void main(String[] args) {
        int[] xy = new int[] {3,5};
        System.out.println(Arrays.toString(xy));
        System.out.println(Arrays.toString(getCoord(xy, "UU")));
        System.out.println(Arrays.toString(getCoord(xy, "RRD")));
    }

    private static int[] getCoord(int[] xy , String s) {
        String str = s.toUpperCase();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'R') xy[0]++;
            if (str.charAt(i) == 'L') xy[0]--;
            if (str.charAt(i) == 'U') xy[1]++;
            if (str.charAt(i) == 'D') xy[1]--;
        }
        return xy;
    }
}
