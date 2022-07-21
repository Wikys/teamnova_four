package com.teamnova;

import java.util.ArrayList;

public class 스킬 {
    String 스킬이름;
    int 스킬공격력;
    int 마나소모;


    public String 용기이름() { //용기의 이름을 출력해주는 메소드
        String 용기이름 = "용기";
        return 용기이름;
    }

    public int 용기동작(int 방어력증가, int 마나소모, int 사용횟수) { //기본스킬 방어력증가
        캐릭터 스탯 = new 캐릭터();
        int _효과 = 스탯.방어력 + 1;
        마나소모 = 5;
        System.out.println("스킬사용으로 용기를 얻습니다" +
                " 방어력이 " + _효과 + " 증가합니다");
        return _효과; // 불린으로 사용횟수 만들기 // 전체적으로 수정?
    }

    public ArrayList<String> _스킬목록() {

        ArrayList<String> _스킬목록 = new ArrayList<>();

        return _스킬목록;

    }



    }

