import java.util.Arrays;

public class InputGanerator {
    public static void main(String[] args) {
        int genNum = 50;
        int minSize = 2;
        int maxSize = 6;

        StringBuilder sb = new StringBuilder();
//      int[] N = new int[genNum];
        char[][] map=null;
        while(genNum>0) {
            int N = (int)(Math.random()*(maxSize-1))+minSize;
            int M = (int)(Math.random()*(maxSize-1))+minSize;
            int[] schoolPosition = new int[] {(int)(Math.random()*N),(int)(Math.random()*M)};
            int[] constructionPosition = new int[] {(int)(Math.random()*N),(int)(Math.random()*M)};
            if((schoolPosition[0]==0&&schoolPosition[1]==0) ||
                    (schoolPosition[0]==N-1&&schoolPosition[1]==M-1) ||
                    (constructionPosition[0]==0&&constructionPosition[1]==0) ||
                    (constructionPosition[0]==N-1&&constructionPosition[1]==M-1) ||
                    (schoolPosition[0]==constructionPosition[0]&&schoolPosition[1]==constructionPosition[1])) {
                continue;
            }
            System.out.println("schoolPosition : "+Arrays.toString(schoolPosition));
            System.out.println("constructionPosition : "+Arrays.toString(constructionPosition));
            System.out.println("--------------------------------------");
            map = new char[N][M];
            for(int j=0; j<N; j++) {
                Arrays.fill(map[j], '#');
            }
            sb.append(N+" "+M+"\n");
            map[0][0]='S';
            map[schoolPosition[0]][schoolPosition[1]]='A';
            map[constructionPosition[0]][constructionPosition[1]]='X';
            map[N-1][M-1]='H';
            for(int j=0; j<N; j++) {
                for(int k=0; k<M; k++) {
                    sb.append(map[j][k]);
                }
                sb.append("\n");
            }
            sb.append("\n");
            genNum--;
        }
        for(int i=0; i<genNum; i++) {

        }
        System.out.print(sb);
    }
}