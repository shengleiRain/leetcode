package offer;

/**
 * 题目描述
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 */
public class StrToInt {
    public int StrToInt(String str) {
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }
        char firstCh = str.charAt(0);
        if (str.length() == 1) {
            if (firstCh >= '0' && firstCh <= '9') {
                return firstCh - '0';
            }
        } else {
            int count = 0, result = 0;
            for (int i = str.length() - 1; i >= 1; i--) {
                char ch = str.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    if (firstCh == '-') {
                        result -= Math.pow(10, count) * (ch - '0');
                    } else {
                        result += Math.pow(10, count) * (ch - '0');
                    }
                } else {
                    return 0;
                }
                count++;
            }
            if (firstCh >= '0' && firstCh <= '9') {
                result += Math.pow(10, count) * (firstCh - '0');
            } else if (firstCh != '-' && firstCh != '+') {
                result = 0;
            }
            return result;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new StrToInt().StrToInt("-2147483648"));
    }
}
