package com.umc.umcbulletinboard.user;

import com.umc.umcbulletinboard.user.model.PostLoginReq;
import com.umc.umcbulletinboard.user.model.PostLoginRes;
import com.umc.umcbulletinboard.user.model.PostUserReq;
import com.umc.umcbulletinboard.user.model.PostUserRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDao userDao;
    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 회원가입
     * POST
     */
    public PostUserRes createUser(PostUserReq postUserReq) {
        int userId = userDao.createUser(postUserReq);
        return new PostUserRes(userId);
    }
}
