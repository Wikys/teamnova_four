package com.teamnova.스킬.공격계열;

import com.teamnova.스킬.스킬;

import static com.teamnova.몬스터.몬스터.유저명;
import static com.teamnova.몬스터.몬스터_인카운터.몬스터;


public class 무기파괴 extends 스킬 { // 불린으로 스킬제한
    int 수치 = 3;
    boolean 스킬제한 = true;
    int 마나소모 = 5;
    public 무기파괴(){

    }

    public 무기파괴(String 스킬이름) { // 불린처리 다시하기
        this.스킬이름 = 스킬이름;
    }
    public void 스킬효과(){


        if(몬스터.공격력 >= this.수치 && this.스킬제한 == true){
            몬스터.공격력 = 몬스터.공격력 - this.수치;
            this.스킬제한 = false;
            System.out.println("적의 무기를 파괴하였습니다 적의 공격력이 감소합니다");
            if(유저명.종족==1){
                몬스터.방어력 = 몬스터.방어력 - this.수치;
                System.out.println("비스트맨의 날카로운 손톱으로 방어구를 찢었습니다");
                System.out.println("적의 방어력이 감소합니다");
            }
            else if(유저명.직업번호==1 && 몬스터.방어력 <=0){
                System.out.println("비스트맨의 날카로운 손톱으로 방어구를 찢었습니다");
            }
        }
        else if(몬스터.공격력 < this.수치 && this.스킬제한 == true){
            몬스터.공격력 = 0;
            this.스킬제한 = false;
            System.out.println("적의 무기를 파괴하였습니다");
        }
        else if (this.스킬제한 == false){
            System.out.println("이미 사용하셨습니다");
        }

    }
    public void 스킬초기화(){
        this.스킬제한 = true;
    }

    @Override
    public void 스킬쿨타임() {

    }

    public void 스킬설명(){
        System.out.println("========================================");
        System.out.println("스킬명 : 무기파괴" );
        System.out.println("스킬설명 : 적을 무기를 파손시켜 공격력을 감소시킵니다");
        System.out.println("패널티 : 전투당 한번만 사용가능합니다");
        System.out.println("스킬데미지 : 없음");
        System.out.println("마나소모 : "+this.마나소모);
        System.out.println("tip : 비스트맨이 사용시 특수효과가 있습니다");
        System.out.println("========================================");
    }

}
