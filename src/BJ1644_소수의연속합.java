import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ1644_소수의연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] prime = new int[N];
        List<Integer> arrPrime = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            if(isPrime(i)) arrPrime.add(i);
        }

        twoPoint(arrPrime, arrPrime.size(), N);

        //System.out.println(arrPrime);
    }

    private static void twoPoint(List<Integer> arr, int N, int target){
        int sum = 0;
        int end = 0;
        int res = 0;

        for(int start = 0; start < N; start++){
            while(sum < target && end < N) {
                sum += arr.get(end);
                end += 1;
            }

            if(sum == target) res++;
            sum -= arr.get(start);
        }

        System.out.println(res);
    }

    private static boolean isPrime(int num){
        for(int i = 2; i*i <= num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
