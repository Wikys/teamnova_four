package com.teamnova;

import java.util.ArrayList;

public class 아이템 {
    String 이름;
    int 타입;  // 1:무기 2:방어구 3:체력포션 4:마나포션
    int 공격력;
    int 방어력;
    int 체력회복;
    int 마나회복;
    int 아이템번호; //1 부터
    int 가격;
    int 특수; // 특수아이템이거나 보스드랍 전용이라거나~
    String 설명;
    //    boolean 중복장착 = false;
    boolean 무기중복 = false;
    boolean 방어구중복 = false;
    ArrayList<아이템> 인벤토리 = new ArrayList<아이템>();
    ArrayList<아이템> 장비창 = new ArrayList<아이템>();
    ArrayList<아이템> 전투인벤토리 = new ArrayList<아이템>();
    //   ArrayList<아이템> 드랍테이블 = new ArrayList<아이템>();



    아이템() {

    }

    아이템(String 이름, int 타입, int 아이템번호, int 수치) {
        this.이름 = 이름;
        this.타입 = 타입;
        this.아이템번호 = 아이템번호;

        if (타입 == 1) { //무기
            if (아이템번호 == 0) {
                this.공격력 = 수치;
            } else if (아이템번호 == 1) {
                this.공격력 = 수치;
            } else if (아이템번호 == 2) {
                this.공격력 = 수치;
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

    아이템(int 가격) {

        this.가격 = 가격;
    }

    public void 낡은검() {
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
        this.설명 = "단순히 체력이 조금 회복될뿐인 싸구려 체력포션이다";
    }
    public void 마나포션() {
        this.이름 = "마나포션";
        this.타입 = 4;
        this.마나회복 = 5;
        this.아이템번호 = 901;
        this.가격 = 5;
        this.특수 = 0;
        this.설명 = "단순히 마나가 조금 회복될뿐인 싸구려 마나포션이다";
    }

}
