package com.teamnova.스킬.종족스킬;

import com.teamnova.메뉴.전투메뉴;
import com.teamnova.몬스터.몬스터;
import com.teamnova.아이템.아이템;
import com.teamnova.플레이어.캐릭터;

public class 강조 extends 종족스킬 {

    public void 종족스킬효과(캐릭터 _캐릭터, 몬스터 _몬스터, 전투메뉴 _전투, 아이템 _아이템){
        if (_캐릭터.종족스킬_제한 == true){
            System.out.println("손톱을 강화해 적을 할퀴어 "+_캐릭터.전투중공격력*3+"의 데미지를 입혔습니다");
            _몬스터.체력 = _몬스터.체력 - _캐릭터.전투중공격력*3;
            _전투.캐릭터공격(_캐릭터,_몬스터,_아이템);
            // 쓰레드 배우고 출혈상태이상 구현해보기?
            _캐릭터.종족스킬_제한 = false;
        }
        else if (_캐릭터.종족스킬_제한 == false){
            System.out.println("종족스킬은 전투한번만 한번만 사용가능합니다");
        }

    }

}
