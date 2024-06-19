package com.example.aopdemo.dao;

import com.example.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;

    private String serviceCode;

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + " :DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public List<Account> findAccounts() {
        List<Account> myAccounts = new ArrayList<>();

        //create sample accounts
        Account temp1 = new Account("Sangha", "Silver");
        Account temp2 = new Account("Jyoti", "Platinum");
        Account temp3 = new Account("Bidya", "Gold");

         //add them to our accounts list
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + " : doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + " : in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " : in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " : in getServiceCode");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " : in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}