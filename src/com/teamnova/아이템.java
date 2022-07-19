package com.teamnova;

public class 아이템 {
    String 타입;
    String 이름;
    캐릭터 아이템 = new 캐릭터();
    public String 낡은검(){

        이름 = "낡은검";
        타입 = "무기";
        아이템.공격력 = 1;
        return 이름;
    }
    public String 철검(){

        이름 = "철검";
        타입 = "무기";
        아이템.공격력 = 3;
        return 이름;
    }
    public String 가죽갑옷(){

        이름 = "가죽갑옷";
        타입 = "갑옷";
        아이템.방어력 = 2;
        return 이름;
    }
    public String 철갑옷(){

        이름 = "철갑옷";
        타입 = "갑옷";
        아이템.방어력 = 5;
        return 이름;
    }
    public String 체력포션(){

        이름 = "체력포션";
        타입 = "포션";
        아이템.체력 = 5;
        return 이름;

    }
    public String 마나포션(){

        이름 = "마나포션";
        타입 = "포션";
        아이템.마나 = 5;
        return 이름;

    }
}
