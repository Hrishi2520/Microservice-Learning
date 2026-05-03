package com.microservice.account.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Schema(
        name = "Response",
        description = "Schema to hold Successful response information"
)
@AllArgsConstructor
public class ResponseDto {

    @Schema(
            description = "Status Code in the Response", example = "200"
    )
    private String statusCode;

    @Schema(
            description = "Status Massage in the response", example = "Request Processed Successfully"
    )
    private String statusMsg;
}
