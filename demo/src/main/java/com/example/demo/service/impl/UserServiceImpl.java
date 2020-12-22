package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.select;
import static com.example.demo.dao.UserDynamicSqlSupport.user;

/**
 * TODO
 *
 * @author wangdf
 * @version 1.0, 2020/12/22
 * @since 1.0.0
 */
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        SelectStatementProvider selectStatement = select(UserMapper.selectList)
                .from(user)
                .build()
                .render(RenderingStrategies.SPRING_NAMED_PARAMETER);

        return userMapper.selectMany(selectStatement);
    }
}
