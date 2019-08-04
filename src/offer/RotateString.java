package offer;

/**
 * ��Ŀ����
 * �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ�����������
 * ����һ���������ַ�����S���������ѭ������Kλ���������������磬�ַ�����S=��abcXYZdef��,
 * Ҫ�����ѭ������3λ��Ľ��������XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨��
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
