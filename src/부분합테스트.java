import java.io.*;
import java.util.*;

public class 부분합테스트 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long S = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] Narr = new int[N];
        for(int i = 0; i < N; i++){
            Narr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 100001, sum = 0;
        int firstPointer = 0, secondPointer = 0;
        while(true){
            if(sum >= S){
                sum -= Narr[firstPointer++];
                ans = Math.min(ans, (secondPointer - firstPointer) + 1);
                System.out.println("ans : "+ans);
                System.out.println("res : "+(secondPointer-firstPointer));
            }
            else if(secondPointer == N) break;
            else sum += Narr[secondPointer++];
            System.out.println(secondPointer+" "+firstPointer);
            System.out.println("sum : "+sum);
        }
        if(ans == 100001){
            bw.write(0 + "\n");
        } else {
            bw.write(ans + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}