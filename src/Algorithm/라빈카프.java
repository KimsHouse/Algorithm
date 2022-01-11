package Algorithm;

public class 라빈카프 {
    public static void main(String[] args) {
        String parent = "ababacabacaabacaaba";
        String pattern = "abacaaba";
        //rabinkarp(parent, pattern);
        System.out.println();
        rabinkarp2(parent, pattern);
    }

    public static void rabinkarp2(String parent, String pattern) {
        int prSize = parent.length();
        int ptSize = pattern.length();

        long prHash = 0, ptHash = 0, power = 1; // 제곱수

        for (int i = 0; i <= prSize-ptSize; i++) { // 한 칸씩 밀면서 패턴 문자열과 부모 문자열(패턴길이만큼) 계산하므로
            if(i == 0){
                for (int j = 0; j < ptSize; j++) {
                    prHash = (prHash + (parent.charAt(ptSize-1-j)) * power); // 각 위치의 해쉬값을 만듬
                    ptHash = (ptHash + (pattern.charAt(ptSize-1-j)) * power);

                    System.out.println(prHash+" "+ptHash);
                    if(j < ptSize - 1) { // 패턴의 길이만큼 해쉬값이 계산이 안되었다면
                        System.out.print("power bf af : "+power+" ");
                        power *= 2; // 2의 제곱
                        System.out.println(power);
                        //power = (power%MOD * 31) % MOD;
                    }
                }
            } else {
                //ptHash = 2 * (prHash - parent[i - 1] * power) + parent[ptSize - 1 + i];
                prHash = 2 * (prHash - (parent.charAt(i-1)*power)) + parent.charAt(i+ptSize-1); // 맨 앞 값을 지우고, 맨 뒤에 새 값을 추가 == 한 칸 뒤로 밈
                //prHash %= MOD;
            }

            System.out.println(i+" >> 해쉬값 비교 : "+prHash+", "+ptHash);

            if(prHash == ptHash){ // 해시는 같지만 낮은 확률로 문자열이 다를 수 있기 때문에
                boolean finded = true;
                for (int j = 0; j < ptSize; j++) { //문자열도 같은지 확인
                    if(parent.charAt(i+j) != pattern.charAt(j)){
                        finded = false;
                        break;
                    }
                }
                if(finded){
                    System.out.println((i+1)+"에서 발견");
                }
                //System.out.println((i+1)+"에서 발견");
            }
        }
    }

    private static void rabinkarp(String parent, String pattern) {
        final int MOD = 100000007;
        int prSize = parent.length();
        int ptSize = pattern.length();

        long prHash = 0, ptHash = 0, power = 1; // 제곱수

        for (int i = 0; i <= prSize-ptSize; i++) {
            if(i == 0){
                for (int j = 0; j < ptSize; j++) {
                    prHash = (prHash + (parent.charAt(ptSize-1-j)) * power) % MOD;
                    ptHash = (ptHash + (pattern.charAt(ptSize-1-j)) * power) % MOD;

                    System.out.println(prHash+" "+ptHash);
                    if(j < ptSize - 1) {
                        //power *= 2;
                        power = (power%MOD * 31) % MOD;
                    }
                }
            } else {
                //ptHash = 2 * (prHash - parent[i - 1] * power) + parent[ptSize - 1 + i];
                prHash = 31*prHash - 31*parent.charAt(i-1)*power%MOD + parent.charAt(i+ptSize-1);
                prHash %= MOD;
            }

            System.out.println(i+" >> 해쉬값 비교 : "+prHash+", "+ptHash);

            if(prHash == ptHash){ // 해시는 같지만 낮은 확률로 문자열이 다를 수 있기 때문에
                boolean finded = true;
                for (int j = 0; j < ptSize; j++) { //문자열도 같은지 확인
                    if(parent.charAt(i+j) != pattern.charAt(j)){
                        finded = false;
                        break;
                    }
                }
                if(finded){
                    System.out.println((i+1)+"에서 발견");
                }
                //System.out.println((i+1)+"에서 발견");
            }
        }
    }
}
