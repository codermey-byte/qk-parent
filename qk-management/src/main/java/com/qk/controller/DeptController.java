package com.qk.controller;

import com.qk.common.PageResult;
import com.qk.common.Result;
import com.qk.entity.Dept;
import com.qk.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 部门管理控制器
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 新增部门
     */
    @PostMapping("/depts")
    public Result addDept(@RequestBody Dept dept) {
        deptService.addDept(dept);
        return Result.success();
    }

    /**
     * 查询部门列表
     *
     * @param name     部门名称
     * @param status   部门状态
     * @param page     当前页码
     * @param pageSize 每页条数
     * @return
     */
    @GetMapping("/depts")
    public Result getDepts(
            String name,
            Integer status,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        PageResult<Dept> pageResult = deptService.getDepts(name, status, page, pageSize);
        return Result.success(pageResult);
    }

    /**
     * 根据 id 查询部门信息
     *
     * @param id 部门 id
     * @return
     */
    @GetMapping("/depts/{id}")
    public Result getDeptById(@PathVariable Integer id) {
        return Result.success(deptService.getDeptById(id));
    }

    /**
     * 更新部门信息
     *
     * @param dept
     * @return
     */
    @PutMapping("/depts")
    public Result updateDept(@RequestBody Dept dept) {
        deptService.updateDept(dept);
        return Result.success();
    }

    @DeleteMapping("/depts/{id}")
    public Result deleteDept(@PathVariable Integer id) {
        deptService.deleteDept(id);
        return Result.success();
    }
}
