import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ9202_Boggle {
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    static class Node {
        Map<Character, Node> child = new HashMap<>();
        boolean isEnd;
    }

    static class Trie {
        Node rootNode = new Node();

        void insert(String str){
            Node node = this.rootNode;

            for (int i = 0; i < str.length(); i++) {
                node = node.child.computeIfAbsent(str.charAt(i), key -> new Node());
                //System.out.println(node.child);
            }
            node.isEnd = true;
        }

        boolean check(String str){
            Node node = this.rootNode;

            for (int i = 0; i < str.length(); i++) {
                node = node.child.getOrDefault(str.charAt(i), null);

                if(node == null) return false;
                //System.out.println(node.child);
            }
            if(node.isEnd) return true;
            else return false;
        }
    }

    static class SaveStr {
        int score;
        String word;
        int count;
    }

    static SaveStr saveStr = new SaveStr();
    static Trie trie = new Trie();
    //static String containCheck;
    static Set<String> set;

    static int count;
    static int score;
    static PriorityQueue<String> pQ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int n = 0; n < N; n++){
            String str = br.readLine();
            trie.insert(str);
        }
        br.readLine();
        int M = Integer.parseInt(br.readLine());

        for(int m = 0; m < M; m++){

            char[][] board = new char[4][4];

            for (int i = 0; i < 4; i++) {
                String str = br.readLine();
                for (int j = 0; j < 4; j++) {
                    board[i][j] = str.charAt(j);
                }
            }

//            containCheck = "";
            set = new HashSet<>();
            count = 0;
            score = 0;
            pQ = new PriorityQueue<>((a, b) -> b.length()-a.length());


            for (int k = 0; k < 4; k++) {
                for (int j = 0; j < 4; j++) {
                    for (int i = 1; i <= 8; i++) {
                        pickWord(board, 0, new char[i], new boolean[4][4], i, k, j);
                    }
                }
            }
            String s = pQ.poll();
            if(s == null) s = "";

            sb.append(score+" ").append(s).append(count).append("\n");
            //System.out.println(score+" "+pQ.poll()+" "+count);
            if(m != M-1)br.readLine();
        }
        System.out.println(sb);
    }

    private static void pickWord(char[][] board, int curr, char[] selected, boolean[][] visited, int escape, int r, int c){

        Queue<int[]> queue = new LinkedList<>();
        visited[r][c] = true;
        queue.offer(new int[] {r, c});
        while(!queue.isEmpty()) {
            //Map<String, Integer> count = new HashMap<>();
            if (curr == escape) { // 최대 8자
                String str = String.valueOf(selected);
                if(trie.check(str)){
                    int setSize = set.size();
                    set.add(str);
                    if(setSize != set.size()) {
                        score += checkScore(str);
                        count++;
                        pQ.offer(str+" ");
                    }
                }
                return;
            }

            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];

            for (int d = 0; d < 8; d++) {
                int sx = x + dx[d];
                int sy = y + dy[d];

                if(sx < 0 || sx >= 4 || sy < 0 || sy >= 4 || visited[sx][sy]) continue;

                visited[sx][sy] = true;
                selected[curr] = board[sx][sy];
                pickWord(board, curr+1, selected, visited, escape, sx, sy);
                visited[sx][sy] = false;

            }

        }
    }

    private static int checkScore(String str) {
        int score = 0;

        switch (str.length()){
            case 1:
            case 2:
                score = 0;
                break;
            case 3:
            case 4:
                score = 1;
                break;
            case 5:
                score = 2;
                break;
            case 6:
                score = 3;
                break;
            case 7:
                score = 5;
                break;
            case 8:
                score = 11;
                break;
        }

        return score;
    }
}
