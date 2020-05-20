package com.ciber.retoandroid_asie_iker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpToolBar();
        //hideToolBar();
        //showToolBar();
    }
    private void setUpToolBar(){
        toolbar = findViewById(R.id.toolbar);
        //Ponemos nuestra toolbar como ActionBar
        setSupportActionBar(toolbar);

        showHomeUpIcon();
        setUpHomeUpIconAndColor(R.drawable.ic_camera, R.color.colorWhiteApp);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", "homeButton - setNavigationOnClickListener");
            }
        });

        customTitleToolBar();
    }

}
