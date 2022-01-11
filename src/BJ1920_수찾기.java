import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1920_수찾기 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer tk;

            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            tk = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(tk.nextToken());
            }

            Arrays.sort(arr);
            int M = Integer.parseInt(br.readLine());
            tk = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < M; i++) {
                int t = Integer.parseInt(tk.nextToken());
                int result = binary(arr, 0, N-1, t);
                System.out.println(result);
                //System.out.println();
            }

            //int result = binary(0, 12-1, data);
            //if(result != -1) System.out.println(result+"번째에 있습니다");
        }

        private static int binary(int[] arr, int start, int end, int target){
            int mid;
            while(start <= end){
                //System.out.println(start+" <= "+end);
                mid = (start + end) / 2;
                //System.out.println("mid : "+mid);

                //System.out.println(arr[mid]+" == "+target);
                if(arr[mid] == target) return 1;
                else if(arr[mid] < target){
                    start = mid + 1;
                    //System.out.println("start : "+start);
                } else if(arr[mid] > target){
                    end = mid - 1;
                    //System.out.println("end : "+end);
                }
                //System.out.println();
            }
            return 0;
        }
    }

