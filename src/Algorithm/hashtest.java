package Algorithm;

import java.util.HashSet;
import java.util.Set;

public class hashtest {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();

        hashSet.add("하늘");
        hashSet.add("구름");
        hashSet.add("달");

        for (String str : hashSet){
            System.out.println(str);
        }
        System.out.println(hashSet.iterator().next());

        while(!hashSet.isEmpty()){

        }
    }
}
