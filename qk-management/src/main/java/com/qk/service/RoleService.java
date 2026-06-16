package com.qk.service;

import com.qk.common.PageResult;
import com.qk.entity.Role;

import java.util.List;

public interface RoleService {

    /**
     * 新增角色
     *
     * @param role 角色信息
     */
    void addRole(Role role);

    /**
     * 删除角色
     *
     * @param id 角色 id
     */
    void deleteRole(Integer id);

    /**
     * 更新角色
     *
     * @param role 角色信息
     */
    void updateRole(Role role);

    /**
     * 根据 id 查询角色
     *
     * @param id 角色 id
     * @return
     */
    Role getRoleById(Integer id);

    /**
     * 角色列表（带分页）
     *
     * @param name     角色名称
     * @param label    角色标识
     * @param page     当前页码
     * @param pageSize 每页条数
     * @return
     */
    PageResult<Role> getRoles(String name, String label, Integer page, Integer pageSize);


    /**
     * 查询所有角色
     *
     * @return
     */
    List<Role> getAllRoles();
}
