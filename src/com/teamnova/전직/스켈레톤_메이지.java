package com.teamnova.전직;

import com.teamnova.플레이어.스켈레톤;
import com.teamnova.플레이어.캐릭터;

public class 스켈레톤_메이지 extends 스켈레톤 {

    public int 불사자의마력 = 5;
    스켈레톤_메이지(){};

@Override
public void 스탯(캐릭터 _캐릭터) {

    _캐릭터.직업이름 = "스켈레톤_메이지";
    _캐릭터.직업번호 = 2;
    _캐릭터.마법력 = _캐릭터.마법력 + this.불사자의마력;

}
}
