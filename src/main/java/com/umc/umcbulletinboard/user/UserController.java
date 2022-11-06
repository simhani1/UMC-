package com.umc.umcbulletinboard.user;

import com.umc.umcbulletinboard.user.model.PostLoginReq;
import com.umc.umcbulletinboard.user.model.PostLoginRes;
import com.umc.umcbulletinboard.user.model.PostUserReq;
import com.umc.umcbulletinboard.user.model.PostUserRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/users")
public class UserController {
    @Autowired
    private final UserProvider userProvider;
    @Autowired
    private final UserService userService;
    public UserController(UserService userService, UserProvider userProvider) {
        this.userService = userService;
        this.userProvider = userProvider;
    }

    /**
     * 회원가입
     * POST
     */
    @ResponseBody
    @PostMapping("/sign-up")
    public PostUserRes createUser(@RequestBody PostUserReq postUserReq) {
        PostUserRes postUserRes = userService.createUser(postUserReq);
        return postUserRes;
    }

    /**
     * 로그인
     * POST
     */
    @ResponseBody
    @PostMapping("/log-in")
    public PostLoginRes login(@RequestBody PostLoginReq postLoginReq) {
        PostLoginRes postLoginRes = userProvider.login(postLoginReq);
        return postLoginRes;
    }
}
