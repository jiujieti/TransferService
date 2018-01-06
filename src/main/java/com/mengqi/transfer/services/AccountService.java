package com.mengqi.transfer.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.mengqi.transfer.models.Account;
import com.mengqi.transfer.repositories.AccountRepository;
import org.springframework.stereotype.Service;

/**
 * This service is account-related, including that checking an account is valid (the balance is not a negative number)
 * or not, saving a new account into Database and change the balance of an account.
 *
 * @author Mengqi Yang
 */
@Service("AccountService")
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public boolean isValid(Account account) {
        return account.getBalance() >= 0;
    }

    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    public void changeAccountBalance(Account sender, Account receiver, long amount) {
        sender.setBalance(sender.getBalance() - amount);
        accountRepository.save(sender);
        receiver.setBalance(receiver.getBalance() + amount);
        accountRepository.save(receiver);
    }

    public Account getAccountByName(long name) {
        return accountRepository.findOne(name);
    }
}
