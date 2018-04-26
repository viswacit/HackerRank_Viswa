package com.example.qlikmysql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution1 {
	
	static TrieNode root;
	
	static class TrieNode {
		
		TrieNode[] children = new TrieNode[26];
        boolean isLeaf;
        int count;
        public TrieNode() {
            isLeaf =  false;
            count = 0;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
        
        static void insert(String contact) {
            
            TrieNode pCrawl = root;
            int index;
            for(int level=0;level<contact.length();level++) {
               index = contact.charAt(level) - 'a';
               if(pCrawl.children[index] ==  null) {
                  pCrawl.children[index] = new TrieNode();
               }
               pCrawl = pCrawl.children[index];
               pCrawl.count++;
            }
            pCrawl.isLeaf = true;
        }
        
        static int SearchTrie(String s) {
        	System.out.println("String Search--"+s);
            TrieNode sCrawl = root;
            int count = 0;
            int cIndex ;
            while(s.length() > 0) {
                cIndex = s.charAt(0) - 'a';
                if (sCrawl.children[cIndex] == null) {
                    break;
                } else {
                    s = s.substring(1);
                    if(s.length() == 0) {
                        count = sCrawl.children[cIndex].count;
                    } else {
                    	sCrawl = sCrawl.children[cIndex];
                    }
                    
                }
            }
            return count;
	    }
        
        public static void main(String[] args) throws IOException{
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            //String line = br.readLine();
        	File file = new File("C:\\Users\\vnagama1\\Desktop\\test2.txt");
        	BufferedReader br = new BufferedReader(new FileReader(file));
        	String line = br.readLine();
            int n = Integer.parseInt(line);
            //int n = 11;
            root = new TrieNode();
            String[] input = new String[11];
            input[0] = "add a";
            input[1] = "add aa";
            input[2] = "add aaa";
            input[3] = "add aaaa";
            input[4] = "add bbb";
            input[5] = "find a";
            input[6] = "find aa";
            input[7] = "find aaa";
            input[8] = "find aaaa";
            input[9] = "find aaaaa";
            input[10] = "find aaaaaa";
            /*input[0] = "add hack";
            input[1] = "add hackerrank";
            input[2] = "find hac";
            input[3] = "find hak";*/
            
            String[] inp;
            for(int i=0;i<n;i++){
                //inp = input[i].split("\\s");
            	inp = br.readLine().split("\\s");
                if(inp[0].equals("add")) {
                    TrieNode.insert(inp[1]);
                    
                } else if(inp[0].equals("find")) {
                    int count = TrieNode.SearchTrie(inp[1]);
                    System.out.println(count);
                }
                
            }    
        }
		
	};

}
