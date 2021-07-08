package com.huangjie.dynamicprograming;

import com.huangjie.util.Utils;

/**
 * @author huangjie
 * @version 1.0
 * @description 42. 接雨水
 * @date 2021/7/5 11:14
 */
public class JieYuShui {
    public static void main(String[] args) {
        int[] arr = {4,2,0,3,2,5};
        System.out.println(trap(arr));
    }
    public static int trap(int[] arr) {
        if (arr==null||arr.length<=2) {
            return 0;
        }
        int max = 0;

        int[] heightLeft = Utils.getLeftMaxHeightForArr(arr);
        int[] heightRight = Utils.getRightMaxHeightForArr(arr);

        for (int i = 0; i < arr.length; i++) {
            if (i==0||i==arr.length-1) {
                continue;
            }
            int leftHeight = heightLeft[i-1];
            int rightHeight = heightRight[i+1];
            int height = Math.min(leftHeight, rightHeight);
            if (height>arr[i]){
                max += height - arr[i];
            }
        }
        return max;
    }



}
