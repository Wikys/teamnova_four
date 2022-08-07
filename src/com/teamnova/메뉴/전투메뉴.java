package com.teamnova.메뉴;

import com.teamnova.몬스터.몬스터;
import com.teamnova.몬스터.보스.보스;
import com.teamnova.스킬.스킬;
import com.teamnova.아이템.아이템;
import com.teamnova.플레이어.캐릭터;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class 전투메뉴 {
    메인메뉴 메인메뉴 = new 메인메뉴();
    Random random = new Random();

//    몬스터 몬스터= new 몬스터();
//    스킬 화염구 = new 화염구("화염구");

    Scanner in = new Scanner(System.in);
    int 입력;
    boolean 도주카운터 = true;


    public 캐릭터 캐릭터_전투_스테이터스(캐릭터 _플레이어) {
        System.out.println("=====================");
        System.out.println("이름 : " + _플레이어.이름);
        System.out.println("체력 : " + _플레이어.전투중체력);
        System.out.println("마나 : " + _플레이어.전투중마나);
        System.out.println("공격력 : " + _플레이어.전투중공격력);
        System.out.println("마법력 : " + _플레이어.전투중마법력);
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
        System.out.println("====================");
        System.out.println("1.공격");
        System.out.println("2.아이템사용");
        System.out.println("3.도주하기");
        System.out.println("====================");
    }

    public void 전투방식() {
        System.out.println("어떻게 공격하시겠습니까");
        System.out.println("====================");
        System.out.println("1.공격");
        System.out.println("2.스킬사용");
        System.out.println("====================");
    }

    public void 몬스터공격(캐릭터 _캐릭터, 몬스터 _몬스터) { //몬스터 공격 메세지 출력 // 일반적인 공격할때 이거씀

        int _랜덤공격 = _몬스터.몹공격받음(_몬스터.방어력, _캐릭터.전투중공격력, _몬스터.회피율);
        _몬스터.체력 = _몬스터.체력 - _랜덤공격;
        System.out.println(_몬스터.이름 + "을(를) 공격하셨습니다 데미지를 "
                + _랜덤공격 + "주었습니다");

        return;
    }
//    public void 보스의공격(캐릭터 _캐릭터, 몬스터 _몬스터){
//        int _랜덤공격 = _캐릭터.공격받음(_캐릭터.전투중방어력,_몬스터.공격력, _캐릭터.회피율);
//        if (_몬스터.체력 > 0){
//            _캐릭터.전투중체력 =
//        }
//    }

    public void 캐릭터공격(캐릭터 _캐릭터, 몬스터 _몬스터) { // 몬스터 반격
        int _랜덤공격 = _캐릭터.공격받음(_캐릭터.전투중방어력, _몬스터.공격력, _캐릭터.회피율);
        if (_몬스터.체력 > 0 && _몬스터.몬스터타입 == 0) {
            _캐릭터.전투중체력 = _캐릭터.전투중체력 - _랜덤공격;
            System.out.println(_몬스터.이름 + "이(가) 반격합니다 데미지를 "
                    + _랜덤공격 + "받았습니다");
        }
        else if(_몬스터.체력 > 0 && _몬스터.몬스터타입 == 1){
            int 스킬 = random.nextInt(100);
            if(스킬 < 30){
                ((보스)_몬스터).보스_스킬(_캐릭터);
            }
            else if (스킬 >= 30){
                _캐릭터.전투중체력 = _캐릭터.전투중체력 - _랜덤공격;
                System.out.println(_몬스터.이름 + "이(가) 반격합니다 데미지를 "
                        + _랜덤공격 + "받았습니다");
            }
        }

        else if (_몬스터.체력 <= 0) { //전투종료시 재화획득

            this.전투종료(_몬스터, _캐릭터);


        }
        return;
    }

    public void 전투종료(몬스터 _몬스터, 캐릭터 _캐릭터) { //전투결과

        int 획득골드 = _몬스터.골드;
        System.out.println("==============================");
        System.out.println(_몬스터.이름 + "을(를) 처치하였습니다");
        System.out.println("획득 경험치 " + _몬스터.경험치);
        System.out.println("획득 골드 " + 획득골드);
//        System.out.println("획득 아이템 " + 랜덤드랍.이름);
        _몬스터.몬스터_드랍(_캐릭터);
        System.out.println("==============================");

        _캐릭터.경험치 = _캐릭터.경험치 + _몬스터.경험치;
        _캐릭터.돈 = _캐릭터.돈 + 획득골드;
//        _캐릭터.인벤토리.add(랜덤드랍);
        if (_캐릭터.경험치 >= _캐릭터.레벨업경험치) { //레벨업
            _캐릭터.경험치 = 0;
            _캐릭터.레벨 = _캐릭터.레벨 + 1;
            _캐릭터.레벨업경험치 = _캐릭터.레벨업경험치 * 2;
            _캐릭터.공격력 = _캐릭터.공격력 + 1;
            _캐릭터.방어력 = _캐릭터.방어력 + 1;
            _캐릭터.마법력 = _캐릭터.마법력 + 1;
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
            System.out.println("방어력이 " + _캐릭터.마법력 + "이 되었습니다");
            System.out.println("최대체력이 " + _캐릭터.최대체력 + "이 되었습니다");
            System.out.println("최대마나가 " + _캐릭터.최대마나 + "이 되었습니다");
            System.out.println("체력과 마나가 전부 회복되었습니다");
            System.out.println("============================");

        }

    }

    public void 스킬사용(캐릭터 _캐릭터, 몬스터 _몬스터, ArrayList<스킬> _공격스킬목록, ArrayList<스킬> _버프스킬목록, ArrayList<스킬> _회복스킬목록, ArrayList<스킬> _종족스킬목록) { //스킬목록 출력후 사용 메소드

        System.out.println("1.공격계열");
        System.out.println("2.버프계열");
        System.out.println("3.회복계열");
        System.out.println("4.종족스킬");
        입력 = in.nextInt();
        if (입력 == 1) {
//            _공격스킬목록.add(this.화염구);
            for (int i = 0; i < _공격스킬목록.size(); i++) {
                System.out.println(i + "." + _공격스킬목록.get(i).스킬이름);
            }
            System.out.println();
            System.out.println("사용할 스킬의 번호를 입력해주세요");
            입력 = in.nextInt(); //입력
            스킬 사용스킬 = _공격스킬목록.get(입력);
            사용스킬.스킬설명();
            System.out.println("아무숫자나 누르시면 사용됩니다");
            입력 = in.nextInt();
            사용스킬.스킬효과(_캐릭터, _몬스터);
//                this.캐릭터공격(_캐릭터, _몬스터, _아이템); //스킬사용즉시 적반격

        } else if (입력 == 2) {
            //버프스킬 어레이
            for (int i = 0; i < _버프스킬목록.size(); i++) {
                System.out.println(i + "." + _버프스킬목록.get(i).스킬이름);
            }
            System.out.println();
            System.out.println("사용할 스킬의 번호를 입력해주세요");
            입력 = in.nextInt(); //입력
            스킬 사용스킬 = _버프스킬목록.get(입력);
            사용스킬.스킬설명();
            System.out.println("아무숫자나 누르시면 사용됩니다");
            입력 = in.nextInt();
            사용스킬.스킬효과(_캐릭터, _몬스터);
//                this.캐릭터공격(_캐릭터, _몬스터, _아이템); //스킬사용즉시 적반격

        } else if (입력 == 3) {
            //회복스킬 어레이
            for (int i = 0; i < _회복스킬목록.size(); i++) {
                System.out.println(i + "." + _회복스킬목록.get(i).스킬이름);
            }
            System.out.println();
            System.out.println("사용할 스킬의 번호를 입력해주세요");
            입력 = in.nextInt(); //입력
            스킬 사용스킬 = _회복스킬목록.get(입력);
            사용스킬.스킬설명();
            System.out.println("아무숫자나 누르시면 사용됩니다");
            입력 = in.nextInt();
            사용스킬.스킬효과(_캐릭터, _몬스터);
//                this.캐릭터공격(_캐릭터, _몬스터, _아이템); //스킬사용즉시 적반격

        } else if (입력 == 4) {
            for (int i = 0; i < _종족스킬목록.size(); i++) {
                System.out.println(i + "." + _종족스킬목록.get(i).스킬이름);
            }
            System.out.println();
            System.out.println("사용할 스킬의 번호를 입력해주세요");
            입력 = in.nextInt(); //입력
            스킬 사용스킬 = _종족스킬목록.get(입력);
            사용스킬.스킬설명();
            System.out.println("아무숫자나 누르시면 사용됩니다");
            입력 = in.nextInt();
            사용스킬.스킬효과(_캐릭터, _몬스터);
//                this.캐릭터공격(_캐릭터, _몬스터, _아이템); //스킬사용즉시 적반격

        } else {
            System.out.println("잘못 입력하셨습니다");
        }

    }


    public void 퀵슬롯(캐릭터 _캐릭터) {
        for (int i = 0; i < _캐릭터.전투인벤토리.size(); i++) {
            System.out.println(i + "." + _캐릭터.전투인벤토리.get(i).이름);
        }
        System.out.println("사용할 아이템 번호를 입력해주세요");
        입력 = in.nextInt();
        아이템 사용아이템 = _캐릭터.전투인벤토리.get(입력);
        System.out.println("====================");
        System.out.println("아이템명: " + 사용아이템.이름);
        System.out.println("회복량: " + 사용아이템.체력회복);
        System.out.println("아이템 설명: " + 사용아이템.설명);
        System.out.println("====================");
        System.out.println("아무숫자나 누르시면 사용됩니다");
        입력 = in.nextInt();

        사용아이템.아이템_효과(_캐릭터);
        _캐릭터.전투인벤토리.remove(사용아이템);

//        if (사용아이템.타입 == 3) { //체력포션 사용
////            _캐릭터.전투중체력 = _캐릭터.포션꿀꺽(사용아이템.체력회복, _캐릭터.최대체력, _캐릭터.전투중체력);
////            System.out.println(사용아이템.이름 + "을 사용하였습니다");
//            사용아이템.아이템_효과(_캐릭터);
//            _캐릭터.전투인벤토리.remove(사용아이템);
//        } else if (사용아이템.타입 == 4) { //마나포션 사용
////            _캐릭터.전투중마나 = _캐릭터.포션꿀꺽(사용아이템.마나회복, _캐릭터.최대마나, _캐릭터.전투중마나);
////            System.out.println(사용아이템.이름 + "을 사용하였습니다");
////            사용아이템.아이템_효과(_캐릭터);
//            _캐릭터.전투인벤토리.remove(사용아이템);
//        }


    }

    public void 도주(메인메뉴 _전투종료) {
        System.out.println("도주를 시도합니다");
        int 도주확률 = random.nextInt(100);

        if (도주확률 <= 50 && this.도주카운터 == true) { // 도주확률이 50안쪽이면 도망성공
            System.out.println("도주에 성공하셨습니다");
            _전투종료.전투종료 = true;
        } else if (도주확률 > 50 && 도주카운터 == true) { // 도주카운터가 51~100이뜨면 도주실패
            System.out.println("도주에 실패하셨습니다");
            도주카운터 = false;
            _전투종료.전투종료 = false;
        } else if (this.도주카운터 == false) { // 도주시도는 단 한번만 가능
            System.out.println("이미 적에게 발각당하셨습니다");
            System.out.println("도망칠수 없습니다");
            _전투종료.전투종료 = false;
        }

    }
}
