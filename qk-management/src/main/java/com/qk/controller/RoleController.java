package com.qk.controller;

import com.qk.common.PageResult;
import com.qk.common.Result;
import com.qk.entity.Role;
import com.qk.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色管理控制器
 */
@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 新增角色
     *
     * @param role 角色信息
     * @return
     */
    @PostMapping("/roles")
    public Result addRole(@RequestBody Role role) {
        roleService.addRole(role);
        return Result.success();
    }

    /**
     * 删除角色
     *
     * @param id 角色 id
     * @return
     */
    @DeleteMapping("/roles/{id}")
    public Result deleteRole(@PathVariable Integer id) {
        roleService.deleteRole(id);
        return Result.success();
    }

    /**
     * 更新角色
     *
     * @param role 角色信息
     * @return
     */
    @PutMapping("/roles")
    public Result updateRole(@RequestBody Role role) {
        roleService.updateRole(role);
        return Result.success();
    }

    /**
     * 根据 id 查询角色
     *
     * @param id 角色 id
     * @return
     */
    @GetMapping("/roles/{id}")
    public Result getRoleById(@PathVariable Integer id) {
        Role role = roleService.getRoleById(id);
        return Result.success(role);
    }


    /**
     * 角色列表（带分页）
     *
     * @param name     角色名称
     * @param label    角色标识
     * @param page     当前页码
     * @param pageSize 每页条数
     * @return
     */
    @GetMapping("/roles")
    public Result getRoles(
            String name,
            String label,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        PageResult<Role> pageResult = roleService.getRoles(name, label, page, pageSize);
        return Result.success(pageResult);
    }

    @GetMapping("/roles/list")
    public Result getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        return Result.success(roles);
    }
}
