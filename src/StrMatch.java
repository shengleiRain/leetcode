import java.util.Arrays;

public class StrMatch {
    public static void main(String[] args) {
        System.out.println(match("abcdefff","cdeff"));
    }

    public static boolean match(String str1,String str2){
        for (int i = 0; i < str1.length()-str2.length(); i++) {
            int k = i;
            int j=0;
            while (j<str2.length()){
                if (str1.charAt(k)!=str2.charAt(j)){
                    break;
                }
                j++;
                k++;
            }
            if (j==str2.length()){
                return true;
            }
        }
        return false;
    }
}
