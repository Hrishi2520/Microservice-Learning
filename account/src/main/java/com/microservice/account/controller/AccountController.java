package com.microservice.account.controller;

import com.microservice.account.constants.AccountsConstants;
import com.microservice.account.dto.CustomerDto;
import com.microservice.account.dto.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountController {


    @PostMapping
    public ResponseEntity<ResponseData> create(@RequestBody CustomerDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseData(
                        AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201
                ));
    }
//    @GetMapping
//    public String sayHello() {
//        return "Hey World";
//    }
}
