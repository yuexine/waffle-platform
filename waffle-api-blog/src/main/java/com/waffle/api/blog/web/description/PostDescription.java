package com.waffle.api.blog.web.description;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Post 描述信息，用于接收Post表单参数，构建Post
 *
 * @author yuexin
 * @since 1.0
 */
@Data
@ApiModel
public class PostDescription implements Serializable {

    private static final long serialVersionUID = 8566853544242192048L;

    @ApiModelProperty(value = "关键字及标签，多个标签以英文逗号隔开", example = "spring,angular")
    private String keywords;

    @NotNull
    @Length(min = 1, max = 255)
    @ApiModelProperty(value = "标题", required = true, notes = "长度限制小于255")
    private String title;

    @ApiModelProperty(value = "缩略正文")
    private String context;

    @NotNull
    @ApiModelProperty(value = "文档key")
    private Long document;

    @ApiModelProperty(value = "作者")
    private String author;

}
