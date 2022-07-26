package com.teamnova;

import java.util.ArrayList;
import java.util.Calendar;

public class 스킬 {

    String 스킬이름;
    int 스킬공격력;
    int 마나소모;
    int 계열; // 공격계열일때 ,패시브일떄 ,회복계열일때랑 객체 다르게만들어야함 // 1.공격스킬, 2.회복스킬, 3.버프스킬
    boolean 스킬제한 = true;
    int 수치;
    String 효과;


    ArrayList<스킬> _스킬목록 = new ArrayList<>();

    스킬() {

    }
    스킬 (String 스킬이름, int 마나소모, int 수치,int 계열, boolean 스킬제한, String 효과){ // 회복스킬
        this.스킬이름 = 스킬이름;
        this.마나소모 = 마나소모;
        this.수치 = 수치;
        this.계열 = 계열;
        this.스킬제한 = 스킬제한;
        this.효과 = 효과;
    }




//    public String 용기이름() { //용기의 이름을 출력해주는 메소드
//        String 용기이름 = "용기";
//        return 용기이름;
//    }

    public int 스킬사용(String _스킬이름,int _사용마나, int _수치, String _효과) { //버프스킬

        System.out.println(_스킬이름+" 스킬을 사용하였습니다" +
        " 마나를 "+_사용마나+" 사용했습니다");
        System.out.println(_효과+" "+_수치);
        return this.수치; // 전투끝나면 방어력 오른거 초기화시켜야함
    }
    public int 스킬패널티(int _마나소모, int _현재마나) { //스킬의 패널티

        int _패널티 = _현재마나 - _마나소모;
        return _패널티;
    }

//    public boolean 스킬제한(boolean _스킬값){ // 횟수제한 스킬 메소드
//        if(_스킬값 = true){
//            _스킬값 = false;
//        }
//        return _스킬값;
//    }





//    public ArrayList<String> _스킬목록() {
//        ArrayList<String> _스킬목록 = new ArrayList<>();
//        return _스킬목록;
//    }
    }

