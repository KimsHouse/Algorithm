import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1764_듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        tk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        Set<String> hashSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            hashSet.add(br.readLine());
        }

//        List<String> strList = new ArrayList<>();
//        for (int i = 0; i < M; i++) {
//            int hSize = hashSet.size();
//            String name = br.readLine();
//            hashSet.add(name);
//            if(hSize == hashSet.size()) strList.add(name);
//        }

         // hashset에 contains가 있었음
            ArrayList<String> strList = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                String name = br.readLine();
                if(hashSet.contains(name)){
                    strList.add(name);
                }
            }


        System.out.println(strList.size());
        Collections.sort(strList);
        for (int i = 0; i < strList.size(); i++) {
            System.out.println(strList.get(i));
        }
    }
}
