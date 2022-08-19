//지난번에 팀장님이 피드백 주셨던부분에 대해서
//        반영을 최대한 해봤습니다
//
//        우선 메인을 정리했구요 지금 보면
//        메인이 너무 극단적이긴 한데
//        이렇게 한 이유가
//        하나는 기존에 너무 지저분해보여서였고
//        두번째는 클래스끼리 유기적으로 연결시키려는데
//        메인을 거치는것보다는
//        클래스에 담아 연결시키는게
//        좀더 자연스럽게 되서 이런방법을 사용했습니다
//
//        그리고 함수화가 덜됬다고 하셨던부분에 대해
//        기능 세분화에 대해서 생각하면서 캡슐화를 해봤구요
//
//        클래스가 너무 적다는 피드백에 대해서도
//        상속 진행하면서 메뉴쪽을 제외한 대부분
//        클래스화 시켰습니다
//
//        일단 시연하면서 발표시작하겠습니다
//
//        종족은 현재 3개가 있는데 저는 인간으로 해보겠습니다
//        종족별 차이점은 시작스탯차이, 종족전용스킬 지급되는게 다르다는 차이가있습니다
//
//        이렇게 이름까지 생성완료되면 종족정보나 이름정보 기본아이템,기본스킬등이
//        메인으로 리턴되고 메인에서 캐릭터타입 객체로 받아서 적용시켜주는 방법을 썻습니다
//
//        그다음은 메인메뉴부분이 실행됩니다
//        일단 기본지급받은 장비부터 장착하겠습니다
//
//        (아이템 장착)
//        버리기 부분은 어레이리스트 리무브메소드를 썻습니다
//        퀵슬롯은 지금 포션을 특정 어레이리스트에 등록해
//        전투중에 사용할수있게 하는기능이고
//        등록시에 소지품창에서 리무브되고 포션어레이리스트에 들어가는방식입니다
//        현재는 돈도없고 포션도없으니 일단 생략하겠습니다
//
//        장비 잘 끼워졌나 보겠습니다
//
//        잘된거같습니다
//        밑에 장착해제부분은
//        해제하게되면 아이템정보에있는 스탯이 캐릭터클래스에서 빼지고
//        장착 어레이리스트에서 삭제되고
//        소지품창으로 다시 에드되게했습니다
//
//        몬스터사냥 들어가보겠습니다
//        일단 3레벨에 전직하게되고 5레벨에 보스전을 진행하게되는 구조라
//        빠른진행을 위해 모든몬스터 경험치를 극단적으로 올려뒀습니다
//
//        몬스터 인카운터의 경우 몬스터클래스의 객체들을 생성해놓은 클래스의
//        메소드에서 주사위를 굴려 랜덤으로 몬스터를 뽑은후 이쪽으로 보내서
//        빈 몬스터 객체에 정보를 대입했습니다
//
//        전 일단 공격을 하겠습니다
//        아래에 아이템사용은 아까 말씀드렸던 퀵슬롯부분입니다
//        도주하기는 주사위굴려서 일정 숫자이상이 나오면 도주하게 되고
//        실패시에 재시도가 불가능하게 만들어둔
//        단순한 메소드입니다
//
//        공격부분은 캐릭터공격력- 적방어력 의 피해를 주는 함수를 썻고
//        특수기능으로는 주사위를 굴려서 일정숫자가 나오면 데미지가 두배들어가고
//        주사위가 적 회피율보다 낮으면 적이 회피하게끔 해뒀습니다
//
//        빠르게 진행해야 되니까 스킬로 죽여보겠습니다
//
//        몹을 죽이게되면 보상을 주는 메서드로 진입하게됩니다
//        아이템획득과 골드획득부분은 각 몬스터의 메서드를 참조합니다
//
//        레벨업을 하게되면 스탯들이 1씩 오르게됩니다
//
//        이후에 메인메뉴 메소드를 다시 호출하게되고
//        메인메뉴쪽에서
//        버프나 기타등등 특수상황때문에 올라간 능력치나 체력마나 등등을 메서드로 초기화 하도록
//        해뒀습니다
//
//        일단 전직레벨까지 진행해보겠습니다
//        (3레벨)
//        전직후에 스테이터스에 들어가서 능력치를 확인해보면
//        체력이 10 올라있습니다
//        각 전직클래스나 종족클래스는 캐릭터의 자식의 자식인데
//        부모인 캐릭터클래스에 정보를 보내주는식으로
//        해놨습니다
//
//        5레벨 보스전 전에 스킬을 배우고 진행해보겠습니다
//        버프랑 회복은 아직 생각중입니다
//        공격계열 배우고 진행하겠습니다
//
//        5레벨이 되면 보스전메뉴가 활성화됩니다
//        잡아보겠습니다
//        (보스스킬설명)
//        보스는 공격하다가 일정확률로
//        전용스킬을 사용하게 해놨습니다
//        얘같은경우는 방어력무시 데미지를 입힙니다
//
//        보스를 잡게되면 보스만의 전용아이템이 떨어지게됩니다
//        일단은 여기까지 만들어뒀고
//        쓰레드를 진행하게되면
//        쓰레드의 기능들을 추가로 공부하면서
//        확장시켜나갈 계획입니다
//
//        2단계상속 캐릭터,보스
//        1단계상속 아이템,스킬,

///////////////////////////////////////////////////
//쓰레드 쓴부분
//
//        타이머 기능의 쓰레드
//        100초 주기로 밤과낮이 바뀌고
//        밤이되면 몬스터가 실시간으로 강화되는 기능이고
//        시간은 자바스윙으로 표기를 했습니다
//
//        카타스트로피
//        시작할때 스토리메세지를 띄우는 기능과
//        해피엔딩, 배드엔딩시 메세지를 출력하는 기능이있고
//        핵심기능이 한가지 있는데
//        제한시간을 주고(현재는 50) 타이머가 낮이될때 1씩 감소하고
//        몬스터와 전투가 끝나면 1씩 감소합니다
//        0이되면 탐색기능이 막히고 강제로 보스전을 진행하게 만드는
//        쓰레드이고
//        자바스윙으로 구현해두었습니다
//
//        몬스터 쓰레드 자동공격and스킬
//        몬스터는 2초마다 자동으로 일반공격과 스킬중 하나를 사용하는데
//        확률적으로 사용하게 해뒀습니다
//        몬스터 공격메세지의 경우는
//        2초마다 출력되는점을 감안해
//        유저 입력이 밀리지않게
//        자바스윙으로 띄워지게끔 해놓았습니다
//
//        몬스터 스테이터스 쓰레드
//        스테이터스는 스탯정보 실시간 반영을 위해 쓰레드를 사용하였고
//        이경우에도 입력텍스트가 밀리는점을 고려하여 스윙으로 gui 구현하였습니다
//
//        지난 피드백
//        전직매리트 추가
//        전직을 했을때 일반공격에 패시브가 터지게끔 수정 (사실 밸런스 맞추기용 ㅎ)
//        전직안했을때 스테이터스부분에 널뜨는거 해결
//
//        다른건 일반적으로 시연하고
//        마왕 보여줄때만 카타스트로피 1로깍고 시연

//반턴제로 구상함

//시작할때 장비끼고시작