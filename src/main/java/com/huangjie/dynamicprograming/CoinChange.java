package com.huangjie.dynamicprograming;

/**
 * @author huangjie
 * @version 1.0
 * @description 322. 零钱兑换
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 你可以认为每种硬币的数量是无限的。
 * @date 2021/7/1 14:46
 */
public class CoinChange {

    public static void main(String[] args) {
        int result = 0;
        int[] arr = {1, 2, 5};
        int amount = 11;
        result = getMinCountCompile(arr, 2, amount);
        System.out.println(result);
    }

    /**
     * 如果要求一共有多少种组合
     *
     * @param arr   coin 数组
     * @param index 当前数组小标
     * @param rest  剩余钱
     */
    public int getAllCompile(int[] arr, int index, int rest) {
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;

        for (int count = 0; arr[index] * count <= rest; count++) {
            ways += getAllCompile(arr, index + 1, rest - (arr[index] * count));
        }
        return ways;
    }

    /**
     * 获取最少钱张数的结果
     *
     * @param arr   coin 数组
     * @param index 当前数组小标
     * @param rest  剩余钱
     */
    public static int getMinCountCompile(int[] arr, int index, int rest) {

        //每种硬币最多个数
        if (rest % arr[index] == 0) {
            return (rest / arr[index]);
        }
        int perMaxCount = rest / arr[index];
        if (perMaxCount <= 0) {
            return getMinCountCompile(arr, index - 1, rest);
        }

        for (int count = perMaxCount; arr[index] * count <= rest; count--) {
            int result = perMaxCount + getMinCountCompile(arr, index - 1, rest - (arr[index] * count));
            if (rest == 0) {
                return result;
            }
        }
        return -1;
    }

    public int coinChange(int[] coins, int amount) {
        return 0;
    }
}
