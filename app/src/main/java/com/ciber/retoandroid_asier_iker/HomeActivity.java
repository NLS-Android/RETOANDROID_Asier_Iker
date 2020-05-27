package com.ciber.retoandroid_asier_iker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ciber.fragments.AllowancesFragment;
import com.ciber.fragments.ExpensesFragment;
import com.ciber.fragments.ProfileFragment;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView mBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById (R.id.toolbar);
        setSupportActionBar(toolbar);

        mBottomNavigation = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.nav_expenses){
                    showSelectedFragment(new ExpensesFragment());
                }
                if (menuItem.getItemId() == R.id.nav_allowances){
                    showSelectedFragment(new AllowancesFragment());
                }
                if (menuItem.getItemId() == R.id.nav_profile){

                    showSelectedFragment(new ProfileFragment());
                }
                return true;
            }
        });
    }

    private void showSelectedFragment (Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menusuper, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.about:
                Intent intent = new Intent(HomeActivity.this, AboutActivity.class);
                startActivity(intent);
        }
        switch (item.getItemId()){
            case R.id.configuration:
                Intent intent = new Intent(HomeActivity.this, ConfigurationActivity.class);
                startActivity(intent);
        }
        switch (item.getItemId()){
            case R.id.see_allowances:
                Intent intent = new Intent(HomeActivity.this, AllowancesActivity.class);
                startActivity(intent);
        }
        switch (item.getItemId()){
            case R.id.see_expenses:
                Intent intent = new Intent(HomeActivity.this, ExpensesActivity.class);
                startActivity(intent);
        }
        switch (item.getItemId()){
            case R.id.my_credit_cards:
                Intent intent = new Intent(HomeActivity.this, CreditCardsActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
