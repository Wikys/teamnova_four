package com.teamnova;

import java.util.Random;


public class 몬스터 {
    String 이름;
    int 공격력;
    int 방어력;
    int 체력;
    int 경험치;
    int 골드;
    int 아이템;
    Random random = new Random();

//    public 몬스터 (String _이름, int _공격력, int _방어력, int _체력, int _경험치, int _골드, int _아이템){ //스테이터스
//
//
//    }
    //디폴트 생성자
    public 몬스터(){}


    public 몬스터(String 이름, int 공격력, int 방어력, int 체력, int 경험치, int 골드, int 아이템) {
        this.이름 = 이름;
        this.공격력 = 공격력;
        this.방어력 = 방어력;
        this.체력 = 체력;
        this.경험치 = 경험치;
        this.골드 = 골드;
        this.아이템 = 아이템;
    }

    public void 고블린() {
        this.이름 = "고블린";
        this.체력 = 10;
        this.공격력 = 1;
        this.방어력 = 0;
        this.경험치 = 5;
        this.골드 = random.nextInt(5);
    }

    public void 오크() {
        this.이름 = "오크";
        this.체력 = 15;
        this.공격력 = 3;
        this.방어력 = 1;
        this.경험치 = 8;
        this.골드 = random.nextInt(10);
    }

    public void 오우거() {
        this.이름 = "오우거";
        this.체력 = 20;
        this.공격력 = 4;
        this.방어력 = 2;
        this.경험치 = 10;
        this.골드 = random.nextInt(15);
    }


    public String 몬스터() { //랜덤숫자 받아서 랜덤몬스터 이름 리턴
        int 인카운터 = random.nextInt(2);

        if (인카운터 == 0) {
            this.이름 = "고블린";
            this.골드 = random.nextInt(5);

        } else if (인카운터 == 1) {
            this.이름 = "오크";

        } else if (인카운터 == 2) {
            this.이름 = "오우거";
        }
        return this.이름;
    }
    public int 몹이공격받음(int 남은체력) { //몬스터가 받은데미지
        캐릭터 캐릭터 = new 캐릭터();

        if (방어력 >= 캐릭터.공격력) {
            남은체력 = 체력 - 0; //방어력이 적 공격력보다 높으면 데미지0
        } else {
            남은체력 = 체력 + 방어력 - 캐릭터.공격력; //적공격력이 더높으면 방어력-적공격력만큼 받음
        }
        return 남은체력;
    }
}


