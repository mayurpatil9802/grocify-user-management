package com.grocify.usermgnt.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GrocifyErrorResponse {

    private String message;
    private int errorCode;

}
