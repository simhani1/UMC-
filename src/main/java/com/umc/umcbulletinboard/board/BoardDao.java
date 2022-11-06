package com.umc.umcbulletinboard.board;

import com.umc.umcbulletinboard.board.model.Board;
import com.umc.umcbulletinboard.board.model.PostWritingRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import javax.sql.DataSource;

@Repository
public class BoardDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * 글 작성
     * POST
     */
    public int createPost(int userId, Board board) {
        String createPostQuery = "insert into Board (boardTypeId, userId, title, contents) values (?, ?, ?, ?)";
        Object[] createPostParams = new Object[]{board.getBoardType(), userId, board.getTitle(), board.getContents()};
        this.jdbcTemplate.update(createPostQuery, createPostParams);
        String lastInsertIdQuery = "select last_insert_id()";
        return this.jdbcTemplate.queryForObject(lastInsertIdQuery, int.class);
    }
}
