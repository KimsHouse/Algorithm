package Algorithm;

import java.util.HashMap;
import java.util.Map;

public class trieAlgorithm {
    // 트리의 구조의 각 노드에는 각 문자열의 일부를 포함하여
    // 자신과 연결되는 문자열의 일부를 가지고 있어야 한다는 점을 명심

    // 1. 생성자 / 클래스 정의

    // 루트 노드는 아무런 문자열(접두사)를 포함하지 않고 모든 문자열의
    // 접두사들을 자식 배열로 가지고 있어야 한다.

    static class Node {
        // 자식노드
        Map<Character, Node> childNode = new HashMap<>();
        // 단어의 끝인지 아닌지 체크하는 불린형
        boolean isEnd;
    }

    static class trie {
        // trie 자료구조를 생성할 때 rootNode는 기본적으로 생성
        Node rootNode = new Node();


        void insert(String str){
            // trie자료구조는 항상 rootNode부터 시작
            Node node = this.rootNode;

            // 문자열의 각 단어마다 가져와서 자식노드 중에 있는지 체크
            // 없으면 자식노드 새로 생성
            for(int i = 0; i <str.length(); i++){

                // 값이 없으면 새로 만들어주고 있으면 그 값을 사용용\
                //System.out.println(str.charAt(i));
               node = node.childNode.computeIfAbsent(str.charAt(i), key -> new Node());
                //System.out.println(node.childNode);
            }
            // 저장 할 문자열의 마지막 단어에 매핑되는 노드에 단어의 끝임을 명시
            node.isEnd = true;
        }

        boolean search(String str){
            // trie 자료구조는 항상 root부터 시작
            Node node = this.rootNode;

            // 문자열의 각 단어마다 노드가 존재하는지 체크
            for(int i = 0; i < str.length(); i++){
                // 문자열의 각 단어에 매핑된 노드가 존재하면 가져오고 아니면 null
                System.out.println(str.charAt(i));
                node = node.childNode.getOrDefault(str.charAt(i), null);
                System.out.println(node.childNode);

                // node가 null이면 현재 trie에 해당 문자열은 없음
                if(node == null) return false;
            }

            // 문자열의 마지막 단어까지 매핑된 노드가 존재한다고해서 무조건 문자열에 존재하는 것은 아님
            // busy를 trie에 저장했으면, bus의 마지막 s단어에 매핑 된 노드는 존재하지만 trie에 저장된건
            // 아니므로 현재 노드가 단어의 끝인지 아닌지 체크하는 변수로 리턴
            return node.isEnd;
        }

        public static void main(String[] args) {
            trie trie = new trie();

            // Trie에 문자열 저장
            trie.insert("kakao");
            trie.insert("busy");
            trie.insert("buss");
            trie.insert("card");
            trie.insert("cap");

            // Trie에 저장 된 문자열 확인
            System.out.println(trie.search("bus")); // false
            System.out.println(trie.search("busy")); // true
            System.out.println(trie.search("kakao")); // true
            System.out.println(trie.search("cap")); // true

        }


    }
}
