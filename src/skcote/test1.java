package skcote;

public class test1 {
    static int money = 4578, min = 987654321;
    static int[] cost = {1, 5, 10, 50, 100, 500};
    //static int[] costs = {1, 4, 99, 35, 50, 1000};
    static int[] costs = {2, 11, 20, 100, 200, 600};
    public static void main(String[] args) {

        Solution();

    }

    private static void Solution() {

        int answer = 0;

        int res = 0;
        int reb = 0;
        int mb = money;
        int ms = money;
        int currb = 0;
        int currs = 0;

        for (int i = 5; i >= 0 ; i--) {
            if(costs[i] > cost[i]) {// 생산단가가 화폐가치보다 크면
                currb = mb / cost[i];
                reb += costs[i] * currb;
                mb = mb % cost[i];
            }

            // 생산단가가 화폐가치보다 낮을 때
            currs = ms / cost[i];
            res += costs[i] * currs;
            reb += costs[i] * currs;
//            System.out.println(ms+" / "+cost[i]+" = "+(ms / cost[i]));
            System.out.println(cost[i]+" 사용개수 : "+currs);
            System.out.println();
            ms = ms % cost[i];

            System.out.println("남은 비용 : "+ms);
            System.out.println("작사용 비용 : "+res);
            System.out.println("큰사용 비용 : "+reb);
            System.out.println();
        }


    }
}
