package com.qk.controller;

import com.qk.common.PageResult;
import com.qk.common.Result;
import com.qk.entity.Dept;
import com.qk.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 部门管理控制器
 */
@Slf4j
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 新增部门
     */
    @PostMapping("/depts")
    public Result addDept(@RequestBody Dept dept) {
        log.info("新增部门:{}", dept);
        deptService.addDept(dept);
        return Result.success();
    }

    /**
     * 删除部门
     *
     * @param id
     * @return
     */
    @DeleteMapping("/depts/{id}")
    public Result deleteDept(@PathVariable Integer id) {
        log.info("删除部门: id={}", id);
        deptService.deleteDept(id);
        return Result.success();
    }

    /**
     * 更新部门
     *
     * @param dept
     * @return
     */
    @PutMapping("/depts")
    public Result updateDept(@RequestBody Dept dept) {
        log.info("更新部门信息: {}", dept);
        deptService.updateDept(dept);
        return Result.success();
    }

    /**
     * 根据 id 查询部门
     *
     * @param id 部门 id
     * @return
     */
    @GetMapping("/depts/{id}")
    public Result getDeptById(@PathVariable Integer id) {
        log.info("根据 id 查询部门信息: id={}", id);
        return Result.success(deptService.getDeptById(id));
    }

    /**
     * 部门列表（带分页）
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
        log.info("查询部门列表: name={}, status={}, page={}, pageSize={}", name, status, page, pageSize);
        PageResult<Dept> pageResult = deptService.getDepts(name, status, page, pageSize);
        return Result.success(pageResult);
    }

    /**
     * 查询所有部门
     *
     * @return
     */
    @GetMapping("/depts/list")
    public Result getAllDepts() {
        log.info("查询所有部门");
        return Result.success(deptService.getAllDepts());
    }
}
