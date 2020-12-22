package com.example.demo.dao;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    public static final User user = new User();

    /**
     * Database Column Remarks:
     *   自增ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.id")
    public static final SqlColumn<Long> id = user.id;

    /**
     * Database Column Remarks:
     *   手机号
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.mobile")
    public static final SqlColumn<String> mobile = user.mobile;

    /**
     * Database Column Remarks:
     *   邮箱
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.email")
    public static final SqlColumn<String> email = user.email;

    /**
     * Database Column Remarks:
     *   用户名
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.username")
    public static final SqlColumn<String> username = user.username;

    /**
     * Database Column Remarks:
     *   昵称
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.nickname")
    public static final SqlColumn<String> nickname = user.nickname;

    /**
     * Database Column Remarks:
     *   密码
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.password")
    public static final SqlColumn<String> password = user.password;

    /**
     * Database Column Remarks:
     *   状态，0=未启用，1=正常
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.status")
    public static final SqlColumn<Byte> status = user.status;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.created")
    public static final SqlColumn<LocalDateTime> created = user.created;

    /**
     * Database Column Remarks:
     *   更新时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.updated")
    public static final SqlColumn<LocalDateTime> updated = user.updated;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    public static final class User extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> mobile = column("mobile", JDBCType.VARCHAR);

        public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

        public final SqlColumn<String> username = column("username", JDBCType.VARCHAR);

        public final SqlColumn<String> nickname = column("nickname", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("`password`", JDBCType.VARCHAR);

        public final SqlColumn<Byte> status = column("`status`", JDBCType.TINYINT);

        public final SqlColumn<LocalDateTime> created = column("created", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updated = column("updated", JDBCType.TIMESTAMP);

        public User() {
            super("user");
        }
    }
}