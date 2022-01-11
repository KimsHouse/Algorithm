package naverCOTE;

public class test4 {
    static class chCard {
        char col;
        int num;

        public chCard(char col, int num) {
            this.col = col;
            this.num = num;
        }
    }

    static int[][] cards = {{10, 5, 15}, {5, 15, 10}, {10, 11, 9}};
    static boolean[] visited;
    public static void main(String[] args) {
        int answer = -1;

        visited = new boolean[cards.length];
        // 1. 교환 상대 지목하기
        for (int i = 0; i < cards.length; i++) { // 교환 신청자
            for (int j = 0; j < cards.length; j++) { // 교환 대상자
                if(visited[j]) continue;
                //exChgCard(i, j);
            }
        }

    }

//    private static void exChgCard(int chg1, int chg2) {
//        chCard c1 = choiceCard(chg1);
//        chCard c2 = choiceCard(chg2);
//    }

//    private static chCard choiceCard(int chg) {
//        int min = Integer.MAX_VALUE;
//        int max = -1;
//        for (int i = 0; i < 3; i++) {
//            //if(min > )
//        }
//    }
}
