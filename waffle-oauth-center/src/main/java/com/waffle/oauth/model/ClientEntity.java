package com.waffle.oauth.model;

import com.waffle.oauth.constant.TableName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 客户端信息，每一个接入的客户端为一个实例
 *
 * @author yuexin
 * @since 1.0
 */
@Getter
@Setter
@Entity
@Table(name = TableName.CLIENT)
public class ClientEntity extends BaseTimedModel {

    /**
     * 接入的客户端名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 客户端详细信息
     */
    @OneToOne(fetch = FetchType.LAZY)
    private ClientDetailEntity clientDetail = new ClientDetailEntity();

    /**
     * 客户端所有者
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private ClientUserEntity clientUser = new ClientUserEntity();
}
