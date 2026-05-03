package com.microservice.account.service;

import com.microservice.account.dto.CustomerDto;
import com.microservice.account.entity.Customer;

public interface IAccountService {


    /**
     * @param dto
     */
    void createAccount(CustomerDto dto);

    CustomerDto fetchAccount(String mobileNumber);

    boolean updateAccount(CustomerDto dto);
}
