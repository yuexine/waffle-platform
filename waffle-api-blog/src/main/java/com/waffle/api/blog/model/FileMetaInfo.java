package com.waffle.api.blog.model;

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
@Table(name = "file_meta_info")
public class FileMetaInfo extends AbstractModel {

    @Column
    private String name;

    @Column
    private long size;

    @Column
    private FileType type;

    @Column
    private String path;
}
