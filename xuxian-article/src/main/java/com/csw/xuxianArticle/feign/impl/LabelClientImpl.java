package com.csw.xuxianArticle.feign.impl;

import com.csw.xuxianArticle.feign.LabelClient;
import com.csw.xuxianCommon2.entity.Result;
import com.csw.xuxianCommon2.entity.StatusCode;
import org.springframework.stereotype.Component;

@Component
public class LabelClientImpl implements LabelClient {
    @Override
    public Result findLabelById(String id) {
        return new Result(false, StatusCode.ERROR, "熔断器启动了", null);
    }
}
