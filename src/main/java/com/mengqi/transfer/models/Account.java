package com.mengqi.transfer.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * A simple object model to represent an account.
 *
 * @author Mengqi Yang
 */
@Entity
public class Account {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long name;

    @Column
    private long balance;

    public Account() {
        this.balance = 0;
    }
    public Account(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getName() {
        return name;
    }
}