package com.teamnova.스킬.종족스킬;

import com.teamnova.스킬.스킬;

import static com.teamnova.몬스터.몬스터.유저명;
import static com.teamnova.몬스터.몬스터_인카운터.몬스터;

public class 강조 extends 스킬 {

    public 강조(String 스킬이름){
        this.스킬이름 = 스킬이름;
    }



    public void 스킬효과(){
        if (유저명.종족스킬_제한 == true){
            for (int i=0; i<=2; i++){
                int 피해 = 몬스터.몹공격받음(몬스터.방어력, 유저명.전투중공격력, 몬스터.회피율);
                System.out.println("손톱을 강화해 적을 할퀴어 "+피해+"의 데미지를 입혔습니다");
                몬스터.체력 = 몬스터.체력 - 피해;

            }
//            System.out.println("손톱을 강화해 적을 할퀴어 "+_캐릭터.전투중공격력*3+"의 데미지를 입혔습니다");
//            _몬스터.체력 = _몬스터.체력 - _캐릭터.전투중공격력*3;
            // 쓰레드 배우고 출혈상태이상 구현해보기?
            유저명.종족스킬_제한 = false;
        }

        else if (유저명.종족스킬_제한 == false){
            System.out.println("종족스킬은 전투한번만 한번만 사용가능합니다");
        }

    }
    public void 스킬초기화(){

    }




    public void 스킬설명() {
        System.out.println("============================");
        System.out.println("스킬명 : 강조");
        System.out.println("설명 : 손톱을 강화하여 적을 3번 타격합니다");
//        System.out.println("TIP : 전직캐릭터가 사용시 특수효과가 발동합니다");
        System.out.println("============================");

    }
}
