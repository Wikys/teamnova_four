package com.teamnova.아이템;

import java.util.ArrayList;

public class 아이템 {
    public String 이름;
    public int 타입;  // 1:무기 2:방어구 3:체력포션 4:마나포션
    public int 공격력;
    public int 방어력;
    public int 마법력;
    public int 체력회복;
    public int 마나회복;
    public int 아이템번호; //1 부터
    public int 가격;
    public int 마법무기; //0: 일반무기 1: 마법무기
    public int 특수; // 0: 일반아이템, 1:특수아이템 2:보스드랍전용
    public String 설명;
    //    boolean 중복장착 = false;
    public boolean 무기중복 = false;
    public boolean 방어구중복 = false;
    public ArrayList<아이템> 인벤토리 = new ArrayList<아이템>();
    public ArrayList<아이템> 장비창 = new ArrayList<아이템>();
    public ArrayList<아이템> 전투인벤토리 = new ArrayList<아이템>();
    //   ArrayList<아이템> 드랍테이블 = new ArrayList<아이템>();

//    public abstract 아이템_설명();
//    public abstract 아이템_효과();


    public 아이템() {

    }

    public 아이템(String 이름, int 타입, int 아이템번호, int 수치, String 설명, int 가격, int 마법무기) { //아이템타입,번호,수치 갈라서 어떤종류의 아이템인지 갈라주는 생성자
        this.이름 = 이름;
        this.타입 = 타입;
        this.아이템번호 = 아이템번호;
        this.설명 = 설명;
        this.가격 = 가격;
        this.마법무기 = 마법무기;


        if (타입 == 1) { //무기
            if (마법무기 == 0) {
                if (아이템번호 == 0) {
                    this.공격력 = 수치;
                } else if (아이템번호 == 1) {
                    this.공격력 = 수치;
                } else if (아이템번호 == 2) {
                    this.공격력 = 수치;
                }
            } else if (마법무기 == 1) {
                if (아이템번호 == 3) {
                    this.마법력 = 수치;
                }
            }
        } else if (타입 == 2) { //방어구
            if (아이템번호 == 100) {
                this.방어력 = 수치;
            } else if (아이템번호 == 101) {
                this.방어력 = 수치;
            }
        } else if (타입 == 3) { //포션류
            if (아이템번호 == 900) {
                this.체력회복 = 수치;
            }

        } else if (타입 == 4) {
            if (아이템번호 == 901) {
                this.마나회복 = 수치;
            }
        }

    }

    public 아이템(int 가격) {

        this.가격 = 가격;
    }

    public void 낡은검() { //아이템 정보들 (기능x)
        this.이름 = "낡은검";
        this.타입 = 1;
        this.공격력 = 1;
        this.아이템번호 = 0;
        this.가격 = 0;
        this.무기중복 = false;
        this.특수 = 0;
        this.설명 = "다 낡아빠진 검이다";
    }

    public void 철검() {
        this.이름 = "철검";
        this.타입 = 1;
        this.공격력 = 3;
        this.아이템번호 = 1;
        this.가격 = 10;
        this.무기중복 = false;
        this.특수 = 0;
        this.설명 = "단단한 철로 만들어진 날카로운 검이다";
    }

    public void 고블린왕의_몽둥이() {
        this.이름 = "고블린왕의_몽둥이";
        this.타입 = 1;
        this.공격력 = 5;
        this.아이템번호 = 2;
        this.가격 = 0;
        this.무기중복 = false;
        this.특수 = 1;
        this.설명 = "조악해 보이지만 한 종족의 왕이 썻던 무기인만큼 튼튼하다";

    }

    public void 조악한_완드() {
        this.이름 = "조악한_완드";
        this.타입 = 1;
        this.공격력 = 3;
        this.마법력 = 5;
        this.아이템번호 = 3;
        this.가격 = 0;
        this.무기중복 = false;
        this.특수 = 0;
        this.설명 = "허접하게 만들어진 완드지만 조금의 마법력은 남아있는듯하다";

    }

    public void 가죽갑옷() {
        this.이름 = "가죽갑옷";
        this.타입 = 2;
        this.방어력 = 2;
        this.아이템번호 = 100;
        this.가격 = 15;
        this.방어구중복 = false;
        this.특수 = 0;
        this.설명 = "초급 모험가들이 즐겨입는 가죽갑옷이다";
    }

    public void 철갑옷() { //이름 리턴시켜주는 메소드,정보
        this.이름 = "철갑옷";
        this.타입 = 2;
        this.방어력 = 5;
        this.아이템번호 = 101;
        this.가격 = 30;
        this.방어구중복 = false;
        this.특수 = 0;
        this.설명 = "철로 만들어져 꽤 강력한 공격까지 막아낼수 있을듯하다";
    }

    public void 체력포션() {
        this.이름 = "체력포션";
        this.타입 = 3;
        this.체력회복 = 5;
        this.아이템번호 = 900;
        this.가격 = 5;
        this.특수 = 0;
        this.설명 = "단순히 체력이 조금 회복될뿐인 싸구려 포션이다";
    }

    public void 마나포션() {
        this.이름 = "마나포션";
        this.타입 = 4;
        this.마나회복 = 5;
        this.아이템번호 = 901;
        this.가격 = 5;
        this.특수 = 0;
        this.설명 = "단순히 마나가 조금 회복될뿐인 싸구려 포션이다";
    }

}
