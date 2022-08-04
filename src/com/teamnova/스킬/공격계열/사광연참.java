package com.teamnova.스킬.공격계열;

import com.teamnova.몬스터.몬스터;
import com.teamnova.스킬.스킬;
import com.teamnova.플레이어.캐릭터;

public class 사광연참 extends 스킬 {

    public int 적_회피증가 = 3;
    public int 마나소모 = 5;
    public 사광연참(String 스킬이름) {
        this.스킬이름 = 스킬이름;


    }


    public void 스킬효과(캐릭터 _캐릭터, 몬스터 _몬스터){
        _몬스터.회피율 = _몬스터.회피율 + this.적_회피증가;
        if(_캐릭터.전투중마나 >= this.마나소모){
        for (int i=0; i<=3; i++) {
            int 피해 = _몬스터.몹공격받음(_몬스터.방어력, _캐릭터.전투중공격력, _몬스터.회피율);
            System.out.println("적을 빠른속도로 베어내" + 피해 + "의 데미지를 주었습니다");

            _몬스터.체력 = _몬스터.체력 - 피해;
            _캐릭터.전투중마나 = _캐릭터.전투중마나 - this.마나소모;
            _몬스터.회피율 = _몬스터.회피율 - this.적_회피증가;//스킬종료시 회피율 빼줌
        }
        }
        else {
            System.out.println("마나가 부족합니다");
        }

    }

    public void 스킬설명(){
        System.out.println("========================================");
        System.out.println("스킬명 : 사광연참" );
        System.out.println("스킬설명 : 적을 빠르게 4번 베어 피해를줍니다");
        System.out.println("패널티 : 빠르게 베는 스킬인만큼 명중률이 감소합니다");
        System.out.println("스킬데미지 : 공격력만큼");
        System.out.println("마나소모 : "+this.마나소모);
        System.out.println("========================================");
    }


}
