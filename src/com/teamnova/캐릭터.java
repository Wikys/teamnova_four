package com.teamnova;
import java.util.ArrayList;

public class 캐릭터 { //구조체
    String 이름;
    int 레벨;
    int 공격력;
    int 방어력;
    int 회피율;
    int 체력;
    int 최대체력;
    int 마나;
    int 최대마나;
    int 돈;
    int 경험치;
    int 레벨업경험치 = 레벨 * 5;

    public 캐릭터(String _이름, int _레벨, int _공격력, int _방어력, int _회피율, int _체력, int _최대체력, int _마나, int _최대마나, int _돈, int _경험치, int _레벨업경험치) {
        this.이름 = _이름;
        this.레벨 = _레벨;
        this.공격력 = _공격력;
        this.방어력 = _방어력;
        this.회피율 = _회피율;
        this.체력 = _체력;
        this.최대체력 = _최대체력;
        this.마나 = _마나;
        this.최대마나 = _최대마나;
        this.돈 = _돈;
        this.경험치 = _경험치;
        this.레벨업경험치 = _레벨업경험치;
    }

    public 캐릭터() {

    }


    //종족 구조체 만들고 메인에서 이프문으로 메소드로 연결?
    public void 스테이터스() {
        스킬 스킬 = new 스킬();
        System.out.println("이름 = " + 이름);
        System.out.println("레벨 = " + 레벨); //최대레벨 표시
        System.out.println("공격력 = " + 공격력); //크리티컬 시스템 추가?
        System.out.println("방어력 = " + 방어력);
        System.out.println("회피율 = " + 회피율);
        System.out.println("체력 = " + 체력); //최대체력 표시
        System.out.println("최대체력 = " + 최대체력);
        System.out.println("마나 = " + 마나); //최대마나 표시
        System.out.println("최대마나 = " + 최대마나);
        System.out.println("경험치 = " + 경험치 + "/" + 레벨업경험치); //최대경험치 표시
        System.out.println("보유스킬 = ");
    }

    public int 공격() { //평타 메소드


        return 공격력; // 스킬공격 추가?

    }

    public int 공격받음(int _체력, int _적공격력) {
//        몬스터 몬스터 = new 몬스터();

        if (this.방어력 >= _적공격력) {
            _체력 = this.체력 - 0; //방어력이 적 공격력보다 높으면 데미지0
        } else {
            _체력 = this.체력 + this.방어력 - _적공격력; //적공격력이 더높으면 방어력-적공격력만큼 받음
        }
        return _체력;
    }

    int 체력회복() { // 휴식
        return 최대체력;
    }

    int 마나회복() {// 휴식
        return 최대마나;
    }

//    캐릭터(int 아이템번호, String 아이템이름){ // 소지품
//        아이템 소지품 = new 아이템();
//        소지품.아이템번호 = 아이템번호;
//        소지품.이름 = 아이템이름;
//        ArrayList<캐릭터> 인벤토리 = new ArrayList<>();

    }

//    public ArrayList<String> 소지품() {
//
//        ArrayList<String> 소지품 = new ArrayList<String>();
//        아이템 아이템 = new 아이템();
//        ArrayList<소지품> 인벤토리 = new ArrayList<>();
//
//        소지품.add(아이템.낡은검() + "/타입: " + 아이템.타입);
//        소지품.add(아이템.체력포션() + "/타입: " + 아이템.타입);
//      //  System.out.println(소지품);
//        return 소지품;
//    }

//    public String 아이템획득(){
//        아이템 아이템 = new 아이템();
//        this.소지품().add();
//        return 소지품().add();
//    }
//}





