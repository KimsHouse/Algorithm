import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BJ10799_쇠막대기_2try {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bars = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < bars.length(); i++) {
            stack.push(bars.charAt(i));
        }

        int curr = 0;
        int result = 0;

        while (!stack.isEmpty()){
            char val = stack.pop();
            if(val == ')') {
                if(stack.peek() == ')') {
                    curr++;
                    System.out.println("curr 증가 -> "+curr);
                } else { // 레이저
                    result += (curr);
                    stack.pop();
                    System.out.println("curr*2 + reslut -> "+result);
                }
                if(stack.isEmpty()) break;
            } else {
                if (stack.isEmpty()){
                    break;
                }
                else if(stack.peek() == '(') {
                    curr--;
                    System.out.println("curr 감소 -> "+curr);
                } else if(stack.peek() == ')') {
                    result += 1;
                    System.out.println("result + 1 -> "+result);
                }
            }
            System.out.println("peek -> "+stack.peek());
            System.out.println("curr -> "+val);
        }

        System.out.println(result);


    }
}
