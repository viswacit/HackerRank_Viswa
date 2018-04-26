package com.example.qlikmysql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	static TrieNode root;
	
	static class TrieNode {
		
		TrieNode[] children = new TrieNode[26];
        boolean isLeaf;
        int count;
        public TrieNode() {
            isLeaf =  false;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
        
        /*static void insert(String contact) {
            
            TrieNode pCrawl = root;
            int index;
            for(int level=0;level<contact.length();level++) {
               index = contact.charAt(level) - 'a';
               if(pCrawl.children[index] ==  null) {
                  pCrawl.children[index] = new TrieNode();
               } else if(pCrawl.children[index].isLeaf == true) {
            	   System.out.println("BAD SET");
            	   System.out.println(contact);
            	   break;
               }
               pCrawl = pCrawl.children[index];
            }
            pCrawl.isLeaf = true;
        }*/
        
        static boolean insert(String contact) {
            
            TrieNode pCrawl = root;
            int index;
            boolean match = true;
            for(int level=0;level<contact.length();level++) {
               index = contact.charAt(level) - 'a';
               if(pCrawl.children[index] ==  null) {
                  pCrawl.children[index] = new TrieNode();
                  match = false;
               } else if(pCrawl.children[index].isLeaf == true) {
            	   match = true;
            	   break;
               }
               pCrawl = pCrawl.children[index];
            }
            pCrawl.isLeaf = true;
            return match;
        }
        
        public static void main(String[] args) throws IOException{
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //String line = br.readLine();
        	File file = new File("C:\\Users\\vnagama1\\Desktop\\test3.txt");
        	BufferedReader br = new BufferedReader(new FileReader(file));
        	String line = br.readLine();
            //int n = Integer.parseInt(line);
            int n = 7;
            root = new TrieNode();
            String[] input = new String[n];
            input[0] = "aab";
            input[1] = "defgab";
            input[2] = "abcde";
            input[3] = "aabcde";
            input[4] = "cedaaa";
            input[5] = "bbbbbbbbbb";
            input[6] = "jabjjjad";
            /*input[0] = "add hack";
            input[1] = "add hackerrank";
            input[2] = "find hac";
            input[3] = "find hak";*/
            
            String inp;
            boolean prefixMatch = false;
            for(int i=0;i<n;i++){
                inp = input[i];
            	//inp = br.readLine();
                //TrieNode.insert(inp);
                if(TrieNode.insert(inp)) {
                	System.out.println("BAD SET");
             	    System.out.println(inp);
                	prefixMatch = true;
                	break;
                }
            }   
            if(!prefixMatch) {
            	System.out.println("GOOD SET");
            } 
        }
		
	};

}
