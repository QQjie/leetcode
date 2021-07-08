package com.huangjie.util;

/**
 * @author huangjie
 * @version 1.0
 * @description
 * @date 2021/7/5 11:10
 */
public class Utils {
    /**
     * 字符串转数组
     *
     * @param str 字符串参数
     * @return 数组
     */
    public static String[] getStrArr(String str) {
        String[] arr = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.substring(i, i + 1);
        }
        return arr;
    }

    /**
     * 获取数组从左到右(左右都包含)的最大高度
     *
     * @param arr   数组参数
     * @param left  左起点
     * @param right 右终点
     * @return 返回最大高度
     */
    public static int getMaxValueForArr(int[] arr, int left, int right) {
        int max = Integer.MIN_VALUE;
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("param is invalid");
        }
        if (left > right || arr.length < right + 1 || left < 0) {
            throw new RuntimeException("param is invalid");
        }
        if (left == right) {
            return arr[right];
        }

        for (int index = left; index <= right; index++) {
            max = Math.max(arr[index], max);
        }
        return max;
    }


    /**
     * 获取0到index的左侧最大高度
     *
     * @param arr 参数
     * @return 最大高度宿主
     */
    public static int[] getLeftMaxHeightForArr(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                result[0] = arr[0];
                continue;
            }
            result[i] = Math.max(result[i - 1], arr[i]);
        }
        return result;
    }

    /**
     * 从index到arr.length-1的最大高度
     *
     * @param arr 参数
     * @return 右侧的最大高度
     */
    public static int[] getRightMaxHeightForArr(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i > 0; i--) {
            if (i == arr.length - 1) {
                result[i] = arr[i];
                continue;
            }
            result[i] = Math.max(result[i + 1], arr[i]);
        }
        return result;
    }

    public static void printArr(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int row = arr.length;
        int column = arr[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


}
