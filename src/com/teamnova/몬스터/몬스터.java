package com.teamnova.몬스터;

import com.teamnova.메뉴.전투메뉴;
import com.teamnova.아이템.분류.잡템;
import com.teamnova.아이템.아이템;
import com.teamnova.플레이어.캐릭터;

import javax.swing.*;
import java.util.Random;

import static com.teamnova.메뉴.행동문.밤;
import static com.teamnova.몬스터.몬스터_인카운터.몬스터;


public abstract class 몬스터 extends Thread {
    JFrame 몬스터_전투 = new JFrame("캐릭터 스테이터스");
    public JLabel 몬스터_전투_메세지 = new JLabel("");
//    public JFrame 몬스터_공격창 = new JFrame("몬스터 메세지");
//    public JLabel 몬스터_텍스트 = new JLabel("몬스터 공격텍스트");
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
    public int 몬스터타입; // 0 일반몬스터 , 1 보스몬스터
    //    int 아이템;
    public int 몬스터번호;
    public String 상태;
    public boolean 도주허용 = false;

    public Random random = new Random();
    아이템 잡템 = new 잡템();
    전투메뉴 전투메뉴 = new 전투메뉴(); // 텍스트출력 매개용
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

    public abstract void 광폭화();
    public abstract void 스킬();

//

    public int 몹공격받음(int _방어력, int _적공격력, int _회피율) {
        int 랜덤이벤트 = random.nextInt(100) + 1;
        if (_방어력 >= _적공격력) {
            _적공격력 = 0; //방어력이 적 공격력보다 높으면 데미지0
        } else if (랜덤이벤트 <= 20) {
            _적공격력 = _적공격력 * 2 - _방어력;
            System.out.println("적에게 치명상을 주었습니다");
            유저명.전용패시브();
        } else if (랜덤이벤트 <= _회피율) {
            _적공격력 = 0; //회피하면 순간 적공격력 0으로 처리
            System.out.println("몬스터가 공격을 회피하였습니다");
        } else {
            _적공격력 = _적공격력 - _방어력;
            유저명.전용패시브();
        }
        return _적공격력;
    }
    public void 몬스터_전투_메세지(){
        this.공격받음(유저명.전투중방어력, 몬스터.공격력, 유저명.회피율); //몹이 보내주는거 받아먹기기
        this.몬스터_전투.add(몬스터_전투_메세지);
        this.몬스터_전투.setLocation(200, 300);
        this.몬스터_전투.pack();
        this.몬스터_전투.setVisible(true);
        if (유저명.전투중체력 <=0 || 몬스터.체력 <=0 ){
            몬스터_전투.setVisible(false);
            몬스터_전투.dispose();
        }

    }
    public int 공격받음(int _방어력, int _적공격력, int _회피율) {//몬스터의 공격

//        몬스터 몬스터 = new 몬스터();
        int 회피 = random.nextInt(100) + 1;

        if (유저명.전투중방어력 >= _적공격력) {
            _적공격력 = 0; //방어력이 적 공격력보다 높으면 데미지0
            this.몬스터_전투_메세지.setText("<html>몬스터가 열심히 공격하고있지만" +
                    "<br> 아프지않습니다");

        } else if (회피 <= _회피율) {
            _적공격력 = 0; //회피하면 순간 적공격력 0으로 처리
//            System.out.println("몬스터의 손이 미끄러졌습니다");
            this.몬스터_전투_메세지.setText("<html>몬스터의 손이 미끄러졌습니다" +
                    "<br> 데미지를 받지않습니다");
        } else if(몬스터.몬스터타입 == 1 && 회피 <= 30){

            몬스터.스킬();
        }
        else {
//            _체력 = _체력 + this.전투중방어력 - _적공격력; //적공격력이 더높으면 방어력-적공격력만큼 받음
            _적공격력 = _적공격력 - _방어력;
            this.몬스터_전투_메세지.setText("<html>몬스터가 공격합니다 <br>" +
                    ""+_적공격력+" 만큼의 데미지를 받습니다");
        }
        return _적공격력;
    }

    public int 캐릭터공격() {
        // 몬스터 반격
        int _랜덤공격 = this.공격받음(유저명.전투중방어력, this.공격력, 유저명.회피율);
        유저명.전투중체력 = 유저명.전투중체력 - _랜덤공격;
    return _랜덤공격; //실 데미지 리턴
    }
    public void run() {
        boolean 제한 = true;

        while(true) {
                this.캐릭터공격();
                this.몬스터_전투_메세지();
            if (밤 == true && 제한 == true && this.몬스터타입 == 0 && 몬스터.체력 > 0){
                this.광폭화();
                System.out.println("몬스터가 광폭화했습니다");
                제한 = false;

            }

            if(유저명.전투중체력 <=0 || this.체력 <= 0 || 몬스터.도주허용){

                this.interrupt();
//                System.exit(1);
                if(유저명.전투중체력 <= 0){
                    System.out.println("죽었습니다");
                    System.exit(1);
                }
                break;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}



