package com.mengqi.transfer.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.mengqi.transfer.models.Account;
import com.mengqi.transfer.repositories.AccountRepository;
import org.springframework.stereotype.Service;

@Service("AccountService")
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    /* check if the balance is valid */
    public boolean isValid(double balance) {
        return balance >= 0;
    }

    public Account createAccount(double balance) {
        Account account = new Account(balance);
        accountRepository.save(account);
        return account;
    }

    public Account getAccountByName(long name) {
        return accountRepository.findOne(name);
    }


}
