package com.waffle.api.blog.web.wrapper;

import com.waffle.api.blog.config.ApplicationProperties;
import com.waffle.api.blog.model.Document;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yuexin
 * @since 1.0
 */
@Getter
@Setter
public class FileWrapper implements Wrapper {

    private static final long serialVersionUID = -8800730997814507817L;

    private String name;

    private Long document;

    private String path;

    public FileWrapper(Document document, ApplicationProperties properties) {
        setName(document.getName());
        setDocument(document.getId());
        setPath(document.getRelativePosition());
    }
}
