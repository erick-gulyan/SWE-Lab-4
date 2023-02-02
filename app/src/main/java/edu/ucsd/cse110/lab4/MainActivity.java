package edu.ucsd.cse110.lab4;

import static edu.ucsd.cse110.lab4.R.id.button2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Optional;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLaunchProfileClicked(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    @SuppressLint("DefaultLocale")
    public void onShowCounterClicked(View view){
        Intent intent = new Intent(this, CounterActivity.class);
        TextView maxCountView = findViewById(R.id.editTextNumber);
        String maxCounterStr = maxCountView.getText().toString();

        Optional<Integer> maybeMaxCount = Utilities.parseCount(maxCounterStr);

        if(!maybeMaxCount.isPresent()){
            Utilities.showAlert(this, "This isn't a number!");
            return;
        }

        int maxCount = maybeMaxCount.get();

        if(maxCount <= 0)
        {
            Utilities.showAlert(this, "Pleace enter a positive number!");
            return;
        }
        Utilities.showAlert(this, String.format("I got the number %d", maxCount));

        intent.putExtra("max_count", maxCount);
        startActivity(intent);
    }
}