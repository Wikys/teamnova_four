package com.teamnova;

import java.util.Random;


public class 몬스터 {
    String 이름;
    int 공격력;
    int 방어력;
    int 체력;
    int 마나;
    int 회피율;
    int 경험치;
    int 골드;
    int 몬스터타입; // 0 일반몬스터 , 1 보스몬스터 아직은 딱히 쓰는덴없음
//    int 아이템;
    int 몬스터번호;
    아이템 아이템드랍 = new 아이템();
    Random random = new Random();

//    public 몬스터 (String _이름, int _공격력, int _방어력, int _체력, int _경험치, int _골드, int _아이템){ //스테이터스
//
//
//    }
    //디폴트 생성자
    public 몬스터(){}


    public 몬스터(String 이름, int 체력,int 마나, int 공격력, int 방어력,int 회피율, int 경험치, int 골드, int 아이템, int 몬스터번호) {
        this.이름 = 이름;
        this.공격력 = 공격력;
        this.방어력 = 방어력;
        this.체력 = 체력;
        this.마나 = 마나;
        this.회피율 = 회피율;
        this.경험치 = 경험치;
        this.골드 = 골드;
        this.몬스터타입 = 0;
//        this.아이템 = 아이템;
        this.몬스터번호 = 몬스터번호;
    }

    public void 보물() {
        this.이름 = "보물";
        this.체력 = 1;
        this.마나 = 0;
        this.공격력 = 0;
        this.방어력 = 0;
        this.회피율 = 0;
        this.경험치 = 1000;
        this.골드 = random.nextInt(1000);
        this.몬스터타입 = 1;
        this.몬스터번호 = 999;

    }

    public void 고블린() {
        this.이름 = "고블린";
        this.체력 = 10;
        this.마나 = 0;
        this.공격력 = 1;
        this.방어력 = 0;
        this.회피율 = 2;
        this.경험치 = 5;
        this.골드 = random.nextInt(5);
        this.몬스터타입 = 0;
        this.몬스터번호 = 0;
    }

    public void 오크() {
        this.이름 = "오크";
        this.체력 = 15;
        this.마나 = 0;
        this.공격력 = 3;
        this.방어력 = 1;
        this.회피율 = 3;
        this.경험치 = 8;
        this.골드 = random.nextInt(10);
        this.몬스터타입 = 0;
        this.몬스터번호 = 1;
    }

    public void 오우거() {
        this.이름 = "오우거";
        this.체력 = 30;
        this.마나 = 0;
        this.공격력 = 5;
        this.방어력 = 2;
        this.경험치 = 10;
        this.골드 = random.nextInt(15);
        this.몬스터타입 = 0;
        this.몬스터번호 = 2;

    }

    public void 고블린킹() {
        this.이름 = "고블린킹";
        this.체력 = 200;
        this.마나 = 0;
        this.공격력 = 10;
        this.방어력 = 3;
        this.회피율 = 5;
        this.경험치 = 30;
        this.골드 = random.nextInt(100);
        this.몬스터타입 = 1;
        this.몬스터번호 = 3;

    } //특수아이템 떨어뜨리게하기


    public String 몬스터(int _인카운터, int _레벨) { //랜덤숫자 받아서 랜덤몬스터 이름 리턴

        if (_인카운터 == 0){ //더미? 치트몬스터
            this.이름 = "보물";
        }
        if (_인카운터 == 1) {
            this.이름 = "고블린";

        } else if (_인카운터 == 2) {
            this.이름 = "오크";

        } else if (_인카운터 == 3) {
            this.이름 = "오우거";
        }

        else if (_인카운터 == 4){ //5레벨 이하면 못만남
            this.이름 = "고블린킹";
        }
        return this.이름;
    }

//    public int 몹공격받음(int _체력, int _적공격력) {
////        몬스터 몬스터 = new 몬스터();
//
//        if (this.방어력 >= _적공격력) {
//            _체력 = this.체력 - 0; //방어력이 적 공격력보다 높으면 데미지0
//        } else {
//            _체력 = this.체력 + this.방어력 - _적공격력; //적공격력이 더높으면 방어력-적공격력만큼 받음
//        }
//        return _체력;
//    }
    public int 몹공격받음(int _방어력, int _적공격력, int _회피율) {
        int 랜덤이벤트 = random.nextInt(100)+1;
//        몬스터 몬스터 = new 몬스터();

        if (_방어력 >= _적공격력) {
            _적공격력 = 0; //방어력이 적 공격력보다 높으면 데미지0
        }
        else if (랜덤이벤트 <= 20){
//            _체력 = _체력 + _방어력 - _적공격력*2;
            _적공격력 = _적공격력*2 - _방어력 ;
            System.out.println("적에게 치명상을 주었습니다");
        }
        else if(랜덤이벤트 <= _회피율){
            _적공격력 = 0; //회피하면 순간 적공격력 0으로 처리
            System.out.println("몬스터가 공격을 회피하였습니다");
        }
        else {
//            _체력 = _체력 + _방어력 - _적공격력; //적공격력이 더높으면 방어력-적공격력만큼 받음
            _적공격력 = _적공격력 - _방어력  ;
        }
        return _적공격력;
    }
 //   public int 전투완료 ();

}
//    public int 공격받음(int _방어력, int _적공격력, int _회피율) {
////        몬스터 몬스터 = new 몬스터();
//        int 회피 = random.nextInt(100)+1;
//
//        if (this.전투중방어력 >= _적공격력) {
//            _적공격력 = 0; //방어력이 적 공격력보다 높으면 데미지0
//        }
//        else if(회피 <= _회피율){
//            _적공격력 = 0; //회피하면 순간 적공격력 0으로 처리
//            System.out.println("완벽하게 회피하였습니다");
//        }
//        else {
////            _체력 = _체력 + this.전투중방어력 - _적공격력; //적공격력이 더높으면 방어력-적공격력만큼 받음
//            _적공격력 = _적공격력 - _방어력 ;
//        }
//        return _적공격력;
//    }


