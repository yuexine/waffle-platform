package com.waffle.api.blog.web.description;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author yuexin
 * @since 1.0
 */
@Data
public class PostDescription implements Serializable {

    private static final long serialVersionUID = 8566853544242192048L;

    private String keywords;

    @NotNull
    @Length(min = 1, max = 255)
    private String title;

    private String context;

    private Long document;

    private String author;

}
