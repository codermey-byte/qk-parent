package com.qk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qk.common.PageResult;
import com.qk.entity.Dept;
import com.qk.mapper.DeptMapper;
import com.qk.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 部门服务实现类
 * 负责处理部门相关的业务逻辑
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public void addDept(Dept dept) {
        deptMapper.insert(dept);
    }

    @Override
    public void deleteDept(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void updateDept(Dept dept) {
        deptMapper.updateById(dept);
    }

    @Override
    public Dept getDeptById(Integer id) {
        return deptMapper.selectById(id);
    }

    @Override
    public PageResult<Dept> getDepts(String name, Integer status, Integer page, Integer pageSize) {
//        方式一：普通 sql 查询
//        Integer count = deptMapper.getDeptsCount(name, status);
//        List<Dept> list = deptMapper.getDepts(name, status, (page - 1) * pageSize, pageSize);
//        PageResult<Dept> pageResult = new PageResult<>(count, list);
//        return pageResult;


//        方式二：借助 pagehelper 插件
        PageHelper.startPage(page, pageSize);
        List<Dept> list = deptMapper.getDeptsByCondition(name, status);
        PageInfo<Dept> pageInfo = new PageInfo<>(list);
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public List<Dept> getAllDepts() {
        return deptMapper.getAllDepts();
    }
}
