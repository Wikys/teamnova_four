package com.teamnova.몬스터;

import com.teamnova.아이템.아이템;
import com.teamnova.플레이어.캐릭터;

public class 고블린 extends 몬스터{
    public 고블린(){
        this.이름 = "고블린";
        this.체력 = 10;
        this.마나 = 0;
        this.공격력 = 1;
        this.방어력 = 0;
        this.회피율 = 2;
        this.경험치 = 1000;
        this.골드 = random.nextInt(5);
        this.몬스터타입 = 0;
        this.몬스터번호 = 0;
    }



    @Override
    public void 몬스터_정보(몬스터 _몬스터) {
        this.이름 = "고블린";
        this.체력 = 10;
        this.마나 = 0;
        this.공격력 = 1;
        this.방어력 = 0;
        this.회피율 = 2;
        this.경험치 = 1000;
        this.골드 = random.nextInt(5);
        this.몬스터타입 = 0;
        this.몬스터번호 = 0;
    }

    @Override
    public void 몬스터_드랍(캐릭터 _캐릭터) {
        int 드랍확률 = random.nextInt(100);
        아이템 드랍아이템 = 잡템;

        _캐릭터.돈 = _캐릭터.돈 + this.골드;

        if (드랍확률 >10){ // 추후에 몬스터 전용아이템 드랍하게변경?
            _캐릭터.인벤토리.add(드랍아이템);
            System.out.println(드랍아이템.이름+"을 획득하셨습니다");
        }else{
            System.out.println("아이템을 발견하지 못했습니다");
        }


    }
}
