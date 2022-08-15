package com.teamnova.스킬;

import javax.swing.*;
import java.util.Scanner;


public abstract class 스킬 extends Thread{

    public Scanner in = new Scanner(System.in);
    public int 입력;
    public String 스킬이름;
//    public int 스킬공격력;
    public int 마나소모;
    public int 계열; // 공격계열일때 ,패시브일떄 ,회복계열일때랑 객체 다르게만들어야함 // 1.공격스킬, 2.회복스킬, 3.버프스킬
    public boolean 스킬제한 = true; //전투당 한번밖에 못쓰는스킬들
    public int 수치;
//    public int 효과; // 0공격관련버프 1방어관련버프 2회복계열 3공격계열
    public int 스킬마법력;
    public String 설명;
    public int 가격;

    public boolean 임시스킬제한 = false; //스킬 쿨타임을 위한 맴버변수
    public int 스킬쿨다운;
    public JFrame 스킬프레임 = new JFrame("스킬프레임");
    public JLabel 쿨타임텍스트 = new JLabel("쿨타임");




//    public 스킬(String 스킬이름, int 마나소모, int 수치, int 계열, boolean 스킬제한, int 효과, String 설명) { // 회복스킬
//        this.스킬이름 = 스킬이름;
//        this.마나소모 = 마나소모;
//        this.수치 = 수치;
//        this.계열 = 계열;
//        this.스킬제한 = 스킬제한;
//        this.효과 = 효과;
//        this.설명 = 설명;
//
//    }
    public abstract void 스킬효과(); //스킬발동되면 나오는 효과
    public abstract void 스킬설명(); //스킬설명
    public abstract void 스킬초기화(); // 제한이 있는스킬들 전투끝나고 초기화시켜주는 메소드
    public abstract void 스킬쿨타임();
}

