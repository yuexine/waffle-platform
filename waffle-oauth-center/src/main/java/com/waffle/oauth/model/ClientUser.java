package com.waffle.oauth.model;

import com.waffle.oauth.constant.TableName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 接入的客户端归属
 *
 * @author yuexin
 */
@Data
@Entity
@Table(name = TableName.CLIENT_USER)
public class ClientUser extends BaseUserInfo implements Serializable {

    @OneToMany(mappedBy = "clientUser")
    private Set<Client> clients = new HashSet<>();
}
