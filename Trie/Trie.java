class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        for (char c: word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }
        current.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current = root;
        for (char c: word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        return current.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c: prefix.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        return true;
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;

        public TrieNode() {}
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }


    public void insert(String word) {
        TrieNode current = root;
        for (char ch: word.toCharArray()) {
            if (current.children[ch - 'a'] == null) {
                current.children[ch - 'a'] = new TrieNode();
            }
            current = current.children[ch - 'a'];
        }
        current.isWord = true;
    }


    public boolean search(String word) {
        TrieNode current = root;
        for (char ch: word.toCharArray()) {
            if (current.children[ch - 'a'] == null) {
                return false;
            }
            current = current.children[ch - 'a'];
        }
        return current.isWord;
    }


    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char ch: prefix.toCharArray()) {
            if (current.children[ch - 'a'] == null) {
                return false;
            }
            current = current.children[ch - 'a'];
        }
        return true;
    }

    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
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