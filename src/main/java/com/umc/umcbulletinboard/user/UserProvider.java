package com.umc.umcbulletinboard.user;

import com.umc.umcbulletinboard.user.model.PostLoginReq;
import com.umc.umcbulletinboard.user.model.PostLoginRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProvider {
    private final UserDao userDao;

    @Autowired
    public UserProvider(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 로그인
     * POST
     */
    public PostLoginRes login(PostLoginReq postLoginReq) {
        PostLoginRes postLoginRes = userDao.getNickname(postLoginReq);
        return postLoginRes;
    }
}
