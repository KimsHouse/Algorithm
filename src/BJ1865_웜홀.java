import java.util.Arrays;
import java.util.Scanner;

public class BJ1865_웜홀 {

        static class Bus {
            int u;
            int v;
            int val;

            public Bus(int u, int v, int val) {
                this.u = u;
                this.v = v;
                this.val = val;
            }
        }

        static int N, M, maxValue = Integer.MAX_VALUE;
        static Bus[] e;
        static long[] dist;
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            N = sc.nextInt();
            M = sc.nextInt();

            e = new Bus[M];

            for (int i = 0; i < M; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int v = sc.nextInt();

                e[i] = new Bus(x, y, v);
            }

            dist = new long[N+1];
            Arrays.fill(dist, maxValue);

            if(bellman(1)){
                System.out.println("No");
            } else {
                for (int i = 2; i <= N; i++) {
                    if(dist[i] == maxValue) System.out.println("No");
                    else System.out.println("Yes");
                }
            }

        }

        private static boolean bellman(int start) {
            dist[start] = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int r = e[j].u;
                    int c = e[j].v;
                    int val = e[j].val;

                    System.out.println("e[j].u : "+e[j].u);
                    System.out.println("e[j].v : "+e[j].v);
                    System.out.println("e[j].val : "+e[j].val);
                    System.out.println();

                    if(dist[r] == maxValue) continue;

                    if(dist[c] > dist[r] + val) {
                        dist[c] = dist[r] + val;
                        if (i == N - 1)
                            return true;

                    }
                }
            }
            return false;
        }


    }

