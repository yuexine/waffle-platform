package com.waffle.api.blog.web.model;

import lombok.Data;

/**
 * 构造微信用户
 *
 * @author yuexin
 */
@Data
public class WechatUserBuilder extends StandardUserBuilder {

    private String openId;

    private String wechatName;

}
