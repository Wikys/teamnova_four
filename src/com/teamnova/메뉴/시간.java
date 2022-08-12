package com.teamnova.메뉴;

import javax.swing.*;
import static com.teamnova.메뉴.행동문.밤;

public class 시간 extends Thread {

    public boolean 밤시작 = false;
    public boolean 낮시작 = true;
    public JFrame 현재시간 = new JFrame("현재시간");
    public JLabel 현재시간_텍스트 = new JLabel("현재시간_텍스트");

    public void 낮() {

        int 밤카운트 = 0;
        if (낮시작 == true) {
            while (true) {
                밤카운트++;
                this.현재시간_텍스트.setText("<html>지금은 낮입니다" +
                        "<br>"+(100 - 밤카운트) + "초 후에 밤이 됩니다");
                this.현재시간.add(this.현재시간_텍스트);
                this.현재시간.setLocation(0,0);
                this.현재시간.pack();
                this.현재시간.setVisible(true);

                if (밤카운트 == 100) {
                    this.밤시작 = true;
                    this.낮시작 = false;
                    현재시간.dispose();
                    밤 = true;
                    break;
                }
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }


    } // 밤낮쪼개기

    public void 밤() {
        int 낮카운트= 0;
        if (밤시작 == true) {

            while (true) {
                낮카운트 ++;
                this.현재시간_텍스트.setText("<html>지금은 밤입니다<br>'휴식'을 권장합니다" +
                        "<br>"+(100 - 낮카운트) + "초 후에 낮이 됩니다");
                this.현재시간.add(this.현재시간_텍스트);
                this.현재시간.setLocation(0,0);
                this.현재시간.pack();
                this.현재시간.setVisible(true);

                if (낮카운트 == 100) {
                    this.밤시작 = false;
                    this.낮시작 = true;
                    현재시간.dispose();
                    밤 = false;
                    break;
                }
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Override
    public void run() {
        while (true) {
            this.낮();
            this.밤();
        }
    }
}
