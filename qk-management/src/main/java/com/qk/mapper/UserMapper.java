package com.qk.mapper;

import com.qk.dto.UserDto;
import com.qk.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {


    /**
     * 添加用户
     *
     * @param user
     */
    void addUser(User user);

    /**
     * 删除用户（批量/单个）
     *
     * @param ids 用户 id 列表
     */
    void deleteUserByIds(List<Integer> ids);

    /**
     * 更新用户
     *
     * @param user
     */
    void updateUserById(User user);

    /**
     * 根据 id 查询用户
     *
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 用户列表 （带分页）
     *
     * @param userDto
     * @return
     */
    List<User> getUsers(UserDto userDto);

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 用户信息
     */
    User getUserByUsername(String username);

    /**
     * 根据角色查询用户
     *
     * @param roleLabel 角色标签
     * @return
     */
    List<User> getUsersByRoleLabel(String roleLabel);

    /**
     * 根据部门查询用户
     *
     * @param deptId
     * @return
     */
    @Select("SELECT * FROM user WHERE dept_id = #{deptId}")
    List<User> getUsersByDeptId(Integer deptId);
}
