package com.teamnova.스킬.스킬샵;

import com.teamnova.스킬.공격계열.영혼흡수;
import com.teamnova.스킬.공격계열.육광연참;
import com.teamnova.스킬.공격계열.헬파이어;
import com.teamnova.스킬.스킬;
import com.teamnova.플레이어.캐릭터;

import java.util.ArrayList;
import java.util.Scanner;

public class 스킬샵 {
    Scanner in = new Scanner(System.in);
    int 선택;
    int 입력;
    ArrayList<스킬> _판매스킬목록;
    스킬 육광연참;
    스킬 영혼흡수;
    스킬 헬파이어;

    public 스킬샵(){
        _판매스킬목록 = new ArrayList<>();
        육광연참 = new 육광연참();
        영혼흡수 = new 영혼흡수();
        헬파이어 = new 헬파이어();
        _판매스킬목록.add(육광연참);
        _판매스킬목록.add(영혼흡수);
        _판매스킬목록.add(헬파이어);

    }



    public void 스킬구매목록 (캐릭터 _캐릭터, ArrayList<스킬> _버프스킬목록, ArrayList<스킬> _회복스킬목록, ArrayList<스킬> _공격스킬목록) {

        입구 :
        while (true) {
            System.out.println("스킬상점입니다 원하시는 스킬계열을 선택해주세요");
//        for (int i = 0; i < _판매스킬목록.size(); i++) {
//            System.out.println("스킬 이름: " + i + ". " + _판매스킬목록.get(i).스킬이름);
//        }
            System.out.println("1.공격계열");
            System.out.println("2.버프계열(미구현)");
            System.out.println("3.회복계열(미구현)");
            System.out.println("0.나가기");
            System.out.println();
            System.out.println("소지금 : "+_캐릭터.돈+" gold");
            선택 = in.nextInt();

            if (선택 == 1) { //공격계열
                System.out.println("구매할 스킬의 번호를 입력해주세요");
                for (int i = 0; i < _판매스킬목록.size(); i++) {
                    System.out.println("스킬 이름: " + i + ". " + _판매스킬목록.get(i).스킬이름);
                }
                    선택 = in.nextInt();
                    스킬 선택스킬 = _판매스킬목록.get(선택);

                    선택스킬.스킬설명();

                    System.out.println("가격은 " + 선택스킬.가격 + "gold 입니다");
                    System.out.println("정말 구매하시겠습니까?");
                    System.out.println("1.예");
                    System.out.println("2.아니오");
                    입력 = in.nextInt();
                    if (입력 == 1 && _캐릭터.돈 >= 선택스킬.가격) {
                        System.out.println(선택스킬.스킬이름 + " 구매가 완료되었습니다");
                        _공격스킬목록.add(선택스킬);
                        _캐릭터.돈 = _캐릭터.돈 - 선택스킬.가격;
                        continue 입구;
                    }
                    else if(입력 == 2){
                        continue 입구;
                    }

            } else if (선택 == 2) { //회복계열 미구현
                System.out.println("구매할 스킬의 번호를 입력해주세요");
                for (int i = 0; i < _판매스킬목록.size(); i++) {
                    if (2 == _판매스킬목록.get(i).계열) { // 스킬계열이 맞는것만 출력
                        System.out.println("스킬 이름: " + i + ". " + _판매스킬목록.get(i).스킬이름);
                    }
                }
            } else if (선택 == 3) { // 버프계열 미구현
                System.out.println("구매할 스킬의 번호를 입력해주세요");
                for (int i = 0; i < _판매스킬목록.size(); i++) {
                    if (3 == _판매스킬목록.get(i).계열) { // 스킬계열이 맞는것만 출력
                        System.out.println("스킬 이름: " + i + ". " + _판매스킬목록.get(i).스킬이름);
                    }
                }
            }
            else if (선택 == 0){
                return;
            }
            else{
                return;
            }
        }
    }

}
