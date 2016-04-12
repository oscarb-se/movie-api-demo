package se.oscarb.movieapidemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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
           Se OpenMovieDatabaseInterface.java



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

        // Börja kommunicera med Open Movie Database API
        OpenMovieDatabaseInterface omdbApi = retrofit.create(OpenMovieDatabaseInterface.class);

        // Film vi ska söka efter
        String movie = "The Matrix";

        // Vad vi vill göra:
        // http://www.omdbapi.com/?t=The+Matrix&y=&plot=short&r=json
        Call<Movie> call = omdbApi.getMovie(movie, "", "short", "json");

        // När vi ska koppla upp oss på internet behöver vi göra det samtidigt
        // som resten av koden i programmet. Vi ser till att kod körs parallellt.
        // Kod som körs parallellt säger man körs på olika "trådar"
        // All kod körs normalt på huvudtråden (MainThread)
        // När vi vill göra något som kan ta tid vill vi göra det på en annan tråd
        // (Så att det inte tar fokus och får appen att verka "stilla")

        // Följande rad kod ser till att vi gör vår internetförfrågan på en annan tråd
        call.enqueue(new Callback<Movie> () {

                         @Override
                         public void onResponse(Call<Movie> call, Response<Movie> response) {
                             // Vi har fått ett svar på vår förfrågan

                             // Skapa ett objekt Movie från vår response
                             Movie returnedMovie = response.body();
                             Log.i("Movie", returnedMovie.getReleased());

                         }

                         @Override
                         public void onFailure(Call<Movie> call, Throwable t) {
                            // Något gick fel när vi gjorde vår förfrågan
                         }
                     }

        );







    }
}
