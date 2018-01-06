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

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public ResponseEntity<Account> createAccount(@RequestBody double balance) {
        if (accountService.isValid(balance)) {
            Account account = accountService.createAccount(balance);
            return ResponseEntity.ok(account);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/account/{name}", method = RequestMethod.GET)
    public Account getAccount(@PathVariable("name") long name) {
        return accountService.getAccountByName(name);
    }
}
