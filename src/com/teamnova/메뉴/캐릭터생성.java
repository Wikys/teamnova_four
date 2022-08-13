package com.teamnova.메뉴;

import com.teamnova.스킬.스킬;
import com.teamnova.플레이어.비스트맨;
import com.teamnova.플레이어.스켈레톤;
import com.teamnova.플레이어.인간;

import java.util.ArrayList;
import java.util.Scanner;

import static com.teamnova.몬스터.몬스터.유저명;

public class 캐릭터생성 {
    Scanner in = new Scanner(System.in);
    int 선택; //정수형 스캐너

    String 이름; //이름 스캐너
    ArrayList<스킬> _버프스킬목록 = new ArrayList<>(); //스킬 어레이
    ArrayList<스킬> _회복스킬목록 = new ArrayList<>();
    ArrayList<스킬> _공격스킬목록 = new ArrayList<>();
    ArrayList<스킬> _종족스킬목록 = new ArrayList<>();
//    스킬 강조 = new 강조("강조"); //기본스킬
//    스킬 부정한기운 = new 부정한기운("부정한기운");
//    스킬 사자의심장 = new 사자의심장("사자의심장");
//    스킬 무기파괴 = new 무기파괴("무기파괴");
//    스킬 사광연참 = new 사광연참("사광연참");
//    스킬 화염구 = new 화염구("화염구");



    public void 캐릭터생성() {
//        유저명._공격스킬목록.add(무기파괴);
//        유저명._공격스킬목록.add(화염구);
//        유저명._공격스킬목록.add(사광연참); //실험용
        캐릭터작성:
        while (true) {


            System.out.println("1.시작하기");
            System.out.println("0.끝내기");
            선택 = in.nextInt();
            if (선택 == 1) {
                System.out.println("캐릭터 생성을 시작합니다");
                System.out.println("====================");
                System.out.println("종종분류를 선택해주세요");
                System.out.println("1.인간종 2.아인종 3.언데드");
                System.out.println("====================");
                선택 = in.nextInt();
                if (선택 == 1) {
                    System.out.println("종족을 선택해주세요");
                    System.out.println("1.인간");
                    System.out.println();
                    System.out.println("0.뒤로가기");
                    선택 = in.nextInt();
                    if (선택 == 1) {
                        유저명 = new 인간();
                        유저명.스탯(유저명);
                        System.out.println("인간을 선택하셨습니다");
//                        유저명._종족스킬목록.add(사자의심장);
                        break;
                    } else if (선택 == 0) {
                        continue 캐릭터작성;
                    }
                } else if (선택 == 2) {
                    System.out.println("종족을 선택해주세요");
                    System.out.println("1.비스트맨");
                    System.out.println();
                    System.out.println("0.뒤로가기");
                    선택 = in.nextInt();
                    if (선택 == 1) {

                        유저명 = new 비스트맨();
                        유저명.스탯(유저명);
                        System.out.println("비스트맨을 선택하셨습니다");
//                        유저명._종족스킬목록.add(강조);

                        break;
                    } else if (선택 == 0) {
                        continue 캐릭터작성;
                    }
                } else if (선택 == 3) {
                    System.out.println("종족을 선택해주세요");
                    System.out.println("1.스켈레톤");
                    System.out.println();
                    System.out.println("0.뒤로가기");
                    선택 = in.nextInt();
                    if (선택 == 1) {
                        유저명 = new 스켈레톤();
                        유저명.스탯(유저명);
                        System.out.println("스켈레톤을 선택하셨습니다");
//                        유저명._종족스킬목록.add(부정한기운);
                        break;
                    } else if (선택 == 0) {
                        continue 캐릭터작성;
                    }
                }
            }
        }
        System.out.println("캐릭터의 이름을 입력해주세요");
        이름 = in.next();
        유저명.이름 = 이름;
        System.out.println("이름이 " + 유저명.이름 + " 으로 결정되었습니다");
        유저명.기본아이템(유저명.인벤토리);
        System.out.println("당신은 모험을 시작합니다");


    }
}
