package com.example.appperpustakaansmpn1rembang;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;

import com.example.appperpustakaansmpn1rembang.fragment.AddFragment;
import com.example.appperpustakaansmpn1rembang.fragment.BookFragment;
import com.example.appperpustakaansmpn1rembang.fragment.BorrowListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }
    void init(){
        getSupportActionBar().hide();
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
    }
    BookFragment homeFragment = new BookFragment();
    AddFragment addFragment = new AddFragment();
    BorrowListFragment borrowListFragment = new BorrowListFragment();

    Fragment fragment = null;
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                fragment = homeFragment;
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fragment).detach(fragment).commitNow();
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fragment).attach(fragment).commitNow();
                break;
            case R.id.add:
                fragment = addFragment;
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fragment).detach(fragment).commitNow();
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fragment).attach(fragment).commitNow();
                break;
            case R.id.borrow_list:
                fragment = borrowListFragment;
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fragment).detach(fragment).commitNow();
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fragment).attach(fragment).commitNow();
                break;
            case R.id.logout:
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(HomeActivity.this.getApplicationContext());
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("login",false);
                editor.apply();
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
        }
        return true;
    }
}