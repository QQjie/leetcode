package com.huangjie.dynamicprograming.ship;

/**
 * @author huangjie
 * @version 1.0
 * @description 221. 最大正方形
 * @date 2021/7/6 15:11
 */
public class MaxSquare {
    public static void main(String[] args) {
        char[][] matrix = {{'0', '0'}, {'0', '0'}};
        System.out.println(maximalSquare(matrix));
    }

    public static int maximalSquare(char[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        if (matrix.length == 1) {
            for (int i = 0; i < matrix[0].length; i++) {
                if ('1' == (matrix[0][i])) {
                    return 1;
                }
            }
            return 0;
        }
        if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length; i++) {
                if ('1' == (matrix[i][0])) {
                    return 1;
                }
            }
            return 0;
        }
        int maxLength = 0;
        int width = matrix.length;
        int height = matrix[0].length;

        for (int i = 0; i < width; i++) {

            if ((width - i) < maxLength) {
                break;
            }
            for (int j = 0; j < height; j++) {

                int maxLength2 = 0;

                if ((height - j) < maxLength) {
                    break;
                }
                if ('1' == (matrix[i][j])) {
                    maxLength2++;
                    int width1 = i + 1;
                    int height1 = j + 1;
                    while (width1 < width && height1 < height && '1' == (matrix[width1][height1])) {
                        boolean flag = true;
                        for (int start = i; start < width1; start++) {
                            if ('1' != (matrix[start][height1])) {
                                flag = false;
                            }
                        }
                        for (int start2 = j; start2 < height1; start2++) {
                            if ('1' != (matrix[width1][start2])) {
                                flag = false;
                            }
                        }
                        if (!flag) {
                            break;
                        }
                        maxLength2++;
                        width1++;
                        height1++;
                    }
                }
                maxLength = Math.max(maxLength, maxLength2);
            }
        }

        return  (int) Math.pow(maxLength, 2);
    }
}
