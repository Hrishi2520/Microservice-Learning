package com.microservice.account.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    @NotEmpty(message = "Name Can not be Null or Empty")
    @Size(min = 5, max = 20)
    private String name;

    @NotEmpty(message = "Email Can not be Null or Empty")
    @Email
    private String email;

    @Pattern(regexp = "^$|[0-9]{10}", message = "mobile Number must be 10 digits.")
    private String mobileNumber;

    private AccountsDto accountsDto;
}
