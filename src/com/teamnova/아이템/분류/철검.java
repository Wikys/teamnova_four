package com.teamnova.아이템.분류;

import static com.teamnova.몬스터.몬스터.유저명;

public class 철검 extends 무기{
    public 철검() {
        this.이름 = "철검";
        this.마법무기 = 0;
        this.가격 = 10;
        this.아이템번호 = 1;
        this.타입 = 1;
        this.무기중복 = false;
        this.수치 = 3;
        this.특수 = 0;

    }
    @Override
    public void 아이템_효과() {
        유저명.공격력 = 유저명.공격력 + this.수치;
        System.out.println("이정도는 되야 쓸만한 검이라고 할수있지.");

    }

    @Override
    public void 아이템_장착해제() {
        유저명.공격력 = 유저명.공격력 - this.수치;
        System.out.println("착용이 해제되었습니다");

    }

    @Override
    public void 아이템_설명() {
        System.out.println("========================================================");
        System.out.println("아이템이름 : "+this.이름);
        System.out.println("설명 : 철로만들어진 보급형 검이다");
        System.out.println("공격력 : "+this.수치);
        System.out.println("========================================================");

    }
}
