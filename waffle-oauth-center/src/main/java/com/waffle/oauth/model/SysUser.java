package com.waffle.oauth.model;

import com.waffle.oauth.constant.TableName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author yuexin
 */
@Data
@Entity
@Table(name = TableName.SYS_USER)
public class SysUser implements Serializable {

    @OneToOne
    private BaseUser user;

}
