package se.oscarb.movieapidemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    /*
        För att använda ett RESTful API i Android
        1. Lägg in Retrofit i build.gradle (app)
           compile 'com.squareup.retrofit2:retrofit:2.0.1'
        2. Lägg in att vi använder oss av internet i AndroidManifest.xml:
           <uses-permission android:name="android.permission.INTERNET" />
        3. För att konvertera informationen (från JSON till Java-objekt) så behöver vi GSON (en konverterare)
           compile 'com.google.code.gson:gson:2.6.2'
           compile 'com.squareup.retrofit2:converter-gson:2.0.1'
        4. Förbered för att hämta JSON-data - skapa en klass som motsvarar det vi hämtar
           * Skapa klassen Movie
           * Lägg till instansvariabler för det du vill komma åt i JSON-datan
           * Skapa getters (get-metoder) för våra instansvariabler
        5. Ta fram koden som gör så att Retrofit går in på en sida, hämtar data
           och gör om det till ett objekt i Java!
           Se metoden findMovie nedan
        6. Skapa ett Interface i Java för det RESTful API vi vill kommunicera med



     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Instansmetod
    public void findMovie(View view) {
        // Adressen vi utgår ifrån
        String baseUrl = "http://www.omdbapi.com/";

        // Skapa en instans av Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


    }
}
