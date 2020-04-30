package com.soft1851.springboot.aop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName RolePermission
 * @Description TODO
 * @Author 丁怡凡
 * @Date 2020年04月14日 09:47:00
 * @Version 1.0.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RolePermission implements Serializable {
    private static final long serialVersionUID = 270567046211088726L;
    /**
     * id
     */
    private Integer id;
    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 权限id
     */
    private Integer permissionId;

}