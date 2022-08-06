package com.teamnova.장비창;
import com.teamnova.메뉴.메인메뉴;
import com.teamnova.아이템.아이템;
import com.teamnova.플레이어.캐릭터;

import java.util.Scanner;
public class 장비창 {
    Scanner in = new Scanner(System.in);
    int 입력;

    public void 장비창(캐릭터 _캐릭터, 메인메뉴 _중복착용){
        System.out.println("====================");
        for (int i = 0; i < _캐릭터.장비창.size(); i++) {
            System.out.println("아이템 이름: " + i + ". " + _캐릭터.장비창.get(i).이름);
        }
        System.out.println("====================");
        System.out.println("1. 장착해제");
        System.out.println("0. 돌아가기");
        입력 = in.nextInt();
        if(입력 == 1){
            System.out.println("====================");
            for (int i = 0; i < _캐릭터.장비창.size(); i++) {
                System.out.println("아이템 이름: " + i + ". " + _캐릭터.장비창.get(i).이름);
            }
            System.out.println("====================");
            System.out.println("장착해제할 아이템 번호를 입력해주세요");
            입력 = in.nextInt();
            아이템 장착해제 = _캐릭터.장비창.get(입력); //선택한요소를 변수에 저장
            if(장착해제.타입 == 1 && 장착해제.마법무기 == 0) { //일반무기
                장착해제.아이템_설명();
                System.out.println("정말로 장착해제하시겠습니까?");
                System.out.println("1.예");
                System.out.println("2.아니오");
                입력 = in.nextInt();
                if (입력 == 1){
                    System.out.println(장착해제.이름+" 장착해제 되었습니다");
                    _캐릭터.장비창.remove(장착해제);
                    _캐릭터.인벤토리.add(장착해제);
//                    _캐릭터.공격력 = _캐릭터.공격력 - 장착해제.공격력;
                    장착해제.아이템_장착해제(_캐릭터);
                    _중복착용.무기중복 = false;
                    this.장비창(_캐릭터,_중복착용);
                }
                else if(입력 ==2){
                    this.장비창(_캐릭터,_중복착용);
                }
            }
            if(장착해제.타입 == 1 && 장착해제.마법무기 == 1) { //마법무기
                장착해제.아이템_설명();
                System.out.println("정말로 장착해제하시겠습니까?");
                System.out.println("1.예");
                System.out.println("2.아니오");
                입력 = in.nextInt();
                if (입력 == 1){
                    System.out.println(장착해제.이름+" 장착해제 되었습니다");
                    _캐릭터.장비창.remove(장착해제);
                    _캐릭터.인벤토리.add(장착해제);
                    장착해제.아이템_장착해제(_캐릭터);
                    _중복착용.무기중복 = false;
                    this.장비창(_캐릭터,_중복착용);
                }
                else if(입력 ==2){
                    this.장비창(_캐릭터,_중복착용);
                }
            }
            else if(장착해제.타입 == 2) {
                장착해제.아이템_설명();
                System.out.println("정말로 장착해제하시겠습니까?");
                System.out.println("1.예");
                System.out.println("2.아니오");
                입력 = in.nextInt();
                if (입력 == 1){
                    System.out.println(장착해제.이름+" 장착해제 되었습니다");
                    _캐릭터.장비창.remove(장착해제);
                    _캐릭터.인벤토리.add(장착해제);
                    장착해제.아이템_장착해제(_캐릭터);
                    _중복착용.방어구중복 = false;
                    this.장비창(_캐릭터,_중복착용);
                }
                else if(입력 ==2){
                    this.장비창(_캐릭터,_중복착용);
                }
            }
        }
    }
}
