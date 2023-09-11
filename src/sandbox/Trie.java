package sandbox;

import java.util.Arrays;

public class Trie {
    public static void main(String[] args) {
        TrieNode trie = new TrieNode();
        System.out.println(trie.insert("KIT"));
        System.out.println(trie.insert("CAT"));
        System.out.println(trie.insert("CATTLE"));
        System.out.println(trie.insert("KIN"));
        System.out.println(trie.insert("HAPPY"));
        System.out.println(trie.insert("HAPPY"));
        trie.print(trie);
    }

}

class TrieNode{
    private final int CHARS = 256;
    boolean terminal;
    TrieNode[] children;
    public TrieNode(){
        children = new TrieNode[CHARS];
        terminal = false;
    }
    public boolean insert(String s){
        return this.insert(this, s);
    }
    public boolean insert(TrieNode root, String s){
        if(root==null){
            root = new TrieNode();
        }
        TrieNode temp = root;
        for(int i=0; i<s.length(); i++){
            if(temp.children[s.charAt(i)] == null){
                temp.children[s.charAt(i)] = new TrieNode();
            }
            temp = temp.children[s.charAt(i)];
        }
        if (temp.terminal){
            return false;
        }
        else {
            return temp.terminal = true;
        }
    }
    public void print(TrieNode root){
        if(root == null) System.out.println("EMPTY");
        else print(root, null, 0);
    }
    private static void print(TrieNode node, Character[] prefix, Integer length){
        if(node.terminal){
            System.out.printf("word: %s\n", Arrays.toString(prefix));
        }
        Character[] newPrefix = new Character[length+2];
        if(prefix!=null) System.arraycopy(prefix, 0, newPrefix, 0, length);
        for (int i=0; i < node.CHARS; i++){
            if(node.children[i] != null){
                newPrefix[length] = (char)i;
                print(node.children[i], newPrefix, length+1);
            }
        }
    }
}