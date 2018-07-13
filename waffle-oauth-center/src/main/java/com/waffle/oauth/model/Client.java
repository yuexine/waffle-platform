package com.waffle.oauth.model;

import com.waffle.oauth.constant.TableName;
import lombok.Data;

import javax.persistence.*;

/**
 * 客户端信息，每一个接入的客户端为一个实例
 *
 * @author yuexin
 */
@Data
@Entity
@Table(name = TableName.CLIENT)
public class Client extends BaseTimedModel {

    /**
     * 接入的客户端名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 客户端详细信息
     */
    @OneToOne
    private ClientDetail clientDetail;

    @ManyToOne
    private ClientUser clientUser;
}
