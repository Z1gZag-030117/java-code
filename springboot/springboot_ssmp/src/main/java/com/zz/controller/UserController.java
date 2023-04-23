package com.zz.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zz.pojo.User;
import com.zz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 朱喆
 * @version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public List<User> getAll(){
        return userService.list();
    }

    @PostMapping
    public Boolean save(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping
    public Boolean update(@RequestBody User user){
        return userService.modify(user);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable Integer id){
        return userService.delete(id);
    }

    @GetMapping("{id}")
    public User getById(@PathVariable Integer id){
        return userService.getById(id);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<User> getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        return userService.getPage(currentPage,pageSize);
    }

}
