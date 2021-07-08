package com.huangjie.dynamicprograming;

/**
 * @author huangjie
 * @version 1.0
 * @description
 * @date 2021/7/5 18:54
 */
public class MaiGuPiao {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int[] ints = maxProfitDf(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public int maxProfit(int[] prices) {

        return 0;
    }

    public static int[] maxProfitDf(int[] prices) {

        int currentMin = prices[0];
        int[] result = new int[prices.length];
        result[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            if (currentMin>=prices[i]) {
                result[i] = 0;
                currentMin = prices[i];
                continue;
            }
            if (i+1>prices.length-1) {
                result[i] = prices[i] - currentMin;

                continue;
            }
            if (prices[i]<prices[i+1]) {
                continue;
            }
            result[i] = prices[i] - currentMin;
            currentMin = prices[i+1];

        }

        return result;
    }
}
