import java.util.Scanner;

public class BJ11047_동전0 {
    static int N, money, count = 987654321;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        money = sc.nextInt();
        int[] coin = new int[N];
        for (int n = N-1; n >= 0; n--) {
            int m = sc.nextInt();
            coin[n] = m;
        }

        for (int i = 0; i < N; i++) {
            int moneytmp = money;
            int moneycount = 0;
            for (int j = i; j < N; j++) {
                if(moneytmp < coin[j]) continue;
                moneycount += moneytmp / coin[j];
                moneytmp = moneytmp % coin[j];
//                System.out.println("curr coin : "+coin[j]);
//                System.out.println("mc : "+moneycount);
//                System.out.println("mt : "+moneytmp);
//                System.out.println();
            }
            if(count > moneycount) count = moneycount;
        }
        System.out.println(count);
    }
}
