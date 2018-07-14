package com.waffle.oauth.web.vmodel;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author yuexin
 */
@Data
public class ResourceDescription implements Serializable {

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
