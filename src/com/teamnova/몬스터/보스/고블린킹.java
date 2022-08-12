package com.teamnova.몬스터.보스;

import com.teamnova.아이템.분류.고블린왕의_몽둥이;
import com.teamnova.아이템.아이템;

public class 고블린킹 extends 보스 {
    아이템 고블린왕의_몽둥이 = new 고블린왕의_몽둥이();
    public 고블린킹(){
        this.이름 = "고블린킹";
        this.체력 = 100;
        this.마나 = 0;
        this.공격력 = 7;
        this.방어력 = 3;
        this.회피율 = 5;
        this.경험치 = 30;
        this.골드 = random.nextInt(100);
        this.몬스터타입 = 1;
        this.몬스터번호 = 3;

    }



    @Override
    public void 몬스터_정보() {
        this.이름 = "고블린킹";
        this.체력 = 100;
        this.마나 = 0;
        this.공격력 = 7;
        this.방어력 = 3;
        this.회피율 = 5;
        this.경험치 = 30;
        this.골드 = random.nextInt(100);
        this.몬스터타입 = 1;
        this.몬스터번호 = 3;
    }

    @Override
    public void 몬스터_드랍() {
        int 드랍확률 = random.nextInt(100);
        아이템 드랍아이템 = 고블린왕의_몽둥이;

        유저명.돈 = 유저명.돈 + this.골드;

        if (드랍확률 >10){ // 추후에 몬스터 전용아이템 드랍하게변경?
            유저명.인벤토리.add(드랍아이템);
           System.out.println(드랍아이템.이름+"을 획득하셨습니다");
        }else{
            System.out.println("아이템을 발견하지 못했습니다");
        }


    }

    @Override
    public void 광폭화() {

    }

    @Override
    public void 보스_스킬() { // 보스몬스터의 기술
        System.out.println("고블린킹이 방어구 궤뚫기를 사용합니다");
        System.out.println(유저명.이름+"이(가) 방어력 무시 데미지 "+this.공격력+"을 받습니다");
        유저명.전투중체력 = 유저명.전투중체력 - this.공격력;

    }


}