package com.teamnova.전직;

import com.teamnova.플레이어.비스트맨;

public class 몽크 extends 비스트맨 {
    public int 직업번호 = 1;
    public 몽크(String _이름, int _레벨, int _공격력, int _방어력, int _회피율, int _체력, int _최대체력, int _마나, int _최대마나, int _돈, int _경험치, int _레벨업경험치,int _마법력,int _종족구분,int _종족,String _종족이름,boolean _종족스킬제한, int _직업번호) {
        super.이름 = _이름;
        super.레벨 = _레벨;
        super.공격력 = _공격력;
        super.방어력 = _방어력;
        super.회피율 = _회피율;
        super.체력 = _체력;
        super.최대체력 = _최대체력;
        super.전투중체력 = super.체력;
        super.마나 = _마나;
        super.최대마나 = _최대마나;
        super.전투중마나 = super.마나;
        super.돈 = _돈;
        super.경험치 = _경험치;
        super.레벨업경험치 = _레벨업경험치;
        super.마법력 = _마법력;
        super.종족구분 = _종족구분;
        super.종족 = _종족;
        super.종족이름 = _종족이름;
        super.종족스킬_제한 = _종족스킬제한;
        super.직업번호 = _직업번호;
    } // 전직시 정보를 그대로 이전하기위해 super 사용
    public void 몽크(비스트맨 _비스트맨){
        this.이름 = super.이름;
        this.레벨 = super.레벨;
        this.공격력 = super.공격력 ;
        this.방어력 = super.방어력 ;
        this.회피율 = super.회피율 ;
        this.체력 = super.체력 ;
        this.최대체력 = super.최대체력 ;
        this.전투중체력 = super.전투중체력 ;
        this.마나 = super.마나;
        this.최대마나 = super.최대마나 ;
        this.전투중마나 = super.전투중마나 ;
        this.돈 = super.돈 ;
        this.경험치 = super.경험치 ;
        this.레벨업경험치 = super.레벨업경험치 ;
        this.마법력 = super.마법력 ;
        this.종족구분 = super.종족구분 ;
        this. 종족 =super.종족 ;
        this. 종족이름 = super.종족이름 ;
        this. 종족스킬_제한 = super.종족스킬_제한 ;
        this.직업번호= 1;

    }
}
