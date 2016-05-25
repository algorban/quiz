package main.java;

/**
 * Created by root on 1/14/2016.
 *
 * find max profit from stock prices.
 * O(n)
 *
 * {10, 7, 5, 8, 11, 9} -> 6 (11-5)
 */
public class StockPrice {

    public static void main(String[] args) {
        int[] stockPricesYesterday = new int[]{10, 7, 5, 8, 11, 9};
        System.out.println(getMaxProfit(stockPricesYesterday));
    }

    public static int getMaxProfit(int[] stocks) {
        if(stocks.length<2) throw new IllegalArgumentException("Minimum 2 elements in array required");

        int profit = stocks[1] - stocks[0];
        int min = stocks[0];
        for(int i=1; i< stocks.length; i++) {
            int potential_profit = stocks[i] - min;
            profit = Math.max(potential_profit, profit);
            min = Math.min(stocks[i], min);
        }

        return profit;
    }
}
