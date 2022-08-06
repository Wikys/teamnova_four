package com.teamnova.아이템.분류;

import com.teamnova.아이템.아이템;
import com.teamnova.플레이어.캐릭터;

public abstract class 마법무기 extends 아이템 {
    public boolean 무기중복 = false;
    public int 마법력;
    public int 타입 = 1;
    public int 마법무기 = 1;
    public abstract void 착용효과(캐릭터 _캐릭터);
    public abstract void 착용해제(캐릭터 _캐릭터);
    public abstract void 설명();

}
