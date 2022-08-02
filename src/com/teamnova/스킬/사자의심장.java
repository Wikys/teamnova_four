package com.teamnova.스킬;

import com.teamnova.메뉴.전투메뉴;
import com.teamnova.몬스터.몬스터;
import com.teamnova.아이템.아이템;
import com.teamnova.플레이어.캐릭터;

public class 사자의심장 extends 종족스킬{
    public  void 종족스킬효과(캐릭터 _캐릭터, 몬스터 _몬스터, 전투메뉴 _전투, 아이템 _아이템){
        if (_캐릭터.종족스킬_제한 == true){
            System.out.println("사자같은 용기를 이끌어내 방어력이 "+_캐릭터.레벨+" 만큼 증가합니다");
            _캐릭터.전투중방어력 = _캐릭터.전투중방어력 + _캐릭터.레벨;
            _전투.캐릭터공격(_캐릭터,_몬스터,_아이템);

            _캐릭터.종족스킬_제한 = false;
        }
        else if (_캐릭터.종족스킬_제한 == false){
            System.out.println("종족스킬은 전투한번만 한번만 사용가능합니다");
        }

    }
}
