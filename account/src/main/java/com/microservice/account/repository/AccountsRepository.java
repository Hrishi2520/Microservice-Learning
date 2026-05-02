package com.microservice.account.repository;

import com.microservice.account.entity.Accounts;
import com.microservice.account.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
}
