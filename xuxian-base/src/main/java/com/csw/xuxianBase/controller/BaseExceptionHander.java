package com.csw.xuxianBase.controller;

import com.csw.xuxianCommon2.entity.Result;
import com.csw.xuxianCommon2.entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class BaseExceptionHander {
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result error(Exception e) {
        return new Result(false, StatusCode.ERROR, "出错了", e.getMessage());
    }

}
