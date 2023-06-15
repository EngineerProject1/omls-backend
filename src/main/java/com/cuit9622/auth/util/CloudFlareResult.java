package com.cuit9622.auth.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CloudFlareResult {
    private Boolean success;
    @JsonProperty("error-codes")
    private String[] errorCodes;
    private String challenge_ts;
    private String hostname;
    private String action;
    private String cdata;
}
