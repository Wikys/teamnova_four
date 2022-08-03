package com.teamnova.스킬.회복계열;

import com.teamnova.스킬.스킬;
import com.teamnova.플레이어.캐릭터;

import java.util.ArrayList;

public abstract class 회복계열 extends 스킬 {
    public ArrayList<스킬> _회복스킬목록 = new ArrayList<>();
    public abstract void 회복적용(캐릭터 _캐릭터);
    public abstract void 스킬설명();


}
