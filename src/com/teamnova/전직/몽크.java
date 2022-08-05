package com.teamnova.전직;

import com.teamnova.플레이어.비스트맨;
import com.teamnova.플레이어.캐릭터;

public class 몽크 extends 비스트맨 {
    public int 몽크의기민함 = 5;



    @Override
    public void 스탯(캐릭터 _캐릭터) {

        _캐릭터.회피율 = _캐릭터.회피율+this.몽크의기민함;
        _캐릭터.직업이름 = "전사";
        _캐릭터.직업번호 = 1;
    }
}



