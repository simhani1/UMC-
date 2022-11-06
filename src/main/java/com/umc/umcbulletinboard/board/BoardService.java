package com.umc.umcbulletinboard.board;

import com.umc.umcbulletinboard.board.model.Board;
import com.umc.umcbulletinboard.board.model.PostWritingRes;
import com.umc.umcbulletinboard.user.model.PostLoginRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    private final BoardDao boardDao;
    @Autowired
    public BoardService(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    /**
     * 글 작성
     * POST
     */
    public PostWritingRes createPost(int userId, Board board) {
        int boardId = boardDao.createPost(userId, board);
        return new PostWritingRes(boardId);
    }
}
