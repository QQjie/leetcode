package com.huangjie.dynamicprograming;

/**
 * @author huangjie
 * @version 1.0
 * @description 45. 跳跃游戏 II
 * @date 2021/7/5 13:38
 */
public class Jump {
    public static void main(String[] args) {
        int[] nums = {2, 9, 6, 5, 7, 0, 7, 2, 7, 9, 3, 2, 2, 5, 7, 8, 1, 6, 6, 6, 3, 5, 2, 2, 6, 3};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        return dp(nums, 0, nums.length - 1, 0);
    }

    /**
     * 从当前节点开始能跳到末尾的最少次数
     *
     * @param nums  数组
     * @param index 当前位置
     * @param rest  剩余路程
     * @return 最少次数
     */
    public static int dp(int[] nums, int index, int rest, int current) {
        if (nums[index] == 0) {
            return Integer.MAX_VALUE;
        }
        if (nums[index] >= rest) {
            return 1;
        }
        int minJumpCount = Integer.MAX_VALUE;

        for (int i = 1; i <= nums[index]; i++) {
            if ((index + i) > nums.length - 1) {
                break;
            }
            minJumpCount = Math.min(dp(nums, index + i, rest - i, current) == Integer.MAX_VALUE ?
                    Integer.MAX_VALUE : dp(nums, index + i, rest - i, current) + 1, minJumpCount);
        }
        return minJumpCount;
    }


    public static void dp2(int[] nums, int index, int start, int end, int[] result) {
        int maxLength = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            Math.max(maxLength, i + nums[start]);
            if (start == 0) {
                result[start] = 0;
                continue;
            }
            result[start] = Math.min(result[start], result[index] + 1);
        }
        dp2(nums, index, index + 1, nums[index], result);
    }


    public boolean canJump(int[] nums) {

        return false;

    }

}
