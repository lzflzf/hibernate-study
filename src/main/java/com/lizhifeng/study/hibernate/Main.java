package com.lizhifeng.study.hibernate;

import java.util.*;

public class Main {

	   public static void main(String[] args) {	        
	   	   		   
		   Customer customer = new Customer();		   
		   customer.setUserName("Customer");
		   customer.setPassword("passwd");		   
		   Account account = new Account();
		   account.setName("Account");	   
		   customer.addAccount(account);		   
		   Factory.save(customer);
   
		   String sql = "from Customer where id = " + customer.getId();			   	
		   List<Object> objs = Factory.select(sql);		   	
		   if(objs!=null)
		   {
		   		customer = (Customer)objs.get(0);		   				   		
		   }
		   
		   // Factory.del(customer);
		   			   	
		   System.exit(1);
	   }
}










