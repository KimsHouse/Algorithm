import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ1541_잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = Integer.MAX_VALUE;	// 초기 상태 여부 확인을 위한 값으로 설정
        String[] subtraction = br.readLine().split("-");

        for (int i = 0; i < subtraction.length; i++) {
            int value = 0;
            String[] add = subtraction[i].split("\\+");

            for(int j = 0; j < add.length; j++){
                value += Integer.parseInt(add[j]);
            }

            if(sum == Integer.MAX_VALUE) sum = value;
            else sum -= value;
        }

        System.out.println(sum);

    }
}
