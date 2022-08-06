package com.teamnova.아이템.분류;

import com.teamnova.플레이어.캐릭터;

public class 낡은검 extends 무기{
    public 낡은검() {
        this.이름 = "낡은검";
        this.마법무기 = 0;
        this.가격 = 5;
        this.아이템번호 = 0;
        this.타입 = 1;
        this.무기중복 = false;
        this.수치 = 1;
        this.특수 = 0;

    }



    @Override
    public void 아이템_효과(캐릭터 _캐릭터) {
        _캐릭터.공격력 = _캐릭터.공격력 + this.수치;
        System.out.println("조금 쓰다보면 부러질거같지만 맨주먹보다는 낫겠지.");

    }

    @Override
    public void 아이템_장착해제(캐릭터 _캐릭터) {
        _캐릭터.공격력 = _캐릭터.공격력 - this.수치;
        System.out.println("착용이 해제되었습니다");

    }
    @Override
    public void 아이템_설명() {
        System.out.println("========================================================");
        System.out.println("아이템이름 : "+this.이름);
        System.out.println("설명 : 낡아빠진 검입니다");
        System.out.println("공격력 : "+this.수치);
        System.out.println("========================================================");


    }
}
