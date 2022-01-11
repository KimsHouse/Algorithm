package Algorithm;
import java.util.*;
public class 맨버마이어스 {
        // Class to store information of a suffix
        public static class Suffix implements Comparable<Suffix> {
            int index;
            int rank;
            int next;

            public Suffix(int ind, int r, int nr) {
                index = ind;
                rank = r;
                next = nr;
            }

            // A comparison function used by sort() // 정렬을 사용한 비교 함수
            // to compare two suffixes.             // 두 접미사를 비교
            // Compares two pairs, returns 1        // 두 짝을 비교
            // if first pair is smaller             // 첫 번째 짝이 더 작으면
            public int compareTo(Suffix s) {
                if (rank != s.rank)
                    return Integer.compare(rank, s.rank);
                return Integer.compare(next, s.next);
            }
        }

        // This is the main function that takes a string 'txt' //
        // of size n as an argument, builds and return the
        // suffix array for the given string
        public static int[] suffixArray(String s) {
            int n = s.length();
            Suffix[] su = new Suffix[n];

            // Store suffixes and their indexes in
            // an array of classes. The class is needed
            // to sort the suffixes alphabetically and
            // maintain their old indexes while sorting

            // 저장된 접두사들과 그들의 인덱스들은 클래스들 가지는 하나의 배열에 들어있습니다.
            // 정렬 하는 중에 예전 인덱스를 유지하고 접두사들을 알파벳순으로 정렬하기 위해서 클래스가 필요합니다.
            for (int i = 0; i < n; i++) {
                su[i] = new Suffix(i, s.charAt(i) - '$', 0);
//                System.out.print(s.charAt(i)+" ");
//                System.out.println(s.charAt(i)-'$');
            }
            for (int i = 0; i < n; i++) {
                //System.out.println(i+"+1 < "+n+" ? "+su[i+1].rank+" : -1");
                su[i].next = (i + 1 < n ? su[i + 1].rank : -1);
                //System.out.println(su[i].next);
            }

            // Sort the suffixes using the comparison function
            // defined above.

            // 비교 함수를 사용해서 접미사들을 정렬합니다.
            // 아래와 같이 정의됩니다.
            Arrays.sort(su); // rank 순으로 정렬

//            for (int i = 0; i < su.length; i++) { // 정렬 확인
//                System.out.println(su[i].index+" "+su[i].rank+" "+su[i].next);
//            }
            // ------------------------- 사전순 정렬 su[0]과 su[1] 두개로 -------------------------------

            // At this point, all suffixes are sorted
            // according to first 2 characters.
            // Let us sort suffixes according to first 4
            // characters, then first 8 and so on

            // 이 포인트에서는, 모든 접미사들이 첫 2개의 문자들에 따라 정렬되었습니다.
            // 우리는 첫 4개의 문자들과, 첫 8개의 문자들 ... 16, 32 등에 따라 접미사들을 정렬합니다.
            int[] ind = new int[n];

            // This array is needed to get the index in suffixes[]
            // from original index. This mapping is needed to get
            // next suffix.

            // 이 배열은 오리지널 인덱스로 부터 suffixes[]안에 있는 인덱스를 가져오기 위해 필요합니다..
            // 이 매핑은 다음 접미사를 가져오는데 필요합니다

            for (int length = 4; length < 2 * n; length <<= 1) {

                //System.out.println(n);
                System.out.println("len : "+length);
                //System.out.println("len <<= 1 : "+(length <<= 1));

                // Assigning rank and index values to first suffix

                //랭크와 인덱스 값들을 첫 번째 접미사로 ?

                int rank = 0, prev = su[0].rank;
                su[0].rank = rank;
                ind[su[0].index] = 0;
                System.out.println("prev : "+prev);
                System.out.println("su[0].idx : "+su[0].index);
                System.out.println();
                for (int i = 1; i < n; i++) {
                    // If first rank and next ranks are same as
                    // that of previous suffix in array,
                    // assign the same new rank to this suffix

                    // 만약 첫 번째 랭크와 다음 랭크들이 배열안의 이전 접미사로써 같다면
                    // 같은 새로운 랭크 값을 이 접미사로 할당합니다.

                    System.out.println("i : "+i);
                    if (su[i].rank == prev && su[i].next == su[i - 1].next) {
                        System.out.println("------------------ture--------------------------");
                        System.out.println(su[i].rank+" == "+ prev +" && "+su[i].next +" == "+su[i-1].next);
                        prev = su[i].rank;
                        su[i].rank = rank;
                        System.out.println("prev : "+prev);
                        System.out.println("su[i].rank : "+su[i].rank);
                        System.out.println();
                    } else {
                        // Otherwise increment rank and assign
                        // 그렇지 않으면 ++랭크
                        System.out.println("--------------------false------------------------");
                        prev = su[i].rank;
                        su[i].rank = ++rank;
                        System.out.println("el prev : "+prev);
                        System.out.println("el su[i].rank : "+su[i].rank);
                        System.out.println();
                    }
                    ind[su[i].index] = i;
                }

                // Assign next rank to every suffix
                // 모든 접미사에게 다음 랭크 할당

                for (int i = 0; i < n; i++) {
                    int nextP = su[i].index + length / 2;
                    su[i].next = nextP < n ? su[ind[nextP]].rank : -1;
                }

                // Sort the suffixes according
                // to first k characters

                // 첫 번째 k 문자들을 따라 접미사들을 정렬
                Arrays.sort(su);
            }

            // Store indexes of all sorted
            // suffixes in the suffix array

            // 접미사 배열안에 모든 정렬된 접미사들의 인덱스를 저장(?)
            int[] suf = new int[n]; // 접미사 배열

            for (int i = 0; i < n; i++)
                suf[i] = su[i].index;

            // Return the suffix array
            // 접미사 배열 리턴
            return suf;
        }

        static void printArr(int arr[], int n) {
            for (int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }

        // Driver Code
        public static void main(String[] args) {
            //String txt = "aaaaaa";
            String txt ="abcacababc";
            int n = txt.length();
            int[] suff_arr = suffixArray(txt);
            System.out.println("Following is suffix array for banana:");
            printArr(suff_arr, n);
        }
    }

