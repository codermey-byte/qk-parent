package com.qk.mapper;

import com.qk.entity.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {

    /**
     * 新增部门信息
     */
    @Insert("insert into dept(name, status) values (#{name}, #{status})")
    void insert(Dept dept);

    /**
     * 查询符合条件的部门总数量
     *
     * @param name   部门名称
     * @param status 部门状态
     * @return
     */
//  @Select("select count(*) from dept where name like concat('%', #{name}, '%') and status = #{status}")
    Integer getDeptsCount(String name, Integer status);

    /**
     * 方式一：普通 sql 查询
     * 查询符合条件的部门列表数量
     *
     * @param name     部门名称
     * @param status   部门状态
     * @param offset   起始索引
     * @param pageSize 每页条数
     * @return
     */
//  @Select("select * from dept where name like concat('%', #{name}, '%') and status = #{status} limit #{offset}, #{pageSize}")
    List<Dept> getDepts(String name, Integer status, Integer offset, Integer pageSize);

    /**
     * 方式二：借助 pagehelper 插件
     * 查询符合条件的部门列表数量
     *
     * @param name   部门名称
     * @param status 部门状态
     * @return
     */
    List<Dept> getDeptsByCondition(String name, Integer status);


    /**
     * 根据部门 id 查询部门信息
     *
     * @param id
     * @return
     */
    @Select("select id,name,status,create_time,update_time from dept where id = #{id}")
    Dept selectById(Integer id);


    /**
     * 根据部门 id 更新部门信息
     *
     * @param dept
     */
    void updateById(Dept dept);

    /**
     * 根据部门 id 删除部门信息
     *
     * @param id
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);
}
