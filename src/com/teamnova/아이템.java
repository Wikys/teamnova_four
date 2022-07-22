package com.teamnova;

import java.util.ArrayList;

public class 아이템 {
    String 이름;
    String 타입;
    int 공격력;
    int 방어력;
    int 체력회복;
    int 마나회복;
    int 아이템번호; //1 부터

     아이템(int _아이템번호){

        if (_아이템번호 == 0) {
            this.이름_낡은검();
            this.정보_낡은검();
        }
        else if (_아이템번호 == 1){
            this.이름_철검();
            this.정보_철검();

        }
        else if (_아이템번호 == 100){
            this.이름_가죽갑옷();
            this.정보_가죽갑옷();
        }
        else if(_아이템번호 == 101){
            this.이름_철갑옷();
            this.정보_철갑옷();
        }

        else if(_아이템번호 == 900){
            this.이름_체력포션();
            this.정보_체력포션();
        }
        else if(_아이템번호 == 901){
            this.이름_마나포션();
            this.정보_마나포션();
        }


    }
    public String 이름_낡은검(){ //이름 리턴시켜주는 메소드,정보

        this.이름 = "낡은검";

        return this.이름;
    }
    public void 정보_낡은검(){
        this.이름 = "낡은검";
        this.타입 = "무기";
        this.공격력 = 1;
        this.아이템번호 = 0;

    }
    public String 이름_철검(){ //이름 리턴시켜주는 메소드,정보

        this.이름 = "철검";
        return this.이름;
    }
    public void 정보_철검(){
        this.이름 = "철검";
        this.타입 = "무기";
        this.공격력 = 3;
        this.아이템번호 = 1;

    }
    public String 이름_가죽갑옷(){ //이름 리턴시켜주는 메소드,정보

        this.이름 = "가죽갑옷";
        return this.이름;
    }
    public void 정보_가죽갑옷(){
        this.이름 = "가죽갑옷";
        this.타입 = "갑옷";
        this.방어력 = 2;
        this.아이템번호 = 100;
    }
    public int 가죽갑옷적용(int _방어도){
        캐릭터 캐릭터 = new 캐릭터();
        _방어도 = 캐릭터.방어력 + 2;
        return _방어도;
    }
    public String 이름_철갑옷(){ //이름 리턴시켜주는 메소드,정보

        this.이름 = "철갑옷";

        return this.이름;
    }
    public void 정보_철갑옷(){ //이름 리턴시켜주는 메소드,정보
        this.이름 = "철갑옷";
        this.타입 = "갑옷";
        this.방어력 = 5;
        this.아이템번호 = 101;

    }
    public String 이름_체력포션(){ //이름 리턴시켜주는 메소드,정보

        this.이름 = "체력포션";
        return this.이름;
    }
    public void 정보_체력포션(){
        this.이름 = "체력포션";
        this.타입 = "포션";
        this.체력회복 = 5;
        this.아이템번호 = 900;

    }
    public String 이름_마나포션(){ //이름 리턴시켜주는 메소드,정보

        this.이름 = "마나포션";
        return this.이름;

    }
    public void 정보_마나포션() {
        this.이름 = "마나포션";
        this.타입 = "포션";
        this.마나회복 = 5;
        this.아이템번호 = 901;
    }



    public ArrayList<아이템> 인벤토리(){
        ArrayList<아이템>아이템생성 = new ArrayList<아이템>();

        return 아이템생성;
    }







}
