package com.qk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qk.common.PageResult;
import com.qk.dto.UserDto;
import com.qk.entity.User;
import com.qk.exception.BusinessException;
import com.qk.mapper.UserMapper;
import com.qk.service.UserService;
import com.qk.utils.JwtUtils;
import com.qk.vo.LoginResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        // 密码加密
        user.setPassword(DigestUtils.md5DigestAsHex((user.getUsername() + "123").getBytes()));
        userMapper.addUser(user);
    }

    @Override
    public void deleteUserById(List<Integer> ids) {
        userMapper.deleteUserByIds(ids);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUserById(user);
    }

    @Override
    public User getUserById(Integer id) {
        User user = userMapper.getUserById(id);
        return user;
    }

    @Override
    public PageResult<User> getUsers(UserDto userDto) {
        PageHelper.startPage(userDto.getPage(), userDto.getPageSize());
        List<User> list = userMapper.getUsers(userDto);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public List<User> getUsersByRoleLabel(String roleLabel) {
        return userMapper.getUsersByRoleLabel(roleLabel);
    }

    @Override
    public List<User> getUsersByDeptId(Integer deptId) {
        return userMapper.getUsersByDeptId(deptId);
    }

    @Override
    public LoginResultVo login(String username, String password) {
        User user = userMapper.getUserByUsername(username);
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
//        log.debug("用户名：{}，密码：{}", username, md5Password);
        if (user == null) {
            log.error("用户不存在");
            throw new BusinessException("用户不存在");
        }
        if (!user.getPassword().equals(md5Password)) {
            log.error("密码错误");
            throw new BusinessException("密码错误");
        }
        if (user.getStatus() == 0) {
            log.error("用户被停用");
            throw new BusinessException("您的账号已被停用，请联系管理员");
        }
        LoginResultVo loginResultVo = new LoginResultVo();
        loginResultVo.setId(user.getId());
        loginResultVo.setUsername(user.getUsername());
        loginResultVo.setName(user.getName());
        loginResultVo.setImage(user.getImage());
        loginResultVo.setRoleName(user.getRoleName());

        // 生成JWT令牌
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("username", user.getUsername());
        String token = JwtUtils.generateToken(claims);
        loginResultVo.setToken(token);

        return loginResultVo;
    }
}
