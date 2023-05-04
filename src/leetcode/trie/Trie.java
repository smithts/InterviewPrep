package leetcode.trie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Trie {
    Map<Character, TrieNode> map;

    public Trie() {
        map = new HashMap<>();
    }

    public void insert(String word) {
        TrieNode current = map.get(word.charAt(0));
        char currentChar;

        if (current == null) {
            currentChar = word.charAt(0);
            current = new TrieNode(currentChar);
            map.put(currentChar, current);
        }

        for(int i = 1; i < word.length(); i++) {
            currentChar = word.charAt(i);
            if (current.hasChild(currentChar)) {
                current = current.getChild(currentChar);
            } else {
                TrieNode newChild = new TrieNode(currentChar);
                current.addChild(newChild);
                current = newChild;
            }
        }
        current.isLeaf = true;
    }

    public boolean search(String word) {
        TrieNode current = map.get(word.charAt(0));

        if (current != null) {
            for (int i = 1; i < word.length(); i++) {
                current = current.getChild(word.charAt(i));
                if (current == null) {
                    return false;
                }
            }
            return current.isLeaf;
        }

        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = map.get(prefix.charAt(0));

        if (current != null) {
            for (int i = 1; i < prefix.length(); i++) {
                current = current.getChild(prefix.charAt(i));
                if (current == null) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public class TrieNode {
        char val;
        Set<TrieNode> children;
        boolean isLeaf;

        public TrieNode(char val) {
            this.val = val;
            children = new HashSet<>();
            isLeaf = false;
        }

        public TrieNode getChild(char val) {
            for(TrieNode t : children) {
                if(t.val == val) {
                    return t;
                }
            }
            return null;
        }

        public boolean hasChild(char val) {
            return getChild(val) != null;
        }

        public void addChild(char val) {
            children.add(new TrieNode(val));
        }

        public void addChild(TrieNode t) {
            children.add(t);
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */