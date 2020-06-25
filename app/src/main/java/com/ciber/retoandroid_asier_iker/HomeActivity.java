package com.ciber.retoandroid_asier_iker;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.ciber.fragments.AboutFragment;
import com.ciber.fragments.AllowancesFragment;
import com.ciber.fragments.ConfigurationFragment;
import com.ciber.fragments.CreditCardFragment;
import com.ciber.fragments.ExpensesFragment;
import com.ciber.fragments.ProfileFragment;
import com.ciber.fragments.SeeAllowancesFragment;
import com.ciber.fragments.SeeExpensesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView mBottomNavigation;
    BottomNavigationView ToolbarBottomNavigation;

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

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about){
            showSelectedFragment(new AboutFragment());
        }
        if (item.getItemId() == R.id.configuration){
            showSelectedFragment(new ConfigurationFragment());
        }
        if (item.getItemId() == R.id.see_allowances){
            showSelectedFragment(new SeeAllowancesFragment());
        }
        if (item.getItemId() == R.id.see_expenses){
            showSelectedFragment(new SeeExpensesFragment());
        }
        if (item.getItemId() == R.id.my_credit_cards){
            showSelectedFragment(new CreditCardFragment());
        }
        if (item.getItemId() == R.id.log_out){
            finish();
        }
        return true;
    }
}
