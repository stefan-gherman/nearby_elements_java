import java.util.Arrays;
public class NearbyElements {


    private static int[][] multi = new int[][]{
            {2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323},
            {1, 3, 5, 7},
            {321, 320, 32, 3, 41241, -11, -12, -13, -66, -688},
            {1}
    };


    public static int[] nearby(int x, int y, int range) {
        int i;
        int size = 0;
        int minIndex;
        int maxIndex;
        int currentPosition = 0;


        if (multi[x].length == 1) {
            int[] neighbours = new int[]{};
            return neighbours;
        }

        if (y + range > multi[x].length) {

            if (y == 0) {
                maxIndex = multi[x].length - 1;
                size = maxIndex;
            } else {
                maxIndex = multi[x].length;
                size = maxIndex - y;
            }
        } else {
            maxIndex = y + range;
            size = range;
        }

        if (y - range < 0) {
            minIndex = 0;

            if (y != 0) {
                if (y == multi[x].length - 1) {
                    size = y;
                }
                else {
                    size += range - y;
                }
            }
        } else {
            minIndex = y - range;
            size += range;
        }

//        System.out.println(String.format("maxIndex: %s; minIndex: %s; size: %s", maxIndex, minIndex, size));
        int[] neigbours = new int[size];

        if (y != 0) {
            for (i = minIndex; i < y; i++) {
                neigbours[currentPosition] = multi[x][i];
                currentPosition += 1;
            }
        }

        if (y != multi[x].length - 1) {
            for (i = y + 1; i <= maxIndex; i++) {
                neigbours[currentPosition] = multi[x][i];
                currentPosition += 1;
            }
        }
//        for (i = 0; i < neigbours.length; i++) {
//            System.out.print(String.format("%s, ", neigbours[i]));
//        }
//
//        System.out.println();
//        System.out.println();
        return neigbours;


    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(nearby(1, 0, 1)));
        System.out.println(Arrays.toString(nearby(1, 3, 5)));
        System.out.println(Arrays.toString(nearby(0, 2, 2)));
        System.out.println(Arrays.toString( nearby(3, 0, 15)));
        System.out.println(Arrays.toString(nearby(0, 0, 15)));
        System.out.println(Arrays.toString(nearby(2, 9, 200)));


    }
}