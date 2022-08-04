package com.teamnova.스킬.공격계열;

import com.teamnova.몬스터.몬스터;
import com.teamnova.스킬.스킬;
import com.teamnova.플레이어.캐릭터;

public class 무기파괴 extends 스킬 { // 불린으로 스킬제한
    int 수치 = 3;
    boolean 스킬제한 = true;
    int 마나소모 = 5;
    public 무기파괴(){

    }

    public 무기파괴(String 스킬이름) { // 불린처리 다시하기
        this.스킬이름 = 스킬이름;
    }
    public void 스킬효과(캐릭터 _캐릭터, 몬스터 _몬스터){

        if(_몬스터.공격력 >= this.수치 && this.스킬제한 == true){
            _몬스터.공격력 = _몬스터.공격력 - this.수치;
            this.스킬제한 = false;
            System.out.println("적의 무기를 파괴하였습니다");
        }
        else if(_몬스터.공격력 < this.수치 && this.스킬제한 == true){
            _몬스터.공격력 = 0;
            this.스킬제한 = false;
            System.out.println("적의 무기를 파괴하였습니다");
        }
        else if (this.스킬제한 == false){
            System.out.println("이미 사용하셨습니다");
        }

    }
    public void 무기파괴_초기화(){
        this.스킬제한 = true;
    }

    public void 스킬설명(){
        System.out.println("========================================");
        System.out.println("스킬명 : 무기파괴" );
        System.out.println("스킬설명 : 적을 무기를 파손시켜 공격력을 감소시킵니다");
        System.out.println("패널티 : 전투당 한번만 사용가능합니다");
        System.out.println("스킬데미지 : 없음");
        System.out.println("마나소모 : "+this.마나소모);
        System.out.println("========================================");
    }

}
