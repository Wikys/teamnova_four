package com.teamnova.아이템.분류;

import com.teamnova.플레이어.캐릭터;

public class 철갑옷 extends 방어구{
    public 철갑옷() {
        this.이름 = "철갑옷";
        this.가격 = 20;
        this.아이템번호 = 101;
        this.타입 = 2;
        this.방어구중복 = false;
        this.수치 = 5;
        this.특수 = 0;

    }

    @Override
    public void 아이템_효과(캐릭터 _캐릭터) {
        _캐릭터.방어력 = _캐릭터.방어력 + this.수치;
        System.out.println("정예 모험가들이 애용하는 철갑옷이군.");

    }

    @Override
    public void 아이템_장착해제(캐릭터 _캐릭터) {
        _캐릭터.방어력 = _캐릭터.방어력 - this.수치;
        System.out.println("착용이 해제되었습니다");

    }

    @Override
    public void 아이템_설명() {
        System.out.println("========================================================");
        System.out.println("아이템이름 : "+this.이름);
        System.out.println("설명 : 철로 만들어진 베테랑 모험가들이 즐겨입는 경갑옷");
        System.out.println("방어력 : "+this.수치);
        System.out.println("========================================================");

    }
}
