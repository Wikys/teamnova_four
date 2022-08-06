package com.teamnova.아이템.분류;

import com.teamnova.플레이어.캐릭터;

public class 조악한_완드 extends 마법무기 {
    public String 이름 = "조악한완드";
    //    int 타입 ; // 상위클래스에서 줍니다
    public int 아이템번호 = 0;
    public int 수치 = 5;
    public int 가격 = 5;
//    int 마법무기; // 상위클래스에서 줍니다

    public 조악한_완드() {
        this.이름 = "조악한완드";
        this.마법무기 = 1;

        this.가격 = 5;
        this.아이템번호 = 0;
        this.타입=1;
        this.무기중복=false;
        this.수치 = 5;
        this.마법력 = this.수치;
    }

    @Override
    public void 착용효과(캐릭터 _캐릭터) {
        _캐릭터.마법력 = _캐릭터.마법력 + this.수치;
        System.out.println("몸에 미약한 마력이 감돕니다");

    }

    @Override
    public void 착용해제(캐릭터 _캐릭터) {
        _캐릭터.마법력 = _캐릭터.마법력 - this.수치;
        System.out.println("착용이 해제되었습니다");
    }

    @Override
    public void 설명() {
        System.out.println("========================================================");
        System.out.println("아이템이름 : 조악한완드");
        System.out.println("설명 : 미량의 마력이 담겨잇는 완드입니다");
        System.out.println("마법력 : +3");
        System.out.println("========================================================");

    }
//    public static 아이템 낡은검 = new 아이템("낡은검", 1, 0, 1, "다 낡아빠진 검이다",0,0); // 아이템호출
//    public static 아이템 철검 = new 아이템("철검", 1, 1, 3, "단단한 철로 만들어진 날카로운 검이다",10,0);
//    public static 아이템 고블린왕의_몽둥이 = new 아이템("고블린왕의_몽둥이", 1, 2, 5, "조악해 보이지만 한 종족의 왕이 썻던 무기인만큼 튼튼하다",0,0);
//    public static 아이템 가죽갑옷 = new 아이템("가죽갑옷", 2, 100, 2, "초급 모험가들이 즐겨입는 가죽갑옷이다",15,0);
//    public static 아이템 철갑옷 = new 아이템("철갑옷", 2, 101, 5, "철로 만들어져 꽤 강력한 공격까지 막아낼수 있을듯하다",30,0);
//    public static 아이템 체력포션 = new 아이템("체력포션",3,900,5, "단순히 체력이 조금 회복될뿐인 싸구려 포션이다",5,0);
//    public static 아이템 마나포션 = new 아이템("마나포션",4,901,5, "단순히 마나가 조금 회복될뿐인 싸구려 포션이다",5,0);
//    public static 아이템 조악한_완드 = new 아이템("조악한_완드",1,3,5,"허접하게 만들어진 완드지만 조금의 마법력은 남아있는듯하다",20,1);
}
