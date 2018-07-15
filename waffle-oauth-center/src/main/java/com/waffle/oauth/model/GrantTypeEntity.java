package com.waffle.oauth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.waffle.oauth.constant.TableName;
import com.waffle.oauth.model.support.GrantTypeName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 授权类型
 *
 * @author yuexin
 * @since 1.0
 */
@Getter
@Setter
@Entity
@Table(name = TableName.CLIENT_Grant_TYPE)
public class GrantTypeEntity extends BaseModel {

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
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private ClientDetailEntity clientDetails;
}
