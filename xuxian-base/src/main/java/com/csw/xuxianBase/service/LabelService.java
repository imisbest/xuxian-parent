package com.csw.xuxianBase.service;

import com.csw.xuxianBase.entity.Label;

public interface LabelService {
    //新增
    Label addLabel(Label label);

    //根据id查询
    Label getLabelById(String id);
}
