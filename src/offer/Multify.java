package offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ��Ŀ����
 * ����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],
 * ����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]������ʹ�ó�����
 */
public class Multify {
    public int[] multiply(int[] A) {
        if (A == null || A.length <= 1) {
            return A;
        }
        int[] B = new int[A.length];
        Arrays.fill(B, 1);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                B[i] *= (i == j ? 1 : A[j]);
            }
        }
        return B;
    }

    public int[] multiply2(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if (length != 0) {
            B[0] = 1;
            // �����ǵļ��㣬��������
            for (int i = 1; i < length; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            // �����ǵļ��㣬��������
            int temp = 1;
            for (int i = length - 2; i >= 1; i--) {
                temp *= A[i + 1];
                B[i] *= temp;
            }

        }
        return B;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Multify().multiply(new int[]{1, 2, 3, 4, 5})));
    }
}
