package com.teamnova.아이템.분류;

import com.teamnova.아이템.아이템;

public class 잡템 extends 아이템 {
    public 잡템(){
        this.가격 = 1;
        this.이름 = "잡템";
    }

    @Override
    public void 아이템_효과() {

    }

    @Override
    public void 아이템_장착해제() {

    }

    @Override
    public void 아이템_설명() {
        System.out.println("========================================================");
        System.out.println("아이템이름 : "+this.이름);
        System.out.println("설명 : 테스트용 잡템");
        System.out.println("========================================================");

    }
}
