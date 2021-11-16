package com.hackathon.youngandrich.common.model;

import com.hackathon.youngandrich.common.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class ErrorResult extends ResultContainer<Void> {
    public ErrorResult(ExceptionCode resultCode) {
        super();
        setResultCode(resultCode);
        setMessage(resultCode.getMessage());
    }
}
