package com.teamnova.전직;

import com.teamnova.플레이어.캐릭터;

public class 전직{

    public void 전직여부(캐릭터 _캐릭터){
        if (_캐릭터.레벨 <3){
            System.out.println("3레벨이 되시면 전직이 가능합니다");
            return;
        }
        else if(_캐릭터.레벨 ==3){
            System.out.println("전직 가능한 레벨에 도달했습니다");
            System.out.println("전직메뉴를 들어가보세요");
        }
        else if(_캐릭터.직업번호 >=0){
            System.out.println("전직을 완료한 상태입니다");
            return;
        }
    }
    public void 전직메뉴(캐릭터 _캐릭터){
        스켈레톤_메이지 스켈레톤메이지 = null;
        if (_캐릭터.레벨 <3){
            System.out.println("3레벨 달성하고 다시오세요!");
            return;
        }
        System.out.println("전직이 가능합니다 진행하시겠습니까?");
        if(_캐릭터.레벨 >=3 && _캐릭터.종족 == 0){
            //전사
            //전사로 전직하셨습니다
        }
        else if(_캐릭터.레벨>=3 && _캐릭터.종족 == 1){
            //몽크
            //몽크로 전직하셨습니다
        }
        else if (_캐릭터.레벨>=3 && _캐릭터.종족 == 2){
            //메이지
            //메이지로 전직하셨습니다



        }
    }
}
