package com.huangjie.dynamicprograming.arr;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangjie
 * @version 1.0
 * @description
 * @date 2021/7/7 17:58
 */
public class ValidBracket {
    public static void main(String[] args) {
         List<String> result = generateParenthesis(4);

      //  List<String> result = getAll(0, 1,  "");
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<String>();
        if (n == 0) {
            return list;
        }
        if (n == 1) {
            list.add("()");
            return list;
        }
        List<String> childList1 = generateParenthesis2(n - 1);

        List<String> childList2 = generateParenthesis2(n - 2);

        if (childList1.size() > 0) {
            for (int i = 0; i < childList1.size(); i++) {
                StringBuilder str1 = new StringBuilder("()");
                str1.append(childList1.get(i));
                list.add(str1.toString());

                StringBuilder str2 = new StringBuilder("(");
                str2.append(childList1.get(i));
                str2.append(")");
                list.add(str2.toString());
            }
        }
        if (childList2.size() > 0) {
            for (int i = 0; i < childList2.size(); i++) {
                StringBuilder str = new StringBuilder("()");
                str.append(childList2.get(i));
                str.append("()");
                list.add(str.toString());
            }
        }

        return list;
    }


    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        if (n == 0) {
            return list;
        }
        if (n == 1) {
            list.add("()");
            return list;
        }
        //遍历获取以（），（（），（（（）...开头的所有结果
        for (int i = 1; i <= n; i++) {
            StringBuilder str = new StringBuilder();

            for (int j = 0; j < i; j++) {
                str.append("(");
            }
            str.append(")");

            //剩余（）有效的集合
            List<String> childList = generateParenthesis(n - i);

            if (i==1) {
                for (String s : childList) {
                    list.add(str + s);
                }
            }else {
                //i-1为剩余有效）的个数
                List<String> all = getAll(childList.size(), i-1, str.toString());
                for (String s : all) {
                    StringBuilder stringBuilder = new StringBuilder(str);
                    stringBuilder.append(s);
                    list.add(s);
                }

                //剩余（）有效的集合
                List<String> childList2 = generateParenthesis(n - i-1);


            }

        }
        return list;
    }

    /**
     * 获取所有的（） 和 ） 的有效组合
     *
     * @param n "()"的个数
     * @param m “）”的个数
     * @param root 父串
     * @return 返回结果
     */
    public static List<String> getAll(int n, int m, String root) {
        List<String> list = new ArrayList<String>();
        if (n == 0 || m == 0) {
            StringBuilder rootStr = new StringBuilder(root);
            for (int i = 0; i < n; i++) {
                rootStr.append("()");
            }
            for (int i = 0; i < m; i++) {
                rootStr.append(")");
            }
            list.add(rootStr.toString());
            return list;
        }
        for (int j = 0; j <= m; j++) {
            StringBuilder stringBuilder = new StringBuilder(root);
            for (int i = 0; i < j; i++) {
                stringBuilder.append(")");
            }
            stringBuilder.append("()");
            List<String> all = getAll(n - 1, m - j, stringBuilder.toString());
            list.addAll(all);
        }
        return list;
    }
}
