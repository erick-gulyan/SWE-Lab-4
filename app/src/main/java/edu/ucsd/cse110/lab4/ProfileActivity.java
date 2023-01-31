package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loadProfile();
    }
    @Override
    protected void onDestroy(){
        saveProfile();
        super.onDestroy();

    }

    public void onGoBackClicked(View view) {
        saveProfile();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        //(R.layout.activity_main);
    }

    public void loadProfile(){
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        TextView tvName = findViewById(R.id.name_textview);
        TextView tvStatus = findViewById(R.id.status_textview);

        String s = preferences.getString("name", "default_if_not_found");
        tvName.setText(s);
        String s2 = preferences.getString("status", "default_if_not_found");
        tvStatus.setText(s2);

    }
    public void saveProfile(){
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();


        TextView tvName = findViewById(R.id.name_textview);
        TextView tvStatus = findViewById(R.id.status_textview);
        editor.putString("name", tvName.getText().toString());
        System.out.println(tvName.getText().toString());
        editor.putString("status", tvStatus.getText().toString());
        editor.apply();

    }
}