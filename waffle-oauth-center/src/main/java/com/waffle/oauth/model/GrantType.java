package com.waffle.oauth.model;

import com.waffle.oauth.constant.TableName;
import com.waffle.oauth.model.support.GrantTypeName;
import lombok.Data;

import javax.persistence.*;

/**
 * 授权类型
 *
 * @author yuexin
 * @since 1.0
 */
@Data
@Entity
@Table(name = TableName.CLIENT_Grant_TYPE)
public class GrantType extends BaseModel {

    /**
     * 授权类型
     */
    @Column(name = "type", length = 50, nullable = false)
    private GrantTypeName type;

    /**
     * 已经移除
     */
    @Column(name = "removed")
    private Boolean removed;

    /**
     * 备注
     */
    @Column(name = "remark", length = 200)
    private String remark;

    /**
     * 对应的客户端详细
     */
    @ManyToOne(cascade = CascadeType.ALL)
    private ClientDetail clientDetails;
}
