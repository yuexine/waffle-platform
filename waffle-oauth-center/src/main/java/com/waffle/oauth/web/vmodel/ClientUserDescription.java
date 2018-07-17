package com.waffle.oauth.web.vmodel;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 客户端用户描述对象
 *
 * @author yuexin
 * @since 1.0
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ClientUserDescription extends UserDescription {

    private static final long serialVersionUID = 2536558152480049656L;
}
