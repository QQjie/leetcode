package com.huangjie.dynamicprograming;

import com.huangjie.util.Utils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/**
 * @author huangjie
 * @version 1.0
 * @description 22. 括号生成
 * 32. 最长有效括号
 * @date 2021/7/5 9:30
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        String str = "())";
        System.out.println(longestValidParentheses(str));
    }

    public void parenthesis(String[] left, String[] right, List<String> list) {


        for (int i = 0; i < left.length; i++) {
            Deque<String> queue = new ArrayDeque<String>();
            queue.push(left[i]);

        }

    }


    public static int longestValidParentheses(String s) {
        if (s==null||s.length()==1||"".equals(s)) {
            return 0;
        }
        String[] arr = Utils.getStrArr(s);
        int[] maxMatchLength = getMaxMatchLength(arr);
        int max = Integer.MIN_VALUE;
        for (int i : maxMatchLength) {
            max = Math.max(max,i);
        }

        return max;
    }


    /**
     * dp 获取必须以index结尾的有效子串的长度
     * @param arr 数组
     * @return dp[]
     */
    public static int[] getMaxMatchLength(String[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                result[0] = 0;
            } else {
                if (")".equals(arr[i]) && (i - result[i - 1] - 1) >= 0 && "(".equals(arr[i - result[i - 1] - 1])) {
                    result[i] = result[i - 1] + 2 + ((i - result[i - 1] - 2) < 0 ? 0 : result[i - result[i - 1] - 2]);
                } else {
                    result[i] = 0;
                }

            }
        }
        return result;
    }


}
