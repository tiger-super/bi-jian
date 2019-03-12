package com.house.tool;

import com.house.entity.Customer;

public class SystemSession {
	 private static ThreadLocal<Customer> local = new ThreadLocal<Customer>();  
	  
	    public static void addSession(Customer customer) { 
	        local.set(customer);  
	    }  
	  
	    public static Customer getSession() {  
	        return local.get();  
	    }  
}
