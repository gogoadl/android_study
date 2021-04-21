# android_study

 안드로이드 공부를 위한 레포지토리 입니다.
 
 이 레포지토리는 오준석님의 강의를 Clone Coding 하면서 알게 된 사실들을 기록하는 레포지토리 입니다.
 
 강의 링크는 [여기](https://www.youtube.com/watch?v=pG6OkJ3rSjg)를 참고 해주세요.
 
 ## 2021-04-22
 ### room_exam

새로 알게 된 것들

1. Room 이란 Sqlite를 대체하기 위해 만들어진 라이브러리
2. Room 에서 Primary Key에 해당하는 변수 위에 @PrimaryKey 어노테이션을 붙여주면 된다. (autoGenerate = true)를 옆에 붙여주면 자동으로 값이 1씩 증가한다.
3. alt + insert를 누르면 constructor, getter, setter, tostring 재정의 기능들을 자동으로 생성 가능하다.
4. Room 에서 사용 할 Entity로 사용하기 위해 2번에서 생성한 클래스 선언부 위에 @Entity 어노테이션을 붙여준다.
5. DAO Interface 생성 후 @Dao 어노테이션을 붙여주면 Dao의 기능을 하도록 한다.
 
