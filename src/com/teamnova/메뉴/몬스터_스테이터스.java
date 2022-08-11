package com.teamnova.메뉴;

import com.teamnova.몬스터.몬스터;

import javax.swing.*;

public class 몬스터_스테이터스 extends Thread{

    JFrame 몬스터_스테이터스 = new JFrame("몬스터 스테이터스");

    JLabel 몬스터_텍스트 = new JLabel("몬스터 스테이터스");
    public void 몬스터_전투_스테이터스(몬스터 _몬스터) {

        this.몬스터_스테이터스.setSize(500, 500);
        this.몬스터_텍스트.setText("" +
                "<html>=====================" +
                "<br>이름 : " + _몬스터.이름+
                "<br>체력 : "+_몬스터.체력+
                "<br>마나 : "+_몬스터.마나+
                "<br>공격력 : "+_몬스터.공격력+
                "<br>방어력 : "+_몬스터.방어력+
                "<br>회피율 : "+ _몬스터.회피율+
                "<br><html>=====================");
        this.몬스터_스테이터스.add(몬스터_텍스트);
        this.몬스터_스테이터스.setLocation(400,400);
        this.몬스터_스테이터스.pack();
        this.몬스터_스테이터스.setVisible(true);
    }
}
