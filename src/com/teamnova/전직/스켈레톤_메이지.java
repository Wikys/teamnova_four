package com.teamnova.전직;

import com.teamnova.플레이어.스켈레톤;
import com.teamnova.플레이어.캐릭터;

import static com.teamnova.몬스터.몬스터.유저명;

public class 스켈레톤_메이지 extends 스켈레톤 {

    public int 불사자의마력 = 5;
    스켈레톤_메이지(){};

@Override
public void 스탯() {

    유저명.직업이름 = "스켈레톤_메이지";
    유저명.직업번호 = 2;
    유저명.마법력 = 유저명.마법력 + this.불사자의마력;

}
}
