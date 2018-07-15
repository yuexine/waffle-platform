package com.waffle.oauth.model;

import com.waffle.oauth.constant.TableName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 接入的客户端归属
 *
 * @author yuexin
 * @since 1.0
 */
@Getter
@Setter
@Entity
@Table(name = TableName.CLIENT_USER)
public class ClientUserEntity extends BaseTimedModel implements Serializable {

    @OneToOne(cascade = CascadeType.ALL)
    private BaseUserEntity user;

    /**
     * 拥有的客户端集合
     */
    @OneToMany(mappedBy = "clientUser")
    private Set<ClientEntity> clients = new HashSet<>();
}
