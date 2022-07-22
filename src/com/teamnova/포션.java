package com.teamnova;

public class 포션 {

    String 이름;
    String 타입;
    int 아이템번호; //900번부터
    int 체력회복;
    int 마나회복;

//    포션(String 이름, String 타입, int 체력회복,int 마나회복, int 아이템번호){
//        this.이름 = 이름;
//        this.타입 = 타입;
//        this.체력회복 = 체력회복;
//        this.마나회복 = 마나회복;
//        this.아이템번호 = 아이템번호;
//
//    }

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
}
