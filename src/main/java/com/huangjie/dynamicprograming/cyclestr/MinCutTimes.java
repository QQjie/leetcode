package com.huangjie.dynamicprograming.cyclestr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangjie
 * @version 1.0
 * @description
 * @date 2021/7/6 12:20
 */
public class MinCutTimes {
    public static void main(String[] args) {
        String str = "11112";

        minCut3(str);



    }

    public static int minCut3(String s){
        int[] minCycleLength = getMinCycleLength(s.toCharArray());

        System.out.println(minCut2(minCycleLength));
        return 0;
    }

    public static int minCut2(int[] arr) {
        int count = 0;
        int lastIndex = arr.length - 1;

        while (lastIndex>=0){
            if (arr[lastIndex]==1){
                lastIndex--;
            }else {
                lastIndex -= arr[lastIndex];
            }
            count++;
        }
        return count;
    }

    public static int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        char[] arr = s.toCharArray();
        List<Integer> list = new ArrayList<Integer>();
        dp(arr, 0, 0, list);
        for (Integer integer : list) {
            System.out.println(integer);
        }

        return 0;
    }

    /**
     * 以index结尾的最小回文串长度
     * @return index[]
     */
    public  static int[] getMinCycleLength(char[] arr){
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i==0) {
                result[i] = 1;
                continue;
            }


        }
        return result;
    }


    public static void dp(char[] arr, int index, int count, List<Integer> result) {
        if (index == arr.length - 1 || check(arr, index, arr.length-1)) {
            result.add(count);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (check(arr, index, i)) {
                count++;
                dp(arr, i + 1, count, result);
            }
        }
    }


    public static boolean check(char[] chars, int start, int end) {
        while (start < end) {
            if (!(chars[start] == chars[end])) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
