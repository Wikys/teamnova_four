package com.teamnova;

public class 방어구 {

    String 이름;
    String 타입 = "갑옷";
    int 방어력;
    int 아이템번호; // 갑옷 100부터







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
}
