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

//        boolean 무기 = false; //중복착용 막기
//        boolean 방어구 = false; //중복착용 막기
//        아이템 낡은검 = new 아이템("낡은검", 1, 0, 1); // 아이템호출
//        아이템 철검 = new 아이템("철검", 1, 1, 3);
//        아이템 가죽갑옷 = new 아이템("가죽갑옷", 2, 100, 2);
//        아이템 철갑옷 = new 아이템("철갑옷", 2, 101, 5);
//        아이템 체력포션 = new 아이템("체력포션",3,900,5);
//        아이템 마나포션 = new 아이템("체력포션",3,900,5);
        상점 상점 = new 상점();
//        ArrayList<아이템> 인벤토리 = new ArrayList<아이템>();
//        ArrayList<아이템> 장비창 = new ArrayList<아이템>();
//        ArrayList<아이템> 전투인벤토리 = new ArrayList<아이템>();
        아이템 아이템 = new 아이템();
        String 내캐릭터;
//        전투 전투 = new 전투();
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
            메뉴.유저상태_초기화(유저명); //버프나 기타등등으로 올라간 능력치 초기화
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

                    if (선택 == 1) {
                        전투메뉴.전투방식(); // 전투방식 선택 메세지 출력 (기능없음)
                        선택 = in.nextInt();

                        if (선택 == 1) {
                            전투메뉴.몬스터공격(유저명, 생성); // 플레이어 -> 몬스터공격
                            if (생성.체력 > 0) { // 적이 죽고나서도 반격하는거 방지
                                전투메뉴.캐릭터공격(유저명, 생성);
                            }
                            if (유저명.전투중체력 <= 0) {
                                System.out.println("사망하셨습니다");
                                return; // 사망했으니 종료
                            } else if (생성.체력 <= 0) {
//
                                전투메뉴.전투종료(생성, 유저명, 아이템); //전투종료시 재화획득
                                continue 행동문; // 초기반복문으로 되돌아가기
                            }


                        } else if (선택 == 2) {
                            전투메뉴.스킬사용(스킬사용,유저명);

                            System.out.println("사용할 스킬의 이름을 입력해주세요");
                            for (int i = 0; i < 스킬사용._스킬목록.size(); i++) {
                                System.out.println("스킬명   " + 스킬사용._스킬목록.get(i).스킬이름);
                                System.out.println("스킬효과 " + 스킬사용._스킬목록.get(i).효과);
                                System.out.println("스킬수치  " + 스킬사용._스킬목록.get(i).수치);
                            } //스킬목록 어레이 호출
                            사용 = in.next(); //입력

                            if (사용.equals("용기") && 용기사용횟수 == true) {
                                용기사용횟수 = false;

//                                유저명.전투중방어력 = 유저명.전투중방어력 + 스킬사용.스킬사용();
                                유저명.용기.스킬사용(유저명.용기.스킬이름,유저명,유저명, 유저명.용기.마나소모, 유저명.용기.수치, 유저명.용기.효과);
                                유저명.전투중마나 = 유저명.용기.스킬패널티(유저명.용기.마나소모, 유저명.전투중마나);

                            } else if (용기사용횟수 == false) {
                                System.out.println("사용횟수를 모두 소진하셨습니다");
                                continue;
                            }
                            int 랜덤피해 = 유저명.공격받음(유저명.전투중방어력, 생성.공격력, 유저명.회피율);
                            int 내남은체력 = 유저명.전투중체력 + 랜덤피해;
                            System.out.println(생성.이름 + "이(가) 공격합니다 데미지를 " + 랜덤피해 + "받았습니다");
                            유저명.전투중체력 = 내남은체력;
                            continue;


                        }

                    } else if (선택 == 2) { //퀵슬롯
                        for (int i = 0; i < 아이템.전투인벤토리.size(); i++) {
                            System.out.println(아이템.전투인벤토리.get(i).이름);
                        }
                        System.out.println("사용할 아이템 이름을 입력해주세요");
                        사용 = in.next();
                        for (int i = 0; i < 아이템.전투인벤토리.size(); i++) {
                            if (사용.equals(아이템.전투인벤토리.get(i).이름)) {

                                if (아이템.전투인벤토리.get(i).타입 == 3) { //체력포션 사용
                                    유저명.전투중체력 = 유저명.포션꿀꺽(아이템.전투인벤토리.get(i).체력회복, 유저명.최대체력, 유저명.전투중체력);
                                    System.out.println(아이템.전투인벤토리.get(i).이름 + "을 사용하였습니다");
                                    아이템.전투인벤토리.remove(아이템.전투인벤토리.get(i));
                                    break;


                                } else if (아이템.전투인벤토리.get(i).타입 == 4) { //마나포션 사용
                                    유저명.전투중마나 = 유저명.포션꿀꺽(아이템.전투인벤토리.get(i).마나회복, 유저명.최대마나, 유저명.전투중마나);
                                    System.out.println(아이템.전투인벤토리.get(i).이름 + "을 사용하였습니다");
                                    아이템.전투인벤토리.remove(아이템.전투인벤토리.get(i)); //3개씩 사용되는버그
                                    break;
                                }
                            }
                        }
                    } else if (선택 == 3) {
                        System.out.println("도주를 시도합니다");
                        int 도주확률 = random.nextInt(100);

                        if (도주확률 <= 50 && 도주카운터 == true) { // 도주확률이 50안쪽이면 도망성공
                            System.out.println("도주에 성공하셨습니다");
                            continue 행동문;
                        } else if (도주확률 > 50 && 도주카운터 == true) { // 도주카운터가 51~100이뜨면 도주실패
                            System.out.println("상남자특) 도망안침");
                            도주카운터 = false;
                        } else if (도주카운터 == false) { // 도주시도는 단 한번만 가능
                            System.out.println("이미 적에게 발각당하셨습니다");
                            System.out.println("도망칠수 없습니다");

                        }
                    }
                }

            } else if (선택 == 2) {
                유저명.체력 = 유저명.체력회복();
                유저명.마나 = 유저명.마나회복();
                System.out.println("충분한 휴식으로 체력과 마나가 모두 회복되었습니다");//스테이터스에 반영
                System.out.println("돌아가시려면 아무키나 입력하세요");
                선택 = in.nextInt();
            } else if (선택 == 3) { //구매완료 판매완료등 설정

                상점.판매목록();
                System.out.println("소지금 " + 유저명.돈 + " Gold");
                System.out.println();
                System.out.println("0.나가기");


                // 내 소지금 추가및 돈부족시에 경고띄우기
                // 구매완료되면 인벤토리와 전투인벤토리에 생성
                선택 = in.nextInt();
                아이템.인벤토리.addAll(상점.아이템반환(선택, 유저명));
                유저명.돈 = 유저명.돈 - 상점.구매(선택, 유저명);


                if (선택 == 0) {
                    continue;
                }
            } else if (선택 == 4) { //소지품창


                for (int i = 0; i < 아이템.인벤토리.size(); i++) {
                    System.out.println("아이템 이름: " + i + ". " + 아이템.인벤토리.get(i).이름);
                }
                // 일단 이름만 띄워주고 숫자입력하면 장착하시겠습니까 띄우고 거기서 정보주기

//                System.out.println(소지품.소지품); // 인벤토리 2차원배열? // 버리기 장착등 구현
                System.out.println("1.아이템장착"); //배열 삭제하면서 플레이어에게 효과적용
                System.out.println("2.아이템버리기"); //배열삭제로 구현?
                System.out.println("3.퀵슬롯장착"); // 전투인벤토리로 보내기
                System.out.println("0. 메인으로 가기");
                System.out.println("포션은 마을에서 사용하실수 없습니다");

                선택 = in.nextInt();
                if (선택 == 1) {

                    System.out.println("장착하실 아이템 이름을 입력해주세요");
                    사용 = in.next();

                    for (int i = 0; i < 아이템.인벤토리.size(); i++) {

                        if (아이템.인벤토리.get(i).이름.equals("낡은검") && 아이템.인벤토리.get(i).이름.equals(사용) && 아이템.무기중복 == false) {
                            System.out.println("공격력이 " + 유저명.낡은검.공격력 + " 증가했습니다");

                            유저명.공격력 = 유저명.공격력 + 유저명.낡은검.공격력;
                            아이템.무기중복 = true;
                            아이템.장비창.add(아이템.인벤토리.get(i));
                            아이템.인벤토리.remove(아이템.인벤토리.get(i));


                            continue;


                        } else if (아이템.인벤토리.get(i).이름.equals("철검") && 아이템.인벤토리.get(i).이름.equals(사용) && 아이템.무기중복 == false) { //계속 장착되는거 막아야함
                            System.out.println("공격력이 " + 유저명.철검.공격력 + " 증가했습니다");

                            유저명.공격력 = 유저명.공격력 + 유저명.철검.공격력;
                            아이템.무기중복 = true;
                            아이템.장비창.add(아이템.인벤토리.get(i));
                            아이템.인벤토리.remove(아이템.인벤토리.get(i));


                            continue;
                        } else if (아이템.인벤토리.get(i).이름.equals("고블린왕의_몽둥이") && 아이템.인벤토리.get(i).이름.equals(사용) && 아이템.무기중복 == false) { //계속 장착되는거 막아야함
                            System.out.println("공격력이 " + 유저명.고블린왕의_몽둥이.공격력 + " 증가했습니다");

                            유저명.공격력 = 유저명.공격력 + 유저명.고블린왕의_몽둥이.공격력;
                            아이템.무기중복 = true;
                            아이템.장비창.add(아이템.인벤토리.get(i));
                            아이템.인벤토리.remove(아이템.인벤토리.get(i));


                            continue;
                        } else if (아이템.인벤토리.get(i).이름.equals("가죽갑옷") && 아이템.인벤토리.get(i).이름.equals(사용) && 아이템.방어구중복 == false) { //계속 장착되는거 막아야함
                            System.out.println("방어력이 " + 유저명.가죽갑옷.방어력 + " 증가했습니다");

                            유저명.방어력 = 유저명.방어력 + 유저명.가죽갑옷.방어력;
                            아이템.방어구중복 = true;
                            아이템.장비창.add(아이템.인벤토리.get(i));
                            아이템.인벤토리.remove(아이템.인벤토리.get(i));


                            continue;
                        } else if (아이템.인벤토리.get(i).이름.equals("철갑옷") && 아이템.인벤토리.get(i).이름.equals(사용) && 아이템.방어구중복 == false) { //계속 장착는거 막아야함
                            System.out.println("방어력이 " + 유저명.철갑옷.방어력 + " 증가했습니다");

                            유저명.방어력 = 유저명.방어력 + 유저명.철갑옷.방어력;
//                            아이템.인벤토리.get(i).중복장착 = true;
                            아이템.방어구중복 = true;
                            아이템.장비창.add(아이템.인벤토리.get(i));
                            아이템.인벤토리.remove(아이템.인벤토리.get(i));

                            continue;
                        } else {
                        }
                    }
                } else if (선택 == 2) {

                    System.out.println("버릴 아이템 이름 입력해주세요");

                    사용 = in.next();

                    for (int i = 0; i < 아이템.인벤토리.size(); i++) {
                        if (아이템.인벤토리.get(i).이름.equals(사용)) {
                            아이템.인벤토리.remove(아이템.인벤토리.get(i));
                            System.out.println(아이템.인벤토리.get(i).이름 + "을 버렸습니다");
                            continue 행동문;

                        }


                    }
                } else if (선택 == 3) {

                    System.out.println("퀵슬롯에 장착할 '포션'이름을 써주세요");
                    사용 = in.next();

                    for (int i = 0; i < 아이템.인벤토리.size(); i++) {

                        if (사용.equals(아이템.인벤토리.get(i).이름) && 아이템.인벤토리.get(i).타입 == 3) { // 체력포션
                            if (아이템.인벤토리.get(i).체력회복 == 5) { // 나중에 상위포션 추가?

                                System.out.println(아이템.인벤토리.get(i).이름 + "을 퀵슬롯에 옮겼습니다");
                                아이템.전투인벤토리.add(아이템.인벤토리.get(i));
                                아이템.인벤토리.remove(아이템.인벤토리.get(i));
                                break;

                            }

                        } else if (사용.equals(아이템.인벤토리.get(i).이름) && 아이템.인벤토리.get(i).타입 == 4) {//마나포션

                            if (아이템.인벤토리.get(i).마나회복 == 5) {

                                System.out.println(아이템.인벤토리.get(i).이름 + "을 퀵슬롯에 옮겼습니다");
                                아이템.전투인벤토리.add(아이템.인벤토리.get(i));
                                아이템.인벤토리.remove(아이템.인벤토리.get(i));
                                break;

                            }
                        } else if (사용.equals(아이템.인벤토리.get(i).이름) && 아이템.인벤토리.get(i).타입 != 3
                                && 아이템.인벤토리.get(i).타입 != 4) {
                            System.out.println("아이템이 없거나 포션이 아닙니다");
                        }
                    }
                }
                //       사용 = in.next();

            } else if (선택 == 5) {
                유저명.스테이터스(); //이름 종족 레벨 체력 마나 공격력 방어력 경험치
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
//        System.out.println("전투를 시작합니다");
//        while (true) {
//            System.out.println("플레이어, 몬스터 스테이터스 출력"); // 클래스
//            System.out.println("전투행동을 선택해주세요");
//            System.out.println("1.공격");
//            System.out.println("2.방어");
//            선택 = in.nextInt();
//
//            if (선택 == 1) {
//                System.out.println("어떻게 공격하시겠습니까");
//                System.out.println("1.공격");
//                System.out.println("2.스킬사용");
//                선택 = in.nextInt();
//
//                if (선택 == 1) {
//                    System.out.println("+몬스터이름+을(를) 공격하였습니다 데미지를 +공격력+ 주었습니다"); //연산후 저장해서 루프처음으로
//                } else if (선택 == 2) {
//                    System.out.println("스킬을 사용해서 피해를 # 주었습니다"); //종족스킬별로 다르게설정..?
//                }
//            } else if (선택 == 2) {
//                System.out.println("적의 공격을 방어하였습니다.");
//                System.out.println("데미지를 +상대방공격력+ - +방어력+ 받았습니다"); ////연산후 저장해서 루프처음으로
//
//            }break; // 몹체력 0이면 브레이크
//
//        }
//        System.out.println("+몬스터이름+을(를) 처치하였습니다"); // 이부분은 고려를 해야될거같음 반복이안됨
//        System.out.println("획득 경험치 n");
//        System.out.println("획득 골드 n");
//        System.out.println("획득 아이템 n");
//        System.out.println("계속하려면 아무숫자나 입력하세요");
//        선택 = in.nextInt();

    }
}

