package com.teamnova.스킬;

import com.teamnova.플레이어.캐릭터;

import java.util.ArrayList;
import java.util.Scanner;

public class 스킬 {
    public Scanner in = new Scanner(System.in);
    public int 입력;
    public String 스킬이름;
    public int 스킬공격력;
    public int 마나소모;
    public int 계열; // 공격계열일때 ,패시브일떄 ,회복계열일때랑 객체 다르게만들어야함 // 1.공격스킬, 2.회복스킬, 3.버프스킬
    public boolean 스킬제한 = true;
    public int 수치;
    public int 효과; // 0공격관련버프 1방어관련버프
    public int 마법력;
    public String 설명;
    public ArrayList<스킬> _스킬목록 = new ArrayList<>();

    public 스킬() {

    }

    public 스킬(String 스킬이름, int 마나소모, int 수치, int 계열, boolean 스킬제한, int 효과, String 설명) { // 회복스킬
        this.스킬이름 = 스킬이름;
        this.마나소모 = 마나소모;
        this.수치 = 수치;
        this.계열 = 계열;
        this.스킬제한 = 스킬제한;
        this.효과 = 효과;
        this.설명 = 설명;

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
    public void 스킬인벤(캐릭터 _캐릭터){
        System.out.println("보유스킬");
        System.out.println("====================");
        for (int i = 0; i < this._스킬목록.size(); i++) {
            System.out.println("스킬 이름: " + i + ". " + _스킬목록.get(i).스킬이름);
        }
        System.out.println("====================");
        System.out.println("1.스킬정보");
        System.out.println("0.나가기");
        입력 = in.nextInt();
        if(입력 == 1) {
            System.out.println("설명을 보고싶은 스킬의 번호를 입력하세요");
            입력 = in.nextInt();
            스킬 선택스킬 = _스킬목록.get(입력);
            System.out.println(선택스킬.설명);
            System.out.println("마나소모량: "+선택스킬.마나소모);
            System.out.println();
            System.out.println("00.돌아가기");
            입력 = in.nextInt();
            if(입력 == 00){
                this.스킬인벤(_캐릭터);
            }
        }
    }// 나가는건 밖에다..
}

