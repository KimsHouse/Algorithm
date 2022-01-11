package Algorithm;

import java.util.Arrays;

public class kmptest {

    public static void main(String[] args) {
        String str = "ababacabacaabacaaba";
        String str2 = "abacaaba";
        String[] stable = new String[str.length()];
        String[] ptable = new String[str2.length()];

        int[] num = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            stable[i] = String.valueOf(str.charAt(i));
        }

        for (int i = 0; i < str2.length(); i++) {
            ptable[i] = String.valueOf(str.charAt(i));
        }

        int j = 0;

        for (int i = 0; i < str.length(); i++) {
            while(j > 0 && str.charAt(i) != str2.charAt(j)) { // 일치하는 부분까지 돌아감
                System.out.println(" j : "+j);
                System.out.println("num[j-1] : "+num[j-1]);
                System.out.println("i : "+i);
                j = num[j-1];

            }
                //num[i] = 0;
                //j = 0;
            if(stable[i].equals(ptable[j])) {
                if(j == str2.length()-1) { // 문자열이 전부 일치할 경우
                    System.out.println("i : "+i);
                    System.out.println("str2.len : "+str2.length());
                    System.out.println("res : "+(i-str2.length()));
                    j = num[j];
                } else {
                    num[i] = ++j;
                }

            }
        }

        System.out.println(Arrays.toString(num));
    }
}
