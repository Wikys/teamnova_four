package com.teamnova;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner in = new Scanner(System.in);
        int 선택;
        String 사용;
        캐릭터 플레이어 = new 캐릭터(); //플레이어 캐릭터 객체


        String 내캐릭터;




        System.out.println("YGGDRASIL RPG"); //타이틀
        System.out.println("1.시작하기\n0.끝내기"); //시작
        선택 = in.nextInt();
        if (선택 == 1) {
            System.out.println("\"캐릭터 작성을 시작합니다\n" +
                    "이름을 선택 해주세요\""); // "(인풋값으로 이름받음")
            플레이어.이름 = in.next();
            플레이어.레벨= 1;
            플레이어.공격력 = 5;
            플레이어.방어력 = 0;
            플레이어.회피율 = 5;
            플레이어.체력 = 1;
            플레이어.최대체력 = 10;
            플레이어.마나 = 10;
            플레이어.최대마나 = 10;
            플레이어.경험치 = 0;
            플레이어.레벨업경험치 = 10;
            플레이어.돈 = 10;
            System.out.println(플레이어.이름 + " 캐릭터가 작성되었습니다"); //클래스로 연결?
        }else{
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
                System.out.println("마을 앞을 탐색합니다");
                System.out.println("+몬스터이름+을(를) 마주쳤습니다!");
                System.out.println("1.전투");
                System.out.println("2.도주");
                선택 = in.nextInt();
                if (선택 == 2) {
                    System.out.println("도주를 시도합니다"); //도주카운터 불러오기
                    int 도주 = random.nextInt(5);

                    if (도주 == 2 || 도주 == 3) {
                        System.out.println("도주에 성공하였습니다");
                    } else {
                        System.out.println("도주에 실패하였습니다");
                        break;
                    }
//                else if(선택 != 2){ // 통수정 해야될수도 있음
//                    System.out.println("전투를 시작합니다");
                    // 플레이어,몬스터 스테이터스 호출 //도주 실패했을때도 여기로
                } else {
                    break;
                }

            } else if (선택 == 2) {
                플레이어.체력 = 플레이어.체력회복();
                플레이어.마나 = 플레이어.마나회복();
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
                아이템 아이템 = new 아이템();
                System.out.println(플레이어.소지품()); // 인벤토리 2차원배열? // 버리기 장착등 구현
                System.out.println("1.아이템장착"); //배열 삭제하면서 플레이어에게 효과적용
                System.out.println("2.아이템버리기"); //배열삭제로 구현?
                System.out.println("포션은 마을에서 사용하실수 없습니다");
                선택 = in.nextInt();
                if (선택 == 1){
                    System.out.println("장착할 아이템 번호를 입력해주세요");
                    선택 = in.nextInt();
 //                   for(int i=0; i<플레이어.소지품().size(); i++){
 //                       System.out.println(플레이어.소지품().get(i));
  //                  }
  //                  for (int i =0; i <플레이어.소지품().size(); i++) {
  //                      if (플레이어.소지품().equals(선택)) {
                            플레이어.소지품().remove(선택);
                            System.out.println(플레이어.소지품());
    //                    }
     //               }

                }
                사용 = in.next();
            } else if (선택 == 5) {
                플레이어.스테이터스(); //이름 종족 레벨 체력 마나 공격력 방어력 경험치
                System.out.println("돌아가시려면 아무키나 입력하세요");
                선택 = in.nextInt();
            }  else if (선택 == 6) {
                System.out.println("장비중인거 보여주기");
            } else if (선택 == 0) {
                return;
            }

        }
        System.out.println("전투를 시작합니다");
        while (true) {
            System.out.println("플레이어, 몬스터 스테이터스 출력"); // 클래스
            System.out.println("전투행동을 선택해주세요");
            System.out.println("1.공격");
            System.out.println("2.방어");
            선택 = in.nextInt();

            if (선택 == 1) {
                System.out.println("어떻게 공격하시겠습니까");
                System.out.println("1.공격");
                System.out.println("2.스킬사용");
                선택 = in.nextInt();

                if (선택 == 1) {
                    System.out.println("+몬스터이름+을(를) 공격하였습니다 데미지를 +공격력+ 주었습니다"); //연산후 저장해서 루프처음으로
                } else if (선택 == 2) {
                    System.out.println("스킬을 사용해서 피해를 # 주었습니다"); //종족스킬별로 다르게설정..?
                }
            } else if (선택 == 2) {
                System.out.println("적의 공격을 방어하였습니다.");
                System.out.println("데미지를 +상대방공격력+ - +방어력+ 받았습니다"); ////연산후 저장해서 루프처음으로

            }break; // 몹체력 0이면 브레이크

        }
        System.out.println("+몬스터이름+을(를) 처치하였습니다"); // 이부분은 고려를 해야될거같음 반복이안됨
        System.out.println("획득 경험치 n");
        System.out.println("획득 골드 n");
        System.out.println("힉득 아이템 n");
        System.out.println("계속하려면 아무숫자나 입력하세요");
        선택 = in.nextInt();

    }
}
