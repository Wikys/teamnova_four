package com.teamnova.메뉴;

import com.teamnova.몬스터.몬스터;
import com.teamnova.몬스터.보스.고블린킹;
import com.teamnova.플레이어.캐릭터;

public class 보스전 extends 전투메뉴{
    

    public void 보스메뉴(캐릭터 _캐릭터){

        if (_캐릭터.레벨 >= 0){
            몬스터 보스 = null;
            System.out.println("도전할 보스를 선택해주세요");
            System.out.println("1.고블린킹");
            System.out.println();
            System.out.println("0.나가기");
            this.입력 = in.nextInt();
            switch (입력){
                case 1: 보스 = new 고블린킹();
                보스.몬스터_정보(보스);
                break;

                case 0 : return;
            }
            while (true){

                this.캐릭터_전투_스테이터스(_캐릭터);
                this.몬스터_전투_스테이터스(보스);
                this.전투행동();
                입력 = in.nextInt();
                switch (입력){
                    case 1: this.몬스터공격(_캐릭터, 보스);
                    this.캐릭터공격(_캐릭터,보스);
                    _캐릭터.끄아악();
                    보스.브아악(_캐릭터);
                    case 2: this.퀵슬롯(_캐릭터);
                        this.캐릭터공격(_캐릭터, 보스);
                }
            }
        }
        else{
            System.out.println("잘못된 접근입니다");
        }

    }


    //캐릭터레벨이 5이상일때만 선택가능하게끔 이프문처리
    //5미만이면 10눌럿을때 아무반응없게만들기
}
