import sun.security.rsa.RSAUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2263_트리의순회 {
    static class Node {
        char[] list;
        int mid;

        public Node(char[] list, int mid) {
            this.list = list;
            this.mid = mid;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int N = Integer.parseInt(br.readLine());

        char[] In;
        boolean[] visited = new boolean[N];
        //char[] Post = new char[N];

        In = br.readLine().replaceAll(" ","").toCharArray();
        br.readLine().replaceAll(" ","").toCharArray();

        //Node node = new Node(In, N/2);

        //findPreOrder(In, N/2);
        binary(In, 0, N, visited);

    }

    private static void findPreOrder(char[] list, int mid) {
        System.out.println("mid : "+mid);
        System.out.println("mid/2 : "+mid/2);
        System.out.print(list[mid]+" ");

        if(list.length == 1) return;
        char[] left = new char[mid];
        char[] right = new char[mid];



        System.arraycopy(list, 0, left, 0, mid/2);
        System.arraycopy(list, mid/2, right, 0, mid);

        findPreOrder(left, mid/2);
        findPreOrder(right, list.length-1);

    }

    private static void binary(char[] list, int start, int end, boolean[] visited){
        int mid = (start + end) / 2;

        if(visited[mid]) return;
        System.out.print(list[mid]+" ");
        visited[mid] = true;

        binary(list, start, mid, visited);
        binary(list, mid, end, visited);
        //return list[mid];

    }
}
