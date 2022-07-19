package com.teamnova;
import java.util.Random;



public class 몬스터 {
    Random random = new Random();
    public void 몬스터(){
        int 인카운터 = random.nextInt(4);
        몬스터정보 몬스터 = new 몬스터정보();

        if (인카운터 == 0){
            몬스터.이름 = "고블린";
            몬스터.체력 = 10;
            몬스터.공격력 = 1;
            몬스터.방어력 = 0;
            몬스터.경험치 = 5;
            몬스터.골드 = random.nextInt(5);
        }
        else if (인카운터 == 1){
            몬스터.이름 = "오크";
            몬스터.체력 = 15;
            몬스터.공격력 = 3;
            몬스터.방어력 = 1;
            몬스터.경험치 = 8;
            몬스터.골드 = random.nextInt(10);
        }
        else if (인카운터 == 2){
            몬스터.이름 = "오우거";
            몬스터.체력 = 20;
            몬스터.공격력 = 4;
            몬스터.방어력 = 2;
            몬스터.경험치 = 10;
            몬스터.골드 = random.nextInt(15);
        }

    }
}
