# android_study

 안드로이드 공부를 위한 레포지토리 입니다.
 
 이 레포지토리는 오준석님의 강의를 Clone Coding 하면서 알게 된 사실들을 기록하는 레포지토리 입니다.
 
 강의 링크는 [여기](https://www.youtube.com/watch?v=pG6OkJ3rSjg)를 참고 해주세요.
 
 ## 2021-04-22
 ### room_exam

1. Room 이란 Sqlite를 대체하기 위해 만들어진 라이브러리
2. Room 에서 Primary Key에 해당하는 변수 위에 @PrimaryKey 어노테이션을 붙여주면 된다. (autoGenerate = true)를 옆에 붙여주면 자동으로 값이 1씩 증가한다.
3. alt + insert를 누르면 constructor, getter, setter, tostring 재정의 기능들을 자동으로 생성 가능하다.
4. Room 에서 사용 할 Entity로 사용하기 위해 2번에서 생성한 클래스 선언부 위에 @Entity 어노테이션을 붙여준다.
5. DAO Interface 생성 후 @Dao 어노테이션을 붙여주면 Dao의 기능을 하도록 한다.
 
## 2021-04-23
### room_exam_kotlin

1. kotlin-android-extensions - kotlin에서 지원하는 플러그인으로, import만 해주면 자동으로 view를 찾아주고, 변수로 생성할 필요가 없어진다.
2. data class - kotlin에서 데이터 보관 목적으로 만든 클래스로, toString(), hashCode(), equals(), copy() 메소드를 자동으로 생성해준다.

### LiveData

1. LiveData - Data의 변경을 관찰할 수 있는 DataHolder 클래스
2. LiveData를 쓰는 이유는 ? 

+ **UI와 데이터 상태의 일치 보장** - 앱 데이터가 변경될 때마다 관찰자가 대신 UI를 업데이트 하므로 개발자가 업데이트할 필요가 없다.
+ **메모리 누수 없음** - 관찰자는 LifeCycle 객체에 결합되어 있으며 연결된 수명 주기가 끝나면 자동으로 삭제된다.
+ **중지된 활동으로 인한 비정상 종료 없음** - 활동이 백 스택에 (Background?) 있을 때를 비롯하여 관찰자의 수명 주기가 비활성 상태에 있으면 관찰자는 어떤 LiveData 이벤트도 받지 않는다.
+ **수명주기를 더 이상 수동으로 처리하지 않음** - LiveData는 관찰하는 동안 관련 수명주기 상태의 변경을 인식하므로 이 모든 것을 자동으로 관리합니다. (LifeCycle에 따른 처리를 하지 않아도 된다는 말인 것 같다)
+ **최신 데이터 유지** - 수명주기가 비활성화되면 다시 활성화 될 때 최신 데이터를 수신한다.
+ **적절한 구성 변경** - 기기 회전과 같은 구성 변경으로 인해 활동 또는 프래그먼트가 다시 생성되면 사용 가능한 최신 데이터를 즉시 받게 된다.
+ **리소스 공유** - 앱에서 시스템 서비스를 공유할 수 있도록 싱글톤 패턴을 사용하는 LiveData 객체를 확장하여 시스템 서비스를 래핑할 수 있습니다.

### Room 비동기 처리

기존의 코드에서는 메인 쓰레드에서 DB조작을 허용하는```allowMainThreadQueries()``` 옵션을 DB 생성시에 주었는데, 이를 비동기로 처리하는 방법을 배운다.

