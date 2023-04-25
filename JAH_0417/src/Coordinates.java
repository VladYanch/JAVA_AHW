import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Coordinates {

    public static void main(String[] args) {
        int[] xy = new int[] {5,8};
        System.out.println("Coordinates :" + Arrays.toString(xy));
        System.out.println(Arrays.toString(getCoord(xy, "UU")));
        System.out.println(Arrays.toString(getCoord(xy, "RRD")));
        System.out.println(Arrays.toString(getCoord(xy, "RRUUULldrdRRddLLDuuuUUUUU")));
    }
    private static int[] getCoord(int[] xy , String s) {
        String str = s.toUpperCase();
        Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                map.merge(str.charAt(i),1,Integer::sum);
            }
//        xy[0] = xy[0] + map.get('R')-map.get('L');
//        xy[1] = xy[1] + map.get('D')-map.get('U');
        int right = 0; int left = 0; int up =0; int down = 0;
            if (map.get('R') != null) right = map.get('R');
            if (map.get('L') != null) left = map.get('L');
            if (map.get('D') != null) down = map.get('D');
            if (map.get('U') != null) up = map.get('U');
        xy[0] = xy[0] + right - left;
        xy[1] = xy[1] + down - up;
        return xy;
}
    private static int[] getCoordDoom(int[] xy , String s) {
        String str = s.toUpperCase();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'R') xy[0]++;
            if (str.charAt(i) == 'L') xy[0]--;
            if (str.charAt(i) == 'U') xy[1]--;
            if (str.charAt(i) == 'D') xy[1]++;
        }
        return xy;
    }
}
