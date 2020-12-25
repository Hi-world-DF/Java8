package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.dto.SignUpResponseDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.IRedisService;
import com.example.demo.service.IUserService;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.mybatis.dynamic.sql.SqlBuilder.insert;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;
import static com.example.demo.dao.UserDynamicSqlSupport.user;

/**
 * 用户服务实现
 *
 * @author wangdf
 * @version 1.0, 2020/12/22
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    IRedisService redisService;

    RedissonClient redisson;

    private RLock lock;

    @Autowired
    public void setRedisService(RedissonClient redisson) {
        this.redisson = redisson;
        this.lock = redisson.getLock("sdf");
    }

    /** {@inheritDoc} */
    @Override
    public List<User> getUserList() {
        SelectStatementProvider selectStatement = select(UserMapper.selectList)
                .from(user)
                .build()
                .render(RenderingStrategies.MYBATIS3);

        return userMapper.selectMany(selectStatement);
    }

    /** {@inheritDoc} */
    @Override
    public Optional<User> getUserById(Long id) {

        SelectStatementProvider selectStatement = select(UserMapper.selectList)
                .from(user)
                .where(user.id, isEqualTo(id))
                .build()
                .render(RenderingStrategies.MYBATIS3);

        return userMapper.selectOne(selectStatement);
    }

    /** {@inheritDoc} */
    @Override
    public int save(UserDTO userDTO) {

        InsertStatementProvider insertStatement = insert(userDTO)
                .into(user)
                .map(user.id).toProperty("id")
                .map(user.mobile).toProperty("mobile")
                .map(user.email).toProperty("email")
                .map(user.username).toProperty("username")
                .map(user.nickname).toProperty("nickname")
                .map(user.password).toProperty("password")
                .map(user.created).toProperty("created")
                .build()
                .render(RenderingStrategies.MYBATIS3);

        return userMapper.insert(insertStatement);
    }

    /** {@inheritDoc} */
    @Override
    public SignUpResponseDTO signUp(String email) {

        SignUpResponseDTO signUpResponseDTO = new SignUpResponseDTO();
        UUID userId = UUID.randomUUID();
        signUpResponseDTO.setUserId(userId.toString());

        lock.lock(10, TimeUnit.SECONDS);
        boolean isLock;
        try {
            isLock = lock.tryLock(100, 10, TimeUnit.SECONDS);
            if (isLock) {
                //邮箱注册,
                if (redisService.exit(email)) {
                    signUpResponseDTO.setSuccess(false);
                    signUpResponseDTO.setMessage("邮箱已注册：可直接登陆！");
                } else {
                    redisService.set(email, userId.toString());
                    signUpResponseDTO.setSuccess(true);
                    signUpResponseDTO.setMessage("注册成功");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return signUpResponseDTO;
    }
}
