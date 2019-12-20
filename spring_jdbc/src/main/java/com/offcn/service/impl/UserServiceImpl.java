package com.offcn.service.impl;

import com.offcn.pojo.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        return  jdbcTemplate.query("select * from tb_user",new BeanPropertyRowMapper(User.class));

    }

    @Override
    public void saveUser(User user) {

        jdbcTemplate.update("insert into tb_user values (?,?,?)",user.getId(),user.getName(),user.getBirthday());
    }

    @Override
    public User findOne(Integer id) {
        return (User) jdbcTemplate.queryForObject("select * from tb_user where id= ? ",new BeanPropertyRowMapper(User.class),id);
    }

    @Override
    public void deleteUser(Integer id) {
         jdbcTemplate.update("delete from tb_user where id = ?",id);
    }

    @Override
    public void updateUser(User user) {
         jdbcTemplate.update("update tb_user set name=?,birthday=? where id=?",user.getName(),user.getBirthday(),user.getId());
    }
}
