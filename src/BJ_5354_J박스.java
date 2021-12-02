import java.util.Scanner;

public class BJ_5354_J박스 {
    static int N;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextByte();

        for(int n = 0; n < N; n++){
            int k = sc.nextInt();

            make(k);
            System.out.println();
        }
    }

    private static void make(int k) {
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= k; j++) {
                if(i == 1 || j == 1 || i == k || j == k) System.out.print("#");
                else System.out.print("J");
            }
            System.out.println();
        }
    }
}
