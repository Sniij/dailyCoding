import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Trie trie = new Trie();
        int size = phone_book.length;
        Arrays.sort(phone_book);
        for(int i = 0; i < size; i++){
            trie.insert(phone_book[i]);
        }

        for(int i = 0; i < size; i++){
            if(trie.search(phone_book[i])){
                answer = false;
                break;
            }
        }
        return answer;
    }
}

class Node{
    Map<Character, Node> child = new HashMap<Character, Node>();
    String str;
    boolean end;
}

class Trie{
    Node root = new Node();

    void insert(String s){
        Node node = this.root;
        int size = s.length();
        for(int i = 0; i < size; i++){
            node = node.child.computeIfAbsent(s.charAt(i), key -> new Node());
            node.str = s;
        }

        node.end = true;
    }

    boolean search(String s){
        Node node = this.root;

        int size = s.length();
        for(int i = 0; i < size; i++){
            node = node.child.getOrDefault(s.charAt(i), null);

            if(node.str.equals(s) || node == null){
                return false;
            }
        }

        return node.end;
    }
}