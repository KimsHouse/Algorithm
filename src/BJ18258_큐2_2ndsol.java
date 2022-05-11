import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Q {
    private int[] queue;
    private int start;
    private int end;

    public Q(int size) {
        this.queue = new int[size];
        this.start = 0;
        this.end = 0;
    }

    public void push(int n){
        this.queue[end++] = n;
    }

    public int pop(){
        if(start>=end) return -1;
        else return queue[start++];
    }

    public int size(){
        return end-start;
    }

    public int isEmpty(){
        if(start==end) return 1;
        else return 0;
    }

    public int front() {
        if(start==end) return -1;
        else return queue[start];
    }

    public int back() {
        if(start==end) return -1;
        else return queue[end-1];
    }


}

public class BJ18258_큐2_2ndsol {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
//        Deque<String> queue = new LinkedList<>();
//        List<String> queue = new ArrayList<>();
        Q queue = new Q(N);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            if(str[0].equals("push")){
                queue.push(Integer.parseInt(str[1]));
            } else if(str[0].equals("pop")){
                sb.append(queue.pop()+"\n");
            } else if(str[0].equals("size")){
                sb.append(queue.size()+"\n");
            } else if(str[0].equals("empty")) {
                sb.append(queue.isEmpty()+"\n");
            } else if(str[0].equals("front")) {
                sb.append(queue.front()+"\n");
            } else if(str[0].equals("back")) {
                sb.append(queue.back()+"\n");
            }
        }

        System.out.println(sb);
    }


}
