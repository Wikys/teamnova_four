package com.teamnova.몬스터;

public class 몬스터_인카운터 extends 몬스터 {

    public 몬스터 고블린 ;
    public 몬스터 오크 ;
    public 몬스터 오우거 ;
    public static 몬스터 몬스터 = null;
//    public 몬스터 고블린킹 = new 고블린킹();
    public 몬스터 몬스터_인카운터() {
        String 몬스터이름 = null;


//        int _인카운터 = random.nextInt(2);
        int _인카운터 = (int)(Math.random()*3);
        if (true) {
              고블린 = new 고블린(); //다시나올때 피가 깎여있는것을 방지하기위해 이프문안에 생성
              오크 = new 오크();
              오우거 = new 오우거();
            if (_인카운터 == this.고블린.몬스터번호) {
                몬스터 = this.고블린.(몬스터)(몬스터_정보());
                몬스터이름 = this.고블린.이름;

            } else if (_인카운터 == this.오크.몬스터번호) {
                몬스터 = this.오크;
                몬스터이름 = this.오크.이름;
            } else if (_인카운터 == this.오우거.몬스터번호) {
                몬스터 = this.오우거;
                몬스터이름 = this.오우거.이름;
            }
        }


        System.out.println("탐색중 " + 몬스터이름 + "을(를) 마주쳤습니다!");
        System.out.println("전투를 시작합니다");
        return 몬스터;

    }

    @Override
    public void 몬스터_정보() {

    }

    @Override
    public void 몬스터_드랍() {

    }


}
