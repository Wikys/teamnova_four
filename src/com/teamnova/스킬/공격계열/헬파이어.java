package com.teamnova.스킬.공격계열;

import com.teamnova.몬스터.몬스터;
import com.teamnova.플레이어.캐릭터;


public class 헬파이어 extends 화염구 {
    public int 마나소모 = 7;
    public int 수치 = 7;
    public 헬파이어(){
        this.가격 = 5;
        this.계열 = 1;
        this.스킬이름 = "헬파이어";
    }

    @Override
    public void 스킬효과(캐릭터 _캐릭터, 몬스터 _몬스터) {
        if(_캐릭터.전투중마나 >= this.마나소모) {
            int 헬파이어 = this.수치 + _캐릭터.마법력;
            System.out.println(_캐릭터.이름 + "이(가) 헬파이어를 날렸습니다");
            System.out.println(_몬스터.이름 + "에게 " + 헬파이어 + "의 데미지를 입혔습니다");
            _몬스터.체력 = _몬스터.체력 - 헬파이어;
            if(_캐릭터.종족 == 2){
                System.out.println("마나가 사용되지 않았습니다");
            }
            else if(_캐릭터.종족 !=2){
                _캐릭터.전투중마나 = _캐릭터.전투중마나 - this.마나소모;
            }
        }
        else{
            System.out.println("마나가 부족합니다");
        }
    }

    @Override
    public void 스킬설명() {
        System.out.println("========================================");
        System.out.println("스킬명 : 헬파이어" );
        System.out.println("스킬설명 : 적에게 지옥불을 던져 피해를 입힙니다");
        System.out.println("스킬데미지 : 7 + 레벨비례");
        System.out.println("마나소모 : 7");
        System.out.println("tip : 스켈레톤이 사용시 특수효과가 있습니다");
        System.out.println("========================================");
    }

}
