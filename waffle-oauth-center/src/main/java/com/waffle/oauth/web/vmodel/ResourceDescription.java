package com.waffle.oauth.web.vmodel;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author yuexin
 */
@Getter
@Setter
public class ResourceDescription implements Serializable {

    private static final long serialVersionUID = -5844550686099140651L;

    /**
     * 资源名
     */
    @NotNull
    private String name;

    /**
     * 资源key
     */
    @NotNull
    private String resourceId;

    /**
     * 资源访问uri
     */
    private String uri;
}
