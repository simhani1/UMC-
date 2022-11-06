package com.umc.umcbulletinboard.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor // 해당 클래스의 모든 멤버 변수(userIdx, nickname, email, password)를 받는 생성자를 생성
public class User {
    private String nickname;
    private String id;
    private String pwd;
}
