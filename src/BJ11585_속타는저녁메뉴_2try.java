import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11585_속타는저녁메뉴_2try {
    static int N, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk1;
        StringTokenizer tk2;

        N = Integer.parseInt(br.readLine());
        char[] dolimpan = new char[N*2];
        char[] answer = new char[N];
        char[] result = new char[N*2];
        StringBuilder sb = new StringBuilder();

        tk1 = new StringTokenizer(br.readLine()," ");
        tk2 = new StringTokenizer(br.readLine()," ");

        for (int i = 0; i < N; i++) {
            char c = tk1.nextToken().charAt(0);
            char c2 = tk2.nextToken().charAt(0);
            dolimpan[i] = c;
            dolimpan[N+i] = c;
            answer[i] = c2;
            //System.out.println((N+i));
        }

        String p = String.valueOf(answer[0]);
//        int[] num = makeArr(answer);
//
//        System.out.println(Arrays.toString(num));

        kmp(dolimpan, answer);
//        System.out.println(N);
        int g = gcd(cnt, N);
        int a = cnt / g;
        int b = N / g;
//        System.out.println(cnt);
        sb.append(a).append("/").append(b);
        System.out.println(sb);
//        //System.out.println(Arrays.toString(answer));
    }

    private static int gcd(int cnt, int length) {
       while( cnt != 0) {
           int res = length % cnt;

           length = cnt;
           cnt = res;
       }
        return length;
        //System.out.println(length+" "+cnt);
    }

    private static void kmp(char[] dolimpan, char[] pat) {
        //char[] answer = pattern.toCharArray();

        int[] arr = makeArr(pat);
//        String dol = new String(dolimpan);
//        String p = new String(pat);


        System.out.println(Arrays.toString(arr));
        int j = 0;
        for (int i = 0; i < dolimpan.length; i++) {
            while (j > 0 && dolimpan[i] != pat[j]) j = arr[j-1];
            if(dolimpan[i] == pat[j]) {
                if(j == pat.length-1 && (i-pat.length+2) <= N){
                    System.out.println("어디야 : "+(i-pat.length+2));
//                    //System.out.println("hi");
//                    String strchk = "";
//
//                    StringBuilder sb = new StringBuilder();
//
//                    int fir = i-answer.length+1;
//
//                    sb.append(dol.substring(fir, dolimpan.length)).append(dol.substring(0, fir));
//
//                    if(p.contentEquals(sb)) cnt++;
//
                    cnt++;
                    j = arr[j];
                }
                else j++;
            }

        }
    }

    private static int[] makeArr(char[] answer) {
        int[] num = new int[answer.length];

        int j = 0;
        for (int i = 1; i < answer.length; i++) {
            while (j > 0 && answer[i] != answer[j]) j = num[j-1];
            if(answer[i] == answer[j]) num[i] = ++j;
        }
        return num;
    }
}
