package com.teamnova.몬스터.보스;

public class 마왕 extends 보스{
    public 마왕(){
        this.이름 = "???";
        this.체력 = 9999;
        this.마나 = 9999;
        this.공격력 = 999;
        this.방어력 = 999;
        this.회피율 = 100;
        this.경험치 = 456456456;
        this.골드 = random.nextInt(10000000);
        this.몬스터타입 = 1;
        this.몬스터번호 = 999;
        this.상태 = "?";

    }
    @Override
    public void 몬스터_정보() {
        this.이름 = "???";
        this.체력 = 9999;
        this.마나 = 9999;
        this.공격력 = 999;
        this.방어력 = 999;
        this.회피율 = 100;
        this.경험치 = 456456456;
        this.골드 = random.nextInt(10000000);
        this.몬스터타입 = 1;
        this.몬스터번호 = 999;
        this.상태 = "?";

    }

    @Override
    public void 몬스터_드랍() {

    }

    @Override
    public void 광폭화() {

    }

    @Override
    public void 스킬() {
        System.out.println("???가 진정한 죽음을 사용합니다");
        유저명.전투중체력 = 유저명.전투중체력 - this.공격력;
    }
}
