package com.microservice.account.service;

import com.microservice.account.dto.CustomerDto;

public interface IAccountService {


    /**
     * @param dto
     */
    void createAccount(CustomerDto dto);
}
