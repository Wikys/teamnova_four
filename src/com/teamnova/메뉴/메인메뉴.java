package com.teamnova.메뉴;

import com.teamnova.스킬.스킬;
import com.teamnova.아이템.아이템;
import com.teamnova.플레이어.캐릭터;

import java.util.ArrayList;
import java.util.Scanner;

import static com.teamnova.몬스터.몬스터.유저명;

public class 메인메뉴 {
//    캐릭터 캐릭터;

    public Scanner in = new Scanner(System.in);
//    public boolean 전투종료 = false;
    public int 입력;
    public boolean 무기중복 = false;
    public boolean 방어구중복 = false;
    String 유저이름;





    public void 행동메뉴() {
        if (유저명.레벨 <5) {

            System.out.println("행동을 선택해주세요");
            System.out.println("====================");
            System.out.println("1.탐색");
            System.out.println("2.휴식");
            System.out.println("3.상점");
            System.out.println("4.소지품");
            System.out.println("5.스테이터스");
            System.out.println("6.장비");
            System.out.println("7.보유스킬");
            System.out.println("8.전직");
            System.out.println("9.스킬배우기");
            System.out.println("0.끝내기");
            System.out.println("====================");
        }
        else if (유저명.레벨 >=5){
            System.out.println("행을 선택해주세요");
            System.out.println("====================");
            System.out.println("1.탐색");
            System.out.println("2.휴식");
            System.out.println("3.상점");
            System.out.println("4.소지품");
            System.out.println("5.스테이터스");
            System.out.println("6.장비");
            System.out.println("7.보유스킬");
            System.out.println("8.전직");
            System.out.println("9.스킬배우기");
            System.out.println("10.보스");
            System.out.println("0.끝내기");
            System.out.println("====================");
        }
    }


    public 캐릭터 유저상태_초기화() { // 버프나 기타등등으로 올라간 능력치 초기화


        유저명.체력 = 유저명.전투중체력;
        유저명.마나 = 유저명.전투중마나;
        유저명.전투중공격력 = 유저명.공격력;
        유저명.전투중방어력 = 유저명.방어력;
        유저명.전투중회피율 = 유저명.회피율;
        유저명.전투중마법력 = 유저명.마법력;
        유저명.종족스킬_제한 = true;
//        this.전투종료 = true;
        for (int i = 0; i < 유저명._공격스킬목록.size(); i++) {
            유저명._공격스킬목록.get(i).스킬초기화();
        }
//        for (int i = 0; i < 유저명._버프스킬목록.size(); i++) {
//            유저명._버프스킬목록.get(i).스킬초기화();
//        }
//        for (int i = 0; i < 유저명._회복스킬목록.size(); i++) {
//            유저명._회복스킬목록.get(i).스킬초기화(); //쓰지않으므로 주석
//        }

        return 유저명;
    }

    public void 치료() { //체,마 회복
        유저명.체력 = 유저명.최대체력; //작동안함
        유저명.마나 = 유저명.최대마나;
        유저명.전투중체력 = 유저명.최대체력;
        유저명.전투중마나 = 유저명.최대마나;
        System.out.println("긴급 치료를 받아 체력과 마나가 모두 회복되었습니다");//스테이터스에 반영

    }

    public void 스테이터스() { //캐릭터의 스테이터스창
        while (true) {
            System.out.println("====================");
            System.out.println("이름 = " + 유저명.이름);
            System.out.println("종족 = " + 유저명.종족이름);
            System.out.println("직업 = " + 유저명.직업이름);
            System.out.println("레벨 = " + 유저명.레벨); //최대레벨 표시
            System.out.println("공격력 = " + 유저명.공격력);
            System.out.println("마법력 = " + 유저명.마법력);
            System.out.println("방어력 = " + 유저명.방어력);
            System.out.println("회피율 = " + 유저명.회피율);
            System.out.println("체력 = " + 유저명.체력 + "/" + 유저명.최대체력); //최대체력 표시
            System.out.println("마나 = " + 유저명.마나 + "/" + 유저명.최대마나); //최대마나 표시
            System.out.println("경험치 = " + 유저명.경험치 + "/" + 유저명.레벨업경험치); //최대경험치 표시
            System.out.println("====================");
            System.out.println("돌아가시려면 아무숫자나 입력하세요");
            입력 = in.nextInt();
            break;
        }
    }

    public void 소지품창() { //아이템장착,버리기,퀵슬롯장착등의 기능을 수행하는메서드
        입구:
        while (true){
            System.out.println("====================");
        for (int i = 0; i < 유저명.인벤토리.size(); i++) {
            System.out.println(i + "." + 유저명.인벤토리.get(i).이름);
        }
        System.out.println("====================");
        System.out.println("1.아이템장착");
        System.out.println("2.아이템버리기");
        System.out.println("3.퀵슬롯장착");
        System.out.println("0.나가기");
        System.out.println("포션은 마을에서 사용하실수 없습니다");
        입력 = in.nextInt();
        if (입력 == 1) {
            System.out.println("====================");
            for (int i = 0; i < 유저명.인벤토리.size(); i++) {
                System.out.println(i + "." + 유저명.인벤토리.get(i).이름);
            }
            System.out.println("====================");
            System.out.println("장착하실 아이템의 번호를 입력하세요");
            입력 = in.nextInt();
            아이템 장착아이템 = 유저명.인벤토리.get(입력);
            if (장착아이템.타입 == 1 && 장착아이템.마법무기 == 0) { //일반무기 장착
                장착아이템.아이템_설명();
                System.out.println("정말로 장착하시겠습니까?");
                System.out.println("====================");
                System.out.println("1.예");
                System.out.println("2.아니오");
                System.out.println("====================");
                입력 = in.nextInt();
                if (입력 == 1 && 무기중복 == false) {
                    System.out.println(장착아이템.이름 + " 장착 되었습니다");
//                    유저명.공격력 = 유저명.공격력 + 장착아이템.공격력;
                    장착아이템.아이템_효과();
                    유저명.장비창.add(장착아이템);
                    유저명.인벤토리.remove(장착아이템);
                    무기중복 = true;
                    continue 입구;
                } else if (입력 == 2) {
                    continue 입구;
                } else {
                    System.out.println("중복착용 하지마세요!");
                    continue 입구;
                }
            } else if (장착아이템.타입 == 1 && 장착아이템.마법무기 == 1) { //마법무기 장착
                장착아이템.아이템_설명();
                System.out.println("====================");
                System.out.println("1.예");
                System.out.println("2.아니오");
                System.out.println("====================");
                입력 = in.nextInt();
                if (입력 == 1 && 무기중복 == false) {
                    System.out.println(장착아이템.이름 + " 장착 되었습니다");
//                    유저명.마법력 = 유저명.마법력 + 장착아이템.마법력;
                    장착아이템.아이템_효과();
                    유저명.장비창.add(장착아이템);

                    유저명.인벤토리.remove(장착아이템);
                    무기중복 = true;
                    continue 입구;
                } else if (입력 == 2) {
                    continue 입구;
                } else {
                    System.out.println("중복착용 하지마세요!");
                    continue 입구;
                }
            }
            if (장착아이템.타입 == 2) {
                장착아이템.아이템_설명();
                System.out.println("====================");
                System.out.println("정말로 장착하시겠습니까?");
                System.out.println("====================");
                System.out.println("1.예");
                System.out.println("2.아니오");
                System.out.println("====================");
                입력 = in.nextInt();
                if (입력 == 1 && 방어구중복 == false) {
                    System.out.println(장착아이템.이름 + " 장착 되었습니다");
//                    유저명.방어력 = 유저명.방어력 + 장착아이템.방어력;
                    장착아이템.아이템_효과();
                    유저명.장비창.add(장착아이템);
                    유저명.인벤토리.remove(장착아이템);
                    방어구중복 = true;
                    continue 입구;
                } else if (입력 == 2) {
                    continue 입구;
                } else {
                    System.out.println("중복착용 하지마세요!");
                    continue 입구;
                }
            } else if (장착아이템.타입 == 3) {
                System.out.println("포션류는 장착이 불가능합니다");
                continue 입구;
            } else if (장착아이템.타입 == 4) {
                System.out.println("포션류는 장착이 불가능합니다");
                continue 입구;
            }
        } else if (입력 == 2) {
            System.out.println("====================");
            for (int i = 0; i < 유저명.인벤토리.size(); i++) {
                System.out.println(i + "." + 유저명.인벤토리.get(i).이름);
            }
            System.out.println("====================");
            System.out.println("버리실 아이템의 번호를 입력하세요");
            System.out.println("90.돌아가기");
            입력 = in.nextInt();
            if (입력 == 10) {
                continue 입구;
            }
            아이템 버릴아이템 = 유저명.인벤토리.get(입력);
            System.out.println(버릴아이템.이름 + "을 정말 버리겠습니까?");
            System.out.println("====================");
            System.out.println("1.예");
            System.out.println("2.아니오");
            System.out.println("0.나가기");
            System.out.println("====================");
            입력 = in.nextInt();
            if (입력 == 1) {
                System.out.println(버릴아이템.이름 + "을 버렸습니다");
                유저명.인벤토리.remove(버릴아이템);
                continue 입구;
            } else if (입력 == 2) {
                continue 입구;
            }
        } else if (입력 == 3) {
            System.out.println("====================");
            for (int i = 0; i < 유저명.인벤토리.size(); i++) {
                System.out.println(i + "." + 유저명.인벤토리.get(i).이름);
            }
            System.out.println("====================");
            System.out.println("퀵슬롯에 장착할 아이템 번호를 입력해주세요");
            System.out.println("포션만 가능합니다");
            System.out.println("90.돌아가기");
            입력 = in.nextInt();
            if (입력 == 90) {
                continue 입구;
            }
            아이템 퀵아이템 = 유저명.인벤토리.get(입력);
            if (퀵아이템.타입 == 3 || 퀵아이템.타입 == 4) {
                System.out.println(퀵아이템.이름 + "을 정말 퀵슬롯에 넣으시겠습니까?");
                System.out.println("1.예");
                System.out.println("2.아니오");
                입력 = in.nextInt();
                if (입력 == 1) {
                    System.out.println(퀵아이템.이름 + "을 퀵슬롯에 넣었습니다");
                    유저명.전투인벤토리.add(퀵아이템);
                    유저명.인벤토리.remove(퀵아이템);
                } else if (입력 == 2) {
                    continue 입구;
                }

            }
        }
        else if(입력 == 0){
            return;
        }else{
            return;
        }
    }
    }

    public void 스킬인벤( ArrayList<스킬> _공격스킬목록, ArrayList<스킬> _버프스킬목록, ArrayList<스킬> _회복스킬목록,ArrayList<스킬> _종족스킬목록) { //메인메뉴 7번 스킬인벤
        메인 :
        while(true) {
            System.out.println("====================");
            System.out.println("1.공격계열");
            System.out.println("2.버프계열");
            System.out.println("3.회복계열");
            System.out.println("4.종족스킬");
            System.out.println("====================");
            System.out.println("0.나가기");
            입력 = in.nextInt();

            if (입력 == 1) {
                for (int i = 0; i < _공격스킬목록.size(); i++) {
                    System.out.println("스킬 이름: " + i + ". " + _공격스킬목록.get(i).스킬이름);
                }
                System.out.println("설명을 보고싶은 스킬의 번호를 입력하세요");

                입력 = in.nextInt();

                스킬 선택스킬 = _공격스킬목록.get(입력);
                선택스킬.스킬설명();
                System.out.println("돌아가시려면 아무숫자나 눌러주세요");
                입력 = in.nextInt();
                continue 메인;
            } else if (입력 == 2) {
                for (int i = 0; i < _버프스킬목록.size(); i++) {
                    System.out.println("스킬 이름: " + i + ". " + _버프스킬목록.get(i).스킬이름);
                }
                System.out.println("설명을 보고싶은 스킬의 번호를 입력하세요");

                입력 = in.nextInt();

                스킬 선택스킬 = _버프스킬목록.get(입력);
                선택스킬.스킬설명();
                System.out.println("돌아가시려면 아무숫자나 눌러주세요");
                입력 = in.nextInt();
                continue 메인;
            } else if (입력 == 3) {
                for (int i = 0; i < _회복스킬목록.size(); i++) {
                    System.out.println("스킬 이름: " + i + ". " + _회복스킬목록.get(i).스킬이름);
                }
                System.out.println("설명을 보고싶은 스킬의 번호를 입력하세요");
                입력 = in.nextInt();

                스킬 선택스킬 = _회복스킬목록.get(입력);
                선택스킬.스킬설명();
                System.out.println("돌아가시려면 아무숫자나 눌러주세요");
                입력 = in.nextInt();
                continue 메인;
            } else if (입력 == 4) {
                for (int i = 0; i < _종족스킬목록.size(); i++) {
                    System.out.println("스킬 이름: " + i + ". " + _종족스킬목록.get(i).스킬이름);
                }
                System.out.println("설명을 보고싶은 스킬의 번호를 입력하세요");
                입력 = in.nextInt();

                스킬 선택스킬 = _종족스킬목록.get(입력);
                선택스킬.스킬설명();

                System.out.println("돌아가시려면 아무숫자나 눌러주세요");
                입력 = in.nextInt();
                    continue 메인;

            }
            else if (입력 == 0){
                return;
            }else {
                System.out.println("잘못 입력하셨습니다");
            }
        }


    }

}

