package com.teamnova.전직;

import com.teamnova.플레이어.인간;
import com.teamnova.플레이어.캐릭터;

import static com.teamnova.몬스터.몬스터.유저명;

public class 전사 extends 인간 {

    public int 직업번호 = 0;
    public int 전사의강직함 = 10;


    @Override
    public void 스탯() {
        유저명.최대체력 = 유저명.최대체력 + this.전사의강직함;
        유저명.직업이름 = "전사";
        유저명.직업번호 = 0;
    }
}
