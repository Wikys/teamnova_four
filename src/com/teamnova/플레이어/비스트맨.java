package com.teamnova.플레이어;


import com.teamnova.몬스터.몬스터;

public class 비스트맨 extends 아인종{
    public int 종족번호 = 1;
    public int 종족 = 1;

//    public int 강조_공격력;
//    public String 설명;
//    public boolean 종족스킬_제한;
    public int 강조_공격력 = 공격력*3;
    public boolean 종족스킬_제한 = true;


    public void 강조(몬스터 _몬스터){
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

        if(this.입력 == 1 && this.종족스킬_제한 == true){
            _몬스터.몹공격받음(_몬스터.방어력,_몬스터.공격력,_몬스터.회피율);
            System.out.println("강화된 손톱으로 적을 할퀴었습니다 추가데미지 "+this.강조_공격력);
            this.종족스킬_제한 = false;

        }
        else if (this.입력 ==2){

        }

    } //추후 전직에따라 강화?
}
