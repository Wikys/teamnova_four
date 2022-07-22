package com.teamnova;

public class 무기 {

    String 이름;
    String 타입;
    int 공격력;
    int 아이템번호; //1 부터

//    무기 (String 이름, String 타입, int 공격력, int 아이템번호){
//        this.이름 = 이름;
//        this.타입 = 타입;
//        this.공격력 = 공격력;
//        this.아이템번호 = 아이템번호;
//    }
//    무기(int 아이템번호){
//
//        this.아이템번호 = 아이템번호;
//
//    }


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

}
