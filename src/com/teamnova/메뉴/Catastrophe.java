package com.teamnova.메뉴;

import javax.swing.*;

import static com.teamnova.메뉴.캐릭터생성.베드엔딩;
import static com.teamnova.메뉴.캐릭터생성.해피엔딩;

public class  Catastrophe extends Thread{
    public JFrame 카타스트로피 = new JFrame("카타스트로피");
    public JLabel 카타스트로피_텍스트 = new JLabel("남은턴");

    public boolean Catastrophe = false;
    public static int 카운트다운 = 1;


    @Override
    public void run() {

//
            try {
                System.out.println("당신은 고블린킹이 주둔한 도시에 파견된 모험자입니다");
                Thread.sleep(1000);
                System.out.println("당신은 주어진 시간내에 고블린킹을 처치해 도시를 구원해야합니다");
                Thread.sleep(1000);
                System.out.println("고블린킹은 선발대에 불과합니다");
                Thread.sleep(1000);
                System.out.println("주어진 시간내에 임무를 완수하지 못할 시");
                Thread.sleep(1000);
                System.out.println("고블린킹은 마왕에게 도시의 조사를 마치고");
                Thread.sleep(1000);
                System.out.println("마왕에게 보고할것입니다");
                Thread.sleep(1000);
                System.out.println("재앙을 막기위해서 시간내에 임무를 완수하세요");
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        while(true) {
            this.카타스트로피_텍스트.setText("종말의 날 : " + 카운트다운);
            this.카타스트로피.add(this.카타스트로피_텍스트);
            this.카타스트로피.setLocation(0, 500);
            this.카타스트로피.pack();
            this.카타스트로피.setVisible(true);
            if (카운트다운 == 0){
                this.카타스트로피_텍스트.setText("보스전 메뉴로 이동해 최후의 전투를 준비하십시오");
                //마왕과의 강제전투 , 탐색막힘
                베드엔딩 = true; //보스몬스터를 잡았을시엔 해피엔딩
            }
            else if(카운트다운 != 0 && 해피엔딩 == true){
                try {
                    System.out.println("축하드립니다");
                    Thread.sleep(1000);
                    System.out.println("당신은 마왕의 위협으로부터");
                    Thread.sleep(1000);
                    System.out.println("마을을 지켜냈습니다");
                    System.exit(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

        }
    }
}
