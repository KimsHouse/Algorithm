import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test3 {
    public static int[] origin;
    public static ArrayList<int[]> temp;
    public static int test = -1;
    //순열로 풀고, 방문 처리. (permu, visited)

    //현재 보고 있는 값과 이전값을 비교해야됨. visited[]에서 확인해야됨.

    // 순열일 시에, 데이터 다 저장하고, 비교해.
    public static void permu(int N, int M, int[] numbers, boolean[] visited) {
        if (N == M) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        test = -1;
        for (int i = 0; i < visited.length; i++) {
            if (test == origin[i] || visited[i]) {
                continue;
            }
                visited[i] = true;
                test = origin[i];
                numbers[N] = origin[i];
                permu(N + 1, M, numbers, visited);
                visited[i] = false;

        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        temp = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        origin = new int[N];
        st= new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(origin);
        // System.out.println(Arrays.toString(origin));
        permu(0, M, new int[N], new boolean[N]);
        System.out.println(sb);
    }
}