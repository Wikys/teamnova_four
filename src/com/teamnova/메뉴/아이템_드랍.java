//package com.teamnova.메뉴;
//
//import com.teamnova.아이템.분류.*;
//import com.teamnova.아이템.아이템;
//
//import java.util.Scanner;
//
//public class 아이템_드랍 {
//    public 아이템 조악한완드 = new 조악한_완드();
//    public 아이템 낡은검 = new 낡은검();
//    public 아이템 철검 = new 철검();
//    public 아이템 가죽갑옷 = new 가죽갑옷();
//    public 아이템 철갑옷 = new 철갑옷();
//    public 아이템 체력포션 = new 체력포션();
//    public 아이템 마나포션 = new 마나포션();
//    public 아이템 고블린왕의_몽둥이 = new 고블린왕의_몽둥이();
//    public Scanner in = new Scanner(System.in);
//
//    public 아이템 랜덤드랍(int _몬스터타입){
//        int 아이템드랍 = (int)(Math.random()*6);
//        아이템 드랍템 = null; //초기화
//
//        if(_몬스터타입 == 0 && 아이템드랍 == 0){
//            드랍템 = this.낡은검;
//        }
//        else if(_몬스터타입 == 0 &&아이템드랍 ==1){
//            드랍템 = this.철검;
//        }
//        else if(_몬스터타입 == 0 &&아이템드랍 ==2){
//            드랍템 = this.가죽갑옷;
//        }
//        else if(_몬스터타입 == 0 &&아이템드랍 ==3){
//            드랍템 = this.철갑옷;
//        }
//        else if(_몬스터타입 == 0 &&아이템드랍 ==4){
//            드랍템 = this.체력포션;
//        }
//        else if(_몬스터타입 == 0 &&아이템드랍 ==5){
//            드랍템 = this.마나포션;
//        }
//        else if(_몬스터타입 == 1){
//            드랍템 = this.고블린왕의_몽둥이;
//        }
//        return 드랍템;
//    }
//}
