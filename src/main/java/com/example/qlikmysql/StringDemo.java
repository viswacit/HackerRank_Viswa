package com.example.qlikmysql;

public class StringDemo {
	
	public static void main(String[] args) {

          String s = "saveChangesInTheEditor";
	     
	      String camelCasePattern = "([a-z]+[A-Z]+\\w+)+"; // 3rd edit, getting better
	      System.out.println(s.matches(camelCasePattern));
	      String[] token = s.split("(?=\\p{Lu})");
	      for(String s1: token){
	    	  System.out.println(s1);
	      }
	      System.out.println(token.length);
	   }

}
