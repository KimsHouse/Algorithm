package Algorithm;

import java.util.Arrays;

public class kmptest2 {
    public static void main(String[] args) {
        String str = "ababacabacaabacaaba";
        String pat = "abacaaba";

        kmp(str, pat);

    }

    private static void kmp(String str, String pat) {
        int[] num = makeTable(pat);
        char[] parent = str.toCharArray();
        char[] pattern = pat.toCharArray();

        int j = 0;
        for (int i = 0; i < parent.length; i++) {
            while(j > 0 && parent[i] != pattern[j]){
                j = num[j-1];
            }

            if(parent[i] == pattern[j]){
                if(j == pattern.length-1){
//                    System.out.println("i : "+i);
//                    System.out.println(Arrays.toString(parent));
//                    System.out.println(Arrays.toString(pattern));
//                    System.out.println("pat.len : "+pattern.length);
                    System.out.println((i-pattern.length+2));
//                    System.out.println();
                    j = num[j];
                }
                else {
                    j++;
                }

            }
        }
        //System.out.println(Arrays.toString(num));
    }

    private static int[] makeTable(String pat) {
        char[] pattern = pat.toCharArray();
        int[] num = new int[pattern.length];

        int j = 0;
        for (int i = 1; i < pattern.length; i++) {
            while(j > 0 && pattern[i] != pattern[j]) {
                j = num[j-1];
            }

            if(pattern[i] == pattern[j]) {
                num[i] = ++j;
            }
        }
        return num;
    }


}
