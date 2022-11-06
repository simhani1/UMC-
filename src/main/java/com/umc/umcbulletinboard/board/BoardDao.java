package com.umc.umcbulletinboard.board;

import com.umc.umcbulletinboard.board.model.Board;
import com.umc.umcbulletinboard.board.model.GetAllPostRes;
import com.umc.umcbulletinboard.board.model.PostWritingRes;
import com.umc.umcbulletinboard.user.model.PostLoginRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import javax.sql.DataSource;
import java.util.List;

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

    /**
     * 전체 글 조회
     * GET
     */
    public List<GetAllPostRes> getAllPost() {
        String getAllPostQuery = "select BT.type         as boardType,\n" +
                "       U.nickname      as nickname,\n" +
                "       title,\n" +
                "       contents,\n" +
                "       Board.createdAt as time\n" +
                "from Board\n" +
                "         left join BoardType BT on Board.boardTypeId = BT.boardTypeId\n" +
                "         left join User U on Board.userId = U.userId\n" +
                "order by time;";
        return this.jdbcTemplate.query(getAllPostQuery,
                (rs, rowNum) -> new GetAllPostRes(
                        rs.getString("boardType"),
                        rs.getString("nickname"),
                        rs.getString("title"),
                        rs.getString("contents"),
                        rs.getString("time")
                ));
    }
}
