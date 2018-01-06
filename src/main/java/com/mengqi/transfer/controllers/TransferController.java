package com.mengqi.transfer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mengqi.transfer.models.Transfer;
import com.mengqi.transfer.services.TransferService;

/**
 * A controller for all the requests related to transfer creation.
 *
 * @author Mengqi Yang
 */
@RestController
public class TransferController {

    @Autowired
    TransferService transferService;

    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public ResponseEntity<Transfer> createTransfer(@RequestBody Transfer trans) {
        Transfer transfer = new Transfer(trans.getSender(), trans.getReceiver(), trans.getAmount());
        if (transferService.saveTransfer(transfer)) {
            return ResponseEntity.ok(transfer);
        }
        return new ResponseEntity<Transfer>(HttpStatus.BAD_REQUEST);
    }
}
