package Leetcode;
//前缀树
public class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word==null)
            return;
        int len=word.length();
        TrieNode head=root;
        for(int i=0;i<len;++i)
        {
            char temp=word.charAt(i);
            int index=temp-'a';
            if(head.nexts[index]==null)
            {
                TrieNode newnode=new TrieNode();
                newnode.pass++;
                head.nexts[index]=newnode;
            }
            else
                head.nexts[index].pass++;
            head=head.nexts[index];
        }
        head.end++;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int len=word.length();
        TrieNode head=root;
        for(int i=0;i<len;i++)
        {
            int index=word.charAt(i)-'a';
            if(head.nexts[index]==null)
                return false;
            head=head.nexts[index];
        }
        return head.end>=1;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int len=prefix.length();
        TrieNode head=root;
        for(int i=0;i<len;i++)
        {
            int index=prefix.charAt(i)-'a';
            if(head.nexts[index]==null)
                return false;
            head=head.nexts[index];
        }
        return true;
    }

    class TrieNode{
        public int pass;
        public int end;
        public TrieNode[] nexts;
        TrieNode()
        {
            pass=end=0;
            nexts=new TrieNode[26];
        }
    }
}
