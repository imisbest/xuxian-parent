package com.csw.xuxianBase.controller;

import com.csw.xuxianBase.entity.Label;
import com.csw.xuxianBase.service.LabelService;
import com.csw.xuxianCommon2.entity.Result;
import com.csw.xuxianCommon2.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("label")
@CrossOrigin
public class LabelController {
    @Autowired
    private LabelService labelService;

    //根据id查询标记
    @GetMapping("{id}")
    public Result findLabelById(@PathVariable("id") String id) {
        /*int i=1/0;//模拟异常*/
        return new Result(true, StatusCode.OK, "查询成功", labelService.getLabelById(id));
    }

    //新增标签
    @PostMapping("addLabel")
    public Result addLabel(@RequestBody Label label) {
        return new Result(true, StatusCode.OK, "新增成功", labelService.addLabel(label));
    }
}
