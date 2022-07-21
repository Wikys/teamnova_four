package com.teamnova;

import java.util.ArrayList;
import java.util.Calendar;

public class 스킬 {

    String 스킬이름;
    int 스킬공격력;
    int 마나소모;
    캐릭터 스탯 = new 캐릭터();

    ArrayList<String> _스킬목록 = new ArrayList<>();



    public String 용기이름() { //용기의 이름을 출력해주는 메소드
        String 용기이름 = "용기";
        return 용기이름;
    }

    public int 용기() { //용기스킬 효과

        System.out.println("스킬사용으로 용기를 얻습니다" +
        " 방어력이 " + 1 + " 증가합니다 마나를 5 사용했습니다");
        return +1; // 전투끝나면 방어력 오른거 초기화시켜야함
    }
    public int 용기패널티() { //용기의 패널티

        int _패널티 = 스탯.전투중마나 - 5;
        return _패널티;
    }





//    public ArrayList<String> _스킬목록() {
//        ArrayList<String> _스킬목록 = new ArrayList<>();
//        return _스킬목록;
//    }
    }

