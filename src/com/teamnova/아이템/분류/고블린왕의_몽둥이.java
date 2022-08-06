package com.teamnova.아이템.분류;

import com.teamnova.플레이어.캐릭터;

public class 고블린왕의_몽둥이 extends 무기{
    public 고블린왕의_몽둥이(){
        this.이름 = "고블린왕의_몽둥이";
        this.타입 = 1;
        this.마법무기 = 0;
        this.수치 = 5;
        this.아이템번호 = 2;
        this.가격 = 0;
        this.무기중복 = false;
        this.특수 = 1;
        this.설명 = "조악해 보이지만 한 종족의 왕이 썻던 무기인만큼 튼튼하다";
    }

    @Override
    public void 아이템_효과(캐릭터 _캐릭터) {
        _캐릭터.공격력 = _캐릭터.공격력 + this.수치;
        System.out.println("단순한 형태의 몽둥이지만 공들여서 만든흔적이 있다.");

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
        System.out.println("설명 : 단순해 보이지만 한 종족의 왕이 썻던 무기인만큼 튼튼하다");
        System.out.println("공격력 : "+this.수치);
        System.out.println("========================================================");
    }
}
