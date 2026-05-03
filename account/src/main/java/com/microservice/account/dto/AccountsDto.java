package com.microservice.account.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountsDto {

    @NotEmpty(message = "Account Number Cannot be Empty")
    @Pattern(regexp = "^$|[0-9]{10}", message = "Account Number must be 10 digits.")
    private Long accountNumber;

    @NotEmpty(message = "Account Type Cannot be Empty")
    private String accountType;

    @NotEmpty(message = "branch address Cannot be Empty")
    private String branchAddress;
}
