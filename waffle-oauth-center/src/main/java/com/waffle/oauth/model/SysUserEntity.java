package com.waffle.oauth.model;

import com.waffle.oauth.constant.TableName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author yuexin
 */
@Getter
@Setter
@Entity
@Table(name = TableName.SYS_USER)
public class SysUserEntity extends BaseTimedModel implements Serializable {

    @OneToOne
    private BaseUserEntity user;

}
