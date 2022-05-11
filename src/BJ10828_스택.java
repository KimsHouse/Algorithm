import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class stack {
    private int top;
    private int[] arr;

    public stack(int size) {
        this.top = -1;
        this.arr = new int[size];
    }

    public void push(int n) {
        this.arr[++top] = n;
    }

    public int pop() {
        if(top == -1) return -1;
        else return this.arr[top--];
    }

    public int size() {
        return this.top+1;
    }

    public int isEmpty() {
        if(top == -1) return 1;
        else return 0;
    }

    public int top() {
        if(top == -1) return -1;
        else return arr[top];
    }

}

public class BJ10828_스택 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
//        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        stack stack = new stack(N);

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");

            if(str[0].equals("push")){
                stack.push(Integer.parseInt(str[1]));
            } else if(str[0].equals("pop")) {
                sb.append(stack.pop()+"\n");
            } else if(str[0].equals("size")) {
                sb.append(stack.size()+"\n");
            } else if(str[0].equals("empty")){
                sb.append(stack.isEmpty()+"\n");
            } else if(str[0].equals("top")){
                sb.append(stack.top()+"\n");
            }
        }
        System.out.println(sb);
    }
}
