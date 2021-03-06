package com.ciber.retoandroid_asier_iker;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.io.InputStream;


public class RegisterActivity extends AppCompatActivity {

    EditText name;
    EditText surnames;
    EditText idcard;
    EditText username;
    EditText password;
    EditText confirm_password;
    TextView login;
    Button register;
    ImageButton pickImg;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);
        name = (EditText) findViewById(R.id.ED_name);
        surnames = (EditText) findViewById(R.id.ED_surnames);
        idcard = (EditText) findViewById(R.id.idcard);
        username = (EditText) findViewById(R.id.ED_username);
        password = (EditText) findViewById(R.id.ED_password);
        confirm_password = (EditText) findViewById(R.id.ED_confirm_password);
        pickImg = (ImageButton) findViewById(R.id.pickimg);
        login = (TextView) findViewById(R.id.TV_login);
        register = (Button) findViewById(R.id.button_register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginintent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(loginintent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ed_name = name.getText().toString().trim();
                String ed_surnames = surnames.getText().toString().trim();
                String ed_idcard = idcard.getText().toString().trim();
                String ed_username = username.getText().toString().trim();
                String ed_password = password.getText().toString().trim();
                String ed_passwordconfirm = confirm_password.getText().toString().trim();

                if (ed_password.equals(ed_passwordconfirm)){
                    long val = db.adduser(ed_name,ed_surnames,ed_idcard,ed_username,ed_password);
                    if (val > 0){
                        Toast.makeText(RegisterActivity.this, "You Have Registered!", Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(moveToLogin);
                    } else {
                        Toast.makeText(RegisterActivity.this, "Registration Error", Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(RegisterActivity.this, "You Have Registered!", Toast.LENGTH_SHORT).show();
                    Intent moveToLogin = new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(moveToLogin);
                } else {
                    Toast.makeText(RegisterActivity.this, "Password Is Not matching, Try Again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void openGallery(View view) {
        Intent interntIMG = new Intent(Intent.ACTION_GET_CONTENT);
        interntIMG.setType("image/*");
        startActivityForResult(interntIMG,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == 100){
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                pickImg.setImageBitmap(decodeStream);
            }catch (Exception ex){
                Log.e("ex", ex.getMessage());
            }
        }
    }
}
