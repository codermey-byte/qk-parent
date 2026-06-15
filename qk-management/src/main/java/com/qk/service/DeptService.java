package com.qk.service;


import com.qk.common.PageResult;
import com.qk.entity.Dept;

/**
 * 部门服务接口
 */
public interface DeptService {
    /**
     * 新增部门
     *
     * @param dept 部门信息
     */
    void addDept(Dept dept);


    /**
     * 查询符合条件的部门分页数据
     *
     * @param name     部门名称
     * @param status   部门状态
     * @param page     当前页码
     * @param pageSize 每页条数
     * @return
     */
    PageResult<Dept> getDepts(String name, Integer status, Integer page, Integer pageSize);

    /**
     * 根据部门 id 查询部门信息
     *
     * @param id 部门 id
     * @return 部门信息
     */

    Dept getDeptById(Integer id);


    /**
     * 更新部门信息
     *
     * @param dept
     */
    void updateDept(Dept dept);

    /**
     * 删除部门
     *
     * @param id
     */
    void deleteDept(Integer id);
}
