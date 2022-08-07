package com.teamnova.아이템.분류;

import com.teamnova.플레이어.캐릭터;

public class 체력포션 extends 포션{
    public 체력포션(){
        this.이름 = "체력포션";
        this.타입 = 3;
        this.체력회복 = 5;
        this.아이템번호 = 900;
        this.가격 = 5;
        this.특수 = 0;
    }
    @Override
    public void 아이템_효과(캐릭터 _캐릭터) { //체력포션 회복
        if (_캐릭터.전투중체력 == _캐릭터.최대체력){ // 최대 체력,마나가 현재 체력마나와 같으면 회복없음
            System.out.println("최대 체력인데 왜먹는지 모르겠다..");
        }
        else if(this.수치+_캐릭터.전투중체력 > _캐릭터.최대체력){ // 포션회복량으로 최대체력 넘길거같으면 그냥 최대체력 리턴
            _캐릭터.전투중체력 = _캐릭터.최대체력;
        }else{
            _캐릭터.전투중체력 = _캐릭터.전투중체력 + this.수치; // 아니면 그냥 회복
        }


    }

    @Override
    public void 아이템_장착해제(캐릭터 _캐릭터) { //메인메뉴 클래스에서 처리

    }

    @Override
    public void 아이템_설명() {
        System.out.println("========================================================");
        System.out.println("아이템이름 : "+this.이름);
        System.out.println("설명 : 단순히 체력이 조금 회복될뿐인 싸구려 포션이다");
        System.out.println("회복량 : "+this.수치);
        System.out.println("========================================================");

    }
}
