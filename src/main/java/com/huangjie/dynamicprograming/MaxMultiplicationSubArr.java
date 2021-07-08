package com.huangjie.dynamicprograming;

/**
 * @author huangjie
 * @version 1.0
 * @description
 * @date 2021/7/5 19:27
 */
public class MaxMultiplicationSubArr {
    public static void main(String[] args) {

    }

    /**
     * 以index结果的绝对值最大乘积
     * @param nums 数组
     * @return 结果
     */
    public int[] maxProduct(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i==0){
                result[i] = nums[i];
                continue;
            }
            result[i] = result[1];
        }
        return result;
    }
}
