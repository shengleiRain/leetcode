package offer;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * ��Ŀ����
 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ����Ϊ��ջ�ĵ���˳��
 * ����ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳������4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
 * ��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
 */
public class PopOrder {

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length != popA.length) {
            return false;
        }
        int length = pushA.length;
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        for (int pop : popA) {
            if (stack.isEmpty() || stack.peek() != pop) {
                while (pushIndex < length) {
                    if (pushA[pushIndex] == pop) {
                        pushIndex++;
                        break;
                    } else {
                        stack.push(pushA[pushIndex++]);
                    }
                }
                if (pushIndex == length) {
                    return false;
                }

            } else {
                stack.pop();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PopOrder().IsPopOrder(new int[]{}, new int[]{}));

    }
}
