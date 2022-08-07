package com.teamnova.플레이어;

import com.teamnova.메뉴.메인메뉴;
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

public abstract class 캐릭터 { //구조체
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
    public int 직업번호; // 0
    public int 종족;
    public String 직업이름;
    public int 전사의강직함;
    public int 몽크의기민함;
    public int 불사자의마력;
    메인메뉴 메인메뉴 = new 메인메뉴();
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
    //     public static 아이템 낡은검 = new 아이템("낡은검", 1, 0, 1, "다 낡아빠진 검이다",0,0); // 아이템호출
//     public static 아이템 철검 = new 아이템("철검", 1, 1, 3, "단단한 철로 만들어진 날카로운 검이다",10,0);
//     public static 아이템 고블린왕의_몽둥이 = new 아이템("고블린왕의_몽둥이", 1, 2, 5, "조악해 보이지만 한 종족의 왕이 썻던 무기인만큼 튼튼하다",0,0);
//     public static 아이템 가죽갑옷 = new 아이템("가죽갑옷", 2, 100, 2, "초급 모험가들이 즐겨입는 가죽갑옷이다",15,0);
//     public static 아이템 철갑옷 = new 아이템("철갑옷", 2, 101, 5, "철로 만들어져 꽤 강력한 공격까지 막아낼수 있을듯하다",30,0);
//     public static 아이템 체력포션 = new 아이템("체력포션",3,900,5, "단순히 체력이 조금 회복될뿐인 싸구려 포션이다",5,0);
//     public static 아이템 마나포션 = new 아이템("마나포션",4,901,5, "단순히 마나가 조금 회복될뿐인 싸구려 포션이다",5,0);
//     public static 아이템 조악한_완드 = new 아이템("조악한_완드",1,3,5,"허접하게 만들어진 완드지만 조금의 마법력은 남아있는듯하다",20,1);
    public Random random = new Random();
    아이템 낡은검 = new 낡은검();
    아이템 가죽갑옷 = new 가죽갑옷();
//    public 스킬 용기 = new 스킬("용기", 5, 1 , 3, false, 1,"용기가 차오릅니다 방어력이 1 증가합니다");

    public 캐릭터() {

    }

    public abstract void 스탯(캐릭터 _캐릭터);

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
            System.out.println("완벽하게 회피하였습니다");
        } else {
//            _체력 = _체력 + this.전투중방어력 - _적공격력; //적공격력이 더높으면 방어력-적공격력만큼 받음
            _적공격력 = _적공격력 - _방어력;
        }
        return _적공격력;
    }
//    public int 포션꿀꺽(int 포션회복량, int 최대체마, int 전투체마){ // 포션회복 함수
//        int _회복량 = 0;
//        if(최대체마 == 전투체마 ){ // 최대 체력,마나가 현재 체력마나와 같으면 0 리턴
//            _회복량 = 최대체마;
//        }
//        else if(포션회복량+전투체마 > 최대체마){ // 포션회복량으로 최대체력 넘길거같으면 그냥 최대체력 리턴
//            _회복량 = 최대체마;
//        }else { // 아니면 그냥 포션회복량 +
//         _회복량 =  전투체마 + 포션회복량;
//        }
//        return _회복량;
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






