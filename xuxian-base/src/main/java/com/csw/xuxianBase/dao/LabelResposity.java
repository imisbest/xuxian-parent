package com.csw.xuxianBase.dao;

import com.csw.xuxianBase.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LabelResposity extends JpaRepository<Label, String>, JpaSpecificationExecutor<Label> {
}
