package com.waffle.oauth.model;

import com.waffle.oauth.constant.TableName;
import com.waffle.oauth.model.support.ScopeName;
import lombok.Data;

import javax.persistence.*;

/**
 * 授权作用域
 *
 * @author yuexin
 * @since 1.0
 */
@Data
@Entity
@Table(name = TableName.CLIENT_SCOPE)
public class Scope extends BaseModel {

    /**
     * 作用域名称
     */
    @Column(name = "name")
    private ScopeName name;

    /**
     * 自动允许
     */
    @Column(name = "auto_approve")
    private Boolean autoApprove;

    /**
     * 被移除了
     */
    @Column(name = "removed")
    private Boolean removed;

    /**
     * 对应的客户端
     */
    @ManyToOne(cascade = CascadeType.ALL)
    private ClientDetail clientDetails;

}
