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
        3. För att konvertera informationen (från JSON till Java-objekt) så behöver vi GSON (en konverterare)
           compile 'com.google.code.gson:gson:2.6.2'
        3. Förbered för att hämta JSON-data - skapa en klass som motsvarar det vi hämtar
           * Skapa klassen Movie
           *

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
