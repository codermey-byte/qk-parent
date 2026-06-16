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
     * 新增部门
     */
    @Insert("insert into dept(name, status) values (#{name}, #{status})")
    void insert(Dept dept);

    /**
     * 删除部门
     *
     * @param id 部门 id
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);


    /**
     * 更新部门
     *
     * @param dept 部门信息
     */
    void updateById(Dept dept);

    /**
     * 根据 id 查询部门
     *
     * @param id 部门 id
     * @return 部门信息
     */
    @Select("select id,name,status,create_time,update_time from dept where id = #{id}")
    Dept selectById(Integer id);

    /**
     * 查询符合条件的部门总数
     *
     * @param name   部门名称
     * @param status 部门状态
     * @return
     */
//  @Select("select count(*) from dept where name like concat('%', #{name}, '%') and status = #{status}")
    Integer getDeptsCount(String name, Integer status);

    /**
     * 方式一：普通 sql 查询
     * 部门列表（带分页）
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
     * 部门列表（带分页）
     *
     * @param name   部门名称
     * @param status 部门状态
     * @return
     */
    List<Dept> getDeptsByCondition(String name, Integer status);

    /**
     * 查询所有部门
     *
     * @return
     */
    @Select("select id,name,status,create_time,update_time from dept")
    List<Dept> getAllDepts();
}
