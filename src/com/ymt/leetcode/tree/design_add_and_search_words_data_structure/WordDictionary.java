package com.ymt.leetcode.tree.design_add_and_search_words_data_structure;

public class WordDictionary {
    private WordTreeNode root;

    public WordDictionary() {
        root = new WordTreeNode();
    }

    public void addWord(String word) {
        WordTreeNode curr = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curr.nodes[index] == null) {
                curr.nodes[index] = new WordTreeNode();
            }
            curr = curr.nodes[index];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, WordTreeNode currNode) {
        if (index == word.length()) {
            return currNode.isWord;
        }

        char ch = word.charAt(index);
        if (ch != '.') {
            WordTreeNode node = currNode.nodes[ch - 'a'];
            if (node != null) {
                return search(word, index + 1, node);
            }
            return false;
        }

        for (int i = 0; i < 26; ++i) {
            if (currNode.nodes[i] != null && search(word, index + 1, currNode.nodes[i])) {
                return true;
            }
        }
        return false;
    }

    class WordTreeNode {
        private WordTreeNode[] nodes;
        private boolean isWord;

        public WordTreeNode() {
            nodes = new WordTreeNode[26];
            isWord = false;
        }
    }
}