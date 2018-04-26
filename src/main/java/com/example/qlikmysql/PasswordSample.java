package com.example.qlikmysql;

import java.util.ArrayList;
import java.util.List;

public class PasswordSample {

	
	public static void main(String[] args) {
		  // spring 4.0.0
		  /*org.springframework.security.crypto.password.PasswordEncoder encoder
		   = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();*/

		   // $2a$10$lB6/PKg2/JC4XgdMDXyjs.dLC9jFNAuuNbFkL9udcXe/EBjxSyqxW
		   // true
		   // $2a$10$KbQiHKTa1WIsQFTQWQKCiujoTJJB7MCMSaSgG/imVkKRicMPwgN5i
		   // true
		   // $2a$10$5WfW4uxVb4SIdzcTJI9U7eU4ZwaocrvP.2CKkWJkBDKz1dmCh50J2
		   // true
		   // $2a$10$0wR/6uaPxU7kGyUIsx/JS.krbAA9429fwsuCyTlEFJG54HgdR10nK
		   // true
		   // $2a$10$gfmnyiTlf8MDmwG7oqKJG.W8rrag8jt6dNW.31ukgr0.quwGujUuO
		   // true

		    for (int i = 0; i < 20; i++) {
		      // "123456" - plain text - user input from user interface
		      //String passwd = encoder.encode("Dipu@1982");
              String password = "$2a$10$uux6VMpRQ5OT19W9n8fSpejycbtr18yvsM1pA3wUkwfexmznpw3jW";
		      // passwd - password from database
		      //System.out.println(passwd); // print hash

		      // true for all 5 iteration
		      //System.out.println(encoder.matches("Dipu@1982", password));
		    }
		    List<Integer> result = new ArrayList<>();
	        int[] grades = {73,67,38,33};
	        for(int i: grades) {
	            if(i>=38) {
	                if(i%5 == 0) { 
	                    result.add(i);
	                } else if(i%5 == 1) {
	                    i = i+1;
	                    result.add(i);
	                } else if(i%5 == 2) {
	                    i = i+2;
	                    result.add(i);
	                } 
	            }
	            
	        }
	        int[] res = new int[result.size()];
	        System.out.println(res.length);
		}
}
