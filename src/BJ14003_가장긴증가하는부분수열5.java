import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ14003_가장긴증가하는부분수열5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N]; // 초기 배열
        int[] index = new int[N]; // 수열의 길이를 담을 배열
        ArrayList<Integer> list = new ArrayList<>();

        list.add(Integer.MIN_VALUE); // 최초의 비교값을 위한 초기화

        tk = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){ // 값을 넣으면서 비교하기
            int val = arr[i] = Integer.parseInt(tk.nextToken()); //비교를 위한 val 변수

            if(list.get(list.size()-1) < val) { // 최초의 비교값을 넣어두었음을 인지 / 리스트의 가장 마지막 값과 val을 비교
                list.add(val); // list의 마지막 값(이전값) 보다 val값이 더 크면 리스트에 넣음
                index[i] = list.size() - 1; // 현재 비교한 인덱스의 위치에 현재 리스트 길이-1(연속된 부분 수열의 길이)를 넣어줌

            } else { // val값이 더 작을경우
                int idx = binary(val, 1, list.size()-1, list); // 이분탐색으로 현재 val값의 들어갈 인덱스 위치를 찾아옴
                list.set(idx, val); // 찾아온 인덱스 위치를 val값으로 새로 갱신해줌
                index[i] = idx; // 현재 비교한 인덱스의 위치에 현재 이분탐색에서 리턴된 값을 넣어줌
            }

//            System.out.println("list : "+list);
//            System.out.println("arr :"+Arrays.toString(arr));
//            System.out.println("index : "+Arrays.toString(index));
//            System.out.println();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int LIS = list.size()-1; // 최종 가장 긴 부분수열의 길이

        sb.append(LIS).append("\n");

        for(int i = N-1; i >= 0; i--){ // 스택에 담기 위해 뒤에서부터 비교함
            if(index[i] == LIS) { // 현재 저장된 부분 수열의 길이가 가장 긴 부분수열의 길이(가변적)과 같다면
//                System.out.println(index[i]+" "+LIS);
//                System.out.println(arr[i]);
                stack.push(arr[i]); // 스택에 담고
                LIS--; // 가장 긴 부분수열의 길이를 -1
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);

    }

    private static int binary(int target, int start, int end, ArrayList<Integer>list){
        //System.out.println("hi");
        while(start < end){
            int mid = (start+end) / 2;
//            System.out.println("mid : "+mid);
//            System.out.println(list.get(mid));
            if(list.get(mid) < target) { // target이 list(mid)위치의 값보다 크다면
                start = mid + 1; // start를 밀고
            }
            else end = mid; // 아니면 end에 mid 값을 넣어줌

        }
        return end;
    }
}
