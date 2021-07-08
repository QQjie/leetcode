package com.huangjie.dynamicprograming;

/**
 * @author huangjie
 * @version 1.0
 * @description  53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @date 2021/7/5 16:21
 */
public class MaxSubArray {
    public static void main(String[] args) {

    }

    /**
     * 返回最大子数组的和，遍历数组得以每个index结尾的最大子数组和
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums==null||nums.length==0) {
            return 0;
        }
        if (nums.length==1) {
            return nums[0];
        }
        int max = nums[0];
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (result[i-1]<0) {
                result[i] = nums[i];
                max = Math.max(result[i], max);
            }else{
                result[i] = nums[i]+result[i-1];
                max = Math.max(result[i], max);
            }
        }
        return max;
    }
}
