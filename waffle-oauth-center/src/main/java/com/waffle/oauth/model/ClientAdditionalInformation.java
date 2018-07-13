package com.waffle.oauth.model;

import com.waffle.oauth.constant.TableName;
import lombok.Data;

import javax.persistence.*;

/**
 * 客户端自定义信息
 *
 * @author yuexin
 * @since 1.0
 */
@Data
@Entity
@Table(name = TableName.CLIENT_ADDITIONAL_INFORMATION)
public class ClientAdditionalInformation extends BaseTimedModel {

    /**
     * 自定义key
     */
    @Column(name = "name")
    private String name;

    /**
     * 自定义值
     */
    @Column(name = "value")
    private String value;

    /**
     * 已被删除
     */
    @Column(name = "removed")
    private Boolean removed;

    /**
     * 对应客户端详细
     */
    @ManyToOne(cascade = CascadeType.ALL)
    private ClientDetail clientDetails;
}
