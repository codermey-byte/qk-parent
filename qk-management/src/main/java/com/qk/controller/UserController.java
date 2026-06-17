package com.qk.controller;

import com.qk.common.PageResult;
import com.qk.common.Result;
import com.qk.dto.UserDto;
import com.qk.entity.User;
import com.qk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    @PostMapping
    public Result addUser(@RequestBody User user) {
        userService.addUser(user);
        return Result.success();
    }


    /**
     * 删除用户（批量/单个）
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/{ids}")
    public Result deleteUserById(@PathVariable List<Integer> ids) {
        userService.deleteUserById(ids);
        return Result.success();
    }

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    @PutMapping
    public Result updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return Result.success();
    }

    /**
     * 根据 id 查询用户
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getUserById(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        return Result.success(user);
    }

    /**
     * 用户列表（带分页）
     *
     * @param userDto
     * @return
     */
    @GetMapping
    public Result getUsers(UserDto userDto) {
        PageResult<User> pageResult = userService.getUsers(userDto);
        return Result.success(pageResult);
    }
}
