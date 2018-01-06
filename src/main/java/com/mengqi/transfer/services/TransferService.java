package com.mengqi.transfer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mengqi.transfer.models.Account;
import com.mengqi.transfer.models.Transfer;
import com.mengqi.transfer.repositories.TransferRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * This service is transfer-related, including that checking an transfer is valid (the balance of the sender is
 * not a negative number) or not, saving a new transfer into Database and change the balance of both sender's and
 * receiver's accounts.
 *
 * @author Mengqi Yang
 */
@Service("TransferService")
public class TransferService {

    @Autowired
    TransferRepository transferRepository;

    @Autowired
    AccountService accountService;

    public boolean isValid(Account sender, Account receiver, double amount) {
        if (sender != null && receiver != null && sender.getBalance() - amount >= 0) {
            return true;
        }
        return false;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRES_NEW)
    public boolean saveTransfer(Transfer transfer) {
        Account sender = accountService.getAccountByName(transfer.getSender());
        Account receiver = accountService.getAccountByName(transfer.getReceiver());
        if (!isValid(sender, receiver, transfer.getAmount())) {
            return false;
        }
        transferRepository.save(transfer);
        accountService.changeAccountBalance(sender, receiver, transfer.getAmount());
        return true;
    }
}
