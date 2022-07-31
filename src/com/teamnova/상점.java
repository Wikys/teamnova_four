package com.teamnova;

import java.util.ArrayList;
import java.util.Scanner;

public class 상점 {
    Scanner in = new Scanner(System.in);
    int 입력;
    캐릭터 캐릭터 = new 캐릭터();
    아이템 낡은검가격 = new 아이템(0); // 아이템호출
    아이템 철검가격 = new 아이템(10);
    아이템 가죽갑옷가격 = new 아이템(15);
    아이템 철갑옷가격 = new 아이템(30);
    아이템 체력포션가격 = new 아이템(5);
    아이템 마나포션가격 = new 아이템(5);
    아이템 아이템 = new 아이템();


    int 판매가격;

    public void 판매목록(캐릭터 _캐릭터, 아이템 _인벤토리){


        System.out.println("구매할 물건 번호를 입력 해주세요");
        System.out.println("1.철검 " + 철검가격.가격+" Gold");
        System.out.println("2.가죽갑옷 "+가죽갑옷가격.가격+" Gold");
        System.out.println("3.철갑옷 "+철갑옷가격.가격+" Gold");
        System.out.println("4.체력포션 "+체력포션가격.가격+" Gold");
        System.out.println("5.마나포션 "+마나포션가격.가격+" Gold");
        System.out.println();
        System.out.println("소지금 " + _캐릭터.돈 + " Gold");
        System.out.println();
        System.out.println("0.나가기");
        입력 = in.nextInt();
        // 돈부족시에 경고띄우기
        // 구매완료되면 인벤토리와 전투인벤토리에 생성
        if (입력 == 1){ //구매선택하면 아이템정보 출력
            System.out.println("====================");
            System.out.println("아이템명: " + _캐릭터.철검.이름);
            System.out.println("공격력: " + _캐릭터.철검.공격력);
            System.out.println("아이템 설명: " + _캐릭터.철검.설명);
            System.out.println("====================");

            System.out.println(_캐릭터.철검.이름+"을 정말 구매하시겠습니까?");
            System.out.println("1.예");
            System.out.println("2.아니오");
            입력 = in.nextInt();
            if (입력 == 1 && _캐릭터.돈 >= _캐릭터.철검.가격){ // 입려값과 돈이 템가격보다 많은지보고 없으면 else직행
                System.out.println("구매가 완료되었습니다");
                _인벤토리.인벤토리.add(캐릭터.철검);
                _캐릭터.돈 = _캐릭터.돈 - _캐릭터.철검.가격;
                this.판매목록(_캐릭터, _인벤토리);
            }
            else if(입력 == 1 && _캐릭터.돈 < _캐릭터.철검.가격){
                System.out.println("소지금이 부족합니다!");
                this.판매목록(_캐릭터, _인벤토리);
            }
            else if(입력 == 2){
                this.판매목록(_캐릭터, _인벤토리);
            }

        }
        else if (입력 == 2){ //구매선택하면 아이템정보 출력
            System.out.println("====================");
            System.out.println("아이템명: " + _캐릭터.가죽갑옷.이름);
            System.out.println("방어력: " + _캐릭터.가죽갑옷.방어력);
            System.out.println("아이템 설명: " + _캐릭터.가죽갑옷.설명);
            System.out.println("====================");

            System.out.println(_캐릭터.가죽갑옷.이름+"을 정말 구매하시겠습니까?");
            System.out.println("1.예");
            System.out.println("2.아니오");
            입력 = in.nextInt();
            if (입력 == 1 && _캐릭터.돈 >= _캐릭터.가죽갑옷.가격){ // 입려값과 돈이 템가격보다 많은지보고 없으면 else직행
                System.out.println("구매가 완료되었습니다");
                _인벤토리.인벤토리.add(캐릭터.가죽갑옷);
                _캐릭터.돈 = _캐릭터.돈 - _캐릭터.가죽갑옷.가격;
                this.판매목록(_캐릭터, _인벤토리);
            }
            else if(입력 == 1 && _캐릭터.돈 < _캐릭터.가죽갑옷.가격){
                System.out.println("소지금이 부족합니다!");
                this.판매목록(_캐릭터, _인벤토리);
            }
            else if(입력 == 2){
                this.판매목록(_캐릭터, _인벤토리);
            }
        }
        else if (입력 == 3){ //구매선택하면 아이템정보 출력
            System.out.println("====================");
            System.out.println("아이템명: " + _캐릭터.철갑옷.이름);
            System.out.println("방어력: " + _캐릭터.철갑옷.방어력);
            System.out.println("아이템 설명: " + _캐릭터.철갑옷.설명);
            System.out.println("====================");

            System.out.println(_캐릭터.철갑옷.이름+"을 정말 구매하시겠습니까?");
            System.out.println("1.예");
            System.out.println("2.아니오");
            입력 = in.nextInt();
            if (입력 == 1 && _캐릭터.돈 >= _캐릭터.철갑옷.가격){ // 입려값과 돈이 템가격보다 많은지보고 없으면 else직행
                System.out.println("구매가 완료되었습니다");
                _인벤토리.인벤토리.add(캐릭터.철갑옷);
                _캐릭터.돈 = _캐릭터.돈 - _캐릭터.철갑옷.가격;
                this.판매목록(_캐릭터, _인벤토리);
            }
            else if(입력 == 1 && _캐릭터.돈 < _캐릭터.철갑옷.가격){
                System.out.println("소지금이 부족합니다!");
                this.판매목록(_캐릭터, _인벤토리);
            }
            else if(입력 == 2){
                this.판매목록(_캐릭터, _인벤토리);
            }
        }
        else if (입력 == 4){ //구매선택하면 아이템정보 출력
            System.out.println("====================");
            System.out.println("아이템명: " + _캐릭터.체력포션.이름);
            System.out.println("체력회복량: " + _캐릭터.체력포션.체력회복);
            System.out.println("아이템 설명: " + _캐릭터.체력포션.설명);
            System.out.println("====================");

            System.out.println(_캐릭터.체력포션.이름+"을 정말 구매하시겠습니까?");
            System.out.println("1.예");
            System.out.println("2.아니오");
            입력 = in.nextInt();
            if (입력 == 1 && _캐릭터.돈 >= _캐릭터.체력포션.가격){ // 입려값과 돈이 템가격보다 많은지보고 없으면 else직행
                System.out.println("구매가 완료되었습니다");
                _인벤토리.인벤토리.add(캐릭터.체력포션);
                _캐릭터.돈 = _캐릭터.돈 - _캐릭터.체력포션.가격;
                this.판매목록(_캐릭터, _인벤토리);
            }
            else if(입력 == 1 && _캐릭터.돈 < _캐릭터.체력포션.가격){
                System.out.println("소지금이 부족합니다!");
                this.판매목록(_캐릭터, _인벤토리);
            }
            else if(입력 == 2){
                this.판매목록(_캐릭터, _인벤토리);
            }
        }
        else if (입력 == 5){ //구매선택하면 아이템정보 출력
            System.out.println("====================");
            System.out.println("아이템명: " + _캐릭터.마나포션.이름);
            System.out.println("체력회복량: " + _캐릭터.마나포션.체력회복);
            System.out.println("아이템 설명: " + _캐릭터.마나포션.설명);
            System.out.println("====================");

            System.out.println(_캐릭터.마나포션.이름+"을 정말 구매하시겠습니까?");
            System.out.println("1.예");
            System.out.println("2.아니오");
            입력 = in.nextInt();
            if (입력 == 1 && _캐릭터.돈 >= _캐릭터.마나포션.가격){ // 입려값과 돈이 템가격보다 많은지보고 없으면 else직행
                System.out.println("구매가 완료되었습니다");
                _인벤토리.인벤토리.add(캐릭터.마나포션);
                _캐릭터.돈 = _캐릭터.돈 - _캐릭터.마나포션.가격;
                this.판매목록(_캐릭터, _인벤토리);
            }
            else if(입력 == 1 && _캐릭터.돈 < _캐릭터.마나포션.가격){
                System.out.println("소지금이 부족합니다!");
                this.판매목록(_캐릭터, _인벤토리);
            }
            else if(입력 == 2){
                this.판매목록(_캐릭터, _인벤토리);
            }
        }//나가는건 밖에서처리
    }
}
