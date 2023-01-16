public class LC_208 {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        boolean b = trie.startsWith("a");
        System.out.println(b);
    }
    static class Trie {
        boolean isEnd;
        Trie[] nexts;
        public Trie() {
            nexts = new Trie[26];
        }

        public void insert(String word) {
            char[] str = word.toCharArray();
            Trie p = this;
            for (int i = 0; i < str.length; i++) {
                int idx = str[i] - 'a';
                if (p.nexts[idx] == null) p.nexts[idx] = new Trie();
                p = p.nexts[idx];
            }
            p.isEnd = true;
        }

        public boolean search(String word) {
            char[] str = word.toCharArray();
            Trie p = this;
            for (int i = 0 ; i < str.length; i ++) {
                int idx = str[i] - 'a';
                if (p.nexts[idx] == null) return  false;
                p = p.nexts[idx];
            }
            return p.isEnd;
        }

        public boolean startsWith(String prefix) {
            char[] str = prefix.toCharArray();
            Trie p = this;
            for (int i = 0 ; i < str.length ; i ++) {
                int idx = str[i] - 'a';
                if (p.nexts[idx] == null) return  false;
                p = p.nexts[idx];
            }
            return  true;
        }
    }
}
