package com.teamnova.전직;

import com.teamnova.플레이어.스켈레톤;
import com.teamnova.플레이어.캐릭터;

import static com.teamnova.몬스터.몬스터.유저명;

public class 스켈레톤_메이지 extends 스켈레톤 {

    public int 불사자의마력 = 5;
    public int 직업번호 = 2;
    public String 직업이름 = "스켈레톤_메이지";
    스켈레톤_메이지(){
        this.이름 = 유저명.이름;
        this.레벨 = 유저명.레벨;
        this.공격력 = 유저명.공격력;
        this.방어력 = 유저명.방어력;
        this.회피율 = 유저명.회피율;
        this.체력 = 유저명.체력;
        this.최대체력 = 유저명.체력;
        this.전투중체력 = 유저명.전투중체력;
        this.마나 = 유저명.마나;
        this.최대마나 = 유저명.최대마나;
        this.전투중마나 = 유저명.전투중마나;
        this.돈 = 유저명.돈;
        this.경험치 = 유저명.경험치;
        this.레벨업경험치 = 유저명.레벨업경험치;
        this.마법력 = 유저명.마법력 + this.불사자의마력;
        this.전투중마법력 = 유저명.마법력;
        this.종족구분 = 유저명.종족구분;
        this.종족 = 유저명.종족;
        this.종족이름 = 유저명.종족이름 ;
        this.직업이름 = "스켈레톤_메이지";
        this.종족스킬_제한 = true;
        this.직업번호 = 2;

        this.인벤토리 = 유저명.인벤토리;
        this.장비창 = 유저명.장비창;
        this.전투인벤토리 = 유저명.전투인벤토리;
        this._버프스킬목록 = 유저명._버프스킬목록;
        this._회복스킬목록 = 유저명._회복스킬목록;
        this._공격스킬목록 = 유저명._공격스킬목록;
        this._종족스킬목록 = 유저명._종족스킬목록;
    }



@Override
public void 스탯(캐릭터 유저명) {

    유저명.직업이름 = "스켈레톤_메이지";
    유저명.직업번호 = 2;
//    유저명.마법력 = 유저명.마법력 + this.불사자의마력;

}
}
