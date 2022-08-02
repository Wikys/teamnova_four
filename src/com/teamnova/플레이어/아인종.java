package com.teamnova.플레이어;

import com.teamnova.몬스터.몬스터;

abstract public class 아인종 extends 캐릭터{
    public int 강조_공격력;
    public boolean 종족스킬_제한;
    public int 종족번호;

    abstract public void 강조(몬스터 _몬스터); //추후 전직에따라 강화?
}
