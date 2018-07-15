package com.waffle.oauth.model;

import com.waffle.oauth.constant.TableName;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * 受信任的重定向地址
 *
 * @author yuexin
 * @since 1.0
 */
@Getter
@Setter
@Entity
@Table(name = TableName.CLIENT_REDIRECT_URI)
public class RedirectUriEntity extends BaseTimedModel {

    /**
     * 重定向地址
     */
    @Type(type = "text")
    @Column(name = "uri", nullable = false)
    private String uri;

    /**
     * 已删除
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
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ClientDetailEntity clientDetails;
}
