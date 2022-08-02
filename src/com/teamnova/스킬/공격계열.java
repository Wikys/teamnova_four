package com.teamnova.스킬;

import com.teamnova.메뉴.전투메뉴;
import com.teamnova.몬스터.몬스터;
import com.teamnova.아이템.아이템;
import com.teamnova.플레이어.캐릭터;

public abstract class 공격계열 extends 스킬 {
    public abstract void 스킬공격(캐릭터 _캐릭터, 몬스터 _몬스터, 전투메뉴 _전투, 아이템 _아이템);

}
