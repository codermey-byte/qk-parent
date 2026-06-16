package com.qk.mapper;

import com.qk.entity.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {

    /**
     * 新增角色
     *
     * @param role 角色信息
     */
    @Insert("insert into role(name, label, remark) values (#{name}, #{label}, #{remark})")
    void insert(Role role);

    /**
     * 删除角色
     *
     * @param id 角色 id
     */
    @Delete("delete from role where id = #{id}")
    void deleteById(Integer id);

    /**
     * 更新角色
     *
     * @param role 角色信息
     */
    @Insert("update role set name = #{name}, label = #{label}, remark = #{remark} where id = #{id}")
    void updateById(Role role);


    /**
     * 根据 id 查询角色
     *
     * @param id 角色 id
     * @return
     */
    @Select("select id, name, label, remark, create_time, update_time from role where id = #{id}")
    Role selectById(Integer id);


    /**
     * 角色列表（带分页）
     *
     * @param name  角色名称
     * @param label 角色标识
     * @return
     */
    List<Role> getRoles(String name, String label);


    /**
     * 查询所有角色
     *
     * @return
     */
    @Select("select id, name, label, remark, create_time, update_time from role")
    List<Role> getAllRoles();

}
