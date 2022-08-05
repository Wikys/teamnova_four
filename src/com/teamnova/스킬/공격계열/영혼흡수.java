package com.teamnova.스킬.공격계열;

import com.teamnova.몬스터.몬스터;
import com.teamnova.스킬.스킬;
import com.teamnova.플레이어.캐릭터;

public class 영혼흡수 extends 스킬 {
    public int 수치;
    public boolean 스킬제한 = true;
    public 영혼흡수(String 스킬이름,int 가격, int 계열){
        this.가격 = 가격;
        this.계열 = 계열;
        this.스킬이름 = 스킬이름;
    }
    @Override
    public void 스킬효과(캐릭터 _캐릭터, 몬스터 _몬스터) {
        if(this.스킬제한 == true){
            System.out.println("주변의 영혼을 흡수하여 마나를 전부 회복합니다");
            _캐릭터.전투중마나 = _캐릭터.최대마나;
            this.스킬제한 = false;
        }
        else if(this.스킬제한 == false){
            System.out.println("주변에 영혼이 없습니다");
        }


    }

    @Override
    public void 스킬설명() {
        System.out.println("========================================");
        System.out.println("스킬명 : 영혼흡수" );
        System.out.println("스킬설명 : 주변의 영혼을 흡수하여 마나를 모두 회복합니다");
        System.out.println("패널티 : 전투당 1회만 사용가능합니다");
        System.out.println("스킬데미지 : 없음");
        System.out.println("마나소모 : 없음");
        System.out.println("========================================");
    }

    @Override
    public void 스킬초기화() {
        this.스킬제한 = true;
    }
}
