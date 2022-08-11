package com.teamnova.스킬.공격계열;

import com.teamnova.스킬.스킬;

import static com.teamnova.몬스터.몬스터.유저명;
import static com.teamnova.몬스터.몬스터_인카운터.몬스터;

public class 사광연참 extends 스킬 {

    public int 적_회피증가 = 3;
    public int 마나소모 = 5;
    public 사광연참(){}
    public 사광연참(String 스킬이름) {
        this.스킬이름 = 스킬이름;


    }



    public void 스킬효과(){
        몬스터.회피율 = 몬스터.회피율 + this.적_회피증가;
        int 피해 = 몬스터.몹공격받음(몬스터.방어력, 유저명.전투중공격력, 몬스터.회피율);
        if(유저명.전투중마나 >= this.마나소모){
        for (int i=0; i<=3; i++) {

            System.out.println("적을 빠른속도로 베어내" + 피해 + "의 데미지를 주었습니다");

            몬스터.체력 = 몬스터.체력 - 피해;


        }
            유저명.전투중마나 = 유저명.전투중마나 - this.마나소모;
            몬스터.회피율 = 몬스터.회피율 - this.적_회피증가;//스킬종료시 회피율 빼줌
        if(유저명.종족 == 0){
            System.out.println("공격한 후 균형을 잃은 몸을 억지로 세워 공격하기 전의 자세로 되돌렸습니다");
            System.out.println("한번 더 무기를 휘둘러 "+피해+"의 데미지를 입혔습니다");
            몬스터.체력 = 몬스터.체력 - 피해;
        }
        }
        else {
            System.out.println("마나가 부족합니다");
        }

    }
    public void 스킬초기화(){

    }
    public void 스킬설명(){
        System.out.println("========================================");
        System.out.println("스킬명 : 사광연참" );
        System.out.println("스킬설명 : 적을 빠르게 4번 베어 피해를줍니다");
        System.out.println("패널티 : 빠르게 베는 스킬인만큼 명중률이 감소합니다");
        System.out.println("스킬데미지 : 공격력만큼");
        System.out.println("마나소모 : "+this.마나소모);
        System.out.println("tip : 인간이 사용하면 특수효과가 있습니다");
        System.out.println("========================================");
    }


}
