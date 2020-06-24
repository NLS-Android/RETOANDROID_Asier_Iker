package com.ciber.retoandroid_asier_iker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreditCardActivity extends AppCompatActivity {

    private TextView lastactive_eur, lastactive_int, card_europe, card_international, current_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card);
        lastactive_eur = (TextView)findViewById(R.id.lastactive_eur);
        lastactive_int = (TextView)findViewById(R.id.lastactive_int);
        card_europe = (TextView)findViewById(R.id.card_europe);
        card_international = (TextView)findViewById(R.id.card_international);
        current_card = (TextView)findViewById(R.id.current_card);
        getSampleJsonResponse();
    }

    private void getSampleJsonResponse(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:4000/infocards/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<Post> call = jsonPlaceHolderApi.getSampleResponse();

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()){
                    lastactive_eur.setText(response.body().getLastactiveEur() + "\n");
                    lastactive_int.setText(response.body().getLastactiveInt() + "\n");
                    card_europe.setText(response.body().getCardEurope() + "\n");
                    card_international.setText(response.body().getCardInternational() + "\n");
                    current_card.setText("current_card: " +response.body().getCurrentCard() + "\n");
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }
}