package offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Rain
 * @date 2019/8/6.
 */

/**
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class StringStream {
    char[] chs = new char[256];
    Queue<Character> queue = new LinkedList<>();


    //Insert one char from stringstream
    public void Insert(char ch) {
        if (chs[ch] == 0) {
            queue.add(ch);
        } else {
            if (!queue.isEmpty() && ch == queue.peek()) {
                queue.poll();
            }
        }
        chs[ch] += 1;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {

        while (!queue.isEmpty()) {
            Character poll = queue.peek();
            if (chs[poll] == 1) {
                return poll;
            }
            if (chs[poll] >= 2) {
                queue.poll();
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        StringStream stringStream = new StringStream();
        stringStream.Insert('g');
        System.out.println(stringStream.FirstAppearingOnce());
        stringStream.Insert('o');
        System.out.println(stringStream.FirstAppearingOnce());
        stringStream.Insert('o');
        System.out.println(stringStream.FirstAppearingOnce());
        stringStream.Insert('g');
        System.out.println(stringStream.FirstAppearingOnce());
        stringStream.Insert('l');
        System.out.println(stringStream.FirstAppearingOnce());
        stringStream.Insert('e');
        System.out.println(stringStream.FirstAppearingOnce());


    }
}
