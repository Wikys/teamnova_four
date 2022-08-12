package com.teamnova.메뉴;

import com.teamnova.스킬.스킬;
import com.teamnova.아이템.아이템;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

import static com.teamnova.몬스터.몬스터.유저명;
import static com.teamnova.몬스터.몬스터_인카운터.몬스터;

public class 전투메뉴 extends Thread {

    JFrame 캐릭터_스테이터스 = new JFrame("캐릭터 스테이터스");
    JFrame 몬스터_스테이터스 = new JFrame("몬스터 스테이터스");
    JLabel 캐릭터_텍스트 = new JLabel("캐릭터 스테이터스");
    JLabel 몬스터_텍스트 = new JLabel("몬스터 스테이터스");
    메인메뉴 메인메뉴 = new 메인메뉴();
    Random random = new Random();


//    몬스터 몬스터= new 몬스터();
//    스킬 화염구 = new 화염구("화염구");

    Scanner in = new Scanner(System.in);
    int 입력;
    boolean 도주카운터 = true;

    //    캐릭터생성 캐릭터생성 = new 캐릭터생성();
    행동문 행동메뉴 = new 행동문();


    public void 캐릭터_전투_스테이터스() {


//        this.캐릭터_스테이터스.setSize(500, 500);
        this.캐릭터_텍스트.setText("" +
                "<html>=====================" +
                "<br>이름 : " + 유저명.이름 +
                "<br>체력 : " + 유저명.전투중체력 +
                "<br>마나 : " + 유저명.전투중마나 +
                "<br>공격력 : " + 유저명.전투중공격력 +
                "<br>마법력 : " + 유저명.전투중마법력 +
                "<br>방어력 : " + 유저명.전투중방어력 +
                "<br>회피율 : " + 유저명.전투중회피율 +
                "<br>=====================" +
                "<br>==========================================" +
                "<br>"+ 몬스터.이름 + "이(가)"+유저명.이름 +"을(를) 공격합니다 데미지를" +
                "<br>"+몬스터.캐릭터공격()+"받았습니다");
        this.캐릭터_스테이터스.add(this.캐릭터_텍스트);
        this.캐릭터_스테이터스.setLocation(0, 100);
        this.캐릭터_스테이터스.pack();
        this.캐릭터_스테이터스.setVisible(true);
        if (유저명.전투중체력 <=0 || 몬스터.체력 <=0 ){
            캐릭터_스테이터스.setVisible(false);
            캐릭터_스테이터스.dispose();
        }


    }

    public void 몬스터_전투_스테이터스() {


//        this.몬스터_스테이터스.setSize(500, 500);
        this.몬스터_텍스트.setText("" +
                "<html>=====================" +
                "<br>이름 : " + 몬스터.이름 +
                "<br>체력 : " + 몬스터.체력 +
                "<br>마나 : " + 몬스터.마나 +
                "<br>공격력 : " + 몬스터.공격력 +
                "<br>방어력 : " + 몬스터.방어력 +
                "<br>회피율 : " + 몬스터.회피율 +
                "<br>상태 : "+ 몬스터.상태+
                "<br><html>=====================");

        this.몬스터_스테이터스.add(this.몬스터_텍스트);
        this.몬스터_스테이터스.setLocation(300, 100);
        this.몬스터_스테이터스.pack();
        this.몬스터_스테이터스.setVisible(true);
        if (유저명.전투중체력 <=0 || 몬스터.체력 <=0 ){
            몬스터_스테이터스.setVisible(false);
            몬스터_스테이터스.dispose();
        }


    }

    @Override
    public void run() {
        while (true) {

            this.캐릭터_전투_스테이터스();
            this.몬스터_전투_스테이터스();
            if(유저명.전투중체력 <= 0 || 몬스터.체력 <= 0){
                this.interrupt();
                break;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public void 전투행동() {
        System.out.println("전투행동을 선택해주세요");
        System.out.println("====================");
        System.out.println("1.공격");
        System.out.println("2.아이템사용");
        System.out.println("3.도주하기");
        System.out.println("====================");
    }

    public void 전투방식() {
        System.out.println("어떻게 공격하시겠습니까");
        System.out.println("====================");
        System.out.println("1.공격");
        System.out.println("2.스킬사용");
        System.out.println("====================");
    }

//    public void 몬스터공격() { //몬스터 공격 메세지 출력 // 일반적인 공격할때 이거씀
//
//        int _랜덤공격 = 몬스터.몹공격받음(몬스터.방어력, 유저명.전투중공격력, 몬스터.회피율);
//        몬스터.체력 = 몬스터.체력 - _랜덤공격;
//        System.out.println(몬스터.이름 + "을(를) 공격하셨습니다 데미지를 "
//                + _랜덤공격 + "주었습니다");
//
//
//    }


    public void 전투종료() { //전투결과

//        this.interrupt();

        int 획득골드 = 몬스터.골드;
        System.out.println("==============================");
        System.out.println(몬스터.이름 + "을(를) 처치하였습니다");
        System.out.println("획득 경험치 " + 몬스터.경험치);
        System.out.println("획득 골드 " + 획득골드);
//        System.out.println("획득 아이템 " + 랜덤드랍.이름);
        몬스터.몬스터_드랍();
        System.out.println("==============================");

        유저명.경험치 = 유저명.경험치 + 몬스터.경험치;
        유저명.돈 = 유저명.돈 + 획득골드;
//        유저명.인벤토리.add(랜덤드랍);
        if (유저명.경험치 >= 유저명.레벨업경험치) { //레벨업
            유저명.경험치 = 0;
            유저명.레벨 = 유저명.레벨 + 1;
            유저명.레벨업경험치 = 유저명.레벨업경험치 * 2;
            유저명.공격력 = 유저명.공격력 + 1;
            유저명.방어력 = 유저명.방어력 + 1;
            유저명.마법력 = 유저명.마법력 + 1;
            유저명.최대체력 = 유저명.최대체력 + 1;
            유저명.최대마나 = 유저명.최대마나 + 1;
            유저명.전투중체력 = 유저명.최대체력;
            유저명.전투중마나 = 유저명.최대마나;
            유저명.체력 = 유저명.최대체력;
            유저명.마나 = 유저명.최대마나;
            System.out.println("============================");
            System.out.println("레벨업 하셨습니다");
            System.out.println("레벨이 " + 유저명.레벨 + "이 되었습니다");
            System.out.println("공격력이 " + 유저명.공격력 + "이 되었습니다");
            System.out.println("방어력이 " + 유저명.방어력 + "이 되었습니다");
            System.out.println("마법력이 " + 유저명.마법력 + "이 되었습니다");
            System.out.println("최대체력이 " + 유저명.최대체력 + "이 되었습니다");
            System.out.println("최대마나가 " + 유저명.최대마나 + "이 되었습니다");
            System.out.println("체력과 마나가 전부 회복되었습니다");
            System.out.println("============================");

        }
//        this.행동메뉴.행동문(this);

    }

    public void 스킬사용() { //스킬목록 출력후 사용 메소드

        System.out.println("1.공격계열");
        System.out.println("2.버프계열");
        System.out.println("3.회복계열");
        System.out.println("4.종족스킬");
        입력 = in.nextInt();
        if (입력 == 1) {
//            유저명._공격스킬목록.add(this.화염구);
            for (int i = 0; i < 유저명._공격스킬목록.size(); i++) {
                System.out.println(i + "." + 유저명._공격스킬목록.get(i).스킬이름);
            }
            System.out.println();
            System.out.println("사용할 스킬의 번호를 입력해주세요");
            입력 = in.nextInt(); //입력
            스킬 사용스킬 = 유저명._공격스킬목록.get(입력);
            사용스킬.스킬설명();
            System.out.println("아무숫자나 누르시면 사용됩니다");
            입력 = in.nextInt();
            사용스킬.스킬효과();
//                this.캐릭터공격(유저명, _몬스터, _아이템); //스킬사용즉시 적반격

        } else if (입력 == 2) {
            //버프스킬 어레이
            for (int i = 0; i < 유저명._버프스킬목록.size(); i++) {
                System.out.println(i + "." + 유저명._버프스킬목록.get(i).스킬이름);
            }
            System.out.println();
            System.out.println("사용할 스킬의 번호를 입력해주세요");
            입력 = in.nextInt(); //입력
            스킬 사용스킬 = 유저명._버프스킬목록.get(입력);
            사용스킬.스킬설명();
            System.out.println("아무숫자나 누르시면 사용됩니다");
            입력 = in.nextInt();
            사용스킬.스킬효과();
//                this.캐릭터공격(유저명, _몬스터, _아이템); //스킬사용즉시 적반격

        } else if (입력 == 3) {
            //회복스킬 어레이
            for (int i = 0; i < 유저명._회복스킬목록.size(); i++) {
                System.out.println(i + "." + 유저명._회복스킬목록.get(i).스킬이름);
            }
            System.out.println();
            System.out.println("사용할 스킬의 번호를 입력해주세요");
            입력 = in.nextInt(); //입력
            스킬 사용스킬 = 유저명._회복스킬목록.get(입력);
            사용스킬.스킬설명();
            System.out.println("아무숫자나 누르시면 사용됩니다");
            입력 = in.nextInt();
            사용스킬.스킬효과();
//                this.캐릭터공격(유저명, _몬스터, _아이템); //스킬사용즉시 적반격

        } else if (입력 == 4) {
            for (int i = 0; i < 유저명._종족스킬목록.size(); i++) {
                System.out.println(i + "." + 유저명._종족스킬목록.get(i).스킬이름);
            }
            System.out.println();
            System.out.println("사용할 스킬의 번호를 입력해주세요");
            입력 = in.nextInt(); //입력
            스킬 사용스킬 = 유저명._종족스킬목록.get(입력);
            사용스킬.스킬설명();
            System.out.println("아무숫자나 누르시면 사용됩니다");
            입력 = in.nextInt();
            사용스킬.스킬효과();
//                this.캐릭터공격(유저명, _몬스터, _아이템); //스킬사용즉시 적반격

        } else {
            System.out.println("잘못 입력하셨습니다");
        }

    }


    public void 퀵슬롯() {
        입구:
        while (true) {
            System.out.println("퀵슬롯");
            System.out.println("1.물약사용");
            System.out.println("0.나가기");
            입력 = in.nextInt();
            if (입력 == 1) {
                for (int i = 0; i < 유저명.전투인벤토리.size(); i++) {
                    System.out.println(i + "." + 유저명.전투인벤토리.get(i).이름);
                }
                System.out.println("사용할 아이템 번호를 입력해주세요");
                입력 = in.nextInt();
                아이템 사용아이템 = 유저명.전투인벤토리.get(입력);

                사용아이템.아이템_설명();
                System.out.println("아무숫자나 누르시면 사용됩니다");
                입력 = in.nextInt();

                사용아이템.아이템_효과();
                유저명.전투인벤토리.remove(사용아이템);
            } else if (입력 == 0) {
                break;
            } else {
                System.out.println("잘못 입력하셨습니다");
                continue 입구;
            }


//        if (사용아이템.타입 == 3) { //체력포션 사용
////            유저명.전투중체력 = 유저명.포션꿀꺽(사용아이템.체력회복, 유저명.최대체력, 유저명.전투중체력);
////            System.out.println(사용아이템.이름 + "을 사용하였습니다");
//            사용아이템.아이템_효과(유저명);
//            유저명.전투인벤토리.remove(사용아이템);
//        } else if (사용아이템.타입 == 4) { //마나포션 사용
////            유저명.전투중마나 = 유저명.포션꿀꺽(사용아이템.마나회복, 유저명.최대마나, 유저명.전투중마나);
////            System.out.println(사용아이템.이름 + "을 사용하였습니다");
////            사용아이템.아이템_효과(유저명);
//            유저명.전투인벤토리.remove(사용아이템);
//        }
        }

    }

    public void 도주() { //손봐야할듯 // 행동문으로 옮기는꼼수 이제 못씀
        System.out.println("도주를 시도합니다");
        int 도주확률 = random.nextInt(100);

        if (도주확률 <= 50 && this.도주카운터 == true && 몬스터.몬스터타입 == 0) { // 도주확률이 50안쪽이면 도망성공
            System.out.println("도주에 성공하셨습니다");
            return;


//            _전투종료.전투종료 = true;
        } else if (도주확률 > 50 && 도주카운터 == true && 몬스터.몬스터타입 == 0) { // 도주카운터가 51~100이뜨면 도주실패
            System.out.println("도주에 실패하셨습니다");
            도주카운터 = false;
//            _전투종료.전투종료 = false;
        } else if (this.도주카운터 == false) { // 도주시도는 단 한번만 가능
            System.out.println("이미 적에게 발각당하셨습니다");
            System.out.println("도망칠수 없습니다");
//            _전투종료.전투종료 = false;
        } else if (몬스터.몬스터타입 == 1) {
            System.out.println("보스에게선 도주할수 없습니다");
        }

    }

    public boolean 사망(boolean _전투종료) {
         // 메인으로 보내기위해서 만든 불린
        if (유저명.전투중체력 <= 0) { //캐릭터 죽음
            System.out.println("사망하셨습니다");
//            행동메뉴.행동문(유저명);
            System.exit(0);


        } else if (몬스터.체력 <= 0) {
            _전투종료 = true;
            this.전투종료();

//            행동메뉴.행동문(유저명);

        }
        return _전투종료;
    }
}
