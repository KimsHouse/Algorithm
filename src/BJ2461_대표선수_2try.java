import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2461_대표선수_2try {
    static class Class {
        int cls, value;

        public Class(int cls, int value) {
            this.cls = cls;
            this.value = value;
        }
    }

    static PriorityQueue<Class> pQ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        tk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        List<Class>[] list = new ArrayList[N+1];
        //int[][] list = new int[N][M];

        Class max = new Class(0, -1); // 초기화 값
        pQ = new PriorityQueue<>((a, b) -> a.value-b.value); // 우선순위 큐에 담아 value값으로 정렬 (학생들의 능력치 순서대로)

        for(int n = 1; n <= N; n++){
            tk = new StringTokenizer(br.readLine(), " ");
            list[n] = new ArrayList<>();

            for(int m = 0; m < M; m++) {
                list[n].add(new Class(n, Integer.parseInt(tk.nextToken()))); // 입력값을 list에 담음
            }

            Collections.sort(list[n], (a, b) -> a.value-b.value); // list 역시 value값(학생들 능력치 순서)대로 정렬
            if(max.value < list[n].get(0).value) { // 현재 결정되어 있는 가장 높은 능력치를 가진 학생보다 현재 선택된 학생의 능력치가 높을 경우
//                max.value = list[n].get(0).value;
//                max.cls = list[n].get(0).cls;
                max = list[n].get(0); // 최고 능력치 학생을 갱신(반, 능력치)
            }

            pQ.offer(list[n].get(0)); // 우선순위 큐의 길이는 학급 수이고, N개의 학급 수 중 현재(첫 번째) 최대 능력치로 결정되어 있는 학생들의 순서로 정렬
                                      // N개의 학급 중 대표 학생의 능력치가 가장 낮은 학급의 학생을 뽑기위해 우선순위 큐를 사용
        }

        twoPoint(list, N, M, max);
    }

    private static void twoPoint(List<Class>[] list, int n, int m, Class MAX) {
        int[] idx = new int[n+1]; // 학급을 나타내는 인덱스 배열
        int res = Integer.MAX_VALUE; // 최종 값을 나타내는 변수
        StringBuilder sb = new StringBuilder();

        while(true){
            Class min = pQ.poll(); // 우선순위 큐에서 가장 작은 능력치를 갖는 학생을 뽑아냄
//            System.out.println(MAX.value+" "+min.value);
//            System.out.println("m-n : "+(MAX.value-min.value));
            res = Math.min(res, MAX.value-min.value); // 뽑자마자 최소값 비교 // (이전 계산값, 현재 결정된 최대 능력치 학생 - 현재 결정된 최소 능력치 학생)
//            System.out.println("res : "+res);

            if(idx[min.cls]+1 >= m) break; // 현재 최소 능력치 학생의 반 + 1의 길이가 학급의 학생 수보다 많을 경우 // 탈출조건
//            System.out.println("idx.cls : "+idx[min.cls]);
            idx[min.cls]++; // 최소 능력치 학생의 반에서 다음 학생을 선택하기 위해 학급의 인덱스 순서를 ++

            Class chk = list[min.cls].get(idx[min.cls]); // 이전 최소 능력치 학생의 반에서 다음 학생을 선택
//            System.out.println("chk : "+chk.value);
            pQ.offer(chk); // 우선순위 큐에 넣어 현재 선택된 학생들 중 능력치 순서로 정렬
//
//            System.out.println("min : "+min.value);
//            System.out.println("m v :"+MAX.value+" "+chk.value);

            if(MAX.value < chk.value) { // 선택된 학생이 최대 능력치 학생인지 확인
//                MAX.value = chk.value;
//                MAX.cls = chk.cls;
                MAX = chk; // 현재 최대 능력치 학생을 갱신
            }

            //System.out.println(res);
//            System.out.println(Arrays.toString(idx));
//            System.out.println();
        }

        sb.append(res);
        System.out.println(sb);


    }


}
