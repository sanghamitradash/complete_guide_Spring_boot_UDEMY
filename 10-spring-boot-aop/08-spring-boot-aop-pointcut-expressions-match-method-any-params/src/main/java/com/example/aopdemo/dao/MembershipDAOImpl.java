package com.example.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

    @Override
    public boolean addSillyMatch() {
        System.out.println(getClass() + " :DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");
        return true;
    }
}
