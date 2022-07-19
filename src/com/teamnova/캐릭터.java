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
    int 레벨업경험치;


    //종족 구조체 만들고 메인에서 이프문으로 메소드로 연결?
    public void 스테이터스() {
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
    }

    public int 공격() { //평타 메소드
        return 공격력; // 스킬공격 추가?

    }

    public void 공격받음(int sum) {
        if (방어력 >= sum) {
            체력 = 체력 - 0; //방어력이 적 공격력보다 높으면 데미지0
        } else {
            체력 = 체력 + 방어력 - sum; //적공격력이 더높으면 방어력-적공격력만큼 받음
        }
    }

    int 체력회복() { // 휴식
        return 최대체력;
    }

    int 마나회복() {// 휴식
        return 최대마나;
    }

    public ArrayList<String> 소지품() {

        ArrayList<String> 소지품 = new ArrayList<String>();
        아이템 아이템 = new 아이템();
        소지품.add(아이템.낡은검() + "/타입: " + 아이템.타입);
        소지품.add(아이템.체력포션() + "/타입: " + 아이템.타입);
      //  System.out.println(소지품);
        return 소지품;
    }
//    public String 아이템획득(){
//        아이템 아이템 = new 아이템();
//        this.소지품().add();
//        return 소지품().add();
//    }
}





