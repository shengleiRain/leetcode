package offer;

/**
 * ��Ŀ����
 * ��һ���ַ���ת����һ������(ʵ��Integer.valueOf(string)�Ĺ��ܣ�����string����������Ҫ��ʱ����0)��
 * Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0��
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
