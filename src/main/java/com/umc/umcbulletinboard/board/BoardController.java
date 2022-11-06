package com.umc.umcbulletinboard.board;

import com.umc.umcbulletinboard.board.model.Board;
import com.umc.umcbulletinboard.board.model.GetAllPostRes;
import com.umc.umcbulletinboard.board.model.PostWritingRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/board")
public class BoardController {
    @Autowired
    private final BoardProvider boardProvider;
    @Autowired
    private final BoardService boardService;

    public BoardController(BoardProvider boardProvider, BoardService boardService) {
        this.boardProvider = boardProvider;
        this.boardService = boardService;
    }

    /**
     * 글 작성
     * POST
     */
    @ResponseBody
    @PostMapping("/{userId}")
    public PostWritingRes createPost(@PathVariable("userId") int userId, @RequestBody Board board) {
        PostWritingRes postWritingRes = boardService.createPost(userId, board);
        return postWritingRes;
    }

    /**
     * 전체 글 조회
     * GET
     */
    @ResponseBody
    @GetMapping("")
    public List<GetAllPostRes> getAllPost() {
        List<GetAllPostRes> getAllPostRes = boardProvider.getAllPost();
        return getAllPostRes;
    }
}