package com.mengqi.transfer.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

    @Id
    @GeneratedValue
    @Column
    private long name;

    @Column
    private double balance;

    public Account() {
        balance = 0.0;
    }

    public Account(double initBalance) {
        balance = initBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void incBalance(double added) {
        balance += added;
    }

    public boolean decBalance(double transferred) {
        if (balance - transferred < 0) {
            return false;
        }
        balance -= transferred;
        return true;
    }
}