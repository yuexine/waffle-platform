package com.waffle.api.blog.model;

import com.waffle.api.blog.model.support.DestType;
import com.waffle.api.blog.model.support.FileType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author yuexin
 */
@Getter
@Setter
@Entity
@Table(name = "document")
public class Document extends AbstractModel {

    private static final long serialVersionUID = -7782115039275574516L;

    @Column(name = "name")
    private String name;

    @Column(name = "size")
    private long size;

    @Column(name = "type")
    private FileType type;

    @Column(name = "relative_position", columnDefinition = "varchar(255) comment '文件存储相对路径'")
    private String relativePosition;

    @Column(name = "dest_type")
    private DestType destType;

    @Column(name = "temporary", columnDefinition = "int(1) comment '临时文件返回true'")
    private Boolean temporary;

    public Document(Long documentId) {
        setId(documentId);
    }

    public Document() {
    }
}
