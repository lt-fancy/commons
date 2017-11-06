package com.sawallianc.entity.exception;

import com.sawallianc.entity.ResultCode;

public class BizRuntimeException extends RuntimeException{
    private ResultCode resultCode;

    public BizRuntimeException(ResultCode resultCode, String errMsg){
        super(errMsg);
        this.resultCode = resultCode;
    }
    public BizRuntimeException(ResultCode resultCode, String errMsg,Throwable cause){
        super(errMsg,cause);
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}
