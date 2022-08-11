package com.teamnova.메뉴;

import com.teamnova.몬스터.몬스터;

import javax.swing.*;

import static com.teamnova.몬스터.몬스터.유저명;

public class 캐릭터_스테이터스 extends Thread{
    JFrame 캐릭터_스테이터스 = new JFrame("캐릭터 스테이터스");

    JLabel 캐릭터_텍스트 = new JLabel("캐릭터 스테이터스");

    public void 캐릭터_전투_스테이터스(몬스터 _몬스터) {

        this.캐릭터_스테이터스.setSize(500, 500);
        this.캐릭터_텍스트.setText("" +
                "<html>=====================" +
                "<br>이름 : " + 유저명.이름+
                "<br>체력 : "+유저명.전투중체력+
                "<br>마나 : "+유저명.전투중마나+
                "<br>공격력 : "+유저명.전투중공격력+
                "<br>마법력 : "+유저명.전투중마법력+
                "<br>방어력 : "+유저명.전투중방어력+
                "<br>회피율 : "+유저명.전투중회피율+
                "<br><html>=====================");
        this.캐릭터_스테이터스.add(캐릭터_텍스트);
        this.캐릭터_스테이터스.setLocation(200,400);
        this.캐릭터_스테이터스.pack();
        this.캐릭터_스테이터스.setVisible(true);
    }
}
