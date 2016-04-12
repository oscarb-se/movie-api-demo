package se.oscarb.movieapidemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /*
        För att använda ett RESTful API i Android
        1. Lägg in Retrofit i build.gradle (app)
           compile 'com.squareup.retrofit2:retrofit:2.0.1'
        2. Lägg in att vi använder oss av internet i AndroidManifest.xml:
           <uses-permission android:name="android.permission.INTERNET" />
        3.

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
