package offer;

/**
 * ��Ŀ����
 * ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�
 * ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish������������ȴ������������˼��
 * ���磬��student. a am I������������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ���ȷ�ľ���Ӧ���ǡ�I am a student.����
 * Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
 */
public class ReverseSentence {
    public String ReverseSentence(String str) {
        if (str == null || str.trim().equals("")) {
            return str;
        }
        String[] splits = str.split(" ");
        for (int i = 0; i < splits.length / 2; i++) {
            String temp = splits[i];
            splits[i] = splits[splits.length - i - 1];
            splits[splits.length - i - 1] = temp;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < splits.length; i++) {
            builder.append(splits[i]);
            if (i != splits.length - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseSentence().ReverseSentence("student. a am I"));
    }
}
