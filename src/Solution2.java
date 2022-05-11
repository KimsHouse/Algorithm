import java.util.*;

class Solution2 {

    static int[] progresses = {93, 30, 55};
    static int[] speeds = {1, 30, 5};

    public static void main(String[] args){

        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();

        for(int i=0; i<progresses.length; i++){
            System.out.println("-------");
            System.out.println((100-progresses[i])%speeds[i]);
            System.out.println((100-progresses[i])/speeds[i]);
            System.out.println(((100-progresses[i])/speeds[i] + 1));
            System.out.println((100-progresses[i])%speeds[i] == 0 ? (100-progresses[i]) : ((100-progresses[i])/speeds[i] + 1));
            q.add((100-progresses[i])%speeds[i] == 0 ? (100-progresses[i])/speeds[i] : ((100-progresses[i])/speeds[i] + 1));
        }

        int start = q.poll();
        int cnt = 1;
        while(!q.isEmpty()){
            int next = q.poll();

            if(start >= next){
                System.out.println("start : "+start+" next : "+next);
                cnt++;
            }else{
                result.add(cnt);
                start = next;
                cnt = 1;

            }
        }
        result.add(cnt);

        int[] answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = result.poll();
        }

    }
}