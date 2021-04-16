package com.csw.xuxianBase.service.impl;

import com.csw.xuxianBase.dao.LabelResposity;
import com.csw.xuxianBase.entity.Label;
import com.csw.xuxianBase.service.LabelService;
import com.csw.xuxianCommon2.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelResposity labelResposity;
    @Autowired
    private IdWorker idWorker;

    @Override
    public Label addLabel(Label label) {
        label.setId(idWorker.nextId() + "");
        return labelResposity.save(label);
    }

    @Override
    public Label getLabelById(String id) {
        return labelResposity.findById(id).get();
    }
}
