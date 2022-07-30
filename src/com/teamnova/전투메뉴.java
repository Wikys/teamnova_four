package com.teamnova;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class 전투메뉴 {
    Random random = new Random();
    Scanner in = new Scanner(System.in);
    int 입력;

    public 캐릭터 캐릭터_전투_스테이터스(캐릭터 _플레이어) {
        System.out.println("=====================");
        System.out.println("이름 : " + _플레이어.이름);
        System.out.println("체력 : " + _플레이어.전투중체력);
        System.out.println("마나 : " + _플레이어.전투중마나);
        System.out.println("공격력 : " + _플레이어.전투중공격력);
        System.out.println("방어력 : " + _플레이어.전투중방어력);
        System.out.println("회피율 : " + _플레이어.전투중회피율);
        System.out.println("=====================");
        return _플레이어;
    }

    public 몬스터 몬스터_전투_스테이터스(몬스터 _몬스터) {
        System.out.println("=====================");
        System.out.println("이름 : " + _몬스터.이름);
        System.out.println("체력 : " + _몬스터.체력);
        System.out.println("마나 : " + _몬스터.마나);
        System.out.println("공격력 : " + _몬스터.공격력);
        System.out.println("방어력 : " + _몬스터.방어력);
        System.out.println("회피율 : " + _몬스터.회피율);
        System.out.println("=====================");

        return _몬스터;
    }

    public void 전투행동() {
        System.out.println("전투행동을 선택해주세요");
        System.out.println("1.공격");
        System.out.println("2.아이템사용");
        System.out.println("3.도주하기");
    }

    public void 전투방식() {
        System.out.println("어떻게 공격하시겠습니까");
        System.out.println("1.공격");
        System.out.println("2.스킬사용");
    }

    public 몬스터 몬스터공격(캐릭터 _캐릭터, 몬스터 _몬스터) { //몬스터 공격 메세지 출력
        int _랜덤공격 = _몬스터.몹공격받음(_몬스터.방어력, _캐릭터.전투중공격력, _몬스터.회피율);
        _몬스터.체력 = _몬스터.체력 - _랜덤공격;
        System.out.println(_몬스터.이름 + "을(를) 공격하셨습니다 데미지를 "
                + _랜덤공격 + "주었습니다");
        return _몬스터;
    }

    public 캐릭터 캐릭터공격(캐릭터 _캐릭터, 몬스터 _몬스터) { // 몬스터 반격
        int _랜덤공격 = _캐릭터.공격받음(_캐릭터.전투중방어력, _몬스터.공격력, _캐릭터.회피율);
        _캐릭터.전투중체력 = _캐릭터.전투중체력 - _랜덤공격;
        System.out.println(_몬스터.이름 + "이(가) 반격합니다 데미지를 "
                + _랜덤공격 + "받았습니다");
        return _캐릭터;
    }

    public void 전투종료(몬스터 _몬스터, 캐릭터 _캐릭터, 아이템 _아이템) { //전투결과
        아이템 랜덤드랍 = _캐릭터.랜덤드랍(_몬스터.몬스터타입);
        int 획득골드 = _몬스터.골드;
        System.out.println("==============================");
        System.out.println(_몬스터.이름 + "을(를) 처치하였습니다");
        System.out.println("획득 경험치 " + _몬스터.경험치);
        System.out.println("획득 골드 " + 획득골드);
        System.out.println("획득 아이템 " + 랜덤드랍.이름);
        System.out.println("==============================");
        System.out.println("계속하려면 아무숫자나 입력하세요");
        _캐릭터.경험치 = _캐릭터.경험치 + _몬스터.경험치;
        _캐릭터.돈 = _캐릭터.돈 + 획득골드;
        _아이템.인벤토리.add(랜덤드랍);
        if (_캐릭터.경험치 >= _캐릭터.레벨업경험치) { //레벨업
            _캐릭터.경험치 = 0;
            _캐릭터.레벨 = _캐릭터.레벨 + 1;
            _캐릭터.레벨업경험치 = _캐릭터.레벨업경험치 * 2;
            _캐릭터.공격력 = _캐릭터.공격력 + 1;
            _캐릭터.방어력 = _캐릭터.방어력 + 1;
            _캐릭터.최대체력 = _캐릭터.최대체력 + 1;
            _캐릭터.최대마나 = _캐릭터.최대마나 + 1;
            _캐릭터.전투중체력 = _캐릭터.최대체력;
            _캐릭터.전투중마나 = _캐릭터.최대마나;
            _캐릭터.체력 = _캐릭터.최대체력;
            _캐릭터.마나 = _캐릭터.최대마나;
            System.out.println("============================");
            System.out.println("레벨업 하셨습니다");
            System.out.println("레벨이 " + _캐릭터.레벨 + "이 되었습니다");
            System.out.println("공격력이 " + _캐릭터.공격력 + "이 되었습니다");
            System.out.println("방어력이 " + _캐릭터.방어력 + "이 되었습니다");
            System.out.println("최대체력이 " + _캐릭터.최대체력 + "이 되었습니다");
            System.out.println("최대마나가 " + _캐릭터.최대마나 + "이 되었습니다");
            System.out.println("체력과 마나가 전부 회복되었습니다");
            System.out.println("============================");
        }
    }

    public void 스킬사용(스킬 _스킬목록, 캐릭터 _캐릭터) { //스킬목록 출력후 사용 메소드
        for (int i = 0; i < _스킬목록._스킬목록.size(); i++) {
            System.out.println(i + "." + _스킬목록._스킬목록.get(i).스킬이름);
        }
        System.out.println();
        System.out.println("사용할 스킬의 번호를 입력해주세요");
        입력 = in.nextInt(); //입력
        스킬 사용스킬 = _스킬목록._스킬목록.get(입력);
        System.out.println("스킬명 " + 사용스킬.스킬이름);
        System.out.println("스킬계열 " + 사용스킬.계열);
        System.out.println("스킬효과 " + 사용스킬.효과);
        System.out.println("스킬수치 " + 사용스킬.수치);
        System.out.println("아무숫자나 누르시면 사용됩니다");
        입력 = in.nextInt();

        if((사용스킬.효과 ==0 || 사용스킬.효과 == 1) && 사용스킬.스킬제한 == false) {
            _스킬목록.스킬사용(사용스킬.스킬이름, _캐릭터.전투중방어력, _캐릭터.전투중공격력, 사용스킬.마나소모, 사용스킬.수치, 사용스킬.효과, _캐릭터);
            사용스킬.스킬제한 = true;
            System.out.println(사용스킬.스킬이름+"의 사용횟수가 소진되었습니다");
        }
        else {
            System.out.println("사용이 불가능합니다");
        }
    }
    public void 퀵슬롯(아이템 _인벤토리, 캐릭터 _캐릭터){
        for (int i = 0; i < _인벤토리.전투인벤토리.size(); i++) {
            System.out.println(i+"."+_인벤토리.전투인벤토리.get(i).이름);
        }
        System.out.println("사용할 아이템 번호를 입력해주세요");
        입력 = in.nextInt();
        아이템 사용아이템 = _인벤토리.전투인벤토리.get(입력);
        System.out.println("스킬명: " + 사용아이템.이름);
        System.out.println("회복량: " + 사용아이템.체력회복);
        System.out.println("아이템설명: " + 사용아이템.설명);
        System.out.println("아무숫자나 누르시면 사용됩니다");
        입력 = in.nextInt();

        if (사용아이템.타입 == 3) { //체력포션 사용
            _캐릭터.전투중체력 = _캐릭터.포션꿀꺽(사용아이템.체력회복, _캐릭터.최대체력, _캐릭터.전투중체력);
            System.out.println(사용아이템.이름 + "을 사용하였습니다");
            사용아이템.전투인벤토리.remove(사용아이템);
        } else if (사용아이템.타입 == 4) { //마나포션 사용
            _캐릭터.전투중마나 = _캐릭터.포션꿀꺽(사용아이템.마나회복, _캐릭터.최대마나, _캐릭터.전투중마나);
            System.out.println(사용아이템.이름 + "을 사용하였습니다");
            사용아이템.전투인벤토리.remove(사용아이템); //3개씩 사용되는버그
        } // 포션 사용해도 삭제안되고 몹이 반격도안하고 아이템 설명도 안나옴 //아이템쪽에 생성자 고치기


    }
}
