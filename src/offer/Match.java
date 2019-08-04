package offer;

/**
 * 题目描述
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
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
        // 顺利都到达末尾，那么返回true
        if (str.length == strIndex && pattern.length == patternIndex) {
            return true;
        }
        // pattern到了末尾，而str还没有
        if (str.length != strIndex && pattern.length == patternIndex) {
            return false;
        }

        // 如果第二个字符为'*'
        if (patternIndex < pattern.length - 1 && pattern[patternIndex + 1] == '*') {
            // 下一个字符为'*'，那么分为下面三种情况
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) ||
                    (pattern[patternIndex] == '.' && strIndex != str.length)) {// 第一个字符匹配
                return helper(str, pattern, strIndex, patternIndex + 2) ||//pattern后移2位，str不动，匹配0个
                        helper(str, pattern, strIndex + 1, patternIndex + 2) ||//匹配一个字符
                        helper(str, pattern, strIndex + 1, patternIndex);//'*'匹配多个，接着递归
            } else {
                return helper(str, pattern, strIndex, patternIndex + 2);
            }
        }

        // 第二个字符不为'*'
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
