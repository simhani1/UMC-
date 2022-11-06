package com.umc.umcbulletinboard.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    private final BoardDao boardDao;
    @Autowired
    public BoardService(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
}
