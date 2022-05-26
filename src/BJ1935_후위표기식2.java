import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ1935_후위표기식2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str =  br.readLine();
        double[] arr = new double[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();

        double result = 0;
        for (int i = 0; i < str.length(); i++) {
            if('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
                stack.push(arr[str.charAt(i)-'A']);
            } else {
                if(!stack.isEmpty()){
                    double first = stack.pop();
                    double second = stack.pop();
                    switch (str.charAt(i)) {
                        case '+':
                            result = second + first;
                            stack.push(result);
                            continue;
                        case '-':
                            result = second - first;
                            stack.push(result);
                            continue;
                        case '*':
                            result = second * first;
                            stack.push(result);
                            continue;
                        case '/':
                            result = second / first;
                            stack.push(result);
                            continue;

                    }
                }
            }
        }

        System.out.printf("%.2f", result);
    }
}
