package com.microservice.account.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold the Account information"
)
@AllArgsConstructor
@NoArgsConstructor
public class AccountsDto {

    @Schema(
            description = "Account Number of the Bank", example = "2749283029"
    )
    @NotEmpty(message = "Account Number Cannot be Empty")
    @Pattern(regexp = "^$|[0-9]{10}", message = "Account Number must be 10 digits.")
    private Long accountNumber;

    @Schema(
            description = "Account Type of Bank", example = "Savings"
    )
    @NotEmpty(message = "Account Type Cannot be Empty")
    private String accountType;

    @Schema(
            description = "Branch Address of Bank", example = "Mumbai"
    )
    @NotEmpty(message = "branch address Cannot be Empty")
    private String branchAddress;
}
