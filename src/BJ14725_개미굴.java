import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ14725_개미굴 {
    static class Node {
        Map<String, Node> childNode = new TreeMap<>();
        boolean isEnd;
    }

    static class trie {
        Node rootNode = new Node();

        void insert(List<String> str){
            Node node = this.rootNode;
            for(int i = 0; i < str.size(); i++){
                node = node.childNode.computeIfAbsent(str.get(i), key -> new Node());
            }
            node.isEnd = true;
        }

        void check(){
            Node node = this.rootNode;
            String space = "";
            StringBuilder sb = new StringBuilder();
            output(node, space, sb);
            System.out.println(sb);
        }

        void output(Node node, String space, StringBuilder sb){
            PriorityQueue<String> queue = new PriorityQueue<>();

            for (String s : node.childNode.keySet()){
                queue.offer(s);
            }

            for(Node n : node.childNode.values()){
                sb.append(space).append(queue.poll()).append("\n");
                output(n, space+"--", sb);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
        int T = Integer.parseInt(br.readLine());
        trie tri = new trie();

        for(int t = 0; t < T; t++){

            tk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(tk.nextToken());
            ArrayList<String> strArr = new ArrayList<>();
            while(tk.hasMoreTokens()){
                String s = tk.nextToken();
                strArr.add(s);
            }
            tri.insert(strArr);
        }
        tri.check();
    }
}
