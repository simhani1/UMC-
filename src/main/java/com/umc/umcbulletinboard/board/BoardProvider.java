package com.umc.umcbulletinboard.board;

import com.umc.umcbulletinboard.board.model.GetAllPostRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardProvider {
    private final BoardDao boardDao;

    @Autowired
    public BoardProvider(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    /**
     * 전체 글 조회
     * GET
     */
    public List<GetAllPostRes> getAllPost() {
        List<GetAllPostRes> getAllPostRes = boardDao.getAllPost();
        return getAllPostRes;
    }
}
