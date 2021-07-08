package com.huangjie.dynamicprograming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangjie
 * @version 1.0
 * @description 118. 杨辉三角
 * @date 2021/7/5 18:34
 */
public class YangHuiSanJiao {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static  List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < i; j++) {
                if (j==0||j==i-1) {
                    list.add(1);
                }else{
                    list.add(result.get(i-2).get(j-1)+result.get(i-2).get(j));
                }
            }
            result.add(list);
        }
        return result;
    }
}
