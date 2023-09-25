package Trie;
import java.util.Map;
import java.util.HashMap;
public class Trie {
    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;

        // Constructor
        public TrieNode(){
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    private final TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    // Insert word into Trie
    public void insert(String word){
        TrieNode current = root;
        for(int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.endOfWord = true;
        System.out.println("Successfully inserted " + word + " in Trie!");
    }
}
