package com.waffle.oauth.model;

import com.waffle.oauth.model.support.ScopeName;
import lombok.Data;

import javax.persistence.*;

/**
 * @author yuexin
 */
@Data
@Entity
@Table(name = "scope")
public class Scope extends BaseModel {

    @Column(name = "name")
    private ScopeName name;

    @Column(name = "auto_approve")
    private Boolean autoApprove;

    @Column(name = "removed")
    private Boolean removed;

    @ManyToOne(cascade = CascadeType.ALL)
    private ClientDetail clientDetails;

}
