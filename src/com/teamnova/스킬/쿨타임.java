package com.teamnova.스킬;

import static com.teamnova.몬스터.몬스터.유저명;
import static com.teamnova.몬스터.몬스터_인카운터.몬스터;

public class 쿨타임 extends 스킬{

    @Override
    public void 스킬효과() {
    }

    @Override
    public void 스킬설명() {
    }

    @Override
    public void 스킬초기화() {
        System.out.println("전투종료시 스킬쿨타임 초기화");
    }

    @Override
    public void 스킬쿨타임() {
        this.쿨타임텍스트.setText("스킬쿨타임");
        this.스킬프레임.add(this.몬스터_텍스트);
        this.스킬프레임.setLocation(300, 100);
        this.스킬프레임.pack();
        this.스킬프레임.setVisible(true);
        if (유저명.전투중체력 <=0 || 몬스터.체력 <=0 ){
            스킬프레임.setVisible(false);
            스킬프레임.dispose();
        }
    }

    @Override
    public void run() {

    }
}
