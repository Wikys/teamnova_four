package com.teamnova.메뉴;

import com.teamnova.스킬.스킬;
import com.teamnova.아이템.아이템;
import com.teamnova.플레이어.캐릭터;

import java.util.Scanner;

public class 메인메뉴 {
    캐릭터 캐릭터;

    public Scanner in = new Scanner(System.in);
    public boolean 전투종료 = false;
    public int 입력;
    public boolean 무기중복 = false;
    public boolean 방어구중복 = false;
    String 유저이름;


    public void 행동메뉴() {

        System.out.println("행동을 선택해주세요");
        System.out.println("====================");
        System.out.println("1.탐색");
        System.out.println("2.휴식");
        System.out.println("3.상점");
        System.out.println("4.소지품");
        System.out.println("5.스테이터스");
        System.out.println("6.장비");
        System.out.println("7.스킬");
        System.out.println("0.끝내기");
        System.out.println("====================");
    }

    public 캐릭터 유저상태_초기화(캐릭터 _플레이어, 스킬 _스킬상태) { // 버프나 기타등등으로 올라간 능력치 초기화
//        if (_플레이어.전투중체력 > _플레이어.최대체력) {
//            _플레이어.체력 = _플레이어.최대체력;
//        } else if (_플레이어.전투중체력 <= _플레이어.최대체력) {
        _플레이어.체력 = _플레이어.전투중체력;
//        } else if (_플레이어.전투중마나 > _플레이어.최대마나) {
//            _플레이어.전투중마나 = _플레이어.최대마나;
//        } else if (_플레이어.전투중마나 <= _플레이어.최대마나) {
        _플레이어.마나 = _플레이어.전투중마나;
//        } else if (_플레이어.전투중공격력 > _플레이어.공격력) {
        _플레이어.전투중공격력 = _플레이어.공격력;
//        } else if (_플레이어.전투중방어력 > _플레이어.방어력) {
        _플레이어.전투중방어력 = _플레이어.방어력;
//        } else if (_플레이어.전투중회피율 > _플레이어.회피율) {
        _플레이어.전투중회피율 = _플레이어.회피율;
//        }
        _플레이어.전투중마법력 = _플레이어.마법력;
        _플레이어.종족스킬_제한 = true;
        _스킬상태.스킬제한 = false;
        this.전투종료 = true;
        return _플레이어;
    }

    public void 휴식(캐릭터 _캐릭터) { //체,마 회복
        _캐릭터.체력 = _캐릭터.최대체력; //작동안함
        _캐릭터.마나 = _캐릭터.최대마나;
        _캐릭터.전투중체력 = _캐릭터.최대체력;
        _캐릭터.전투중마나 = _캐릭터.최대마나;
        System.out.println("충분한 휴식으로 체력과 마나가 모두 회복되었습니다");//스테이터스에 반영

    }

    public void 스테이터스(캐릭터 _캐릭터) { //캐릭터의 스테이터스창
        System.out.println("====================");
        System.out.println("이름 = " + _캐릭터.이름);
        System.out.println("종족 = " + _캐릭터.종족이름);
        System.out.println("레벨 = " + _캐릭터.레벨); //최대레벨 표시
        System.out.println("공격력 = " + _캐릭터.공격력);
        System.out.println("마법력 = " + _캐릭터.마법력);
        System.out.println("방어력 = " + _캐릭터.방어력);
        System.out.println("회피율 = " + _캐릭터.회피율);
        System.out.println("체력 = " + _캐릭터.체력 + "/" + _캐릭터.최대체력); //최대체력 표시
        System.out.println("마나 = " + _캐릭터.마나 + "/" + _캐릭터.최대마나); //최대마나 표시
        System.out.println("경험치 = " + _캐릭터.경험치 + "/" + _캐릭터.레벨업경험치); //최대경험치 표시
        System.out.println("====================");
    }

    public void 소지품창(캐릭터 _캐릭터, 아이템 _아이템) { //아이템장착,버리기,퀵슬롯장착등의 기능을 수행하는메서드
        System.out.println("====================");
        for (int i = 0; i < _아이템.인벤토리.size(); i++) {
            System.out.println(i + "." + _아이템.인벤토리.get(i).이름);
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
            for (int i = 0; i < _아이템.인벤토리.size(); i++) {
                System.out.println(i + "." + _아이템.인벤토리.get(i).이름);
            }
            System.out.println("====================");
            System.out.println("장착하실 아이템의 번호를 입력하세요");
            입력 = in.nextInt();
            아이템 장착아이템 = _아이템.인벤토리.get(입력);
            if (장착아이템.타입 == 1 && 장착아이템.마법무기 == 0) { //일반무기 장착
                System.out.println("====================");
                System.out.println("아이템명: " + 장착아이템.이름);
                System.out.println("공격력: " + 장착아이템.공격력);
                System.out.println("아이템 설명: " + 장착아이템.설명);
                System.out.println("====================");
                System.out.println("정말로 장착하시겠습니까?");
                System.out.println("====================");
                System.out.println("1.예");
                System.out.println("2.아니오");
                System.out.println("====================");
                입력 = in.nextInt();
                if (입력 == 1 && 무기중복 == false) {
                    System.out.println(장착아이템.이름 + " 장착 되었습니다");
                    _캐릭터.공격력 = _캐릭터.공격력 + 장착아이템.공격력;
                    _아이템.장비창.add(장착아이템);
                    _아이템.인벤토리.remove(장착아이템);
                    무기중복 = true;
                    this.소지품창(_캐릭터, _아이템);
                } else if (입력 == 2) {
                    this.소지품창(_캐릭터, _아이템);
                }else{
                    System.out.println("중복착용 하지마세요!");
                    this.소지품창(_캐릭터, _아이템);
                }
            }
            else if (장착아이템.타입 == 1 && 장착아이템.마법무기 == 1) { //마법무기 장착
                System.out.println("====================");
                System.out.println("아이템명: " + 장착아이템.이름);
                System.out.println("마법력: " + 장착아이템.마법력);
                System.out.println("아이템 설명: " + 장착아이템.설명);
                System.out.println("====================");
                System.out.println("정말로 장착하시겠습니까?");
                System.out.println("====================");
                System.out.println("1.예");
                System.out.println("2.아니오");
                System.out.println("====================");
                입력 = in.nextInt();
                if (입력 == 1 && 무기중복 == false) {
                    System.out.println(장착아이템.이름 + " 장착 되었습니다");
                    _캐릭터.마법력 = _캐릭터.마법력 + 장착아이템.마법력;
                    _아이템.장비창.add(장착아이템);
                    _아이템.인벤토리.remove(장착아이템);
                    무기중복 = true;
                    this.소지품창(_캐릭터, _아이템);
                } else if (입력 == 2) {
                    this.소지품창(_캐릭터, _아이템);
                }else{
                    System.out.println("중복착용 하지마세요!");
                    this.소지품창(_캐릭터, _아이템);
                }
            }
            if (장착아이템.타입 == 2) {
                System.out.println("====================");
                System.out.println("아이템명: " + 장착아이템.이름);
                System.out.println("방어력: " + 장착아이템.방어력);
                System.out.println("아이템 설명: " + 장착아이템.설명);
                System.out.println("====================");
                System.out.println("정말로 장착하시겠습니까?");
                System.out.println("====================");
                System.out.println("1.예");
                System.out.println("2.아니오");
                System.out.println("====================");
                입력 = in.nextInt();
                if (입력 == 1 && 방어구중복 == false) {
                    System.out.println(장착아이템.이름 + " 장착 되었습니다");
                    _캐릭터.방어력 = _캐릭터.방어력 + 장착아이템.방어력;
                    _아이템.장비창.add(장착아이템);
                    _아이템.인벤토리.remove(장착아이템);
                    방어구중복 = true;
                    this.소지품창(_캐릭터, _아이템);
                } else if (입력 == 2) {
                    this.소지품창(_캐릭터, _아이템);
                } else {
                    System.out.println("중복착용 하지마세요!");
                    this.소지품창(_캐릭터, _아이템);
                }
            } else if (장착아이템.타입 == 3) {
                System.out.println("포션류는 장착이 불가능합니다");
                this.소지품창(_캐릭터, _아이템);
            } else if (장착아이템.타입 == 4) {
                System.out.println("포션류는 장착이 불가능합니다");
                this.소지품창(_캐릭터, _아이템);
            }
        } else if (입력 == 2) {
            System.out.println("====================");
            for (int i = 0; i < _아이템.인벤토리.size(); i++) {
                System.out.println(i + "." + _아이템.인벤토리.get(i).이름);
            }
            System.out.println("====================");
            System.out.println("버리실 아이템의 번호를 입력하세요");
            System.out.println("00.돌아가기");
            입력 = in.nextInt();
            if (입력 == 00) {
                this.소지품창(_캐릭터, _아이템);
            }
            아이템 버릴아이템 = _아이템.인벤토리.get(입력);
            //버릴아이템까진 선택됨
            System.out.println(버릴아이템.이름 + "을 정말 버리겠습니까?");
            System.out.println("====================");
            System.out.println("1.예");
            System.out.println("2.아니오");
            System.out.println("0.나가기");
            System.out.println("====================");
            입력 = in.nextInt();
            if (입력 == 1) {
                System.out.println(버릴아이템.이름 + "을 버렸습니다");
                _아이템.인벤토리.remove(버릴아이템);
                this.소지품창(_캐릭터, _아이템);
            } else if (입력 == 2) {
                this.소지품창(_캐릭터, _아이템);
            }
        } else if (입력 == 3) {
            System.out.println("====================");
            for (int i = 0; i < _아이템.인벤토리.size(); i++) {
                System.out.println(i + "." + _아이템.인벤토리.get(i).이름);
            }
            System.out.println("====================");
            System.out.println("퀵슬롯에 장착할 아이템 번호를 입력해주세요");
            System.out.println("포션만 가능합니다");
            System.out.println("00.돌아가기");
            입력 = in.nextInt();
            if (입력 == 00){
                this.소지품창(_캐릭터, _아이템);
            }
            아이템 퀵아이템 = _아이템.인벤토리.get(입력);
            if (퀵아이템.타입 == 3 || 퀵아이템.타입 == 4){
                System.out.println(퀵아이템.이름+"을 정말 퀵슬롯에 넣으시겠습니까?");
                System.out.println("1.예");
                System.out.println("2.아니오");
                입력 = in.nextInt();
                if (입력 == 1){
                    System.out.println(퀵아이템.이름+"을 퀵슬롯에 넣었습니다");
                    _아이템.전투인벤토리.add(퀵아이템);
                    _아이템.인벤토리.remove(퀵아이템);
                }
                else if(입력 == 2 ){
                    this.소지품창(_캐릭터, _아이템);
                }

            }
        }
    }
}

