package com.teamnova.스킬.종족스킬;

import com.teamnova.몬스터.몬스터;
import com.teamnova.스킬.스킬;
import com.teamnova.플레이어.캐릭터;

public abstract class 종족스킬 extends 스킬 {
    public abstract void 스킬효과(캐릭터 _캐릭터, 몬스터 _몬스터);
}
