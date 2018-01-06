package com.mengqi.transfer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import com.mengqi.transfer.services.AccountService;
import com.mengqi.transfer.models.Account;

/**
 * A controller for all the requests related to account creation and reading.
 *
 * @author Mengqi Yang
 */
@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    /* Http post to create a new account */
    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public ResponseEntity<Account> createAccount(@RequestBody Account acc) {
        Account account = new Account(acc.getBalance());
        if (accountService.isValid(account)) {
            accountService.saveAccount(account);
            return ResponseEntity.ok(account);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /* Http get to show the details of an existing account */
    @RequestMapping(value = "/account/{name}", method = RequestMethod.GET)
    public Account getAccount(@PathVariable("name") long name) {
        return accountService.getAccountByName(name);
    }
}
