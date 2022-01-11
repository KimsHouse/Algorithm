package Algorithm;

import java.util.Scanner;

public class 등차수열의합 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long sum = ((long) n * (1 + n )) / 2; // 등차수열 합 공식
        System.out.println(sum);
    }
}
