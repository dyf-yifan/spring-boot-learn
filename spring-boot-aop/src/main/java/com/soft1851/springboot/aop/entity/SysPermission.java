package com.soft1851.springboot.aop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName SysPermission
 * @Description TODO
 * @Author 丁怡凡
 * @Date 2020年04月14日 09:48:00
 * @Version 1.0.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SysPermission implements Serializable {
    private static final long serialVersionUID = 700935788952405813L;
    /**
     * 权限id
     */
    private Integer perId;
    /**
     * 父类id
     */
    private Integer parentId;
    /**
     * 权限名称
     */
    private String pName;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 图标
     */
    private String icon;
    /**
     * 地址
     */
    private String path;
    /**
     * 扩展字段1
     */
    private String ex1;
    /**
     * 扩展字段2
     */
    private Integer ex2;
}