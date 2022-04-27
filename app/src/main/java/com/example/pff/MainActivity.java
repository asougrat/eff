package com.example.pff;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    private FirebaseAuth mAuth;

    BottomNavigationView bottomNavigationView;

    homeFragment homeFragment = new homeFragment();
    Prgram_Fragment prgram_fragment = new Prgram_Fragment();
    repasFragment repasFragment = new repasFragment();
    TipsFragment TipsFragment = new TipsFragment();


    //private Button btnLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /* listView.findViewById(R.id.listent);

        //create data
        ArrayList<entraine> arrayList = new ArrayList<>();

        arrayList.add(new entraine(R.drawable.ic_baseline_home_24,"Pecs","4 exercices chasue exercice 12 fois de repetition"));
        arrayList.add(new entraine(R.drawable.ic_baseline_home_24,"Pecs","4 exercices chasue exercice 12 fois de repetition"));
        arrayList.add(new entraine(R.drawable.ic_baseline_home_24,"Pecs","4 exercices chasue exercice 12 fois de repetition"));
        arrayList.add(new entraine(R.drawable.ic_baseline_home_24,"Pecs","4 exercices chasue exercice 12 fois de repetition"));
        arrayList.add(new entraine(R.drawable.ic_baseline_home_24,"Pecs","4 exercices chasue exercice 12 fois de repetition"));

        //make custom adapter
        entrradapter entrradapter = new entrradapter(this,R.layout.list_row,arrayList);
        listView.setAdapter(entrradapter);*/

        bottomNavigationView  = findViewById(R.id.bottomnav);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameid,homeFragment).commit();
        mAuth = FirebaseAuth.getInstance();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameid,homeFragment).commit();
                            return true;
                    case R.id.programme:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameid,prgram_fragment).commit();
                        return true;
                    case R.id.repas:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameid,repasFragment).commit();
                        return true;
                    case R.id.Tips:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameid,TipsFragment).commit();
                        return true;
                }
                return false;
            }
        });
        //btnLogout = findViewById(R.id.btn_logout);

       /* btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });*/
    }
        @Override
        public void onStart(){
        super.onStart();
            FirebaseUser currentuser = mAuth.getCurrentUser();
            if (currentuser == null)
            {
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        }



       /* public void logout(){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(MainActivity.this,LoginActivity.class));
        }*/
}