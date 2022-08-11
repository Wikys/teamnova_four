package com.teamnova.아이템.분류;

import static com.teamnova.몬스터.몬스터.유저명;

public class 마나포션 extends 포션{
    public 마나포션(){
        this.이름 = "마나포션";
        this.타입 = 4;
        this.마나회복 = 5;
        this.아이템번호 = 901;
        this.가격 = 5;
        this.특수 = 0;
    }

    @Override
    public void 아이템_효과() {
        if (유저명.전투중마나 == 유저명.전투중마나){ // 최대 체력,마나가 현재 체력마나와 같으면 회복없음
            System.out.println("최대 마나인데 왜먹는지 모르겠다..");
        }
        else if(this.수치+유저명.전투중마나 > 유저명.최대마나){ // 포션회복량으로 최대체력 넘길거같으면 그냥 최대체력 리턴
            유저명.전투중마나 = 유저명.최대마나;
        }else{
            유저명.전투중마나 = 유저명.전투중마나 + this.수치; // 아니면 그냥 회복
        }

    }

    @Override
    public void 아이템_장착해제() {
    }

    @Override
    public void 아이템_설명() {
        System.out.println("========================================================");
        System.out.println("아이템이름 : "+this.이름);
        System.out.println("설명 : 단순히 마나가 조금 회복될뿐인 싸구려 포션이다");
        System.out.println("회복량 : "+this.수치);
        System.out.println("========================================================");

    }
}
