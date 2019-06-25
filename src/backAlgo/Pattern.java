package backAlgo;

/**
 * Created by Rain on 2019/6/5.
 */
public class Pattern {
    final char star = '*'; // 任意多个
    final char any = '?'; // 零个或者一个

    private char[] pattern; //正则表达式的字符
    private int patternLen; //正则表达式的长度

    private boolean match = false;

    public Pattern(char[] pattern, int patternLen) {
        this.pattern = pattern;
        this.patternLen = patternLen;
    }

    public boolean isMatch(char[] chs, int len) {
        match = false;
        rmatch(0, 0, chs, len);
        return match;
    }

    private void rmatch(int pIndex, int tIndex, char[] chs, int len) {
        if (match) return;
        if (pIndex == patternLen) {
            // 已经到了正则表达式的末尾
            if (tIndex == len) match = true;
            return;
        }
        switch (pattern[pIndex]) {
            case star:
                for (int i = 0; i < len - tIndex; ++i) {
                    rmatch(pIndex + 1, tIndex + i, chs, len);
                }
                break;
            case any:
                rmatch(pIndex + 1, tIndex, chs, len);
                rmatch(pIndex + 1, tIndex + 1, chs, len);
                break;
            default:
                if (tIndex < len && pattern[pIndex] == chs[tIndex]) {
                    rmatch(pIndex + 1, tIndex + 1, chs, len);
                }
                break;
        }
    }

    public static void main(String[] args) {
        char[] pattenChs = "he*llo?".toCharArray();
        char[] matchText = "helloH".toCharArray();
        Pattern pattern = new Pattern(pattenChs, pattenChs.length);
        boolean matched = pattern.isMatch(matchText, matchText.length);
        System.out.println(matched);
    }
}
