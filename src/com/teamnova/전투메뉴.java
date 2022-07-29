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
        _캐릭터.전투중체력 = _캐릭터.전투중체력 - _캐릭터.공격받음(_캐릭터.방어력, _몬스터.공격력, _캐릭터.회피율);
        System.out.println(_몬스터.이름 + "이(가) 반격합니다 데미지를 "
                + _캐릭터.공격받음(_캐릭터.방어력, _몬스터.공격력, _캐릭터.회피율) + "받았습니다");
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

        System.out.println(사용스킬.스킬이름+"을(를) 정말 사용하시겠습니까?");
        System.out.println("1. 예");
        System.out.println("2. 아니오");
        입력 = in.nextInt();
        if (입력 == 1){
            _스킬목록.스킬사용(사용스킬.스킬이름,_캐릭터.방어력,_캐릭터.공격력,); // 여기서부터 하자
        }


    }

//    public void 레벨업(캐릭터 _캐릭터) {
//        _캐릭터.경험치 = 0;
//        _캐릭터.레벨 = _캐릭터.레벨 + 1;
//        _캐릭터.레벨업경험치 = _캐릭터.레벨업경험치 * 2;
//        _캐릭터.공격력 = _캐릭터.공격력 + 1;
//        _캐릭터.방어력 = _캐릭터.방어력 + 1;
//        _캐릭터.최대체력 = _캐릭터.최대체력 + 1;
//        _캐릭터.최대마나 = _캐릭터.최대마나 + 1;
//        _캐릭터.전투중체력 = _캐릭터.최대체력;
//        _캐릭터.전투중마나 = _캐릭터.최대마나;
//        System.out.println("============================");
//        System.out.println("레벨업 하셨습니다");
//        System.out.println("공격력이 "+_캐릭터.공격력+"이 되었습니다");
//        System.out.println("방어력이 "+_캐릭터.방어력+"이 되었습니다");
//        System.out.println("최대체력이 "+_캐릭터.최대체력+"이 되었습니다");
//        System.out.println("최대마나가 "+_캐릭터.최대마나+"이 되었습니다");
//        System.out.println("체력과 마나가 전부 회복되었습니다");
//        System.out.println("============================");
//    }


}
//    int 랜덤공격 = 생성.몹공격받음(생성.방어력, 유저명.전투중공격력);
//    int 적남은체력 = 생성.체력 - 랜덤공격;
//    int 랜덤피해 = 유저명.공격받음(유저명.전투중방어력, 생성.공격력, 유저명.회피율);
//    int 내남은체력 = 유저명.전투중체력 - 랜덤피해;
//
//   System.out.println(생성.이름 + "을(를) 공격하였습니다 데미지를 " + 랜덤공격 + " 주었습니다"); //연산후 저장해서 루프처음으로
//   생성.체력 = 적남은체력;