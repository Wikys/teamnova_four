package com.teamnova.몬스터;

import com.teamnova.몬스터.보스.보스;
import com.teamnova.아이템.분류.잡템;
import com.teamnova.아이템.아이템;
import com.teamnova.플레이어.캐릭터;

import javax.swing.*;
import java.util.Random;



public abstract class 몬스터 extends Thread {
    public JFrame 몬스터_공격창 = new JFrame("몬스터 메세지");
    public JLabel 몬스터_텍스트 = new JLabel("몬스터 공격텍스트");
    //    전투메뉴 전투메뉴 = new 전투메뉴();
    public static 캐릭터 유저명;
    public String 이름;
    public int 공격력;
    public int 방어력;
    public int 체력;
    public int 마나;
    public int 회피율;
    public int 경험치;
    public int 골드;
    public int 몬스터타입; // 0 일반몬스터 , 1 보스몬스터 아직은 딱히 쓰는덴없음
    //    int 아이템;
    public int 몬스터번호;

    public Random random = new Random();
    아이템 잡템 = new 잡템();
//    전투메뉴 전투메뉴 = new 전투메뉴();


    public 몬스터() {
    }


    //    public 몬스터(String 이름, int 체력,int 마나, int 공격력, int 방어력,int 회피율, int 경험치, int 골드, int 몬스터번호, int 몬스터타입) {
    public 몬스터(int 몬스터번호) {
//        this.이름 = 이름;
//        this.공격력 = 공격력;
//        this.방어력 = 방어력;
//        this.체력 = 체력;
//        this.마나 = 마나;
//        this.회피율 = 회피율;
//        this.경험치 = 경험치;
//        this.골드 = 골드;
        this.몬스터번호 = 몬스터번호;

    }

    public abstract void 몬스터_정보();

    public abstract void 몬스터_드랍();

//

    public int 몹공격받음(int _방어력, int _적공격력, int _회피율) {
        int 랜덤이벤트 = random.nextInt(100) + 1;
        if (_방어력 >= _적공격력) {
            _적공격력 = 0; //방어력이 적 공격력보다 높으면 데미지0
        } else if (랜덤이벤트 <= 20) {
            _적공격력 = _적공격력 * 2 - _방어력;
            System.out.println("적에게 치명상을 주었습니다");
        } else if (랜덤이벤트 <= _회피율) {
            _적공격력 = 0; //회피하면 순간 적공격력 0으로 처리
            System.out.println("몬스터가 공격을 회피하였습니다");
        } else {
            _적공격력 = _적공격력 - _방어력;
        }
        return _적공격력;
    }

    public void 캐릭터공격() { // 몬스터 반격
        int _랜덤공격 = 유저명.공격받음(유저명.전투중방어력, this.공격력, 유저명.회피율);
        if (this.체력 > 0 && this.몬스터타입 == 0 ) {
            유저명.전투중체력 = 유저명.전투중체력 - _랜덤공격;
            this.몬스터_텍스트.setText("<html>==========================================" +
                    "<br>" + this.이름 + "이(가) 공격합니다 데미지를 "
                    + _랜덤공격 + "받았습니다" +
                    "<br>==========================================");
            this.몬스터_공격창.add(this.몬스터_텍스트);
            this.몬스터_공격창.setLocation(500, 500);
            this.몬스터_공격창.pack();
            this.몬스터_공격창.setVisible(true);
            if (유저명.전투중체력 <= 0 || this.체력 <= 0) {

                this.몬스터_공격창.dispose();

            }

//            System.out.println(this.이름 + "이(가) 반격합니다 데미지를 "
//                    + _랜덤공격 + "받았습니다");
        } else if (this.체력 > 0 && this.몬스터타입 == 1) {
            int 스킬 = random.nextInt(100);
            if (스킬 < 30) {
                ((보스) this).보스_스킬();
                if (유저명.전투중체력 <= 0 || this.체력 <= 0) {

                    this.몬스터_공격창.dispose();

                }
            } else if (스킬 >= 30) {
                유저명.전투중체력 = 유저명.전투중체력 - _랜덤공격;
                this.몬스터_텍스트.setText("<html>==========================================" +
                        "<br>" + this.이름 + "이(가) 공격합니다 데미지를 "
                        + _랜덤공격 + "받았습니다" +
                        "<br>==========================================");
                this.몬스터_공격창.add(this.몬스터_텍스트);
                this.몬스터_공격창.setLocation(500, 500);
                this.몬스터_공격창.pack();
                this.몬스터_공격창.setVisible(true);
            }
            if (유저명.전투중체력 <= 0 || this.체력 <= 0) {
                this.몬스터_공격창.dispose();

            }
        }

    }


}



