package com.teamnova.아이템;


public abstract class 아이템 {
    public String 이름;
    public int 타입;  // 1:무기 2:방어구 3:체력포션 4:마나포션
    public int 공격력;
    public int 방어력;
    public int 마법력;
    public int 체력회복;
    public int 마나회복;
    public int 아이템번호; //1 부터
    public int 가격;
    public int 마법무기; //0: 일반무기 1: 마법무기
    public int 특수; // 0: 일반아이템, 1:특수아이템 2:보스드랍전용
    public int 수치;
    public String 설명;
    //    boolean 중복장착 = false;
    public boolean 무기중복 = false;
    public boolean 방어구중복 = false;
//    public ArrayList<아이템> 인벤토리 = new ArrayList<아이템>();
//    public ArrayList<아이템> 장비창 = new ArrayList<아이템>();
//    public ArrayList<아이템> 전투인벤토리 = new ArrayList<아이템>();
    //   ArrayList<아이템> 드랍테이블 = new ArrayList<아이템>();


    public abstract void 아이템_효과();
    public abstract void 아이템_장착해제();
    public abstract void 아이템_설명();


    public 아이템() {

    }

    public 아이템(String 이름, int 타입, int 아이템번호, int 수치, String 설명, int 가격, int 마법무기) { //아이템타입,번호,수치 갈라서 어떤종류의 아이템인지 갈라주는 생성자
        this.이름 = 이름;
        this.타입 = 타입;
        this.아이템번호 = 아이템번호;
        this.설명 = 설명;
        this.가격 = 가격;
        this.마법무기 = 마법무기;

        if (타입 == 1) { //무기
            if (마법무기 == 0) {
                if (아이템번호 == 0) {
                    this.공격력 = 수치;
                } else if (아이템번호 == 1) {
                    this.공격력 = 수치;
                } else if (아이템번호 == 2) {
                    this.공격력 = 수치;
                }
            } else if (마법무기 == 1) {
                if (아이템번호 == 3) {
                    this.마법력 = 수치;
                }
            }
        } else if (타입 == 2) { //방어구
            if (아이템번호 == 100) {
                this.방어력 = 수치;
            } else if (아이템번호 == 101) {
                this.방어력 = 수치;
            }
        } else if (타입 == 3) { //포션류
            if (아이템번호 == 900) {
                this.체력회복 = 수치;
            }

        } else if (타입 == 4) {
            if (아이템번호 == 901) {
                this.마나회복 = 수치;
            }
        }

    }

    public 아이템(int 가격) {

        this.가격 = 가격;
    }



}
