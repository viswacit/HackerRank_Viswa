package com.example.tutorials;

import java.io.*;
import java.util.*;
public class CandidateCode {
	
	static Node root = null;
	
    public static void main(String args[] ) throws Exception {

    	int n = 5;
        int arr[] = {-1 ,0 ,0 ,1 ,1};
        int nd = 2;
        Node res = constructTree(arr,arr.length);
        Node res1 = DeleteNode(res,nd);
        int cnt = countLeaves(res1);
        System.out.println("Success");
        System.out.println("Count--"+cnt);
   }
    
    
   
    static int countLeaves(Node res1) {
    	
    	int count = 0;
    	if(res1==null) {
    		return 0;
    	} 
    	if(res1.left==null&&res1.right==null) {
    		return 1;
    	} else {
    		return countLeaves(res1.left) + countLeaves(res1.right);
    	}
    		
    	
    }
    
    static class Node  {
    	int key;
        Node left, right;
      
        public Node(int key) 
        {
            this.key = key;
            left = right = null;
        }
    }
    
   static Node DeleteNode(Node arr,int n) {
	   if(arr==null){
		   return null;
	   } else {
		   DeleteNode(arr.left,n);
		   DeleteNode(arr.right,n);
	   }
	   
	   if(arr.left!=null) {
		   if(arr.left.key == n){
			   System.out.println("Deleting Left Node--"+arr.left.key);
			   arr.left = null;
			   
		   }
	   }
	   if(arr.right!=null) {
		   if(arr.right.key == n){
			   System.out.println("Deleting Right Node--"+arr.right.key);
			   arr.right = null;
			   
		   }
	   }
	   return arr;
	    
   }
   static Node constructTree(int[] arr,int n) {
	   
	   Node[] created = new Node[n];
       for (int i = 0; i < n; i++) 
           created[i] = null;
 
       for (int i = 0; i < n; i++)
           createNode(arr, i, created);
 
       return root;
	
   }
   
   static void createNode(int parent[], int i, Node created[]) 
   {
       if (created[i] != null)
           return;
       
       created[i] = new Node(i);
 
       if (parent[i] == -1) 
       {
           root = created[i];
           return;
       }
       // If parent is not created, then create parent first
       if (created[parent[i]] == null)
           createNode(parent, parent[i], created);
 
       Node p = created[parent[i]];
 
       if (p.left == null)
           p.left = created[i];
       else // If second child
         
           p.right = created[i];
   }
}
