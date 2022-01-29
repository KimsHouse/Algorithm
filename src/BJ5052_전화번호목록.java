import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BJ5052_전화번호목록 {
    static String ans = "";

    static class Node {
        HashMap<Character, Node> childNode = new HashMap<>();
        boolean isEnd;
    }

    static class trie{
        Node rootNode = new Node();

        void insert(String str){
            Node node = this.rootNode;

            for(int i = 0; i < str.length(); i++){
                //if(node.isEnd) ans = "NO";
                node = node.childNode.computeIfAbsent(str.charAt(i), key -> new Node());
            }
            node.isEnd = true;
        }

        void check(String str){
            Node node = this.rootNode;

            for (int i = 0; i < str.length(); i++) {
                if (node.isEnd) ans = "NO";
                node = node.childNode.getOrDefault(str.charAt(i), null);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());
            List<String> strArr = new ArrayList<>();
            trie tri = new trie();
            ans = "YES";

            for(int n = 0; n < N; n++){
                String str = br.readLine();
                tri.insert(str);
                strArr.add(str);
            }

            for (int i = 0; i < strArr.size(); i++) {
                tri.check(strArr.get(i));
            }

            //System.out.println(ans);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
