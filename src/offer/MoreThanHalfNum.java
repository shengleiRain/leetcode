package offer;

/**
 * ��Ŀ����
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 * ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}����������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2��
 * ��������������0��
 * <p>
 * �ⷨ��
 * 1, ���������е�һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬��ô�����ȱ���һ��array����¼�µ�һ��λ��Ϊprev������ֵcount=1��
 * ��index=1��ʼ��ÿ��������prev�Ƚϣ������ͬ����count++���������ͬ����count--����count����0�󣬾ͽ�prev��ֵ��ֵΪ��ǰ���֣�
 * ���ҽ�count=1��
 * 2�����ڲ�һ���������������֣����ԣ���Ҫ����һ��array���õ���prevֵ�ĸ������������һ�룬�򷵻�prev������Ϊ0
 */
public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int count = 1, prev = array[0];
        for (int i = 1; i < array.length; i++) {
            if (prev == array[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    prev = array[i];
                    count = 1;
                }
            }
        }

        int prevCount = 0;
        if (count > 0) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == prev) {
                    prevCount++;
                }
            }
        }


        return 2 * prevCount > array.length ? prev : 0;

    }
}
