package com.waffle.oauth.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 主键定义
 *
 * @author yuexin
 */
@Data
@MappedSuperclass
public abstract class BaseModel {

    /**
     * 主键生成策略
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
