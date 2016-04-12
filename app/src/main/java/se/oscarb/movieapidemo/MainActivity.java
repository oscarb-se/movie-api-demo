package se.oscarb.movieapidemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /*
        För att använda ett API
        1. Lägg in Retrofit i build.gradle
        2. Lägg in att vi använder oss av internet i manifestet:
             <uses-permission android:name="android.permission.INTERNET" />

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
