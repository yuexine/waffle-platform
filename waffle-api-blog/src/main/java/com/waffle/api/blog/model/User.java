package com.waffle.api.blog.model;

import com.waffle.api.blog.constant.CommonConstant;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author yuexin
 */
@Data
@Entity
@Table(name = CommonConstant.PREFIX + "user")
public class User extends AbstractModel {

    public static final long serialVersionUID = -5463489572489L;

    @Column
    private String name;

    @Column
    private String avatar;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String password;

}
