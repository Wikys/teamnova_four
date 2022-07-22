package com.teamnova;

public class 샘플코드 {
}
//class 아이템 {
//    String 이름;
//    int 타입;
//    int 아이템코드;
//
//    int 체력회복량;
//    int 마나회복량;
//    int 공격력;
//    int 방어력;
//
//    //생성자의 메소드명은 클래스 이름과 같다
//    //타입 1:체력포션 2:마나포션 3:방어구 4:무기
//
//    void 아이템(이름, 타입, 아이템코드, 수치) {
//        this.이름 = 이름;
//        this.타입 = 타입;
//        this.아이템코드 = 아이템코드
//
//        if (타입 == 1){
//            this.체력회복량 = 수치
//        }
//        else if (타입 == 2){
//            this.마나회복량 = 수치
//        }
//        else if (타입 == 3){
//            this.방어력 = 수치
//        }
//        else if (타입 == 4){
//            this.공격력 = 수치
//        }
//    }
//
//}
//
//    아이템 체력포션 = new 아이템("빨간포션", 1, 0001, 50);
//    아이템 마나포션 = new 아이템("마나포션", 2, 0002, 50);
//
//    ArrayList<아이템> 인벤토리 = new ArrayList<아이템>();
//
//인벤토리.append(체력포션)
//        인벤토리.append(체력포션)
//
//        인벤토리.append(마나포션)
//        인벤토리.append(마나포션)
//
////인벤토리 상황
////인벤토리 = [체력포션,체력포션,마나포션,마나포션]


//import java.util.ArrayList;
//
//class gameItem {
//    String Name;
//    int Type;
//    int Code;
//    int HPheal;
//    int MPheal;
//    int defence;
//    int attack;
//
//
//    public gameItem(String name, int type, int code, int value){
//        this.Name = name;
//        this.Type = type;
//        this.Code = code;
//
//        if(this.Type == 1){
//            this.HPheal = value;
//        }
//        else if(this.Type == 2){
//            this.MPheal = value;
//        }
//        else if(this.Type == 3){
//            this.defence = value;
//        }
//        else if(this.Type == 4){
//            this.attack = value;
//        }
//    }
//}
//
//public class Game {
//    public static void main(String[] args) {
//        gameItem hpPotion = new gameItem("빨간포션", 1, 1, 50);
//        gameItem mpPotion = new gameItem("파란포션", 2, 1, 100);
//
//        ArrayList<gameItem> Inventory = new ArrayList<gameItem>();
//
//        Inventory.add(hpPotion);
//        Inventory.add(hpPotion);
//        Inventory.add(mpPotion);
//        Inventory.add(mpPotion);
//
//        for (int i = 0; i < Inventory.size(); i++) {
//            System.out.println(Inventory.get(i).Name); }
//    }
//}