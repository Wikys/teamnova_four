package com.teamnova;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner in = new Scanner(System.in);
        int 선택;
        String 사용;
        String 이름;
        캐릭터 유저명 = new 캐릭터(null,1,5,0,5,10,10,10,10,10,0,10);
        몬스터 몬스터정보 = new 몬스터();
        몬스터 생성된몬스터 = new 몬스터();
        String 내캐릭터;
        전투 전투 = new 전투();
        Random 랜덤 = new Random(); // 몬스터 생성자?

        System.out.println("YGGDRASIL RPG"); //타이틀
        System.out.println("1.시작하기\n0.끝내기"); //시작
        선택 = in.nextInt();
        if (선택 == 1) {
            System.out.println("\"캐릭터 작성을 시작합니다\n" +
                    "이름을 입력 해주세요\""); // "(인풋값으로 이름받음")
            유저명.이름=in.next();

            System.out.println(유저명.이름 + " 캐릭터가 작성되었습니다"); //클래스로 연결?
        } else {
            return;
        }

        System.out.println("당신은 모험을 시작합니다");
        while (true) {
            System.out.println("행동을 선택해주세요");
            System.out.println("1.탐색");
            System.out.println("2.휴식");
            System.out.println("3.상점");
            System.out.println("4.소지품");
            System.out.println("5.스테이터스");
            System.out.println("6.장비");
            System.out.println("0.끝내기");
            선택 = in.nextInt();

            if (선택 == 1) {
                int 인카운터 = random.nextInt(2);
                몬스터 생성 = new 몬스터();
                String 몬스터생성 = 생성.몬스터();
                System.out.println("탐색중 " + 몬스터생성 + "을(를) 마주쳤습니다!");
                System.out.println("전투를 시작합니다");
                if (몬스터생성 == "고블린"){
                    생성.고블린();
                }
                else if (몬스터생성 == "오크"){
                    생성.오크();
                }
                else if (몬스터생성 == "오우거"){
                    생성.오우거();

                }

                while (true) {
                    System.out.println("이름  : "+유저명.이름+"      ||"+생성.이름); // "플레이어, 몬스터 스테이터스 출력"
                    System.out.println("체력  : "+유저명.체력+"     ||"+생성.체력);
                    System.out.println("마나  : "+유저명.마나+"     ||0");
                    System.out.println("공격력: "+유저명.공격력+"      ||"+생성.공격력);
                    System.out.println("방어력: "+유저명.방어력+"      ||"+생성.방어력);
                    System.out.println("회피율: "+유저명.회피율+"      ||0");



                    System.out.println("전투행동을 선택해주세요");
                    System.out.println("1.공격");
                    System.out.println("2.아이템사용"); //미구현
                    선택 = in.nextInt();

                    if (선택 == 1) {
                        System.out.println("어떻게 공격하시겠습니까");
                        System.out.println("1.공격");
                        System.out.println("2.스킬사용"); //아직 미구현

                        선택 = in.nextInt();

                        if (선택 == 1) {
                            System.out.println(생성.이름+"을(를) 공격하였습니다 데미지를 "+(유저명.공격력-생성.방어력)+" 주었습니다"); //연산후 저장해서 루프처음으로
                            System.out.println(생성.이름+"이(가) 반격합니다 데미지를 "+유저명.공격받음(유저명,생성)+ "받았습니다");

                            생성.체력 = 생성.체력 + 생성.방어력 - 유저명.공격력;
                            유저명.체력 = 유저명.공격받음(유저명,생성);


                        } else if (선택 == 2) {
                            System.out.println("스킬을 사용해서 피해를 # 주었습니다"); //종족스킬별로 다르게설정..?
                        }
                    } else if (선택 == 2) {
                        System.out.println("아이템 사용");

                    }
                    // 몹체력 0이면 브레이크

                }
//                System.out.println("+몬스터이름+을(를) 처치하였습니다"); // 이부분은 고려를 해야될거같음 반복이안됨
//                System.out.println("획득 경험치 n");
//                System.out.println("획득 골드 n");
//                System.out.println("획득 아이템 n");
//                System.out.println("계속하려면 아무숫자나 입력하세요");
//                선택 = in.nextInt();
//                continue;

//                if (선택 == 2) {
//                    System.out.println("도주를 시도합니다"); //도주카운터 불러오기
//                    int 도주 = random.nextInt(5);
//
//                    if (도주 == 2 || 도주 == 3) {
//                        System.out.println("도주에 성공하였습니다");
//                        System.out.println("계속하시려면 아무숫자나 입력해주세요");
//                        선택 = in.nextInt();
//                        continue;
//                    }
//                    else if(도주 == 0 || 도주 == 1 || 도주 == 4 || 도주 == 5) {
//                        System.out.println("도주에 실패하였습니다");
//                        System.out.println(전투);
                //실패하면 다음으로 넘겨서 전투 시작하게 해야하는데..
//                    }
                // 전투중에 도주버튼 만드는걸로 바꾸고 도주실패했을시 몹이 한대때리는 패널티만들기

            } else if (선택 == 2) {
                유저명.체력 = 유저명.체력회복();
                유저명.마나 = 유저명.마나회복();
                System.out.println("충분한 휴식으로 체력과 마나가 모두 회복되었습니다");//스테이터스에 반영//끗
                System.out.println("돌아가시려면 아무키나 입력하세요");
                선택 = in.nextInt();
            } else if (선택 == 3) { //구매완료 판매완료등 설정
                System.out.println("구매할 물건을 선택 해주세요");
                System.out.println("1.낡은 철검 10 Gold");
                System.out.println("2.낡은 가죽갑옷 15 Gold");
                System.out.println("3.체력 포션 5 Gold");
                System.out.println("4.마나 포션 5 Gold");
                선택 = in.nextInt();
            } else if (선택 == 4) {
                소지품 소지품 = new 소지품(0, null, null);
//                System.out.println(소지품.소지품); // 인벤토리 2차원배열? // 버리기 장착등 구현
                System.out.println("1.아이템장착"); //배열 삭제하면서 플레이어에게 효과적용
                System.out.println("2.아이템버리기"); //배열삭제로 구현?
                System.out.println("포션은 마을에서 사용하실수 없습니다");
                선택 = in.nextInt();
//                if (선택 == 1){
//                    System.out.println("장착할 아이템 이름을 입력해주세요");
//                    사용 = in.next();
//
//                    for (int i = 0; i <소지품.소지품().size(); i++) {
//                        if (플레이어.소지품().equals(선택)) {
//                            플레이어.소지품().remove(선택);
//                            System.out.println(플레이어.소지품());
//                        }
//                    }
//
//                }
                사용 = in.next();
            } else if (선택 == 5) {
                유저명.스테이터스(); //이름 종족 레벨 체력 마나 공격력 방어력 경험치
                System.out.println("돌아가시려면 아무키나 입력하세요");
                선택 = in.nextInt();
            } else if (선택 == 6) {
                System.out.println("장비중인거 보여주기");
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
