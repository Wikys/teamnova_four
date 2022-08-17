package com.teamnova.메뉴;

import com.teamnova.몬스터.보스.고블린킹;
import com.teamnova.몬스터.보스.마왕;

import java.util.Scanner;

import static com.teamnova.메뉴.캐릭터생성.베드엔딩;
import static com.teamnova.몬스터.몬스터.유저명;
import static com.teamnova.몬스터.몬스터_인카운터.몬스터;


public class 보스전{
    boolean 전투종료;
    Scanner in = new Scanner(System.in);

    int 입력;
//    메인메뉴 메뉴 = new 메인메뉴();


    public void 보스메뉴( 전투메뉴 _전투메뉴){


        if (유저명.레벨 >= 0){

            System.out.println("도전할 몬스터를 선택해주세요");
            System.out.println("1.고블린킹");
            System.out.println();
            System.out.println("0.나가기");
            this.입력 = in.nextInt();

                if (입력 == 1){
                    몬스터 = new 고블린킹();
                    _전투메뉴.start();
                    몬스터.start();
                    입구:
                    while (true){

                        _전투메뉴.전투행동(); // 전투행동 선택 메세지 출력 (기능없음)

                    입력 = in.nextInt();
                    if(입력 == 1){
                        _전투메뉴.전투방식();
                        입력= in.nextInt();
                        if (입력 == 1){ // 일반공격
                            유저명.몬스터공격(); // 플레이어 -> 몬스터공격
                            전투종료 = _전투메뉴.사망();
                            if (전투종료 == true){
                                break ;
                            }
                        }
                        else if (입력 == 2){ //스킬사용
                            _전투메뉴.스킬사용();
                            전투종료 =_전투메뉴.사망();
                            if (전투종료 == true){
                                break ;
                            }

                        }

                    }
                    else if (입력 == 2) { //퀵슬롯
                        _전투메뉴.퀵슬롯();
                        전투종료 =_전투메뉴.사망();
                        if (전투종료 == true){
                            break ;
                        }
//
                    }
                    else if(입력 == 3){
                        int 도주 = _전투메뉴.도주();
                        if (도주 == 1) {
                            break ;
                        }
                    }
                }
            }
        }
        else if(유저명.레벨 >= 0 && 베드엔딩 == true ){
            System.out.println("1.???");
            this.입력 = in.nextInt();

            if (입력 == 1){
                몬스터 = new 마왕();
                _전투메뉴.start();
                몬스터.start();
                입구:
                while (true){

                    _전투메뉴.전투행동(); // 전투행동 선택 메세지 출력 (기능없음)

                    입력 = in.nextInt();
                    if(입력 == 1){
                        _전투메뉴.전투방식();
                        입력= in.nextInt();
                        if (입력 == 1){ // 일반공격
                            유저명.몬스터공격(); // 플레이어 -> 몬스터공격
                            전투종료 = _전투메뉴.사망();
                            if (전투종료 == true){
                                break ;
                            }
                        }
                        else if (입력 == 2){ //스킬사용
                            _전투메뉴.스킬사용();
                            전투종료 =_전투메뉴.사망();
                            if (전투종료 == true){
                                break ;
                            }

                        }

                    }
                    else if (입력 == 2) { //퀵슬롯
                        _전투메뉴.퀵슬롯();
                        전투종료 =_전투메뉴.사망();
                        if (전투종료 == true){
                            break ;
                        }
                    }
                    else if(입력 == 3){
                        int 도주 = _전투메뉴.도주();
                        if (도주 == 1) {
                            break ;
                        }
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
