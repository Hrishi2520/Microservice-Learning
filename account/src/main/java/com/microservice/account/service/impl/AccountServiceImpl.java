package com.microservice.account.service.impl;

import com.microservice.account.constants.AccountsConstants;
import com.microservice.account.dto.CustomerDto;
import com.microservice.account.entity.Accounts;
import com.microservice.account.entity.Customer;
import com.microservice.account.mapper.AccountsMapper;
import com.microservice.account.mapper.CustomerMapper;
import com.microservice.account.repository.AccountsRepository;
import com.microservice.account.repository.CustomerRepository;
import com.microservice.account.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto dto) {
        Customer customer = CustomerMapper.mapToCustomer(dto, new Customer());
        customerRepository.save(customer);

    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomNumber = 10000000000L+new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        return newAccount;
    }
}
