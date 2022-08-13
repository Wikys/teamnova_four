package com.teamnova.메뉴;

import com.teamnova.몬스터.고블린;
import com.teamnova.몬스터.몬스터_인카운터;
import com.teamnova.상점.상점;
import com.teamnova.스킬.스킬;
import com.teamnova.스킬.스킬샵.스킬샵;
import com.teamnova.장비창.장비창;
import com.teamnova.전직.전사;
import com.teamnova.전직.전직;
import com.teamnova.플레이어.캐릭터;

import java.util.ArrayList;

import static com.teamnova.몬스터.몬스터.유저명;
import static com.teamnova.몬스터.몬스터_인카운터.몬스터;

public class 행동문 extends 캐릭터생성{
//    public static 캐릭터 유저명 = new 캐릭터();
    public boolean 전투종료;
    public static boolean 밤;

    메인메뉴 메뉴;
    boolean 고블린킹;
    전직 전직;
//    _전투메뉴 _전투메뉴 = new _전투메뉴();
    몬스터_인카운터 인카운터;
    상점 상점;
    스킬샵 스킬샵 ;
    장비창 장비창;
    ArrayList<스킬> _판매스킬목록;

    보스전 보스전;
    시간 타이머 = new 시간();

    public 행동문(){
//        타이머.start();
        메뉴 = new 메인메뉴();
        고블린킹 = true;
        전직 = new 전직();

        인카운터 = new 몬스터_인카운터();
        상점 = new 상점();
        스킬샵 = new 스킬샵();
        장비창 = new 장비창();
//        _판매스킬목록 = new ArrayList<>();
//        육광연참 = new 육광연참();
//        영혼흡수 = new 영혼흡수();
//        헬파이어 = new 헬파이어();
        보스전 = new 보스전();
//        _전투메뉴 = new _전투메뉴();
    }

    public void test() {

    }


    public void 행동문(전투메뉴 _전투메뉴) {
        타이머.start();
//        전투메뉴 스테이터스 = new 전투메뉴();

//        _판매스킬목록.add(육광연참);
//        _판매스킬목록.add(영혼흡수);
//        _판매스킬목록.add(헬파이어);

        행동문:
        while (true) {

            전투종료 = false;

            고블린킹 = 유저명.보스_컨텐츠해금(유저명.레벨, 고블린킹); // 5레벨 컨텐츠 // 나중에 수정
            전직.전직여부();
            메뉴.유저상태_초기화(스킬샵); //버프나 기타등등으로 올라간 능력치 초기화,제한스킬 초기화
            메뉴.행동메뉴(); // 행동메뉴 호출 메서드
            선택 = in.nextInt();
            if (선택 == 1) {
                전투메뉴 스테이터스 = new 전투메뉴();
               몬스터 = new 고블린();

                몬스터 = 인카운터.몬스터_인카운터(); // 랜덤몬스터 정보 생성 메서드

                스테이터스.start();
                몬스터.start(); // 몬스터들 메소드에서 중단요청

                전투:
                while (true) {
//                    System.out.println("확인용");
//                    if (몬스터.isInterrupted() == true){
//                        _전투메뉴.사망();
//                        if(true){
////                            System.out.println("스테이터스: "+_전투메뉴.getState());
////                            System.out.println("몬스터: "+몬스터.getState());
//                            continue 행동문;
//
//                        }
//                    }
                        _전투메뉴.전투행동(); // 전투행동 선택 메세지 출력 (기능없음)
                        선택 = in.nextInt();

                    if (선택 == 1 ) { //1.공격 선택시

                        _전투메뉴.전투방식(); // 전투방식 선택 메세지 출력 (기능없음)
                        선택 = in.nextInt();

                        if (선택 == 1 ) { //일반적인 공격 선택시

                            유저명.몬스터공격(); // 플레이어 -> 몬스터공격
                            전투종료 = _전투메뉴.사망();
                            if (전투종료 == true){
                                break ;
                            }



                        } else if (선택 == 2 ) { //스킬사용 선택시

                            _전투메뉴.스킬사용();
                            전투종료 =_전투메뉴.사망();
                            if (전투종료 == true){
                                break ;
                            }


//                            몬스터.캐릭터공격();
//                            _전투메뉴.사망(전투종료);

                        }
                    } else if (선택 == 2 ) { //퀵슬롯

                        _전투메뉴.퀵슬롯();
                        전투종료 =_전투메뉴.사망();
                        if (전투종료 == true){
                            break ;
                        }

//                        몬스터.캐릭터공격();
//                        _전투메뉴.사망(전투종료);
//
                    } else if (선택 == 3) { // 도주선택시

                        int 도주 = _전투메뉴.도주();
                        if (도주 == 1) {
                            break ;
                        }

                    }
                }
            }
            else if (선택 == 2) { // 치료(체,마 전부회복) 메뉴
                메뉴.치료();

            } else if (선택 == 3) { //상점 메소드 //아이템구매 // 나중에 필요에따라 아이템판매도 만들기
                상점.판매목록();

                if (선택 == 0) {
                    continue;
                }
            } else if (선택 == 4) { //소지품창
                메뉴.소지품창();
            } else if (선택 == 5) {
                메뉴.스테이터스(); //이름 레벨 체력 마나 공격력 방어력 경험치등

            } else if (선택 == 6) { // 장비착용 메서드 중복착용여부등 체크기능 있음
                장비창.장비창(메뉴);
                if (선택 == 0) {
                    continue 행동문;
                }

            } else if (선택 == 7) {//보유스킬 목록 // 보유스킬 효과등 포함
                //여기다 스킬목록 메서드
                메뉴.스킬인벤(유저명._공격스킬목록,유저명._버프스킬목록,유저명._회복스킬목록,유저명._종족스킬목록);
                if (선택 == 0) {
                    continue 행동문;
                }
            }else if(선택 == 8){
                //전직
                전직.전직메뉴();
            }else if (선택 == 9){
                //스킬샵
                스킬샵.스킬구매목록(유저명._버프스킬목록,유저명._회복스킬목록,유저명._공격스킬목록);

            }
            else if (선택 == 10){
                보스전.보스메뉴(_전투메뉴,this);
            }
            else if (선택 == 0) {
                System.exit(0);
            }
        }
    }

}
