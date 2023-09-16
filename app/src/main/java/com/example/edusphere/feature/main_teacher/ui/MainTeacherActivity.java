package com.example.edusphere.feature.main_teacher.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.edusphere.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainTeacherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_teacher);


        BottomNavigationView navView = findViewById(R.id.bottomNavigationViewTeacher);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.signesTeacherFragment, R.id.statisticTeacherFragment, R.id.profileTeacherFragment)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main_teacher);
        NavigationUI.setupWithNavController(navView, navController);
    }
}