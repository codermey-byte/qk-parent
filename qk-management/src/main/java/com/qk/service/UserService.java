package com.qk.service;

import com.qk.common.PageResult;
import com.qk.dto.UserDto;
import com.qk.entity.User;
import com.qk.vo.LoginResultVo;

import java.util.List;


public interface UserService {

    /**
     * 新增用户
     *
     * @param user
     */
    void addUser(User user);


    /**
     * 删除用户
     *
     * @param ids
     */
    void deleteUserById(List<Integer> ids);

    /**
     * 更新用户
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据 id 查询用户
     *
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 用户列表（带分页）
     *
     * @param userDto
     * @return
     */
    PageResult<User> getUsers(UserDto userDto);

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    LoginResultVo login(String username, String password);

}
