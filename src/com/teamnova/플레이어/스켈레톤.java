package com.teamnova.플레이어;

import static com.teamnova.몬스터.몬스터.유저명;

public class 스켈레톤 extends 언데드 {
    public 스켈레톤(){

    }

public void 스탯(캐릭터 유저명){

    this.이름 = 유저명.이름;
    this.레벨 = 1;
    this.공격력 = 3;
    this.방어력 = 0;
    this.회피율 = 3;
    this.체력 = 10;
    this.최대체력 = 10;
    this.전투중체력 = 10;
    this.마나 = 20;
    this.최대마나 = 20;
    this.전투중마나 = 20;
    this.돈 = 0;
    this.경험치 = 0;
    this.레벨업경험치 = 10;
    this.마법력 = 15;
    this.종족구분 = 2;
    this.종족 = 2;
    this.종족이름 = "스켈레톤" ;
    this.종족스킬_제한 = true;
}
}
