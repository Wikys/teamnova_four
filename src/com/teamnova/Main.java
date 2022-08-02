package com.teamnova;

import com.teamnova.메뉴.메인메뉴;
import com.teamnova.메뉴.전투메뉴;
import com.teamnova.몬스터.몬스터;
import com.teamnova.상점.상점;
import com.teamnova.스킬.스킬;
import com.teamnova.아이템.아이템;
import com.teamnova.플레이어.캐릭터;
import com.teamnova.장비창.장비창;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner in = new Scanner(System.in);
        int 선택; //정수형 스캐너
        String 사용; //문자열 스캐너
        String 이름; //캐릭터이름 입력
    //    캐릭터 유저명 = new 캐릭터(null, 1, 5, 0, 5, 10, 10, 10, 10, 100, 0, 5, 0,null);
        몬스터 몬스터정보 = new 몬스터();
        몬스터 생성된몬스터 = new 몬스터();
        스킬 스킬사용 = new 스킬(); // 스킬사용 호출
        boolean 고블린킹 = true;
        메인메뉴 메뉴 = new 메인메뉴();
        전투메뉴 전투메뉴 = new 전투메뉴();
        상점 상점 = new 상점();
        아이템 아이템 = new 아이템();
        장비창 장비창 = new 장비창();
        몬스터 몬스터 = new 몬스터();
        String 내캐릭터;
        Random 랜덤 = new Random(); // 몬스터 생성자


        System.out.println("RPG만들기 연습"); //타이틀
        System.out.println("1.시작하기\n0.끝내기"); //시작
        선택 = in.nextInt();
        if (선택 == 1) {
            System.out.println("\"캐릭터 작성을 시작합니다\n" +
                    "이름을 입력 해주세요\""); // "(인풋값으로 이름받음")
            이름 = in.next(); //여기서 이름입력받고 아래로 넘김
            유저명.캐릭터이름(이름); // 캐릭터이름 결정 메서드
            System.out.println("종족을 선택해주세요");

            유저명.기본아이템(아이템.인벤토리);
            유저명.기본스킬(스킬사용._스킬목록); //기본아이템,스킬 지급 메서드
            System.out.println("계속하려면 아무숫자나 입력해주세요");
            선택 = in.nextInt();

        } else {
            return;
        }

        System.out.println("당신은 모험을 시작합니다");
        행동문:
        while (true) {
            고블린킹 = 유저명.보스_컨텐츠해금(유저명.레벨, 고블린킹); // 5레벨 컨텐츠 // 나중에 수정
            메뉴.유저상태_초기화(유저명, 스킬사용); //버프나 기타등등으로 올라간 능력치 초기화
            메뉴.행동메뉴(); // 행동메뉴 호출 메서드
            선택 = in.nextInt();

            if (선택 == 1) {
                전투메뉴.몬스터_인카운터(몬스터, 유저명); // 랜덤몬스터 정보 생성 메서드

                while (true) {
                    전투메뉴.캐릭터_전투_스테이터스(유저명); // 유저 상태창
                    전투메뉴.몬스터_전투_스테이터스(몬스터); // 몬스터 상태창
                    전투메뉴.전투행동(); // 전투행동 선택 메세지 출력 (기능없음)
                    선택 = in.nextInt();

                    if (선택 == 1) { //1.공격 선택시
                        전투메뉴.전투방식(); // 전투방식 선택 메세지 출력 (기능없음)
                        선택 = in.nextInt();

                        if (선택 == 1) { //일반적인 공격 선택시
                            전투메뉴.몬스터공격(유저명, 몬스터); // 플레이어 -> 몬스터공격
                            // 적이 죽고나서도 반격하는거 방지
                            전투메뉴.캐릭터공격(유저명, 몬스터, 아이템);

                            if (유저명.전투중체력 <= 0) { //캐릭터 죽음
                                System.out.println("사망하셨습니다");
                                return; // 사망했으니 종료
                            } else if (몬스터.체력 <= 0) { // 몹죽음
                                continue 행동문; // 초기반복문으로 되돌아가기
                            }
                        } else if (선택 == 2) { //스킬사용 선택시
                            전투메뉴.스킬사용(스킬사용, 유저명);
                            전투메뉴.캐릭터공격(유저명, 몬스터, 아이템);
                            continue;
                        } else if (선택 == 3) {
                            //종족스킬
                            //끝나고 몹반격
                            //if 종족번호 0일때 인간클래스~ 이런식으로 하기
                            if (선택 == 2){

                            }
                        }
                    } else if (선택 == 2) { //퀵슬롯
                        전투메뉴.퀵슬롯(아이템, 유저명);
                        전투메뉴.캐릭터공격(유저명, 몬스터, 아이템);
//
                    } else if (선택 == 3) { // 도주선택시
                        전투메뉴.도주(메뉴);
                        if (메뉴.전투종료 == true) {
                            continue 행동문;
                        }
                    }
                }
            } else if (선택 == 2) { // 휴식(체,마 전부회복) 메뉴
                메뉴.휴식(유저명);
                System.out.println(유저명.체력 + " " + 유저명.마나);


            } else if (선택 == 3) { //상점 메소드 //아이템구매 // 나중에 필요에따라 아이템판매도 만들기
                상점.판매목록(유저명, 아이템);

                if (선택 == 0) {
                    continue;
                }
            } else if (선택 == 4) { //소지품창
                메뉴.소지품창(유저명, 아이템);
            } else if (선택 == 5) {
                메뉴.스테이터스(유저명); //이름 레벨 체력 마나 공격력 방어력 경험치등
                System.out.println("돌아가시려면 아무숫자나 입력하세요");
                선택 = in.nextInt();
            } else if (선택 == 6) { // 장비착용 메서드 중복착용여부등 체크기능 있음
                장비창.장비창(유저명, 아이템, 메뉴);
                if (선택 == 0) {
                    continue 행동문;
                }

            } else if (선택 == 7) {//보유스킬 목록 // 보유스킬 효과등 포함
                //여기다 스킬목록 메서드
                스킬사용.스킬인벤(유저명);
                if (선택 == 0) {
                    continue 행동문;
                }
            } else if (선택 == 0) {
                return;
            }
        }
    }
}

