package com.microservice.account.controller;

import com.microservice.account.constants.AccountsConstants;
import com.microservice.account.dto.CustomerDto;
import com.microservice.account.dto.ResponseDto;
import com.microservice.account.service.IAccountService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class AccountController {

    private IAccountService iAccountService;

    @PostMapping
    public ResponseEntity<ResponseDto> create(@Valid @RequestBody CustomerDto dto) {
        iAccountService.createAccount(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(
                        AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201
                ));
    }

    @GetMapping
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam
                                                               @Pattern(regexp = "^$|[0-9]{10}", message = "mobile Number must be 10 digits.")
                                                               String mobileNumber) {
        CustomerDto customerDto = iAccountService.fetchAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

    @PutMapping
    public ResponseEntity<ResponseDto> updateCustomerDetail(@Valid @RequestBody CustomerDto customerDto) {
        boolean isUpdated = iAccountService.updateAccount(customerDto);
        if (isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_500, AccountsConstants.MESSAGE_500));
        }
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto> deleteCustomerDetail(@RequestParam
                                                                @Pattern(regexp = "^$|[0-9]{10}", message = "mobile Number must be 10 digits.")
                                                                String mobileNumber) {
        boolean isDeleted = iAccountService.deleteAccount(mobileNumber);
        if (isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_500, AccountsConstants.MESSAGE_500));
        }
    }
}
