package com.soft1851.springboot.aop.service;

import java.util.List;
import java.util.Map;

/**
 * @author dyf
 */
public interface RolePermissionService {

    /**
     * 查询超管权限
     * @return
     */
    List<Map<String, Object>> getAdminRolePermission();

    /**
     * 查询
     * @param sysAdminId
     * @return
     */
    List<Map<String, Object>> getRolePermissionBySysAdmin(int sysAdminId);
}