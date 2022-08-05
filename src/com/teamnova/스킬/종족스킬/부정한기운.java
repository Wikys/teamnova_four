package com.teamnova.스킬.종족스킬;

import com.teamnova.몬스터.몬스터;
import com.teamnova.스킬.스킬;
import com.teamnova.플레이어.캐릭터;

public class 부정한기운 extends 스킬 {
    public 부정한기운(String 스킬이름){
        this.스킬이름 = 스킬이름;
    }

    public  void 스킬효과(캐릭터 _캐릭터, 몬스터 _몬스터){
        if (_캐릭터.종족스킬_제한 == true){
            System.out.println("무기에 부정한 기운을 둘러 공격과 마법에 "+_캐릭터.레벨+" 의 데미지를 추가로 줍니다");
            _캐릭터.전투중공격력 = _캐릭터.전투중공격력+_캐릭터.레벨;
            _캐릭터.전투중마법력 = _캐릭터.전투중마법력+_캐릭터.레벨;


            _캐릭터.종족스킬_제한 = false;
        }
        else if (_캐릭터.종족스킬_제한 == false){
            System.out.println("종족스킬은 전투한번만 한번만 사용가능합니다");
        }

    }
    public void 스킬초기화(){

    }

    public void 스킬설명() {
        System.out.println("============================");
        System.out.println("스킬명 : 부정한기운");
        System.out.println("설명 : 무기에 언데드의 부정한 기운을 둘러");
        System.out.println("레벨만큼 추가데미지를 줍니다");
        System.out.println("일반공격과 마법 모두에 적용됩니다");
        System.out.println("============================");

    }
}
