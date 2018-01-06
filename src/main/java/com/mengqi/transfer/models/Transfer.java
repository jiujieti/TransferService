package com.mengqi.transfer.models;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * A simple object model to represent an transfer.
 *
 * @author Mengqi Yang
 */
@Entity
public class Transfer {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private long sender;

    @Column
    private long receiver;

    @Column
    private long amount;

    public Transfer() {}

    public Transfer(long sender, long receiver, long amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    public long getSender() {
        return sender;
    }

    public long getReceiver() {
        return receiver;
    }

    public long getAmount() {
        return amount;
    }
}
