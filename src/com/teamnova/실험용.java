//사용자입장에서는 번호를 치는게 나음 (사용자 실수 고려) 아이템이나 기타등등 이름이 길어지면 힘들어짐 인터페이스,최적화 불리
//함수화가 잘안되있음
//메인쪽에 최대한 코딩이 적어야함
//기능 세분화가 안되있음
//상속하면서 클래스추가
//어떤클래스에 어떤기능을 넣어줄것인가 고민
//큼지막한 틀안에서만 보고있음





// 스테이터스 널 없애기
// 기능적인거는 만들고싶은거 만들기
// 캐릭터부분에서 전직을한다 이런게 큰 의미가 있어보이지않음
// 능력치만 증가함
// 클래스를 쓰는 의미가 크게없어보임 //상속?
// 전직을 했을때 클래스를 쓴 의미가 발생할수 있도록 수정


//반격없애야함 쓰레드 적용하려면..
//        스킬에 쿨타임줘보기?
//        고블린킹 고블린소환 스킬
//        전직스킬들 광역화
//
//        쓰레드 상속화?

//과제에 넣을만한 아이디어
//
//        주인공쓰레드
//        입력쓰레드 //  스킬?
//        몬스터쓰레드? // 쓰레드들이 각각 따로돌아가니까 적용하면 재밌을법함

//몬스터 자동공격, 게임시간 스레드로 구현
//1초에 한번씩 자동공격?
//가끔 스킬?

//플레이어도 자동공격하고 스킬및 포션사용은 수동으로?
//스킬쿨타임

//내행동은 굳이 쓰레드를 넣을필요가 없음
//항상 어떻게 행동할지 내가 선택해야하니까
//회피부분도 jlabel로 옮기기?? //일단 ㅂㄹ인거같음
//전직 병신됨