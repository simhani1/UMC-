package com.umc.umcbulletinboard.user;

import com.umc.umcbulletinboard.user.model.PostLoginReq;
import com.umc.umcbulletinboard.user.model.PostLoginRes;
import com.umc.umcbulletinboard.user.model.PostUserReq;
import com.umc.umcbulletinboard.user.model.PostUserRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * 회원가입
     * POST
     */
    public int createUser(PostUserReq postUserReq) {
        String createUserQuery = "insert into User (nickname, id, pwd) VALUES (?, ?, ?)";
        Object[] createUserParams = new Object[]{postUserReq.getNickname(), postUserReq.getId(), postUserReq.getPwd()};
        this.jdbcTemplate.update(createUserQuery, createUserParams);
        String lastInsertIdQuery = "select last_insert_id()";
        return this.jdbcTemplate.queryForObject(lastInsertIdQuery, int.class);
    }

    /**
     * 로그인
     * POST
     */
    public PostLoginRes getNickname(PostLoginReq postLoginReq) {
        String getNicknameQuery="select nickname from User where id = ? and pwd = ?";
        Object[] getNicknameParams = new Object[]{postLoginReq.getId(), postLoginReq.getPwd()};
        return this.jdbcTemplate.queryForObject(getNicknameQuery,
                (rs, rowNum) -> new PostLoginRes(
                        rs.getString("nickname")
                ),
                getNicknameParams);
    }
}
