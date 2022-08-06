package com.teamnova.몬스터.보스;

import com.teamnova.몬스터.몬스터;
import com.teamnova.아이템.분류.고블린왕의_몽둥이;
import com.teamnova.아이템.아이템;
import com.teamnova.플레이어.캐릭터;

public class 고블린킹 extends 몬스터 {
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
    public void 몬스터_정보(몬스터 _몬스터) {
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
    public void 몬스터_드랍(캐릭터 _캐릭터) {
        int 드랍확률 = random.nextInt(100);
        아이템 드랍아이템 = 고블린왕의_몽둥이;

        _캐릭터.돈 = _캐릭터.돈 + this.골드;

        if (드랍확률 >10){ // 추후에 몬스터 전용아이템 드랍하게변경?
            _캐릭터.인벤토리.add(드랍아이템);
            System.out.println(드랍아이템.이름+"을 획득하셨습니다");
        }else{
            System.out.println("아이템을 발견하지 못했습니다");
        }


    }
}