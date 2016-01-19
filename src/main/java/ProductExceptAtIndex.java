package main.java;

/**
 * Created by root on 1/14/2016.
 */
public class ProductExceptAtIndex {

    public static void main(String[] args) {
        int[] arr = new int[] {1,7,0,4};
        int[] result = getProductsOfAllIntsExceptAtIndex(arr);
        printArray(result);
    }

    public static int[] getProductsOfAllIntsExceptAtIndex(int[] arr) {
        int[] result = new int[arr.length];
        result[0] = 1;
        for(int i=1; i< arr.length; i++) {
            result[i] = arr[i-1] * result[i-1];
        }
        int res = 1;
        for(int i=arr.length-1; i>-1; i--) {
            result[i] = result[i]*res;
            res = res*arr[i];
        }
        return result;
    }

    private static void printArray(int[] array) {
        for(int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
