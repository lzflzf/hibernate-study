package com.lizhifeng.study.hibernate;

import java.util.HashSet;
import java.util.Set;

public class Customer {
    
    private int id;
    private String userName;
    private String password;
    private Set<Account> accounts = new HashSet<Account>(); 


    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
	public Set<Account> getAccounts() {
		return accounts;
	}


	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	
	public void addAccount(Account account)
	{
		account.setCustomer(this);
		this.accounts.add(account);
	}
	
}