package com.teamnova;

import com.teamnova.메뉴.메인메뉴;
import com.teamnova.메뉴.전투메뉴;
import com.teamnova.몬스터.몬스터;
import com.teamnova.상점.상점;
import com.teamnova.스킬.공격계열.무기파괴;
import com.teamnova.스킬.공격계열.사광연참;
import com.teamnova.스킬.공격계열.화염구;
import com.teamnova.스킬.스킬;
import com.teamnova.스킬.종족스킬.강조;
import com.teamnova.스킬.종족스킬.부정한기운;
import com.teamnova.스킬.종족스킬.사자의심장;
import com.teamnova.아이템.아이템;
import com.teamnova.장비창.장비창;
import com.teamnova.플레이어.비스트맨;
import com.teamnova.플레이어.스켈레톤;
import com.teamnova.플레이어.인간;
import com.teamnova.플레이어.캐릭터;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner in = new Scanner(System.in);
        int 선택; //정수형 스캐너
        String 사용; //문자열 스캐너
        String 이름; //캐릭터이름 입력
        //    캐릭터 유저명 = new 캐릭터(null, 1, 5, 0, 5, 10, 10, 10, 10, 100, 0, 5, 0,null);
//        몬스터 몬스터정보 = new 몬스터();
//        몬스터 생성된몬스터 = new 몬스터();
//        스킬 스킬사용 = new 스킬(); // 스킬사용호출
//       스킬 스킬 = new 화염구("화염구",5,5,"안녕");
//        스킬 비스트맨 = new 강조();
//        스킬 스켈레톤 = new 부정한기운();
//        스킬 인간 = new 사자의심장();
        스킬 강조 = new 강조("강조");
        스킬 부정한기운 = new 부정한기운("부정한기운");
        스킬 사자의심장 = new 사자의심장("사자의심장");
        스킬 무기파괴 = new 무기파괴("무기파괴");
        스킬 사광연참 = new 사광연참("사광연참");
        스킬 화염구 = new 화염구("화염구");

        boolean 고블린킹 = true;
        메인메뉴 메뉴 = new 메인메뉴();
        전투메뉴 전투메뉴 = new 전투메뉴();
        상점 상점 = new 상점();
        아이템 아이템 = new 아이템();
        장비창 장비창 = new 장비창();
        몬스터 몬스터 = new 몬스터();
        ArrayList<스킬> _버프스킬목록 = new ArrayList<>();
        ArrayList<스킬> _회복스킬목록 = new ArrayList<>();
        ArrayList<스킬> _공격스킬목록 = new ArrayList<>();
        ArrayList<스킬> _종족스킬목록 = new ArrayList<>();
        _공격스킬목록.add(무기파괴);
        _공격스킬목록.add(화염구);
        _공격스킬목록.add(사광연참); //실험용


        String 내캐릭터;
        Random 랜덤 = new Random(); // 몬스터 생성자
        캐릭터 유저명;

        캐릭터작성:
        while (true) {

            System.out.println("1.시작하기");
            System.out.println("0.끝내기");
            선택 = in.nextInt();
            if (선택 == 1) {
                System.out.println("캐릭터 생성을 시작합니다");
                System.out.println("====================");
                System.out.println("종종분류를 선택해주세요");
                System.out.println("1.인간종 2.아인종 3.언데드");
                System.out.println("====================");
                선택 = in.nextInt();

                if (선택 == 1) {
                    System.out.println("종족을 선택해주세요");
                    System.out.println("1.인간");
                    System.out.println();
                    System.out.println("0.뒤로가기");
                    선택 = in.nextInt();
                    if (선택 == 1) {
                        유저명 = new 인간(null, 1, 5, 0, 5, 10, 10, 10, 10, 0, 0, 10, 10, 0, 0, "인간", true);
                        System.out.println("인간을 선택하셨습니다");
                        _종족스킬목록.add(사자의심장);

                        break;
                    } else if (선택 == 0) {
                        continue 캐릭터작성;
                    }
                } else if (선택 == 2) {
                    System.out.println("종족을 선택해주세요");
                    System.out.println("1.비스트맨");
                    System.out.println();
                    System.out.println("0.뒤로가기");
                    선택 = in.nextInt();
                    if (선택 == 1) {
                        유저명 = new 비스트맨(null, 1, 5, 0, 10, 10, 10, 5, 5, 0, 0, 10, 3, 1, 1, "비스트맨", true);
                        System.out.println("비스트맨을 선택하셨습니다");
                        _종족스킬목록.add(강조);

                        break;
                    } else if (선택 == 0) {
                        continue 캐릭터작성;
                    }
                } else if (선택 == 3) {
                    System.out.println("종족을 선택해주세요");
                    System.out.println("1.스켈레톤");
                    System.out.println();
                    System.out.println("0.뒤로가기");
                    선택 = in.nextInt();
                    if (선택 == 1) {
                        유저명 = new 스켈레톤(null, 1, 3, 0, 3, 15, 15, 20, 20, 0, 0, 10, 10, 2, 2, "스켈레톤", true);
                        System.out.println("스켈레톤을 선택하셨습니다");
                        _종족스킬목록.add(부정한기운);
                        break;
                    } else if (선택 == 0) {
                        continue 캐릭터작성;
                    }
                }
            } else {
                return;
            }
        }
        System.out.println("캐릭터의 이름을 입력해주세요");
        이름 = in.next();
        유저명.이름 = 이름;
        System.out.println("이름이 " + 유저명.이름 + " 으로 결정되었습니다");
        유저명.기본아이템(아이템.인벤토리);
        System.out.println("당신은 모험을 시작합니다");


        행동문:
        while (true) {
            고블린킹 = 유저명.보스_컨텐츠해금(유저명.레벨, 고블린킹); // 5레벨 컨텐츠 // 나중에 수정
            메뉴.유저상태_초기화(유저명); //버프나 기타등등으로 올라간 능력치 초기화
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
                            전투메뉴.스킬사용(유저명,몬스터,아이템,_공격스킬목록,_버프스킬목록,_회복스킬목록,_종족스킬목록);

                            전투메뉴.캐릭터공격(유저명, 몬스터, 아이템);
                            if (유저명.전투중체력 <= 0) { //캐릭터 죽음
                                System.out.println("사망하셨습니다");
                                return; // 사망했으니 종료
                            } else if (몬스터.체력 <= 0) { // 몹죽음
                                continue 행동문; // 초기반복문으로 되돌아가기
                            }

//                            continue;
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
                메뉴.스킬인벤(_공격스킬목록,_버프스킬목록,_회복스킬목록,_종족스킬목록);
                if (선택 == 0) {
                    continue 행동문;
                }
            } else if (선택 == 0) {
                return;
            }
        }
    }
}

