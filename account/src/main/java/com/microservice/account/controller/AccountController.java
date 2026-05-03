package com.microservice.account.controller;

import com.microservice.account.constants.AccountsConstants;
import com.microservice.account.dto.CustomerDto;
import com.microservice.account.dto.ResponseData;
import com.microservice.account.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountController {

    private IAccountService iAccountService;

    @PostMapping
    public ResponseEntity<ResponseData> create(@RequestBody CustomerDto dto) {
        iAccountService.createAccount(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseData(
                        AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201
                ));
    }
}
