package com.microservice.account.controller;

import com.microservice.account.constants.AccountsConstants;
import com.microservice.account.dto.CustomerDto;
import com.microservice.account.dto.ResponseData;
import com.microservice.account.entity.Accounts;
import com.microservice.account.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
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

    @GetMapping
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam String mobileNumber) {
        CustomerDto customerDto = iAccountService.fetchAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

    @PutMapping
    public ResponseEntity<ResponseData> updateCustomerDetail(@RequestBody CustomerDto customerDto) {
        boolean isUpdated = iAccountService.updateAccount(customerDto);
        if (isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseData(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseData(AccountsConstants.STATUS_500, AccountsConstants.MESSAGE_500));
        }
    }
}
