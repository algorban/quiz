package main.java;

/**
 * Created by root on 1/18/2016.
 * return highest product of 3 integers from given array
 * {1, -10, 2, -10, 5, -7} -> 500 (-10*-10*5)
 * O(n)
 */
public class HighestProduct {

    public static void main(String[] args) {
        int[] array = new int[]{1, -10, 2, -10, 5, -7};
        System.out.println(highestProduct(array));
    }

    public static int highestProduct(int[] arrayOfInt) {
        int[] max = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        int[] min = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};

        for(int i=0; i<arrayOfInt.length; i++) {
            addMax(max, arrayOfInt[i]);
            addMin(min, arrayOfInt[i]);
        }

        return Math.max(max[2]*max[1]*max[0], min[0]*min[1]*max[2]);
    }

    //todo use max and min heaps instead of plain array.
    private static void addMax(int[] max, int value) {
        if(value > max[0]) {
            int i= max.length-1;
            while(i>-1 && value < max[i]) i--;
            if(i>-1) {
                int tmp = max[i];
                max[i] = value; i--;
                while(i>=0) {
                    int tmp2 = max[i];
                    max[i] = tmp;
                    tmp = tmp2;
                    i--;
                }
            }
        }
    }

    private static void addMin(int[] min, int value) {
        if(value < min[0]) {
            int i= min.length-1;
            while(i>-1 && value > min[i]) i--;
            if(i>-1) {
                int tmp = min[i];
                min[i] = value; i--;
                while(i>=0) {
                    int tmp2 = min[i];
                    min[i] = tmp;
                    tmp = tmp2;
                    i--;
                }
            }
        }
    }
}
