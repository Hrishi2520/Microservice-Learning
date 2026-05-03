package com.microservice.account.service.impl;

import com.microservice.account.constants.AccountsConstants;
import com.microservice.account.dto.AccountsDto;
import com.microservice.account.dto.CustomerDto;
import com.microservice.account.entity.Accounts;
import com.microservice.account.entity.Customer;
import com.microservice.account.exception.CustomerAlreadyExistsException;
import com.microservice.account.exception.ResourceNotFoundException;
import com.microservice.account.mapper.AccountsMapper;
import com.microservice.account.mapper.CustomerMapper;
import com.microservice.account.repository.AccountsRepository;
import com.microservice.account.repository.CustomerRepository;
import com.microservice.account.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto dto) {
        Customer customer = CustomerMapper.mapToCustomer(dto, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(dto.getMobileNumber());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer Already Register with given Mobile Number "+ dto.getMobileNumber());
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        Customer save = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(save));
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomNumber = 10000000000L+new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Anonymous");
        return newAccount;
    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "Mobile Number", mobileNumber));

        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Account", "Customer Id", customer.getCustomerId().toString()));
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));
        return customerDto;
    }

    @Override
    public boolean updateAccount(CustomerDto dto) {
        boolean isUpdated = false;
        AccountsDto accountsDto = dto.getAccountsDto();
        if (accountsDto != null) {
            Accounts accounts = accountsRepository.findById(accountsDto.getAccountNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Account", "Account Number", accountsDto.getAccountNumber().toString())
            );
            AccountsMapper.mapToAccounts(accountsDto, accounts);
            accounts = accountsRepository.save(accounts);

            Long customerId = accounts.getCustomerId();
            Customer customer = customerRepository.findById(customerId)
                    .orElseThrow(
                            () -> new ResourceNotFoundException("Customer", "Customer Id", customerId.toString())
                    );
            CustomerMapper.mapToCustomer(dto, customer);
            customerRepository.save(customer);
            isUpdated = true;
        }
        return isUpdated;
    }
}
