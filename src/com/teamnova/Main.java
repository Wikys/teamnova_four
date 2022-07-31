package com.teamnova;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner in = new Scanner(System.in);
        int 선택; //정수형 스캐너
        String 사용; //문자열 스캐너
        String 이름; //캐릭터이름 입력
        캐릭터 유저명 = new 캐릭터(null, 1, 5, 0, 5, 10, 10, 10, 10, 100, 0, 5);
        몬스터 몬스터정보 = new 몬스터();
        몬스터 생성된몬스터 = new 몬스터();
        스킬 스킬사용 = new 스킬(); // 스킬사용 호출
        boolean 고블린킹 = true;
        메인메뉴 메뉴 = new 메인메뉴();
        전투메뉴 전투메뉴 = new 전투메뉴();
        상점 상점 = new 상점();
        아이템 아이템 = new 아이템();
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
            메뉴.유저상태_초기화(유저명,스킬사용); //버프나 기타등등으로 올라간 능력치 초기화
            메뉴.행동메뉴(); // 행동메뉴 호출 메서드
            선택 = in.nextInt();

            if (선택 == 1) {

                int 인카운터 = random.nextInt(5); //몬스터 랜덤생성


                몬스터 생성 = new 몬스터();
                String 몬스터생성 = 생성.몬스터(인카운터, 유저명.레벨);
                System.out.println("탐색중 " + 몬스터생성 + "을(를) 마주쳤습니다!");
                System.out.println("전투를 시작합니다");
                boolean 도주카운터 = true;

                boolean 용기사용횟수 = true; // 용기스킬사용횟수

                if (몬스터생성 == "고블린") {
                    생성.고블린();
                } else if (몬스터생성 == "오크") {
                    생성.오크();
                } else if (몬스터생성 == "오우거") {
                    생성.오우거();
                } else if (고블린킹 == true && 몬스터생성 == "고블린킹") {
                    System.out.println("아직은 보스를 마주할 시기가 아닙니다 도망칩니다");
                    continue 행동문;
                } else if (고블린킹 == false && 몬스터생성 == "고블린킹") { // 5랩보스
                    생성.고블린킹();
                } else if (몬스터생성 == "보물") { // 임시 치트?
                    생성.보물();
                }


                while (true) {
                    전투메뉴.캐릭터_전투_스테이터스(유저명); // 유저 상태창
                    전투메뉴.몬스터_전투_스테이터스(생성); // 몬스터 상태창
                    전투메뉴.전투행동(); // 전투행동 선택 메세지 출력 (기능없음)
                    선택 = in.nextInt();

                    if (선택 == 1) { //1.공격 선택시
                        전투메뉴.전투방식(); // 전투방식 선택 메세지 출력 (기능없음)
                        선택 = in.nextInt();

                        if (선택 == 1) { //일반적인 공격 선택시
                            전투메뉴.몬스터공격(유저명, 생성); // 플레이어 -> 몬스터공격
                             // 적이 죽고나서도 반격하는거 방지
                                전투메뉴.캐릭터공격(유저명, 생성, 아이템);

                            if (유저명.전투중체력 <= 0) { //캐릭터 죽음
                                System.out.println("사망하셨습니다");
                                return; // 사망했으니 종료
                            } else if (생성.체력 <= 0) { // 몹죽음
                                continue 행동문; // 초기반복문으로 되돌아가기
                            }


                        } else if (선택 == 2) { //스킬사용 선택시
                            전투메뉴.스킬사용(스킬사용,유저명);
                            전투메뉴.캐릭터공격(유저명,생성, 아이템);
                            continue;
                        }
                    } else if (선택 == 2) { //퀵슬롯
                        전투메뉴.퀵슬롯(아이템,유저명);
                        전투메뉴.캐릭터공격(유저명,생성, 아이템);
//
                    } else if (선택 == 3) { // 도주선택시
                        전투메뉴.도주(메뉴);
                        if (메뉴.전투종료 == true){
                            continue 행동문;
                        }
                    }
                }
            } else if (선택 == 2) { // 휴식(체,마 전부회복) 메뉴
                메뉴.휴식(유저명);
                System.out.println(유저명.체력+" "+유저명.마나);


            } else if (선택 == 3) { //구매완료 판매완료등 설정
                상점.판매목록(유저명); //이건 집가서하기
                // 내 소지금 추가및 돈부족시에 경고띄우기
                // 구매완료되면 인벤토리와 전투인벤토리에 생성
                선택 = in.nextInt();
                아이템.인벤토리.addAll(상점.아이템반환(선택, 유저명));
                유저명.돈 = 유저명.돈 - 상점.구매(선택, 유저명);


                if (선택 == 0) {
                    continue;
                }
            } else if (선택 == 4) { //소지품창
                메뉴.소지품창(아이템);


//                for (int i = 0; i < 아이템.인벤토리.size(); i++) {
//                    System.out.println("아이템 이름: " + i + ". " + 아이템.인벤토리.get(i).이름);
//                }
//                System.out.println("1.아이템장착"); //배열 삭제하면서 플레이어에게 효과적용
//                System.out.println("2.아이템버리기"); //배열삭제로 구현?
//                System.out.println("3.퀵슬롯장착"); // 전투인벤토리로 보내기
//                System.out.println("0. 메인으로 가기");
//                System.out.println("포션은 마을에서 사용하실수 없습니다");
//
//                선택 = in.nextInt();
////                if (선택 == 1) {
//                    메뉴.소지품창(아이템);
//
//                    System.out.println("장착하실 아이템 이름을 입력해주세요");
//                    사용 = in.next();
//
//                    for (int i = 0; i < 아이템.인벤토리.size(); i++) {
//
//                        if (아이템.인벤토리.get(i).이름.equals("낡은검") && 아이템.인벤토리.get(i).이름.equals(사용) && 아이템.무기중복 == false) {
//                            System.out.println("공격력이 " + 유저명.낡은검.공격력 + " 증가했습니다");
//
//                            유저명.공격력 = 유저명.공격력 + 유저명.낡은검.공격력;
//                            아이템.무기중복 = true;
//                            아이템.장비창.add(아이템.인벤토리.get(i));
//                            아이템.인벤토리.remove(아이템.인벤토리.get(i));
//
//
//                            continue;
//
//
//                        } else if (아이템.인벤토리.get(i).이름.equals("철검") && 아이템.인벤토리.get(i).이름.equals(사용) && 아이템.무기중복 == false) { //계속 장착되는거 막아야함
//                            System.out.println("공격력이 " + 유저명.철검.공격력 + " 증가했습니다");
//
//                            유저명.공격력 = 유저명.공격력 + 유저명.철검.공격력;
//                            아이템.무기중복 = true;
//                            아이템.장비창.add(아이템.인벤토리.get(i));
//                            아이템.인벤토리.remove(아이템.인벤토리.get(i));
//
//
//                            continue;
//                        } else if (아이템.인벤토리.get(i).이름.equals("고블린왕의_몽둥이") && 아이템.인벤토리.get(i).이름.equals(사용) && 아이템.무기중복 == false) { //계속 장착되는거 막아야함
//                            System.out.println("공격력이 " + 유저명.고블린왕의_몽둥이.공격력 + " 증가했습니다");
//
//                            유저명.공격력 = 유저명.공격력 + 유저명.고블린왕의_몽둥이.공격력;
//                            아이템.무기중복 = true;
//                            아이템.장비창.add(아이템.인벤토리.get(i));
//                            아이템.인벤토리.remove(아이템.인벤토리.get(i));
//
//
//                            continue;
//                        } else if (아이템.인벤토리.get(i).이름.equals("가죽갑옷") && 아이템.인벤토리.get(i).이름.equals(사용) && 아이템.방어구중복 == false) { //계속 장착되는거 막아야함
//                            System.out.println("방어력이 " + 유저명.가죽갑옷.방어력 + " 증가했습니다");
//
//                            유저명.방어력 = 유저명.방어력 + 유저명.가죽갑옷.방어력;
//                            아이템.방어구중복 = true;
//                            아이템.장비창.add(아이템.인벤토리.get(i));
//                            아이템.인벤토리.remove(아이템.인벤토리.get(i));
//
//
//                            continue;
//                        } else if (아이템.인벤토리.get(i).이름.equals("철갑옷") && 아이템.인벤토리.get(i).이름.equals(사용) && 아이템.방어구중복 == false) { //계속 장착는거 막아야함
//                            System.out.println("방어력이 " + 유저명.철갑옷.방어력 + " 증가했습니다");
//
//                            유저명.방어력 = 유저명.방어력 + 유저명.철갑옷.방어력;
////                            아이템.인벤토리.get(i).중복장착 = true;
//                            아이템.방어구중복 = true;
//                            아이템.장비창.add(아이템.인벤토리.get(i));
//                            아이템.인벤토리.remove(아이템.인벤토리.get(i));
//
//                            continue;
//                        } else {
//                        }
//                    }
//                }
//                else if (선택 == 2) {
//
//                    System.out.println("버릴 아이템 이름 입력해주세요");
//
//                    사용 = in.next();
//
//                    for (int i = 0; i < 아이템.인벤토리.size(); i++) {
//                        if (아이템.인벤토리.get(i).이름.equals(사용)) {
//                            아이템.인벤토리.remove(아이템.인벤토리.get(i));
//                            System.out.println(아이템.인벤토리.get(i).이름 + "을 버렸습니다");
//                            continue 행동문;
//
//                        }
//
//
//                    }
//                }
//                else if (선택 == 3) {
//
//                    System.out.println("퀵슬롯에 장착할 '포션'이름을 써주세요");
//                    사용 = in.next();

//                    for (int i = 0; i < 아이템.인벤토리.size(); i++) {
//
//                        if (사용.equals(아이템.인벤토리.get(i).이름) && 아이템.인벤토리.get(i).타입 == 3) { // 체력포션
//                            if (아이템.인벤토리.get(i).체력회복 == 5) { // 나중에 상위포션 추가?
//
//                                System.out.println(아이템.인벤토리.get(i).이름 + "을 퀵슬롯에 옮겼습니다");
//                                아이템.전투인벤토리.add(아이템.인벤토리.get(i));
//                                아이템.인벤토리.remove(아이템.인벤토리.get(i));
//                                break;
//
//                            }
//
//                        } else if (사용.equals(아이템.인벤토리.get(i).이름) && 아이템.인벤토리.get(i).타입 == 4) {//마나포션
//
//                            if (아이템.인벤토리.get(i).마나회복 == 5) {
//
//                                System.out.println(아이템.인벤토리.get(i).이름 + "을 퀵슬롯에 옮겼습니다");
//                                아이템.전투인벤토리.add(아이템.인벤토리.get(i));
//                                아이템.인벤토리.remove(아이템.인벤토리.get(i));
//                                break;
//
//                            }
//                        } else if (사용.equals(아이템.인벤토리.get(i).이름) && 아이템.인벤토리.get(i).타입 != 3
//                                && 아이템.인벤토리.get(i).타입 != 4) {
//                            System.out.println("아이템이 없거나 포션이 아닙니다");
//                        }
//                    }
//                }
                //       사용 = in.next();

            }
            else if (선택 == 5) {
                메뉴.스테이터스(유저명); //이름 종족 레벨 체력 마나 공격력 방어력 경험치
                System.out.println("돌아가시려면 아무키나 입력하세요");
                선택 = in.nextInt();
            } else if (선택 == 6) {
                for (int i = 0; i < 아이템.장비창.size(); i++) {
                    System.out.println("아이템 이름: " + i + ". " + 아이템.장비창.get(i).이름);
                }
                System.out.println("1. 장착해제");
                System.out.println("0. 돌아가기");
                선택 = in.nextInt();
                for (int i = 0; i < 아이템.장비창.size(); i++) {
                    if (선택 == 1) {
                        System.out.println("벗고싶은 아이템 이름을 입력하세요");
                        사용 = in.next();
//
                        if (아이템.장비창.get(i).이름.equals("낡은검") && 아이템.장비창.get(i).이름.equals(사용) && 아이템.무기중복 == true) {
                            System.out.println("공격력이 " + 유저명.낡은검.공격력 + " 감소했습니다");

                            유저명.공격력 = 유저명.공격력 - 유저명.낡은검.공격력;
                            아이템.무기중복 = false;
                            아이템.인벤토리.add(아이템.장비창.get(i));
                            아이템.장비창.remove(아이템.장비창.get(i));


                            break;

                        } else if (아이템.장비창.get(i).이름.equals("철검") && 아이템.장비창.get(i).이름.equals(사용) && 아이템.무기중복 == true) {
                            System.out.println("공격력이 " + 유저명.철검.공격력 + " 감소했습니다");

                            유저명.공격력 = 유저명.공격력 - 유저명.철검.공격력;
                            아이템.무기중복 = false;
                            아이템.인벤토리.add(아이템.장비창.get(i));
                            아이템.장비창.remove(아이템.장비창.get(i));


                            break;

                        }
                        if (아이템.장비창.get(i).이름.equals("고블린왕의_몽둥이") && 아이템.장비창.get(i).이름.equals(사용) && 아이템.무기중복 == true) {
                            System.out.println("공격력이 " + 유저명.고블린왕의_몽둥이.공격력 + " 감소했습니다");

                            유저명.공격력 = 유저명.공격력 - 유저명.고블린왕의_몽둥이.공격력;
                            아이템.무기중복 = false;
                            아이템.인벤토리.add(아이템.장비창.get(i));
                            아이템.장비창.remove(아이템.장비창.get(i));


                            break;

                        } else if (아이템.장비창.get(i).이름.equals("가죽갑옷") && 아이템.장비창.get(i).이름.equals(사용) && 아이템.방어구중복 == true) {
                            System.out.println("방어력이 " + 유저명.가죽갑옷.방어력 + " 감소했습니다");

                            유저명.방어력 = 유저명.방어력 - 유저명.가죽갑옷.방어력;
                            아이템.방어구중복 = false;
                            아이템.인벤토리.add(아이템.장비창.get(i));
                            아이템.장비창.remove(아이템.장비창.get(i));


                            break;

                        } else if (아이템.장비창.get(i).이름.equals("철갑옷") && 아이템.장비창.get(i).이름.equals(사용) && 아이템.방어구중복 == true) {
                            System.out.println("방어력이 " + 유저명.철갑옷.방어력 + " 감소했습니다");

                            유저명.방어력 = 유저명.방어력 - 유저명.철갑옷.방어력;
                            아이템.방어구중복 = false;
                            아이템.인벤토리.add(아이템.장비창.get(i));
                            아이템.장비창.remove(아이템.장비창.get(i));


                            break;

                        }
                    } else if (선택 == 0) {
                        continue 행동문;

                    } else {
                        System.out.println("아이템이 없거나 중복장착 시도입니다!");
                    }
                }


                //장비 장착하면 인벤에서 삭제되고 여기로 생성.. 여기서 해제하면 공,방 빠지고 인벤토리로 생성
                //같은부위 아이템 여러개 장착못하도록 수정.. (아이템타입으로 구분)


            } else if (선택 == 7) {
                System.out.println("보유스킬");

                for (int i = 0; i < 스킬사용._스킬목록.size(); i++) {
                    System.out.println("스킬명   " + 스킬사용._스킬목록.get(i).스킬이름);
                    System.out.println("스킬효과 " + 스킬사용._스킬목록.get(i).효과);
                    System.out.println("스킬수치  " + 스킬사용._스킬목록.get(i).수치);
                }

                System.out.println("돌아가시려면 아무키나 입력하세요");
                선택 = in.nextInt();

            } else if (선택 == 0) {
                return;
            }
        }
    }
}

