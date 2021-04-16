package com.csw.xuxianArticle.feign;

import com.csw.xuxianArticle.feign.impl.LabelClientImpl;
import com.csw.xuxianCommon2.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "xuxian-base", fallback = LabelClientImpl.class)
public interface LabelClient {
    @GetMapping("label/{id}")
    Result findLabelById(@PathVariable("id") String id);

}
