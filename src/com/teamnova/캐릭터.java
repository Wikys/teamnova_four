package com.teamnova;
import java.util.ArrayList;

public class 캐릭터 { //구조체
    String 이름;
    int 레벨 = 1;
    int 공격력 = 5;
    int 전투중공격력 = 공격력; // 버프스킬등의 사용으로 증가되는 공격력 // 초기값은 기본공격력
    int 방어력 = 0;
    int 전투중방어력 = 방어력; // 버프스킬등의 사용으로 증가되는 방어력

    int 회피율 = 5;
    int 전투중회피율 = 회피율; // 버프스킬등의 사용으로 증가되는 방어력
    int 체력 = 10;
    int 전투중체력 = 체력;
    int 최대체력 = 10;
    int 마나 = 10;
    int 전투중마나 = 마나;
    int 최대마나 = 10;
    int 돈 = 10;
    int 경험치 = 0;
    int 레벨업경험치; // 레벨 *5로 설정?
    아이템 낡은검 = new 아이템("낡은검", 1, 0, 1); // 아이템호출
    아이템 철검 = new 아이템("철검", 1, 1, 3);
    아이템 가죽갑옷 = new 아이템("가죽갑옷", 2, 100, 2);
    아이템 철갑옷 = new 아이템("철갑옷", 2, 101, 5);
    아이템 체력포션 = new 아이템("체력포션",3,900,5);
    아이템 마나포션 = new 아이템("마나포션",4,901,5);

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

        System.out.println("이름 = " + this.이름);
        System.out.println("레벨 = " + this.레벨); //최대레벨 표시
        System.out.println("공격력 = " + this.공격력); //크리티컬 시스템 추가?
        System.out.println("방어력 = " + this.방어력);
        System.out.println("회피율 = " + this.회피율);
        System.out.println("체력 = " + this.체력); //최대체력 표시
        System.out.println("최대체력 = " + this.최대체력);
        System.out.println("마나 = " + this.마나); //최대마나 표시
        System.out.println("최대마나 = " + this.최대마나);
        System.out.println("경험치 = " + this.경험치 + "/" + this.레벨업경험치); //최대경험치 표시

    }

    public int 공격() { //평타 메소드


        return 전투중공격력; // 스킬공격 추가?

    }

    public int 공격받음(int _체력, int _적공격력) {
//        몬스터 몬스터 = new 몬스터();

        if (this.전투중방어력 >= _적공격력) {
            _체력 = this.전투중체력 - 0; //방어력이 적 공격력보다 높으면 데미지0
        } else {
            _체력 = this.전투중체력 + this.전투중방어력 - _적공격력; //적공격력이 더높으면 방어력-적공격력만큼 받음
        }
        return _체력;
    }

    int 체력회복() { // 휴식
        return 최대체력;
    }

    int 마나회복() {// 휴식
        return 최대마나;
    }

    public int 포션꿀꺽(int 포션회복량, int 최대체마, int 전투체마){ // 포션회복 함수
        int _회복량 = 0;
        if(최대체마 == 전투체마 ){ // 최대 체력,마나가 현재 체력마나와 같으면 0 리턴
            _회복량 = 최대체마;
        }
        else if(포션회복량+전투체마 > 최대체마){ // 포션회복량으로 최대체력 넘길거같으면 그냥 최대체력 리턴
            _회복량 = 최대체마;
        }else { // 아니면 그냥 포션회복량 +
         _회복량 =  전투체마 + 포션회복량;
        }


        return _회복량;
    }


    }





