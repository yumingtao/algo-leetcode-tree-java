package com.ymt.leetcode.tree.design_add_and_search_words_data_structure;

public class WordDictionary1 {
    private WordTreeNode root;
    WordDictionary1 (){
        root = new WordTreeNode();
    }
    
    public void addWord(String word){
        WordTreeNode currNode = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(currNode.words[index] == null){
                currNode.words = new WordTreeNode[26];
            }
            currNode = currNode.words[index];
        }
        currNode.isEnd = true;
    }
    
    public boolean search(String word){
        return search(root, word, 0);
    }
    
    private boolean search(WordTreeNode node, String word, int index){
        if(index == word.length()){
            return node.isEnd;
        }
        char ch = word.charAt(index);
        if(ch != '.'){
            int chIndex = ch - 'a';
            if(node.words[chIndex] == null){
                return false;
            }
            return search(node.words[chIndex], word, index + 1);
        }
        for(int i = 0; i < 26; ++i){
            if(node.words[i] != null && search(node.words[i], word, index + 1)){
                return true;
            }
        }
        return false;
    }
    
    class WordTreeNode{
        private WordTreeNode[] words;
        private boolean isEnd;
        
        WordTreeNode(){
            words = new WordTreeNode[26];
            isEnd = false;
        }
    }
}