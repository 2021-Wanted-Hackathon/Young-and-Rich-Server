package com.hackathon.youngandrich.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.hackathon.youngandrich.common.exception.ExceptionCode;
import com.hackathon.youngandrich.common.exception.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultContainer<T> {

    @JsonIgnore
    private ResultCode resultCode = ExceptionCode.SUCCESS;
    private String message;
    private T result;

    public int getCode() {
        return resultCode.getResponseCode();
    }

    public ResultContainer(T result) {
        this.result = result;
    }

    public String getMessage() {
        return StringUtils.isBlank(message) ? resultCode.getMessage() : message;
    }


}
