package com.teamnova.스킬.버프계열;

import com.teamnova.스킬.스킬;
import com.teamnova.플레이어.캐릭터;

import java.util.ArrayList;

public abstract class 버프계열 extends 스킬 {
    public ArrayList<스킬> _버프스킬목록 = new ArrayList<>();
    public abstract void 버프적용(캐릭터 _캐릭터);
    public abstract void 스킬설명();

}
