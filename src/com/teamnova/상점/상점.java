package com.teamnova.상점;

import com.teamnova.아이템.분류.*;
import com.teamnova.아이템.아이템;

import java.util.Scanner;

import static com.teamnova.몬스터.몬스터.유저명;

public class 상점 {
    public Scanner in = new Scanner(System.in);
    public int 입력;
    //  public   com.teamnova.플레이어.캐릭터 캐릭터 = new 캐릭터();
//  public   com.teamnova.아이템.아이템 낡은검가격 = new 아이템(0); // 아이템호출
//    public 아이템 철검가격 = new 아이템(10);
//    public 아이템 가죽갑옷가격 = new 아이템(15);
//    public 아이템 철갑옷가격 = new 아이템(30);
//    public 아이템 체력포션가격 = new 아이템(5);
//    public 아이템 마나포션가격 = new 아이템(5);
//    public 아이템 조악한_완드가격 = new 아이템 (20);
//    public 아이템 아이템 = new 아이템();
    public 아이템 조악한완드 = new 조악한_완드();
    public 아이템 낡은검 = new 낡은검();
    public 아이템 철검 = new 철검();
    public 아이템 가죽갑옷 = new 가죽갑옷();
    public 아이템 철갑옷 = new 철갑옷();
    public 아이템 체력포션 = new 체력포션();
    public 아이템 마나포션 = new 마나포션();


    //아이템 추상화하고 싹다고치기


    int 판매가격;

    public void 판매목록() {
        입구 :
        while (true) {
            System.out.println("구매할 물건 번호를 입력 해주세요");
            System.out.println("1.철검 " + this.철검.가격 + " Gold");
            System.out.println("2.가죽갑옷 " + this.가죽갑옷.가격 + " Gold");
            System.out.println("3.철갑옷 " + this.철갑옷.가격 + " Gold");
            System.out.println("4.체력포션 " + this.체력포션.가격 + " Gold");
            System.out.println("5.마나포션 " + this.마나포션.가격 + " Gold");
            System.out.println("6.조악한 완드 " + this.조악한완드.가격 + " Gold");
            System.out.println();
            System.out.println("소지금 " + 유저명.돈 + " Gold");
            System.out.println();
            System.out.println("0.나가기");
            입력 = in.nextInt();
            // 돈부족시에 경고띄우기
            // 구매완료되면 인벤토리와 전투인벤토리에 생성
            if (입력 == 1) { //구매선택하면 아이템정보 출력

                this.철검.아이템_설명();


                System.out.println(this.철검.이름 + "을 정말 구매하시겠습니까?");
                System.out.println("1.예");
                System.out.println("2.아니오");
                입력 = in.nextInt();
                if (입력 == 1 && 유저명.돈 >= this.철검.가격) { // 입려값과 돈이 템가격보다 많은지보고 없으면 else직행
                    System.out.println("구매가 완료되었습니다");
                    유저명.인벤토리.add(this.철검);
                    유저명.돈 = 유저명.돈 - this.철검.가격;
                    continue 입구;
                } else if (입력 == 1 && 유저명.돈 < this.철검.가격) {
                    System.out.println("소지금이 부족합니다!");
                    continue 입구;
                } else if (입력 == 2) {
                    continue 입구;
                }

            } else if (입력 == 2) { //구매선택하면 아이템정보 출력
                this.가죽갑옷.아이템_설명();

                System.out.println(this.가죽갑옷.이름 + "을 정말 구매하시겠습니까?");
                System.out.println("1.예");
                System.out.println("2.아니오");
                입력 = in.nextInt();
                if (입력 == 1 && 유저명.돈 >= this.가죽갑옷.가격) { // 입려값과 돈이 템가격보다 많은지보고 없으면 else직행
                    System.out.println("구매가 완료되었습니다");
                    유저명.인벤토리.add(this.가죽갑옷);
                    유저명.돈 = 유저명.돈 - this.가죽갑옷.가격;
                    continue 입구;
                } else if (입력 == 1 && 유저명.돈 < this.가죽갑옷.가격) {
                    System.out.println("소지금이 부족합니다!");
                    continue 입구;
                } else if (입력 == 2) {
                    continue 입구;
                }
            } else if (입력 == 3) { //구매선택하면 아이템정보 출력
                this.철갑옷.아이템_설명();

                System.out.println(this.철갑옷.이름 + "을 정말 구매하시겠습니까?");
                System.out.println("1.예");
                System.out.println("2.아니오");
                입력 = in.nextInt();
                if (입력 == 1 && 유저명.돈 >= this.철갑옷.가격) { // 입려값과 돈이 템가격보다 많은지보고 없으면 else직행
                    System.out.println("구매가 완료되었습니다");
                    유저명.인벤토리.add(this.철갑옷);
                    유저명.돈 = 유저명.돈 - this.철갑옷.가격;
                    continue 입구;
                } else if (입력 == 1 && 유저명.돈 < this.철갑옷.가격) {
                    System.out.println("소지금이 부족합니다!");
                    continue 입구;
                } else if (입력 == 2) {
                    continue 입구;
                }
            } else if (입력 == 4) { //구매선택하면 아이템정보 출력
                this.체력포션.아이템_설명();

                System.out.println(this.체력포션.이름 + "을 정말 구매하시겠습니까?");
                System.out.println("1.예");
                System.out.println("2.아니오");
                입력 = in.nextInt();
                if (입력 == 1 && 유저명.돈 >= this.체력포션.가격) { // 입려값과 돈이 템가격보다 많은지보고 없으면 else직행
                    System.out.println("구매가 완료되었습니다");
                    유저명.인벤토리.add(this.체력포션);
                    유저명.돈 = 유저명.돈 - this.체력포션.가격;
                    continue 입구;
                } else if (입력 == 1 && 유저명.돈 < this.체력포션.가격) {
                    System.out.println("소지금이 부족합니다!");
                    continue 입구;
                } else if (입력 == 2) {
                    continue 입구;
                }
            } else if (입력 == 5) { //구매선택하면 아이템정보 출력
                this.마나포션.아이템_설명();

                System.out.println(this.마나포션.이름 + "을 정말 구매하시겠습니까?");
                System.out.println("1.예");
                System.out.println("2.아니오");
                입력 = in.nextInt();
                if (입력 == 1 && 유저명.돈 >= this.마나포션.가격) { // 입려값과 돈이 템가격보다 많은지보고 없으면 else직행
                    System.out.println("구매가 완료되었습니다");
                    유저명.인벤토리.add(this.마나포션);
                    유저명.돈 = 유저명.돈 - this.마나포션.가격;
                    continue 입구;
                } else if (입력 == 1 && 유저명.돈 < this.마나포션.가격) {
                    System.out.println("소지금이 부족합니다!");
                    continue 입구;
                } else if (입력 == 2) {
                    continue 입구;
                }
            } else if (입력 == 6) { //구매선택하면 아이템정보 출력

                this.조악한완드.아이템_설명();


                System.out.println(this.조악한완드.이름 + "을 정말 구매하시겠습니까?");
                System.out.println("1.예");
                System.out.println("2.아니오");
                입력 = in.nextInt();
                if (입력 == 1 && 유저명.돈 >= this.조악한완드.가격) { // 입려값과 돈이 템가격보다 많은지보고 없으면 else직행
                    System.out.println("구매가 완료되었습니다");
                    유저명.인벤토리.add(this.조악한완드);
                    유저명.돈 = 유저명.돈 - this.조악한완드.가격;
                    continue 입구;
                } else if (입력 == 1 && 유저명.돈 < this.조악한완드.가격) {
                    System.out.println("소지금이 부족합니다!");
                    continue 입구;
                } else if (입력 == 2) {
                    continue 입구;
                }
            } else if (입력 == 0) {
                return;
            }
        }
    }
}
