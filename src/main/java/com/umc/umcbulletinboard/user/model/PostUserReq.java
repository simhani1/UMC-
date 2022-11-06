package com.umc.umcbulletinboard.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostUserReq {
    private String nickname;
    private String id;
    private String pwd;
}
