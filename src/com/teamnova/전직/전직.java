package com.teamnova.전직;

import com.teamnova.플레이어.캐릭터;

import java.util.Scanner;

import static com.teamnova.몬스터.몬스터.유저명;

public class 전직{
    Scanner in = new Scanner(System.in);
    int 입력;


    public void 전직여부(){

        if (유저명.레벨 <3){
            System.out.println("3레벨이 되시면 전직이 가능합니다");
            return;
        }
        else if(유저명.레벨 ==3){
            System.out.println("전직 가능한 레벨에 도달했습니다");
            System.out.println("전직메뉴를 들어가보세요");
        }
        else if(유저명.직업번호 >=0){
            System.out.println("전직을 완료한 상태입니다");
            return;
        }
    }
    public void 전직메뉴(){

        if(유저명.직업번호 >= 0){
            System.out.println("이미 전직을 완료한 상태입니다");
            return;
        }

        if (유저명.레벨 <3){
            System.out.println("3레벨 달성하고 다시오세요!");
            return;
        }
        System.out.println("전직이 가능합니다 진행하시겠습니까?");
        System.out.println("1.예");
        System.out.println("2.아니오");
        입력 = in.nextInt();
        if(입력 == 1) {
            if (유저명.레벨 >= 1 && 유저명.종족 == 0) {
//                캐릭터 전사 = new 전사();

//                System.out.println(전사.직업이름);
//                System.out.println(전사.직업번호);
//                캐릭터 임시 = new 전사();
//                임시.스탯();
//                임시 = 유저명;
//                임시 = 전사;
//                전사.스탯();
//                System.out.println(전사.최대체력);

                유저명 = new 전사();
                유저명.스탯(유저명);



                System.out.println("전사로 전직하셨습니다");
                System.out.println("전사의 강직함으로 최대체력이 10 상승하였습니다");


            } else if (유저명.레벨 >= 3 && 유저명.종족 == 1) {
                //몽크
                //몽크로 전직하셨습니다
                //몽크의 기민함으로 인해 회피율이 5 증가합니다
//                캐릭터 몽크 = new 몽크();
//                몽크.스탯();
                유저명 = new 몽크();
                유저명.스탯(유저명);
                System.out.println("몽크로 전직하셨습니다");
                System.out.println("몽크의 기민함으로 인해 회피율이 5 증가합니다");


            } else if (유저명.레벨 >= 3 && 유저명.종족 == 2) {
                //메이지
                //메이지로 전직하셨습니다
                //불사자의 마력으로 마법력이 5 올랐습니다
//                캐릭터 메이지 = new 스켈레톤_메이지();
//                메이지.스탯(유저명);
                유저명 = new 스켈레톤_메이지();
                유저명.스탯(유저명);
                System.out.println("스켈레톤 메이지로 전직하셨습니다");
                System.out.println("불사자의 마력으로 마법력이 5 올랐습니다");
            }
        }
        else {
            return;
        }
    }

}
