package com.csw.xuxianUser.xuxianBase.xuxianArticle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

//第四步
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_admin")
public class Admin implements Serializable {
    @Id
    private String id;
    private String loginName;
    private String password;
    private String state;


}
