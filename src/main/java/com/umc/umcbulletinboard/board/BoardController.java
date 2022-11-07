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

    /**
     * 특정 게시판 글 조회
     * GET
     */
    @ResponseBody
    @GetMapping("/{boardTypeId}")
    public List<GetAllPostRes> getAllPostResByType(@PathVariable("boardTypeId") int boardTypeId) {
        List<GetAllPostRes> getAllPostRes = boardProvider.getAllPostResByType(boardTypeId);
        return getAllPostRes;
    }

    /*
     * 제목으로 글 검색
     * GET
     * */
    @ResponseBody
    @GetMapping("/title")
    public List<GetAllPostRes> getAllPostResByKeyword(@RequestParam(required = true) String keyword) {
        List<GetAllPostRes> getAllPostResByKeyword = boardProvider.getAllPostResByKeyword(keyword);
        return getAllPostResByKeyword;
    }

    /*
     * 작성자로 글 검색
     * GET
     * */
    @ResponseBody
    @GetMapping("/writer")
    public List<GetAllPostRes> getAllPostResByWriter(@RequestParam(required = true) String nickname) {
        List<GetAllPostRes> getAllPostResByNickname = boardProvider.getAllPostResByNickname(nickname);
        return getAllPostResByNickname;
    }
}