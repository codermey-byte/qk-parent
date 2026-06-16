package com.qk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qk.common.PageResult;
import com.qk.entity.Role;
import com.qk.mapper.RoleMapper;
import com.qk.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public void addRole(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public void deleteRole(Integer id) {
        roleMapper.deleteById(id);
    }

    @Override
    public void updateRole(Role role) {
        roleMapper.updateById(role);
    }

    @Override
    public Role getRoleById(Integer id) {
        return roleMapper.selectById(id);
    }

    @Override
    public PageResult<Role> getRoles(String name, String label, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Role> list = roleMapper.getRoles(name, label);
        log.info("查询角色列表: name={}, label={}, page={}, pageSize={}, resultCount={}", name, label, page, pageSize, list.size());
        PageInfo<Role> pageInfo = new PageInfo<>(list);
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }
}
