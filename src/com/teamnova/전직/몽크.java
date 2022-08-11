package com.teamnova.전직;

import com.teamnova.플레이어.비스트맨;

import static com.teamnova.몬스터.몬스터.유저명;


public class 몽크 extends 비스트맨 {
    public int 몽크의기민함 = 5;



    @Override
    public void 스탯() {

        유저명.회피율 = 유저명.회피율+this.몽크의기민함;
        유저명.직업이름 = "전사";
        유저명.직업번호 = 1;
    }
}



