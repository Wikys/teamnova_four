package com.teamnova;

import java.util.ArrayList;

public class 상점 {



    캐릭터 캐릭터 = new 캐릭터();

    아이템 낡은검가격 = new 아이템(0); // 아이템호출
    아이템 철검가격 = new 아이템(10);
    아이템 가죽갑옷가격 = new 아이템(15);
    아이템 철갑옷가격 = new 아이템(30);
    아이템 체력포션가격 = new 아이템(5);
    아이템 마나포션가격 = new 아이템(5);
    아이템 아이템 = new 아이템();

    int 판매가격;

    public void 판매목록(캐릭터 _캐릭터){


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
        // 돈부족시에 경고띄우기
        // 구매완료되면 인벤토리와 전투인벤토리에 생성
    }
    public int 구매(int _구매번호, 캐릭터 소지금){ // 구매번호를 인자로 받아와서 아이템에 대입후 함수실행
        int 지불 = 0;
        if(_구매번호 == 1 && 소지금.돈>=this.철검가격.가격){
            지불 = this.철검가격.가격; // 인벤토리 클래스로 옮기고 add 아이템 여기다추가

        }
        else if(_구매번호 == 2 && 소지금.돈>=this.가죽갑옷가격.가격){
            지불 = this.가죽갑옷가격.가격;

        }
        else if(_구매번호 == 3 && 소지금.돈>=this.철갑옷가격.가격){
            지불 = this.철갑옷가격.가격;

        }
        else if(_구매번호 == 4 && 소지금.돈>=this.체력포션가격.가격){
            지불 = this.체력포션가격.가격;

        }
        else if(_구매번호 == 5 && 소지금.돈>=this.마나포션가격.가격){
            지불 = this.마나포션가격.가격;

        }
        else {

            System.out.println("돈이 부족합니다");
        }


        return 지불;
    }
    public ArrayList<아이템> 아이템반환 (int _구매번호, 캐릭터 소지금){ // 1번 입력하면 본인 소지금-철검가격이 반환됨 (여기까진함)
        // -> 아이템이 생성되서 인벤과 전투인벤에 들어가야함
        아이템.인벤토리.clear();


        if(_구매번호 == 1 && 소지금.돈>=this.철검가격.가격){
            아이템.인벤토리.add(캐릭터.철검);

        }
        else if(_구매번호 == 2 && 소지금.돈>=this.가죽갑옷가격.가격){
            아이템.인벤토리.add(캐릭터.가죽갑옷);

        }
        else if(_구매번호 == 3 && 소지금.돈>=this.철갑옷가격.가격){
            아이템.인벤토리.add(캐릭터.철갑옷);

        }
        else if(_구매번호 == 4 && 소지금.돈>=this.체력포션가격.가격){
            아이템.인벤토리.add(캐릭터.체력포션);

        }
        else if(_구매번호 == 5 && 소지금.돈>=this.마나포션가격.가격){
            아이템.인벤토리.add(캐릭터.마나포션);

        }

        return 아이템.인벤토리;

    }
// 아이템번호를 1234 식으로 바꿔서 리턴시켜서 팔아먹기..?
}
