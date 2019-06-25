package __leetcode._032;

import java.util.Stack;

/**
 * Created by Rain on 2019/6/4.
 */
public class Solution {
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int result = 0;
        for (int i=0;i<s.length();i++){
            for (int j = i+2; j <= s.length(); j+=2) {
                if (isValid(s.substring(i,j))){
                    result=Math.max(result,j-i);
                }
            }
        }
        return result;
    }

    private static boolean isValid(String s){
        char[] chs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch: chs){
            if (ch=='('){
                stack.push(ch);
            } else if (!stack.isEmpty() && stack.pop()=='('){
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(()()()()()()())";
        System.out.println(longestValidParentheses(s));
    }
}
