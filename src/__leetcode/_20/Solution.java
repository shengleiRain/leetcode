package __leetcode._20;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Rain on 2019/5/28.
 */
public class Solution {
    public static boolean isValid(String s) {
        if (s==null || s.length()==0) return true;
        char[] arr=s.toCharArray();
        Stack<Character> stack=new Stack<>();
        for (char ch : arr) {
            switch (ch){
                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;
                case '}':
                    if (stack.isEmpty()||stack.pop()!='{') return false;
                    break;
                case ']':
                    if (stack.isEmpty()||stack.pop()!='[') return false;
                    break;
                case ')':
                    if (stack.isEmpty()||stack.pop()!='(') return false;
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        if (s==null || s.length()==0) return true;
        HashMap<Character,Character> map = new HashMap<>();
        Stack<Character> stack=new Stack<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)){
                if (!stack.isEmpty()&&stack.peek()==map.get(ch)){
                    stack.pop();
                }else{
                    return false;
                }
            }else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        String str="{}";
        System.out.println(isValid(str));


    }
}
