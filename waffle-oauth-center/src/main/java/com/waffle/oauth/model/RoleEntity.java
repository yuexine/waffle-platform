package com.waffle.oauth.model;

import com.waffle.oauth.constant.TableName;
import com.waffle.oauth.model.support.RoleName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author yuexin
 */
@Getter
@Setter
@Entity
@Table(name = TableName.ROLE)
public class RoleEntity extends BaseModel {

    @Column(name = "name")
    private RoleName name;

    @Column(name = "removed")
    private Boolean removed = false;
}
