import java.util.Scanner;

public class BJ5585_거스름돈 {
    static final int[] coin = {500, 100, 50, 10, 5, 1};
    static final int thousand = 1000;
    static int min = 987654321;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int payment = sc.nextInt();
        
        for (int i = 0; i < coin.length; i++) {
            int change = thousand - payment;
            int result = 0;
            for (int j = i; j < coin.length; j++) {
                if(change < coin[j]) continue;
                //System.out.println("계산하려는 코인 : "+coin[j]);
                //System.out.println("현재 계산금액 : "+change);
                result += change/coin[j];
                //System.out.println("거스름돈 수 : "+result);
                change %= coin[j];
                //System.out.println(change);
            }
            if(min > result) min = result;
        }


        System.out.println(min);
    }
}
