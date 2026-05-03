package com.microservice.account.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold customer and Account information"
)
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    @Schema(
            description = "Name of the customer", example = "Hrishikesh"
    )
    @NotEmpty(message = "Name Can not be Null or Empty")
    @Size(min = 5, max = 20)
    private String name;

    @Schema(
            description = "Email of the customer", example = "hrishikeshshedge@gmail.com"
    )
    @NotEmpty(message = "Email Can not be Null or Empty")
    @Email
    private String email;

    @Schema(
            description = "Mobile Mumber of the customer", example = "8836882482"
    )
    @Pattern(regexp = "^$|[0-9]{10}", message = "mobile Number must be 10 digits.")
    private String mobileNumber;

    @Schema(
            description = "Accounts Details of the customer"
    )
    private AccountsDto accountsDto;
}
