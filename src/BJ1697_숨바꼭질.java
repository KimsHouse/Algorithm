import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ1697_숨바꼭질 {
    static class Subin{
        int X;
        int count;

        public Subin(int x, int count) {
            X = x;
            this.count = count;
        }

        public int getX() {
            return X;
        }

        public int getCount() {
            return count;
        }
    }
    static int N, K;
    static int[] rane = new int[100001];
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        rane[N] = 1; // 수빈
        rane[K] = 2; // 동생

        findBro(N);

    }

    private static void findBro(int n) {
        Queue<Subin> queue = new LinkedList<>();
        queue.offer(new Subin(n, 0));
        visited[n] = true;
        while (!queue.isEmpty()){
            Subin s = queue.poll();
            int subin = s.getX();
            int cnt = s.getCount();

            //System.out.println("현재 수빈 위치 "+subin);
            if (subin == K) {
                System.out.println(cnt);
                return;
            }

            if(subin-1 >= 0 && !visited[subin-1]) {
                //System.out.println("수빈이 -1 "+(subin-1));
                visited[subin-1] = true;
                queue.offer(new Subin(subin-1, cnt+1));
            }
            if(subin+1 <= 100000 && !visited[subin+1]) {
                //System.out.println("수빈이 +1 "+(subin+1));
                visited[subin+1] = true;
                queue.offer(new Subin(subin+1, cnt+1));
            }
            if(subin*2 <= 100000 && !visited[subin*2]){
                //System.out.println("수빈이 *2 "+(subin*2));
                visited[subin*2] = true;
                queue.offer(new Subin(subin*2, cnt+1));
            }
        }
    }
}
