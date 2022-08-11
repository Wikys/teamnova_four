package com.teamnova.아이템.분류;

import static com.teamnova.몬스터.몬스터.유저명;

public class 가죽갑옷 extends 방어구{
    public 가죽갑옷() {
        this.이름 = "가죽갑옷";
        this.가격 = 10;
        this.아이템번호 = 100;
        this.타입 = 2;
        this.방어구중복 = false;
        this.수치 = 2;
        this.특수 = 0;

    }

    @Override
    public void 아이템_효과() {
        유저명.방어력 = 유저명.방어력 + this.수치;
        System.out.println("초보 모험가들이 애용하는 가죽갑옷이다.");

    }

    @Override
    public void 아이템_장착해제() {
        유저명.방어력 = 유저명.방어력 - this.수치;
        System.out.println("착용이 해제되었습니다");

    }

    @Override
    public void 아이템_설명() {
        System.out.println("========================================================");
        System.out.println("아이템이름 : "+this.이름);
        System.out.println("설명 : 가죽으로 만들어진 초보모험가용 갑옷이다");
        System.out.println("방어력 : "+this.수치);
        System.out.println("========================================================");

    }
}
