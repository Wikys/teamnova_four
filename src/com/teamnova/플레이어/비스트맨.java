package com.teamnova.플레이어;


import com.teamnova.몬스터.몬스터;

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


    public void 종족스킬(캐릭터 _캐릭터 , 몬스터 _몬스터){
        System.out.println("========================================");
        System.out.println("아인종의 전용 종족스킬 입니다");
        System.out.println("손틉을 강화시켜 무기공격과 함께 손톱공격을 합니다");
        System.out.println("현재 공격력 추가데미지 : "+this.강조_공격력);
        System.out.println("종족스킬은 전투한번당 단 한번만 사용이 가능합니다");
        System.out.println("========================================");
        System.out.println();

        System.out.println("사용 하시겠습니까?");
        System.out.println("====================");
        System.out.println("1.예");
        System.out.println("2.아니오");
        System.out.println("====================");
        this.입력 = in.nextInt();

        if(this.입력 == 1 && _캐릭터.종족스킬_제한 == true){
            System.out.println("강화된 손톱으로 적을 할퀴었습니다 데미지 "+_캐릭터.공격력*3);
            _몬스터.체력 = _몬스터.체력 - _캐릭터.공격력*3; //쓰레드때 출혈 상태이상 추가?
            _캐릭터.종족스킬_제한 = false;
                if (_몬스터.체력 <= 0) { //전투종료시 재화획득
                    //종족스킬 걍 따로만들자..
                }


        }
        else if(입력 ==1 && _캐릭터.종족스킬_제한 == false){
            System.out.println("이미 종족스킬을 사용하셨습니다");
        }

    } //추후 전직에따라 강화?

}
