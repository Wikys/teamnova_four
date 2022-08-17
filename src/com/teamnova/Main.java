package com.teamnova;

import com.teamnova.메뉴.전투메뉴;
import com.teamnova.메뉴.캐릭터생성;
import com.teamnova.메뉴.행동문;


public class Main {
    public static void main(String[] args) {
        캐릭터생성 캐릭터생성 = new 캐릭터생성();
        행동문 행동메뉴 = new 행동문();
        전투메뉴 전투메뉴 = new 전투메뉴();

        캐릭터생성.캐릭터생성(); //캐릭터생성 메소드
        행동메뉴.행동문(전투메뉴); // 메인메뉴 메소드
    }
}

