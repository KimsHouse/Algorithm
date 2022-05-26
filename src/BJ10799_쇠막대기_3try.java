import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ10799_쇠막대기_3try {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bars = br.readLine();
        Stack<Character> stack = new Stack<>();

        int result = 0;
        int curr = 0;
        boolean flag = false;

        for (int i = 0; i < bars.length(); i++) {
            char val = bars.charAt(i);
//            System.out.println("curr : "+val);

            if(val == '(') {
                stack.push(val);
                result += 1;
//                System.out.println("stack -> "+stack.size());
                flag = true;
            } else {
                if(flag) {
                    stack.pop();
//                    System.out.println("size : "+stack.size());
                    result--;
                    result += stack.size();
//                    System.out.println("razer -> "+result);
                    flag = false;
                }
                else stack.pop();
            }

        }

        System.out.println(result);

    }
}
