package com.teamnova;

public class 메인메뉴 {

    public void 행동메뉴() {
        System.out.println("행동을 선택해주세요");
        System.out.println("1.탐색");
        System.out.println("2.휴식");
        System.out.println("3.상점");
        System.out.println("4.소지품");
        System.out.println("5.스테이터스");
        System.out.println("6.장비");
        System.out.println("7.스킬");
        System.out.println("0.끝내기");
    }

    public 캐릭터 유저상태_초기화(캐릭터 _플레이어, 스킬 _스킬상태) { // 버프나 기타등등으로 올라간 능력치 초기화
        if (_플레이어.전투중체력 > _플레이어.최대체력) {
            _플레이어.전투중체력 = _플레이어.체력;
        } else if (_플레이어.전투중마나 > _플레이어.최대마나) {
            _플레이어.전투중마나 = _플레이어.마나;
        } else if (_플레이어.전투중공격력 > _플레이어.공격력){
            _플레이어.전투중공격력 = _플레이어.공격력;
        } else if (_플레이어.전투중방어력 > _플레이어.방어력){
            _플레이어.전투중방어력 = _플레이어.방어력;
        } else if (_플레이어.전투중회피율 > _플레이어.회피율){
            _플레이어.전투중회피율 = _플레이어.회피율;
        }
        _스킬상태.스킬제한 = false;
        return _플레이어;


    }
}
