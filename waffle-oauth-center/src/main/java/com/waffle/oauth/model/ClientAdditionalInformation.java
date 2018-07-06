package com.waffle.oauth.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author yuexin
 */
@Data
@Entity
@Table(name = "client_additional_information")
public class ClientAdditionalInformation extends BaseTimedModel {

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    @Column(name = "removed")
    private Boolean removed;

    @ManyToOne(cascade = CascadeType.ALL)
    private DefaultClientDetails clientDetails;
}
