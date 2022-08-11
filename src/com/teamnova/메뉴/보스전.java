package com.teamnova.메뉴;

import com.teamnova.몬스터.보스.고블린킹;

import java.util.Scanner;

import static com.teamnova.몬스터.몬스터.유저명;
import static com.teamnova.몬스터.몬스터_인카운터.몬스터;


public class 보스전 {
    Scanner in = new Scanner(System.in);

    int 입력;
    메인메뉴 메뉴 = new 메인메뉴();


    public void 보스메뉴( 전투메뉴 _전투메뉴,행동문 _행동문){


        if (유저명.레벨 >= 5){

            System.out.println("도전할 몬스터를 선택해주세요");
            System.out.println("1.고블린킹");
            System.out.println();
            System.out.println("0.나가기");
            this.입력 = in.nextInt();

                if (입력 == 1){
                    몬스터 = new 고블린킹();
                    입구:
                    while (true){

                    _전투메뉴.캐릭터_전투_스테이터스(); // 유저 상태창
                    _전투메뉴.몬스터_전투_스테이터스();
                    _전투메뉴.전투행동(); // 전투행동 선택 메세지 출력 (기능없음)
                    입력 = in.nextInt();
                    if(입력 == 1){
                        _전투메뉴.전투방식();
                        입력= in.nextInt();
                        if (입력 == 1){
                            _전투메뉴.몬스터공격(); // 플레이어 -> 몬스터공격
                            // 적이 죽고나서도 반격하는거 방지
                            몬스터.캐릭터공격();
//                            _전투메뉴.사망(); 일단 보류쓰
                        }
                        else if (입력 == 2){
                            _전투메뉴.스킬사용();
                            몬스터.캐릭터공격();
//                            _전투메뉴.사망(); 일단 보류쓰

                        }

                    }
                    else if (입력 == 2) { //퀵슬롯
                        _전투메뉴.퀵슬롯();
                        몬스터.캐릭터공격();
//                        _전투메뉴.사망();  일단 보류쓰
//
                    }
                    else if(입력 == 3){
                        _전투메뉴.도주(_행동문);
                    }
                }

            }

        }
        else{
            System.out.println("잘못된 접근입니다");
        }

    }


    //캐릭터레벨이 5이상일때만 선택가능하게끔 이프문처리
    //5미만이면 10눌럿을때 아무반응없게만들기
}
