import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ14725_개미굴_ans {

    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stz;
        Trie trie = new Trie("");
        Trie node;
        sb = new StringBuilder();

        while(n --> 0) {
            stz = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(stz.nextToken());
            node = trie;

            while(k --> 0) {
                String name = stz.nextToken();
                int index = -1;

                for(int i = 0; i < node.list.size(); i++) {
                    if(node.list.get(i).name.equals(name)) {
                        index = i;
                        break;
                    }
                }

                if(index == -1) {
                    node.list.add(new Trie(name));
                    node = node.list.get(node.list.size()-1);
                }
                else {
                    node = node.list.get(index);
                }
            }
        }

        print(trie, -1);
        System.out.println(sb.toString());
    }

    public static void print(Trie trie, int depth) {
        Collections.sort(trie.list, new Comparator<Trie>() {
            @Override
            public int compare(Trie o1, Trie o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        if(depth != -1) {
            for(int i = 0; i < depth; i++) {
                sb.append("--");
            }
            sb.append(trie.name).append("\n");
        }

        for(Trie tr : trie.list) {
            print(tr, depth+1);
        }
    }

    static class Trie{
        ArrayList<Trie> list;
        String name;

        Trie(String name) {
            list = new ArrayList<>();
            this.name = name;
        }
    }
}