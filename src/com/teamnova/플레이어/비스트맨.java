package com.teamnova.플레이어;


import static com.teamnova.몬스터.몬스터.유저명;

public class 비스트맨 extends 아인종 {
    public 비스트맨() {

    }

    public void 스탯(캐릭터 유저명) {
        this.이름 = 유저명.이름;
        this.레벨 = 1;
        this.공격력 = 5;
        this.방어력 = 0;
        this.회피율 = 10;
        this.체력 = 10;
        this.최대체력 = 10;
        this.전투중체력 = 10;
        this.마나 = 5;
        this.최대마나 = 5;
        this.전투중마나 = 5;
        this.돈 = 0;
        this.경험치 = 0;
        this.레벨업경험치 = 10;
        this.마법력 = 3;
        this.종족구분 = 1;
        this.종족 = 1;
        this.종족이름 = "비스트맨";
        this.종족스킬_제한 = true;
    }
    @Override
    public void 전용패시브() {

    }

}
