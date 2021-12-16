import java.util.Scanner;

public class 순조부 {
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        run(0, new int[M], new boolean[N+1]);
    }

    private static void run(int cnt, int[] selected, boolean[] visited) {

        if(cnt == M){
            for (int i = 0; i < selected.length; i++) {
                System.out.print(selected[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(!visited[i]){
                visited[i] = true;
                selected[cnt] = i;
                run(cnt+1, selected, visited);
                visited[i] = false;
            }
        }
    }
}
