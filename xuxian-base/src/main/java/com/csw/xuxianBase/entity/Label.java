package com.csw.xuxianBase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_label")
public class Label {
    @Id
    private String id;//主键通过IdWorker生产
    private String labelName;//标签姓名
    private String state;//标签状态
    private Long count;//使用次数
    private Long fans;//粉丝状态
    private String recommend;//是否关注
}
