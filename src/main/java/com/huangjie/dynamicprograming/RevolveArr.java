package com.huangjie.dynamicprograming;

import com.huangjie.util.Utils;

/**
 * @author huangjie
 * @version 1.0
 * @description 48. 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * @date 2021/7/6 8:38
 */
public class RevolveArr {
    public static void main(String[] args) {
        int[][] arr = getArr(4);
        Utils.printArr(arr);

        int[][] ints = revolveArr(arr);

        Utils.printArr(ints);
    }

    public static int[][] getArr(int n) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = n * i + j + 1;
            }
        }
        return result;
    }

    public static int[][] revolveArr(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        //起始位置到右下角位置
        int startRow = 0;
        int startColumn = 0;
        int endRow = arr.length - 1;
        int endColumn = arr[0].length - 1;

        while (startRow < endRow && startColumn < endColumn) {
            int tmp = 0;
            for (int i = startRow; i < endColumn; i++) {
                tmp = arr[startRow][i];
                arr[startRow][i] = arr[endRow - i][startRow];
                arr[endRow - i][startRow]=arr[endRow - startRow][arr.length-i-1];
                arr[endRow - startRow][arr.length-i-1] = arr[i][endRow - startRow];
                arr[i][endRow - startRow] = tmp;
            }
            startRow++;
            startColumn++;
            endColumn--;
            endRow--;
        }
        return arr;
    }


}
