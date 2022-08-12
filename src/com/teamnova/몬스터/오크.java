package com.teamnova.몬스터;

import com.teamnova.아이템.아이템;

import static com.teamnova.메뉴.행동문.밤;

public class 오크 extends 몬스터{
    public 오크(){
        this.이름 = "오크";
        this.체력 = 15;
        this.마나 = 0;
//        this.공격력 = 3;
        this.공격력 = 0;
        this.방어력 = 1;
        this.회피율 = 3;
        this.경험치 = 1000;
        this.골드 = random.nextInt(10);
        this.몬스터타입 = 0;
        this.몬스터번호 = 1;
        this.상태 = "일반";
    }



    @Override
    public void 몬스터_정보() {
        this.이름 = "오크";
        this.체력 = 15;
        this.마나 = 0;
//        this.공격력 = 3;
        this.공격력 = 0;
        this.방어력 = 1;
        this.회피율 = 3;
        this.경험치 = 1000;
        this.골드 = random.nextInt(10);
        this.몬스터타입 = 0;
        this.몬스터번호 = 1;
        this.상태 = "일반";
        if (밤 == true){
            this.이름 = "광폭화된 오크";
            this.체력 = 15*2;
            this.마나 = 0;
//        this.공격력 = 3;
            this.공격력 = 0*2;
            this.방어력 = 1;
            this.회피율 = 0;
            this.경험치 = 1000*2;
            this.골드 = random.nextInt(10)*2;
            this.몬스터타입 = 0;
            this.몬스터번호 = 1;
            this.상태 = "광폭화";
        }
    }

    @Override
    public void 몬스터_드랍() {
        int 드랍확률 = random.nextInt(100);
        아이템 드랍아이템 = 잡템;

        유저명.돈 = 유저명.돈 + this.골드;

        if (드랍확률 >10){ // 추후에 몬스터 전용아이템 드랍하게변경?
            유저명.인벤토리.add(드랍아이템);
           System.out.println(드랍아이템.이름+"을 획득하셨습니다");
        }else{
            System.out.println("아이템을 발견하지 못했습니다");
        }


    }



}
