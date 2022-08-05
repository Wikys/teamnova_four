package com.teamnova.전직;

import com.teamnova.플레이어.인간;
import com.teamnova.플레이어.캐릭터;

public class 전사 extends 인간 {

    public int 직업번호 = 0;
    public int 전사의강직함 = 10;


    @Override
    public void 스탯(캐릭터 _캐릭터) {
        _캐릭터.최대체력 = _캐릭터.최대체력 + this.전사의강직함;
        _캐릭터.직업이름 = "전사";
        _캐릭터.직업번호 = 0;
    }
}
