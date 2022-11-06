package com.umc.umcbulletinboard.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardProvider {
    private final BoardDao boardDao;

    @Autowired
    public BoardProvider(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
}
