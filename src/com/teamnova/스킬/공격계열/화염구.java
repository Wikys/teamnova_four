package com.teamnova.스킬.공격계열;

import com.teamnova.메뉴.전투메뉴;
import com.teamnova.몬스터.몬스터;
import com.teamnova.아이템.아이템;
import com.teamnova.플레이어.캐릭터;

public class 화염구 extends 공격계열{

    public 화염구(String 스킬이름, int 마나소모, int 수치, String 설명) { // 회복스킬
        this.스킬이름 = 스킬이름;
        this.마나소모 = 마나소모;
        this.수치 = 수치;
        this.설명 = 설명;
    }
    int 화염구_계수 = 5;
    public void 스킬공격(캐릭터 _캐릭터, 몬스터 _몬스터, 전투메뉴 _전투, 아이템 _아이템){
        int 화염구 = this.수치 + _캐릭터.마법력;
        System.out.println(_캐릭터+"이(가) 화염구를 날립니다 콰광~");
        System.out.println(_몬스터+"에게 "+화염구+"의 데미지를 입혔습니다");
        _캐릭터.전투중마나 = _캐릭터.전투중마나 - this.마나소모;
        _몬스터.체력 = _몬스터.체력 - 화염구;
        _전투.캐릭터공격(_캐릭터,_몬스터,_아이템);
    }
    public void 스킬설명(){

    }
}
