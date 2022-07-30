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
    int 효과; // 0공격관련버프 1방어관련버프


    ArrayList<스킬> _스킬목록 = new ArrayList<>();

    스킬() {

    }

    스킬(String 스킬이름, int 마나소모, int 수치, int 계열, boolean 스킬제한, int 효과) { // 회복스킬
        this.스킬이름 = 스킬이름;
        this.마나소모 = 마나소모;
        this.수치 = 수치;
        this.계열 = 계열;
        this.스킬제한 = 스킬제한;
        this.효과 = 효과;

    }

    public void 스킬사용(String _스킬이름,int _방어력,int _공격력, int _사용마나, int _수치, int _효과, 캐릭터 _대상) { //버프스킬 효과0 공격 , 1방어관련

        System.out.println(_스킬이름 + " 스킬을 사용하였습니다" +
                " 마나를 " + _사용마나 + " 사용했습니다");
        if (_효과 == 0) {
            _대상.전투중공격력 = _대상.전투중공격력 + _수치;
            _대상.전투중마나 = _대상.전투중마나 - _사용마나;
            System.out.println("공격력 " + "+" + _수치 + " 증가했습니다");

        } else if (_효과 == 1) {
            _대상.전투중방어력 = _대상.전투중방어력 + _수치;
            _대상.전투중마나 = _대상.전투중마나 - _사용마나;
            System.out.println("방어력 " + "+" + _수치 + " 증가했습니다");
        }
    }
    public int 스킬패널티(int _마나소모, int _현재마나) { //스킬의 패널티

        int _패널티 = _현재마나 - _마나소모;
        return _패널티;
    }

}

