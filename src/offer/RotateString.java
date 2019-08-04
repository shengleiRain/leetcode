package offer;

/**
 * 题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
 * 要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它
 */
public class RotateString {
    public String LeftRotateString(String str, int n) {
        if (str.length() <= 1 || n == 0) {
            return str;
        }
        int len = str.length();
        char[] res = new char[len];
        for (int i = 0; i < str.length(); i++) {
            res[(i + (len - n % len)) % len] = str.charAt(i);
        }
        return new String(res);
    }

    public String LeftRotateString2(String str, int n) {
        if (str.length() <= 1 || n == 0) {
            return str;
        }
        int len = str.length();
        char[] chars = str.toCharArray();
        reverse(chars, 0, len - 1);
        int index = len - n % len;
        reverse(chars, 0, index - 1);
        reverse(chars, index, len - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        for (int i = start; i <= (end + start) / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[end + start - i];
            chars[end + start - i] = temp;
        }
    }

    public String LeftRotateString3(String str, int n) {
        if (str.length() <= 1 || n == 0) {
            return str;
        }
        int len = str.length();
        int move = n % len;
        String doubleStr = str + str;
        return doubleStr.substring(move, move + len);
    }

    public static void main(String[] args) {
        System.out.println(new RotateString().LeftRotateString("abcXYZdef", 10));
        System.out.println(new RotateString().LeftRotateString2("abcXYZdef", 10));
        System.out.println(new RotateString().LeftRotateString3("abcXYZdef", 10));
    }
}
