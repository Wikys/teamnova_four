package com.teamnova.플레이어;


public class 비스트맨 extends 아인종{
    public 비스트맨(){

    }
//    public int 강조_공격력;
//    public String 설명;
//    public boolean 종족스킬_제한;
  //  public int 강조_공격력 = 공격력*3;
    public boolean 종족스킬_제한 = true;



    public 비스트맨(String _이름, int _레벨, int _공격력, int _방어력, int _회피율, int _체력, int _최대체력, int _마나, int _최대마나, int _돈, int _경험치, int _레벨업경험치,int _마법력,int _종족구분,int _종족,String _종족이름,boolean _종족스킬제한) {
        this.이름 = _이름;
        this.레벨 = _레벨;
        this.공격력 = _공격력;
        this.방어력 = _방어력;
        this.회피율 = _회피율;
        this.체력 = _체력; //ㅇ
        this.최대체력 = _최대체력;
        this.전투중체력 = this.체력;
        this.마나 = _마나; //ㅇ
        this.최대마나 = _최대마나;
        this.전투중마나 = this.마나;
        this.돈 = _돈;
        this.경험치 = _경험치;
        this.레벨업경험치 = _레벨업경험치;
        this.마법력 = _마법력;
        this.종족구분 = _종족구분;
        this.종족 = _종족;
        this.종족이름 = _종족이름;
        this.종족스킬_제한 =_종족스킬제한;

//        ,int _전투중공격력, int _전투중방어력, int _전투중회피율,int _전투중체력, int _전투중마나, int _전투중마법력
//        this.전투중공격력 = _전투중공격력;
//        this.전투중방어력 = _전투중방어력;
//        this.전투중회피율 = _전투중회피율;
//        this.전투중체력 = _전투중체력;
//        this.전투중마나 = _전투중마나;
//        this.전투중마법력 = _전투중마법력;
    } // 하위종족 클래스에 넣어야할듯


    //추후 전직에따라 강화?

}
