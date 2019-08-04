package offer;

/**
 * ��Ŀ����
 * ��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ���
 * �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ�����磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��
 */
public class Match {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return helper(str, pattern, 0, 0);
    }

    /**
     *
     */
    public boolean helper(char[] str, char[] pattern, int strIndex, int patternIndex) {
        // ˳��������ĩβ����ô����true
        if (str.length == strIndex && pattern.length == patternIndex) {
            return true;
        }
        // pattern����ĩβ����str��û��
        if (str.length != strIndex && pattern.length == patternIndex) {
            return false;
        }

        // ����ڶ����ַ�Ϊ'*'
        if (patternIndex < pattern.length - 1 && pattern[patternIndex + 1] == '*') {
            // ��һ���ַ�Ϊ'*'����ô��Ϊ�����������
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) ||
                    (pattern[patternIndex] == '.' && strIndex != str.length)) {// ��һ���ַ�ƥ��
                return helper(str, pattern, strIndex, patternIndex + 2) ||//pattern����2λ��str������ƥ��0��
                        helper(str, pattern, strIndex + 1, patternIndex + 2) ||//ƥ��һ���ַ�
                        helper(str, pattern, strIndex + 1, patternIndex);//'*'ƥ���������ŵݹ�
            } else {
                return helper(str, pattern, strIndex, patternIndex + 2);
            }
        }

        // �ڶ����ַ���Ϊ'*'
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) ||
                (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return helper(str, pattern, strIndex + 1, patternIndex + 1);
        } else {
            return false;
        }


    }

    public static void main(String[] args) {
        System.out.println(new Match().match("a".toCharArray(), "ab*a".toCharArray()));
    }
}
