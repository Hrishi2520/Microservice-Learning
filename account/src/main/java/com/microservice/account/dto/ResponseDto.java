package com.microservice.account.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(
        name = "Response",
        description = "Schema to hold Successful response information"
)
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    @Schema(
            description = "Status Code in the Response"
    )
    private String statusCode;

    @Schema(
            description = "Status Massage in the response"
    )
    private String statusMsg;
}
