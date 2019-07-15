package offer;

/**
 * @author Rain
 * @date 2019/7/15.
 * -------------------------------------------------------------------------------------------------------
 * 替换空格
 * -------------------------------------------------------------------------------------------------------
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * -------------------------------------------------------------------------------------------------------
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                res.append("%20");
            } else {
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }
}
