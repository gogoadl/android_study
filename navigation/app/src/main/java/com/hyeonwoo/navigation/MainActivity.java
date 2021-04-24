package com.hyeonwoo.navigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    AppBarConfiguration appBarConfiguration;

    /* navigation을 통해 fragment 통신하는 방법을 배운다.
    1. navigation이란?
    Fragment간의 통신을 하나의 스토리보드에서 관리할 수 있는 라이브러리로
    IOS에 StoryBoard에 해당하는 부분으로 보인다.

    2. navigation 적용 방법
    fragment 생성 후
    res 폴더에서 new > android resource directory
    values는 navigation 으로 생성
    리소스 생성 후 자동으로 navigation에 관련된 라이브러리가 build.gradle에 추가된다.
    이후 생성된 navigation graph 파일을 열면 프로젝트에 있는 fragment 목록들을 볼 수 있다.
    왼쪽 위 new destination 버튼을 통해 fragment를 graph 위에 올려주고, fragment에서 fragment로 드래그하여 연결시킬 수 있다.

    3. safe args 적용 방법
    최상위 build.gradle 파일의 dependencies 아래에 추가
    classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"

    4. safe args 사용하는 이유
    왜? -> 결론적으로 실수를 줄이기 위해.
    safe args를 사용하면, 데이터 전송시에 매개변수의 타입을 지정해줌으로써 잘못된 데이터가 보내지는 오류를 막아준다. (다른 매개변수가 주어지면 컴파일러가 오류를 발생시킴)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }

}