package com.teamnova.플레이어;

import com.teamnova.메뉴.메인메뉴;
import com.teamnova.몬스터.몬스터;
import com.teamnova.몬스터.몬스터_인카운터;
import com.teamnova.스킬.공격계열.무기파괴;
import com.teamnova.스킬.공격계열.사광연참;
import com.teamnova.스킬.공격계열.화염구;
import com.teamnova.스킬.스킬;
import com.teamnova.스킬.종족스킬.강조;
import com.teamnova.스킬.종족스킬.부정한기운;
import com.teamnova.스킬.종족스킬.사자의심장;
import com.teamnova.아이템.분류.가죽갑옷;
import com.teamnova.아이템.분류.낡은검;
import com.teamnova.아이템.아이템;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static com.teamnova.몬스터.몬스터.유저명;
import static com.teamnova.몬스터.몬스터_인카운터.몬스터;

public abstract class 캐릭터{ //구조체

    public Scanner in = new Scanner(System.in);
    public String 이름;
    public int 입력;
    public int 레벨;
    public int 공격력;

    public int 전투중공격력 = 공격력; // 버프스킬등의 사용으로 증가되는 공격력 // 초기값은 기본공격력
    public int 방어력;
    public int 전투중방어력 = 방어력; // 버프스킬등의 사용으로 증가되는 방어력
    public int 회피율;
    public int 전투중회피율 = 회피율; // 버프스킬등의 사용으로 증가되는 방어력
    public int 체력;
    public int 전투중체력 = 체력;
    public int 최대체력;
    public int 마나;
    public int 전투중마나 = 마나;
    public int 최대마나;
    public int 마법력;
    public int 전투중마법력 = 마법력;
    public int 돈;
    public int 경험치;
    public int 레벨업경험치; // 레벨 *5로 설정?
    public int 종족구분;
    public String 종족이름;
    public int 직업번호 = -1; // 0
    public int 종족;
    public String 직업이름 = "모험자"; //디폴트
    public int 전사의강직함;
    public int 몽크의기민함;
    public int 불사자의마력;
//    메인메뉴 메인메뉴 = new 메인메뉴();
    public ArrayList<아이템> 인벤토리 = new ArrayList<아이템>();
    public ArrayList<아이템> 장비창 = new ArrayList<아이템>();
    public ArrayList<아이템> 전투인벤토리 = new ArrayList<아이템>();
    public ArrayList<스킬> _버프스킬목록 = new ArrayList<>(); //스킬 어레이
    public ArrayList<스킬> _회복스킬목록 = new ArrayList<>();
    public ArrayList<스킬> _공격스킬목록 = new ArrayList<>();
    public ArrayList<스킬> _종족스킬목록 = new ArrayList<>();
    스킬 무기파괴 = new 무기파괴("무기파괴");
    스킬 사광연참 = new 사광연참("사광연참");
    스킬 화염구 = new 화염구("화염구");
    스킬 강조 = new 강조("강조"); //기본스킬
    스킬 부정한기운 = new 부정한기운("부정한기운");
    스킬 사자의심장 = new 사자의심장("사자의심장");

    public boolean 종족스킬_제한 = true;

    public Random random = new Random();
    아이템 낡은검 = new 낡은검();
    아이템 가죽갑옷 = new 가죽갑옷();
//    public 스킬 용기 = new 스킬("용기", 5, 1 , 3, false, 1,"용기가 차오릅니다 방어력이 1 증가합니다");

    public 캐릭터() {

    }

    public abstract void 스탯(캐릭터 유저명);

    public ArrayList<아이템> 기본아이템(ArrayList<아이템> _인벤토리) {
        _인벤토리.add(낡은검);
        _인벤토리.add(가죽갑옷);
        this._공격스킬목록.add(사광연참);
        this._공격스킬목록.add(화염구);
        this._공격스킬목록.add(무기파괴);
        System.out.println("기본아이템이 지급되었습니다");
        System.out.println("기본스킬이 지급되었습니다");
        if (this.종족 == 0){
            this._종족스킬목록.add(사자의심장);
            System.out.println("종족스킬 사자의심장 획득하셨습니다");
        }
        else if (this.종족 == 1){
            this._종족스킬목록.add(강조);
            System.out.println("종족스킬 강조 획득하셨습니다");
        }
        else if (this.종족 == 2){
            this._종족스킬목록.add(부정한기운);
            System.out.println("종족스킬 부정한기운 획득하셨습니다");
        }
        return _인벤토리;
    }

    public int 공격받음(int _방어력, int _적공격력, int _회피율) {
//        몬스터 몬스터 = new 몬스터();
        int 회피 = random.nextInt(100) + 1;

        if (this.전투중방어력 >= _적공격력) {
            _적공격력 = 0; //방어력이 적 공격력보다 높으면 데미지0
        } else if (회피 <= _회피율) {
            _적공격력 = 0; //회피하면 순간 적공격력 0으로 처리
            System.out.println("몬스터의 공격을 완벽하게 회피하였습니다");
        } else {
//            _체력 = _체력 + this.전투중방어력 - _적공격력; //적공격력이 더높으면 방어력-적공격력만큼 받음
            _적공격력 = _적공격력 - _방어력;
        }
        return _적공격력;
    }

    public int 몬스터공격() { //몬스터 공격 메세지 출력 // 일반적인 공격할때 이거씀

        int _랜덤공격 = 몬스터_인카운터.몬스터.몹공격받음(몬스터_인카운터.몬스터.방어력, 유저명.전투중공격력, 몬스터_인카운터.몬스터.회피율);
        몬스터_인카운터.몬스터.체력 = 몬스터_인카운터.몬스터.체력 - _랜덤공격;
        System.out.println(몬스터_인카운터.몬스터.이름 + "을(를) 공격하셨습니다 데미지를 "
                + _랜덤공격 + "주었습니다");

    return _랜덤공격;
    }
//    public void run() {
//        while(true) {
//            this.몬스터공격();
//            if(몬스터.체력 <=0 || this.체력 <= 0){
//                this.interrupt();
//                break;
//            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }


    public boolean 보스_컨텐츠해금(int _캐릭터레벨, boolean _해금) { //캐릭터레벨이 5일때 고블린킹 컨텐츠해금


        if (_캐릭터레벨 == 5) {
            System.out.println("5레벨이 되어 고블린킹 보스가 해금되었습니다");
            System.out.println("앞으로 탐색에서 일정확률로 해당보스가 등장합니다");
            _해금 = false;

        } else if (_캐릭터레벨 < 5) {
            System.out.println("5레벨에 보스컨텐츠가 해금됩니다");
            _해금 = true;
        }
        return _해금;
    }




}






