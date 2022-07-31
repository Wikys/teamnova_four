package com.teamnova;
import java.util.Scanner;

public class 메인메뉴 {
    Scanner in = new Scanner(System.in);
    boolean 전투종료 = false;
    int 입력;

    public void 행동메뉴() {
        System.out.println("행동을 선택해주세요");
        System.out.println("1.탐색");
        System.out.println("2.휴식");
        System.out.println("3.상점");
        System.out.println("4.소지품");
        System.out.println("5.스테이터스");
        System.out.println("6.장비");
        System.out.println("7.스킬");
        System.out.println("0.끝내기");
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
    public void 스테이터스(캐릭터 _캐릭터){ //캐릭터의 스테이터스창
            System.out.println("이름 = " + _캐릭터.이름);
            System.out.println("레벨 = " + _캐릭터.레벨); //최대레벨 표시
            System.out.println("공격력 = " + _캐릭터.공격력); //크리티컬 시스템 추가?
            System.out.println("방어력 = " + _캐릭터.방어력);
            System.out.println("회피율 = " + _캐릭터.회피율);
            System.out.println("체력 = " + _캐릭터.체력+"/"+_캐릭터.최대체력); //최대체력 표시
            System.out.println("마나 = " + _캐릭터.마나+"/"+_캐릭터.최대마나); //최대마나 표시
            System.out.println("경험치 = " + _캐릭터.경험치 + "/" + _캐릭터.레벨업경험치); //최대경험치 표시
    }
    public void 소지품창(아이템 _아이템){
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
        if (입력 == 1){
            System.out.println("====================");
            for (int i = 0; i < _아이템.인벤토리.size(); i++) {
                System.out.println(i + "." + _아이템.인벤토리.get(i).이름);
            }
            System.out.println("====================");
            System.out.println("장착하실 아이템의 번호를 입력하세요");
            입력 = in.nextInt();
            아이템 장착아이템 = _아이템.인벤토리.get(입력);
            if(장착아이템.타입 == 1) {
                System.out.println("아이템명: " + 장착아이템.이름);
                System.out.println("공격력: " + 장착아이템.공격력);
                System.out.println("아이템 설명: " + 장착아이템.설명);
                System.out.println(장착아이템.이름+" 장착 되었습니다");
                //공방적용
                this.소지품창(_아이템);
            }
            if(장착아이템.타입 == 2){
                System.out.println("아이템명: " + 장착아이템.이름);
                System.out.println("방어력: " + 장착아이템.방어력);
                System.out.println("아이템 설명: " + 장착아이템.설명);
                System.out.println(장착아이템.이름+" 장착 되었습니다");
                //공방적용
                this.소지품창(_아이템);
            }
            else if (장착아이템.타입 == 3){
                System.out.println("포션류는 장착이 불가능합니다");
                this.소지품창(_아이템);
            }
            else if (장착아이템.타입 == 4){
                System.out.println("포션류는 장착이 불가능합니다");
                this.소지품창(_아이템);
            }
        }
        else if (입력 == 2){
            System.out.println("====================");
            for (int i = 0; i < _아이템.인벤토리.size(); i++) {
                System.out.println(i + "." + _아이템.인벤토리.get(i).이름);
            }
            System.out.println("====================");
            System.out.println("버리실 아이템의 번호를 입력하세요");
            입력 = in.nextInt();
            아이템 버릴아이템 = _아이템.인벤토리.get(입력);

        }
    }
}

//for (int i = 0; i < 아이템.인벤토리.size(); i++) {
//        System.out.println("아이템 이름: " + i + ". " + 아이템.인벤토리.get(i).이름);
//        }
//        // 일단 이름만 띄워주고 숫자입력하면 장착하시겠습니까 띄우고 거기서 정보주기
//
//        System.out.println("1.아이템장착"); //배열 삭제하면서 플레이어에게 효과적용
//        System.out.println("2.아이템버리기"); //배열삭제로 구현?
//        System.out.println("3.퀵슬롯장착"); // 전투인벤토리로 보내기
//        System.out.println("0. 메인으로 가기");
//        System.out.println("포션은 마을에서 사용하실수 없습니다");
//
//        선택 = in.nextInt();
