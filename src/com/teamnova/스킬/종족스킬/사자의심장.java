package com.teamnova.스킬.종족스킬;

import com.teamnova.스킬.스킬;

import static com.teamnova.몬스터.몬스터.유저명;

public class 사자의심장 extends 스킬 {
    public 사자의심장(String 스킬이름){
        this.스킬이름 = 스킬이름;
    }
    public  void 스킬효과(){

        if (유저명.종족스킬_제한 == true){
            System.out.println("사자같은 용기를 이끌어내 방어력이 "+유저명.레벨+" 만큼 증가합니다");
            유저명.전투중방어력 = 유저명.전투중방어력 + 유저명.레벨;

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
        System.out.println("스킬명 : 사자의심장");
        System.out.println("설명 : 방어력을 레벨만큼 증가시켜줍니다");
//        System.out.println("TIP : 전직캐릭터가 사용시 특수효과가 발동합니다");
        System.out.println("============================");
    }
}
