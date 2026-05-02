package com.microservice.account.service.impl;

import com.microservice.account.dto.CustomerDto;
import com.microservice.account.repository.AccountsRepository;
import com.microservice.account.repository.CustomerRepository;
import com.microservice.account.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto dto) {

    }
}
